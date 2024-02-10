package net.jmp.demo.exchange.rate.api;

/*
 * (#)Quote.java    0.4.0   02/10/2024
 * (#)Quote.java    0.2.0   02/07/2024
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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public final class Quote {
    private String high;
    private String low;
    @SerializedName("settletime")
    private String settleTime;
    private String last;
    @SerializedName("feedtime")
    private String feedTime;
    private String market;
    private String open;
    @SerializedName("pctChange")
    private String percentChange;
    private String settled;
    private String symbol;
    @SerializedName("netchange")
    private String netChange;
    @SerializedName("changecolor")
    private String changeColor;
    @SerializedName("changeclass")
    private String changeClass;
    private String exchange;
    @SerializedName("openintfinal")
    private String openIntFinal;
    private String delay;
    @SerializedName("shortsymbol")
    private String shortSymbol;
    @SerializedName("prevclose")
    private String prevClose;
    @SerializedName("timediff")
    private String timeDiff;
    private String name;

    public Quote() {
        super();
    }

    public Quote(
            final String high,
            final String low,
            final String settleTime,
            final String last,
            final String feedTime,
            final String market,
            final String open,
            final String percentChange,
            final String settled,
            final String symbol,
            final String netChange,
            final String changeColor,
            final String changeClass,
            final String exchange,
            final String openIntFinal,
            final String delay,
            final String shortSymbol,
            final String prevClose,
            final String timeDiff,
            final String name
    ) {
        super();

        this.high = high;
        this.low = low;
        this.settleTime = settleTime;
        this.last = last;
        this.feedTime = feedTime;
        this.market = market;
        this.open = open;
        this.percentChange = percentChange;
        this.settled = settled;
        this.symbol = symbol;
        this.netChange = netChange;
        this.changeColor = changeColor;
        this.changeClass = changeClass;
        this.exchange = exchange;
        this.openIntFinal = openIntFinal;
        this.delay = delay;
        this.shortSymbol = shortSymbol;
        this.prevClose = prevClose;
        this.timeDiff = timeDiff;
        this.name = name;
    }

    public String getHigh() {
        return this.high;
    }

    public void setHigh(final String high) {
        this.high = high;
    }

    public String getLow() {
        return this.low;
    }

    public void setLow(final String low) {
        this.low = low;
    }

    public String getSettleTime() {
        return this.settleTime;
    }

    public void setSettleTime(final String settleTime) {
        this.settleTime = settleTime;
    }

    public String getLast() {
        return this.last;
    }

    public void setLast(final String last) {
        this.last = last;
    }

    public String getFeedTime() {
        return this.feedTime;
    }

    public void setFeedTime(final String feedTime) {
        this.feedTime = feedTime;
    }

    public String getMarket() {
        return this.market;
    }

    public void setMarket(final String market) {
        this.market = market;
    }

    public String getOpen() {
        return this.open;
    }

    public void setOpen(final String open) {
        this.open = open;
    }

    public String getPercentChange() {
        return this.percentChange;
    }

    public void setPercentChange(final String percentChange) {
        this.percentChange = percentChange;
    }

    public String getSettled() {
        return this.settled;
    }

    public void setSettled(final String settled) {
        this.settled = settled;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }

    public String getNetChange() {
        return this.netChange;
    }

    public void setNetChange(final String netChange) {
        this.netChange = netChange;
    }

    public String getChangeColor() {
        return this.changeColor;
    }

    public void setChangeColor(final String changeColor) {
        this.changeColor = changeColor;
    }

    public String getChangeClass() {
        return this.changeClass;
    }

    public void setChangeClass(final String changeClass) {
        this.changeClass = changeClass;
    }

    public String getExchange() {
        return this.exchange;
    }

    public void setExchange(final String exchange) {
        this.exchange = exchange;
    }

    public String getOpenIntFinal() {
        return this.openIntFinal;
    }

    public void setOpenIntFinal(final String openIntFinal) {
        this.openIntFinal = openIntFinal;
    }

    public String getDelay() {
        return this.delay;
    }

    public void setDelay(final String delay) {
        this.delay = delay;
    }

    public String getShortSymbol() {
        return this.shortSymbol;
    }

    @SerializedName("shortsymbol")
    public void setShortSymbol(final String shortSymbol) {
        this.shortSymbol = shortSymbol;
    }

    public String getPrevClose() {
        return this.prevClose;
    }

    public void setPrevClose(final String prevClose) {
        this.prevClose = prevClose;
    }

    public String getTimeDiff() {
        return this.timeDiff;
    }

    public void setTimeDiff(final String timeDiff) {
        this.timeDiff = timeDiff;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Quote quote = (Quote) o;

        if (!Objects.equals(this.high, quote.high)) return false;
        if (!Objects.equals(this.low, quote.low)) return false;
        if (!Objects.equals(this.settleTime, quote.settleTime)) return false;
        if (!Objects.equals(this.last, quote.last)) return false;
        if (!Objects.equals(this.feedTime, quote.feedTime)) return false;
        if (!Objects.equals(this.market, quote.market)) return false;
        if (!Objects.equals(this.open, quote.open)) return false;
        if (!Objects.equals(this.percentChange, quote.percentChange))
            return false;
        if (!Objects.equals(this.settled, quote.settled)) return false;
        if (!Objects.equals(this.symbol, quote.symbol)) return false;
        if (!Objects.equals(this.netChange, quote.netChange)) return false;
        if (!Objects.equals(this.changeColor, quote.changeColor)) return false;
        if (!Objects.equals(this.changeClass, quote.changeClass)) return false;
        if (!Objects.equals(this.exchange, quote.exchange)) return false;
        if (!Objects.equals(this.openIntFinal, quote.openIntFinal)) return false;
        if (!Objects.equals(this.delay, quote.delay)) return false;
        if (!Objects.equals(this.shortSymbol, quote.shortSymbol)) return false;
        if (!Objects.equals(this.prevClose, quote.prevClose)) return false;
        if (!Objects.equals(this.timeDiff, quote.timeDiff)) return false;

        return Objects.equals(this.name, quote.name);
    }

    @Override
    public int hashCode() {
        int result = high != null ? high.hashCode() : 0;

        result = 31 * result + (this.low != null ? this.low.hashCode() : 0);
        result = 31 * result + (this.settleTime != null ? this.settleTime.hashCode() : 0);
        result = 31 * result + (this.last != null ? this.last.hashCode() : 0);
        result = 31 * result + (this.feedTime != null ? this.feedTime.hashCode() : 0);
        result = 31 * result + (this.market != null ? this.market.hashCode() : 0);
        result = 31 * result + (this.open != null ? this.open.hashCode() : 0);
        result = 31 * result + (this.percentChange != null ? this.percentChange.hashCode() : 0);
        result = 31 * result + (this.settled != null ? this.settled.hashCode() : 0);
        result = 31 * result + (this.symbol != null ? this.symbol.hashCode() : 0);
        result = 31 * result + (this.netChange != null ? this.netChange.hashCode() : 0);
        result = 31 * result + (this.changeColor != null ? this.changeColor.hashCode() : 0);
        result = 31 * result + (this.changeClass != null ? this.changeClass.hashCode() : 0);
        result = 31 * result + (this.exchange != null ? this.exchange.hashCode() : 0);
        result = 31 * result + (this.openIntFinal != null ? this.openIntFinal.hashCode() : 0);
        result = 31 * result + (this.delay != null ? this.delay.hashCode() : 0);
        result = 31 * result + (this.shortSymbol != null ? this.shortSymbol.hashCode() : 0);
        result = 31 * result + (this.prevClose != null ? this.prevClose.hashCode() : 0);
        result = 31 * result + (this.timeDiff != null ? this.timeDiff.hashCode() : 0);
        result = 31 * result + (this.name != null ? this.name.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "high='" + this.high + '\'' +
                ", low='" + this.low + '\'' +
                ", settleTime='" + this.settleTime + '\'' +
                ", last='" + this.last + '\'' +
                ", feedTime='" + this.feedTime + '\'' +
                ", market='" + this.market + '\'' +
                ", open='" + this.open + '\'' +
                ", percentChange='" + this.percentChange + '\'' +
                ", settled='" + this.settled + '\'' +
                ", symbol='" + this.symbol + '\'' +
                ", netChange='" + this.netChange + '\'' +
                ", changeColor='" + this.changeColor + '\'' +
                ", changeClass='" + this.changeClass + '\'' +
                ", exchange='" + this.exchange + '\'' +
                ", openIntFinal='" + this.openIntFinal + '\'' +
                ", delay='" + this.delay + '\'' +
                ", shortSymbol='" + this.shortSymbol + '\'' +
                ", prevClose='" + this.prevClose + '\'' +
                ", timeDiff='" + this.timeDiff + '\'' +
                ", name='" + this.name + '\'' +
                '}';
    }
}
