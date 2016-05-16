package ru.academit.novikov.range;

public class Range {

    private double from;
    private double to;

    public Range() {
    }

    public Range(double from, double to) {
        if (to < from) {
            throw new IllegalArgumentException("считаем что второе число всегда >= чем первое");
        }
        this.from = from;
        this.to = to;
    }

    public double lengthRange() {
        return to - from;
    }

    public boolean isInside(double number) {
        return this.from <= number && number <= this.to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("( ");
        resultString.append(this.from);
        resultString.append(" , ");
        resultString.append(this.to);
        resultString.append(" )");
        //resultString.append("( " + this.from + " , " + this.to + " )");
        return resultString.toString();
    }

    //пересечение
    public Range intersection(Range r2) {
        Range r3 = new Range();
        if (this.to < r2.from || r2.to < this.from) {
            return r3;
        } else if (this.from <= r2.from && r2.to <= this.to) {
            r3.from = Math.max(this.from, r2.from);
            r3.to = Math.min(r2.to, this.to);
        } else if (isInside(r2.from) && !isInside(r2.to)) {
            r3.from = r2.from;
            r3.to = this.to;
        } else if (!isInside(r2.from) && isInside(r2.to)) {
            r3.from = this.from;
            r3.to = r2.to;
        }
        return r3;
    }
    //разность
    public Range[] difference(Range r2) {
        Range r3 = new Range();
        Range r4 = new Range();
        Range[] newRange = new Range[1];
        if (this.to < r2.from || r2.to < this.from) {
            r3.from = this.from;
            r3.to = this.to;
            newRange[0] = r3;
        } else if (this.from < r2.from && r2.to < this.to) {
            r3.from = this.from;
            r3.to = r2.from;
            r4.from = r2.to;
            r4.to = this.to;
            Range[] newRange2 = new Range[2];
            newRange2[0] = r3;
            newRange2[1] = r4;
            return newRange2;
        } else if (this.from == r2.from && r2.to == this.to) {
            newRange[0] = r3;
        } else if (isInside(r2.from) && !isInside(r2.to)) {
            r3.from = this.from;
            r3.to = r2.from;
            r4.from = this.to;
            r4.to = r2.to;
            Range[] newRange2 = new Range[2];
            newRange2[0] = r3;
            newRange2[1] = r4;
            return newRange2;
        } else if (!isInside(r2.from) && isInside(r2.to)) {
            r3.from = r2.from;
            r3.to = this.from;
            r4.from = r2.to;
            r4.to = this.to;
            Range[] newRange2 = new Range[2];
            newRange2[0] = r3;
            newRange2[1] = r4;
            return newRange2;
        }
        return newRange;
    }

    public Range[] combination(Range r2) {
        Range r3 = new Range();
        Range r4 = new Range();
        Range[] newRange = new Range[1];
        if (r2.from <= this.to && this.from <= r2.to) {
            r3.from = Math.min(this.from, r2.from);
            r3.to = Math.max(this.to, r2.to);
            newRange[0] = r3;
        } else if (r2.to < this.from || this.to < r2.from) {
            Range[] newRange2 = new Range[2];
            r3.from = Math.min(this.from, r2.from);
            r3.to = Math.min(this.to, r2.to);
            r4.from = Math.max(this.from, r2.from);
            r4.to = Math.max(this.to, r2.to);
            newRange2[0] = r3;
            newRange2[1] = r4;
            return newRange2;
        }
        return newRange;
    }


}