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

    public Range intersection(Range r1, Range r2) {
        double newFrom;
        double newTo;
        if (r1.to < r2.from || r2.to < r1.from) {
            return null;
        } else if (r2.from <= r1.to && r1.to <= r2.to) {
            newFrom = r2.from;
            newTo = r1.to;
            this.from = newFrom;
            this.to = newTo;
        } else if (r1.from <= r2.to && r2.to <= r1.to) {
            newFrom = r1.from;
            newTo = r2.to;
            this.from = newFrom;
            this.to = newTo;
        }
        return this;
    }

    @Override
    public String toString() {
        return "(" + this.from + " , " + this.to + ")";

    }

    public Range[] combination(Range r1, Range r2) {
        Range r3 = new Range();
        Range r4 = new Range();
        Range[] newRange = new Range[1];
        if (r2.from <= r1.to && r1.from <= r2.to) {
            r3.from = Math.min(r1.from, r2.from);
            r3.to = Math.max(r1.to, r2.to);
            newRange[0] = r3;
        } else if (r2.to < r1.from || r1.to < r2.from) {
            Range[] newRange2 = new Range[2];
            r3.from = Math.min(r1.from, r2.from);
            r3.to = Math.min(r1.to, r2.to);
            r4.from = Math.max(r1.from, r2.from);
            r4.to = Math.max(r1.to, r2.to);
            newRange2[0] = r3;
            newRange2[1] = r4;
            return newRange2;
        }
        return newRange;
    }

    //разность
    public Range[] difference(Range r2) {
        double[] temp = new double[2];

        Range[] newRange = new Range[2];
        newRange[0] = r2;
        newRange[1] = this;
        newRange[0].from = 1;
        newRange[0].to = 11;

        //Range r3;
        temp[0] = 0;
        temp[1] = 1;


        if (this.to < r2.from || r2.to < this.from) {
            return newRange;
        }

        //this=temp;
//        this.from = Math.min(r1.from, r2.from);
//        this.to = Math.max(r1.to, r2.to);
        return newRange;
    }
}