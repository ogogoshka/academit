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
        return this.from < number && number < this.to;
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
        return String.format("(%.2f, %.2f)", this.from, this.to);
    }

    public boolean isIntersection(Range r2) {
        return isInside(r2.from) || isInside(r2.to);
    }

    public Range intersection(Range range) {
        if (this.to <= range.from || range.to <= this.from) {
            return null;
        } else {
            if (this.from > range.from && range.to <= this.to) {
                return new Range(this.from, range.to);
            } else if (this.to <= range.to && this.from < range.from) {
                return new Range(range.from, this.to);
            } else if (range.from < this.from && range.to > this.to) {
                return new Range(this.from, this.to);
            } else {
                return new Range(range.from, range.to);
            }
        }
    }

    public Range[] union(Range range) {
        if (range.from > this.to) {
            Range[] newRange = new Range[2];
            newRange[0] = new Range(this.from, this.to);
            newRange[1] = new Range(range.from, range.to);
            return newRange;
        } else if (this.from > range.to) {
            Range[] newRange = new Range[2];
            newRange[0] = new Range(range.from, range.to);
            newRange[1] = new Range(this.from, this.to);
            return newRange;
        } else {
            Range[] newRange = new Range[1];
            Range r3 = new Range(Math.min(this.from, range.from), Math.max(range.to, this.to));
            newRange[0] = r3;
            return newRange;
        }
    }

    public Range[] difference(Range range) {
        if (this.from > range.from && range.to < this.to) {
            Range[] newRange2 = new Range[2];
            newRange2[0] = new Range(range.from, this.from);
            newRange2[1] = new Range(range.to, this.to);
            return newRange2;
        } else if (this.to < range.to && this.from < range.from) {
            Range[] newRange2 = new Range[2];
            newRange2[0] = new Range(this.from, range.from);
            newRange2[1] = new Range(this.to, range.to);
            return newRange2;
        } else if (range.from > this.from && range.from < this.to) {
            Range[] newRange2 = new Range[2];
            newRange2[0] = new Range(this.from, range.from);
            newRange2[1] = new Range(Math.min(range.to, this.to), Math.max(range.to, this.to));
            return newRange2;
        } else if (range.to < this.to && this.from < range.to) {
            Range[] newRange2 = new Range[2];
            newRange2[0] = new Range(range.from, this.from);
            newRange2[1] = new Range(Math.min(range.to, this.to), Math.max(range.to, this.to));
            return newRange2;
        } else {
            return new Range[0];
        }
    }
}