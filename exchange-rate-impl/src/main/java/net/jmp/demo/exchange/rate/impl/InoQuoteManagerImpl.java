package net.jmp.demo.exchange.rate.impl;

/*
 * (#)InoQuoteManagerImpl.java  0.4.0   02/09/2024
 *
 * @author    Jonathan Parker
 * @version   0.4.0
 * @since     0.4.0
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

import com.google.gson.GsonBuilder;

import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import net.jmp.demo.exchange.rate.api.Quote;
import net.jmp.demo.exchange.rate.api.QuoteBuilder;
import net.jmp.demo.exchange.rate.api.QuoteManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import org.slf4j.LoggerFactory;

import org.slf4j.ext.XLogger;

/*
 * This class is the Ino Finance implementation of a quote manager.
 */

public class InoQuoteManagerImpl implements QuoteManager {
    private static final String URL_PROVIDER = "https://assets.ino.com/data/quote/?format=json&s=FOREX_%s";

    private final OkHttpClient httpClient = new OkHttpClient();
    private final XLogger logger = new XLogger(LoggerFactory.getLogger(this.getClass().getName()));

    @Override
    public List<Quote> getQuotes(final String baseCurrency, final LocalDate date) {
        this.logger.entry(baseCurrency, date);

        final List<Quote> quotes = this.getInoQuotes(baseCurrency, date);

        this.logger.exit(quotes);

        return quotes;
    }

    private List<Quote> getInoQuotes(final String baseCurrency, final LocalDate date) {
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
                final Quote quote = this.mapResponeToQuote(response);

                if (quote != null) {
                    quotes.add(quote);
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

        final var gsonBuilder = new GsonBuilder();

        final LinkedTreeMap deserializedMap = gsonBuilder.create().fromJson(response, LinkedTreeMap.class);
        final var keyIterator = deserializedMap.keySet().iterator();

        if (keyIterator.hasNext()) {
            final var key = keyIterator.next();
            final var entry = (LinkedTreeMap) deserializedMap.get(key);

            quote = this.buildQuote(entry);
        }

        this.logger.exit(quote);

        return quote;
    }

    private Quote buildQuote(final LinkedTreeMap map) {
        this.logger.entry(map);

        final var builder = new QuoteBuilder();

        if (map.containsKey("high"))
            builder.high((String) map.get("high"));

        if (map.containsKey("low"))
            builder.low((String) map.get("low"));

        if (map.containsKey("settletime"))
            builder.settleTime((String) map.get("settletime"));

        if (map.containsKey("last"))
            builder.last((String) map.get("last"));

        if (map.containsKey("feedtime"))
            builder.feedTime((String) map.get("feedtime"));

        if (map.containsKey("market"))
            builder.market((String) map.get("market"));

        if (map.containsKey("open"))
            builder.open((String) map.get("open"));

        if (map.containsKey("pctchange"))
            builder.percentChange((String) map.get("pctchange"));

        if (map.containsKey("settled"))
            builder.settled((String) map.get("settled"));

        if (map.containsKey("symbol"))
            builder.symbol((String) map.get("symbol"));

        if (map.containsKey("netchange"))
            builder.netChange((String) map.get("netchange"));

        if (map.containsKey("changecolor"))
            builder.changeColor((String) map.get("changecolor"));

        if (map.containsKey("changeclass"))
            builder.changeClass((String) map.get("changeclass"));

        if (map.containsKey("exchange"))
            builder.exchange((String) map.get("exchange"));

        if (map.containsKey("openintfinal"))
            builder.openIntFinal((String) map.get("openintfinal"));

        if (map.containsKey("delay"))
            builder.delay((String) map.get("delay"));

        if (map.containsKey("shortsymbol"))
            builder.shortSymbol((String) map.get("shortsymbol"));

        if (map.containsKey("prevclose"))
            builder.prevClose((String) map.get("prevclose"));

        if (map.containsKey("timediff"))
            builder.timeDiff((String) map.get("timediff"));

        if (map.containsKey("name"))
            builder.name((String) map.get("name"));

        final var quote = builder.build();

        this.logger.exit(quote);

        return quote;
    }
}
