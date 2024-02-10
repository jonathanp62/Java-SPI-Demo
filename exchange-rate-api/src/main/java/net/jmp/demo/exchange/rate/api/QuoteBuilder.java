package net.jmp.demo.exchange.rate.api;

/*
 * (#)QuoteBuilder.java 0.4.0   02/10/2024
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

public final class QuoteBuilder {
    private String high;
    private String low;
    private String settleTime;
    private String last;
    private String feedTime;
    private String market;
    private String open;
    private String percentChange;
    private String settled;
    private String symbol;
    private String netChange;
    private String changeColor;
    private String changeClass;
    private String exchange;
    private String openIntFinal;
    private String delay;
    private String shortSymbol;
    private String prevClose;
    private String timeDiff;
    private String name;

    public QuoteBuilder() {
        super();
    }

    public QuoteBuilder high(final String high) {
        this.high = high;

        return this;
    }

    public QuoteBuilder low(final String low) {
        this.low = low;

        return this;
    }

    public QuoteBuilder settleTime(final String settleTime) {
        this.settleTime = settleTime;

        return this;
    }

    public QuoteBuilder last(final String last) {
        this.last = last;

        return this;
    }

    public QuoteBuilder feedTime(final String feedTime) {
        this.feedTime = feedTime;

        return this;
    }

    public QuoteBuilder market(final String market) {
        this.market = market;

        return this;
    }

    public QuoteBuilder open(final String open) {
        this.open = open;

        return this;
    }

    public QuoteBuilder percentChange(final String percentChange) {
        this.percentChange = percentChange;

        return this;
    }

    public QuoteBuilder settled(final String settled) {
        this.settled = settled;

        return this;
    }

    public QuoteBuilder symbol(final String symbol) {
        this.symbol = symbol;

        return this;
    }

    public QuoteBuilder netChange(final String netChange) {
        this.netChange = netChange;

        return this;
    }

    public QuoteBuilder changeColor(final String changeColor) {
        this.changeColor = changeColor;

        return this;
    }

    public QuoteBuilder changeClass(final String changeClass) {
        this.changeClass = changeClass;

        return this;
    }

    public QuoteBuilder exchange(final String exchange) {
        this.exchange = exchange;

        return this;
    }

    public QuoteBuilder openIntFinal(final String openIntFinal) {
        this.openIntFinal = openIntFinal;

        return this;
    }

    public QuoteBuilder delay(final String delay) {
        this.delay = delay;

        return this;
    }

    public QuoteBuilder shortSymbol(final String shortSymbol) {
        this.shortSymbol = shortSymbol;

        return this;
    }

    public QuoteBuilder prevClose(final String prevClose) {
        this.prevClose = prevClose;

        return this;
    }

    public QuoteBuilder timeDiff(final String timeDiff) {
        this.timeDiff = timeDiff;

        return this;
    }

    public QuoteBuilder name(final String name) {
        this.name = name;

        return this;
    }

    public Quote build() {
        return new Quote(
                this.high == null ? "" : this.high,
                this.low == null ? "" : this.low,
                this.settleTime == null ? "" : this.settleTime,
                this.last == null ? "" : this.last,
                this.feedTime == null ? "" : this.feedTime,
                this.market == null ? "" : this.market,
                this.open == null ? "" : this.open,
                this.percentChange == null ? "" : this.percentChange,
                this.settled == null ? "" : this.settled,
                this.symbol == null ? "" : this.symbol,
                this.netChange == null ? "" : this.netChange,
                this.changeColor == null ? "" : this.changeColor,
                this.changeClass == null ? "" : this.changeClass,
                this.exchange == null ? "" : this.exchange,
                this.openIntFinal == null ? "" : this.openIntFinal,
                this.delay == null ? "" : this.delay,
                this.shortSymbol == null ? "" : this.shortSymbol,
                this.prevClose == null ? "" : this.prevClose,
                this.timeDiff == null ? "" : this.timeDiff,
                this.name == null ? "" : this.name
        );
    }
}
