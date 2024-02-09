package net.jmp.demo.exchange.rate.impl;

/*
 * (#)YahooQuoteManagerImpl.java    0.3.0   02/08/2024
 * (#)YahooQuoteManagerImpl.java    0.2.0   02/07/2024
 *
 * @author    Jonathan Parker
 * @version   0.3.0
 * @since     0.2.0
 *
 * MIT License
 *
 * Copyright (c) 2024 Jonathan M. Parker
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.io.IOException;

import java.math.BigDecimal;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;

import net.jmp.demo.exchange.rate.api.Quote;
import net.jmp.demo.exchange.rate.api.QuoteManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import org.slf4j.LoggerFactory;

import org.slf4j.ext.XLogger;

/*
 * This class is the Yahoo Finance implementation of a quote manager.
 */

public class YahooQuoteManagerImpl implements QuoteManager {
    private static final String URL_PROVIDER = "https://query2.finance.yahoo.com/v6/finance/quoteSummary/%s=X?modules=summaryDetail";

    private final OkHttpClient httpClient = new OkHttpClient();

    private final XLogger logger = new XLogger(LoggerFactory.getLogger(this.getClass().getName()));

    @Override
    public List<Quote> getQuotes(final String baseCurrency, final LocalDate date) {
        this.logger.entry(baseCurrency, date);

        final List<Quote> quotes = this.getYahooQuotes(baseCurrency, date);

        this.logger.exit(quotes);

        return quotes;
    }

    private List<Quote> getYahooQuotes(final String baseCurrency, final LocalDate date) {
        this.logger.entry(baseCurrency, date);

        final List<Quote> quotes = new ArrayList<>();

        final List<String> currencyQuery = new ArrayList<>();

        Currency.getAvailableCurrencies().forEach(currency -> {
            if (!baseCurrency.equals(currency.getCurrencyCode())) {
                currencyQuery.add(String.format(URL_PROVIDER, baseCurrency + currency.getCurrencyCode()));
            }
        });

        for (final var url : currencyQuery) {
            final var response = doGetRequest(url);

            if (response != null) {
                // This is assuming JSON is returned, not HTML

                final Quote map = this.mapResponeToQuote(response);

                if (map != null) {
                    quotes.add(map);
                }
            }
        }

        this.logger.exit(quotes);

        return quotes;
    }

    private String doGetRequest(final String url) {
        this.logger.entry(url);

        String result = null;

        this.logger.debug("Request URL: {}", url);

        final var request = new Request.Builder()
                .url(url)
                .build();

        try (final var response = this.httpClient.newCall(request).execute()) {
            if (response.body() != null)
                result = response.body().string();
        } catch (final IOException ioe) {
            this.logger.catching(ioe);
        }

        this.logger.exit(result);

        return result;
    }

    private Quote mapResponeToQuote(final String response) {
        this.logger.entry(response);

        Quote quote = null;

        try (final Jsonb jsonb = JsonbBuilder.create()) {
            final Map qrw = jsonb.fromJson(response, Map.class);

            quote = this.parseResult(qrw);
        } catch (final Exception e) {
            this.logger.error("Error while trying to read response");
            this.logger.catching(e);
        }

        this.logger.exit(quote);

        return quote;
    }

    private Quote parseResult(final Map qrw) {
        this.logger.entry(qrw);

        Quote quote = null;

        if (qrw != null) {
            final Map quoteSummary = (Map) qrw.get("quoteSummary");

            if (quoteSummary != null) {
                final List<Map> result = (List<Map>) quoteSummary.get("result");

                if (result != null) {
                    final Map resultArray = result.get(0);

                    if (resultArray != null) {
                        final Map summaryDetail = (Map) resultArray.get("summaryDetail");

                        if (summaryDetail != null) {
                            quote = this.constructQuote(summaryDetail);
                        }
                    }
                }
            }
        }

        this.logger.exit(quote);

        return quote;
    }

    private Quote constructQuote(final Map summaryDetail) {
        this.logger.entry(summaryDetail);

        Quote quote = null;

        final String currency = (String) summaryDetail.get("currency");

        final Map ask = (Map) summaryDetail.get("ask");
        final Map bid = (Map) summaryDetail.get("bid");

        final BigDecimal askPrice = (BigDecimal) ask.get("raw");
        final BigDecimal bidPrice = (BigDecimal) bid.get("raw");

        if (askPrice != null && bidPrice != null) {
            quote = new Quote(currency, askPrice, bidPrice);
        }

        this.logger.exit(quote);

        return quote;
    }
}
