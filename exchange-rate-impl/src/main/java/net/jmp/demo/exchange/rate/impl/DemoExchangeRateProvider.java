package net.jmp.demo.exchange.rate.impl;

/*
 * (#)DemoExchangeRateProvider.java 0.3.0   02/08/2024
 *
 * @author    Jonathan Parker
 * @version   0.3.0
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

import net.jmp.demo.exchange.rate.api.QuoteManager;
import net.jmp.demo.exchange.rate.spi.ExchangeRateProvider;

import org.slf4j.LoggerFactory;

import org.slf4j.ext.XLogger;

/*
 * This class is a demonstration SPI implementation of the exchange
 * rate API. It returns a quote manager implemented as a demonstration.
 */

public class DemoExchangeRateProvider implements ExchangeRateProvider {
    private final XLogger logger = new XLogger(LoggerFactory.getLogger(this.getClass().getName()));

    @Override
    public QuoteManager getQuoteManager() {
        this.logger.entry();
        this.logger.exit();

        return new DemoQuoteManagerImpl();
    }

    @Override
    public String getName() {
        return "Demo";
    }
}
