package net.jmp.demo.exchange.rate.app;

/*
 * (#)Main.java 0.2.0   02/07/2024
 *
 * @author    Jonathan Parker
 * @version   0.2.0
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

import net.jmp.demo.exchange.rate.ExchangeRate;

import org.slf4j.LoggerFactory;

import org.slf4j.ext.XLogger;

public final class Main {
    private final XLogger logger = new XLogger(LoggerFactory.getLogger(this.getClass().getName()));

    private Main() {
        super();
    }

    private void run() {
        this.logger.entry();
        this.logger.info("Begin running the application...");

        this.listAllProviders();
        this.listDefaultProvider();

        this.logger.info("Completed running the application.");
        this.logger.exit();
    }

    private void listAllProviders() {
        this.logger.entry();

        ExchangeRate.getAllProviders().forEach(provider -> {
            this.logger.info("Found provider: {}", provider.getClass().getName());
        });

        this.logger.exit();
    }

    private void listDefaultProvider() {
        this.logger.entry();

        final var defaultProvider = ExchangeRate.getDefaultProvider();

        this.logger.info("Default provider: {}", defaultProvider.getClass().getName());

        this.logger.exit();
    }

    public static void main(final String[] args) {
        new Main().run();
    }
}
