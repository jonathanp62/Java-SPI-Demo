package net.jmp.demo.exchange.rate;

/*
 * (#)ExchangeRate.java 0.4.0   02/09/2024
 * (#)ExchangeRate.java 0.3.0   02/08/2024
 * (#)ExchangeRate.java 0.2.0   02/07/2024
 *
 * @author    Jonathan Parker
 * @version   0.4.0
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

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import net.jmp.demo.exchange.rate.exception.ProviderNotFoundException;

import net.jmp.demo.exchange.rate.spi.ExchangeRateProvider;

import org.slf4j.LoggerFactory;

import org.slf4j.ext.XLogger;

/*
 * This class is the gateway into the SPI. Its purpose is to return a
 * list of providers, the default provider, or a named provider.
 */

public final class ExchangeRate {
    private static final XLogger LOGGER = new XLogger(LoggerFactory.getLogger("net.jmp.demo.exchange.rate.ExchangeRate"));

    private static final String DEFAULT_PROVIDER = "net.jmp.demo.exchange.rate.impl.InoFinanceExchangeRateProvider";

    private ExchangeRate() {
        super();
    }

    public static List<ExchangeRateProvider> getAllProviders() {
        LOGGER.entry();

        final List<ExchangeRateProvider> services = new ArrayList<>();
        final ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);

        loader.forEach(services::add);

        LOGGER.exit(services);

        return services;
    }

    public static ExchangeRateProvider getDefaultProvider() {
        LOGGER.entry();

        /*
         * The default provider can be overridden by setting the following system property:
         * - net.jmp.demo.exchange.rate.spi.ExchangeRateProvider
         */

        final String defaultProvider = System.getProperty("net.jmp.demo.exchange.rate.spi.ExchangeRateProvider", DEFAULT_PROVIDER);

        LOGGER.exit(defaultProvider);

        return getProvider(defaultProvider);
    }

    public static ExchangeRateProvider getProvider(final String providerName) {
        LOGGER.entry(providerName);

        final ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);

        for (final var provider : loader) {
            if (providerName.equals(provider.getClass().getName())) {
                LOGGER.exit(provider);

                return provider;
            }
        }

        throw new ProviderNotFoundException("Exchange rate provider '" + providerName + "' not found");
    }
}
