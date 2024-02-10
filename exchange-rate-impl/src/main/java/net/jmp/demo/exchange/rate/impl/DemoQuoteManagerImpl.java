package net.jmp.demo.exchange.rate.impl;

/*
 * (#)DemoQuoteManagerImpl.java 0.4.0   02/10/2024
 * (#)DemoQuoteManagerImpl.java 0.3.0   02/08/2024
 *
 * @author    Jonathan Parker
 * @version   0.4.0
 * @since     0.3.0
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

import java.time.LocalDate;

import java.util.List;

import net.jmp.demo.exchange.rate.api.Quote;
import net.jmp.demo.exchange.rate.api.QuoteBuilder;
import net.jmp.demo.exchange.rate.api.QuoteManager;

import org.slf4j.LoggerFactory;

import org.slf4j.ext.XLogger;

/*
 * This class is the demonstration implementation of a quote manager.
 */

public class DemoQuoteManagerImpl implements QuoteManager {
    private final XLogger logger = new XLogger(LoggerFactory.getLogger(this.getClass().getName()));

    @Override
    public List<Quote> getQuotes(final String baseCurrency, final LocalDate date) {
        this.logger.entry(baseCurrency, date);

        final List<Quote> quotes = this.createDemoQuotes(baseCurrency, date);

        this.logger.exit(quotes);

        return quotes;
    }

    private List<Quote> createDemoQuotes(final String baseCurrency, final LocalDate date) {
        this.logger.entry(baseCurrency, date);

        final List<Quote> quotes = List.of(
                new QuoteBuilder().market("forex").symbol("FOREX_USDJMD").exchange("FOREX").shortSymbol("USDJMD").name("US Dollar/Jamaican Dollar").build(),
                new QuoteBuilder().market("forex").symbol("FOREX_USDMXN").exchange("FOREX").shortSymbol("USDMXN").name("US Dollar/Mexican Peso").build(),
                new QuoteBuilder().exchange("FOREX").shortSymbol("USDNLG").build()
        );

        this.logger.exit(quotes);

        return quotes;
    }
}
