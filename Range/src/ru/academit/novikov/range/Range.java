package ru.academit.novikov.range;

public class Range {

    private double from;
    private double to;

    public Range() {
    }

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double lengthRange() {
        return Math.abs(to - from);
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

    //пересечение
    public Range intersection(Range r1, Range r2) {
        if (r1.to < r2.from || r2.to < r1.from) {
            return null;
        } else if (r2.from <= r1.to && r1.to <= r2.to) {
            this.from = r2.from;
            this.to = r1.to;
        } else if (r1.from <= r2.to && r2.to <= r1.to) {
            this.from = r1.from;
            this.to = r2.to;
        }
        return this;
    }

    //объединение
    public Range association(Range r1, Range r2) {

        if (r2.from <= r1.to || r1.from <= r2.to) {
            this.from = Math.min(r1.from, r2.from);
            this.to = Math.max(r1.to, r2.to);
            return this;
        } else if (r1.to < r2.from || r2.to < r1.from) {
            //this.from = Math.min(r1.from, r2.from);
            //this.to = Math.max(r1.to, r2.to);
            return null;
        }


        //this.from = Math.min(r1.from, r2.from);
        //this.to = Math.max(r1.to, r2.to);

        return null;
    }

    //разность
    public Range difference(Range r1, Range r2) {
        this.from = Math.min(r1.from, r2.from);
        this.to = Math.max(r1.to, r2.to);
        return this;
    }
}