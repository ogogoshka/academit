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

    public Range intersection(Range r2) {
        if (this.to <= r2.from || r2.to <= this.from) {
            return null;
        } else {
            if (this.from > r2.from && r2.to <= this.to) {
                return new Range(this.from, Math.min(r2.to, this.to));
            } else if (this.to <= r2.to && this.from < r2.from) {
                return new Range(Math.max(r2.from, this.from), this.to);
            } else if (r2.from < this.from && r2.to > this.to) {
                return new Range(this.from, this.to);
            } else {
                return new Range(r2.from, r2.to);
            }
        }
    }

    /*

        public Range intersection(Range r2) {
        if (!isIntersection(r2)) {
            return null;
        } else {
            if (this.from < r2.to && r2.to < this.to) {
                return new Range(this.from, Math.min(r2.to, this.to));
            } else if (this.to < r2.to && this.to > r2.from) {
                return new Range(Math.min(r2.from, this.from), this.to);
            } else {
                return null;
            }
        }
    }


     */
    /*

        public Range intersection(Range r2) {
        Range r3 = new Range();

        if (this.to <= r2.from || r2.to <= this.from) {
            //Range r3 = new Range();
            return null;
        } else if (this.from <= r2.from && r2.to <= this.to) {
            return new Range(Math.max(this.from, r2.from), Math.min(r2.to, this.to));
        } else if (isInside(r2.from) && !isInside(r2.to)) {
            return new Range(r2.from, this.to);
        } else if (!isInside(r2.from) && isInside(r2.to)) {
            return new Range(this.from, r2.to);
        }
        return r3;
    }

     */


    public Range[] difference(Range r2) {
        //Range r3 = new Range();
        //Range r4 = new Range();
        Range[] newRange = new Range[1];
        if (this.to < r2.from || r2.to < this.from) {
            newRange[0] = new Range(this.from, this.to);
        } else if (this.from < r2.from && r2.to < this.to) {
            Range[] newRange2 = new Range[2];
            newRange2[0] = new Range(this.from, r2.from);
            newRange2[1] = new Range(r2.to, this.to);
            return newRange2;
        } else if (this.from == r2.from && r2.to == this.to) {
            newRange[0] = new Range(this.from, this.to);
        } else if (isInside(r2.from) && !isInside(r2.to)) {
            Range[] newRange2 = new Range[2];
            newRange2[0] = new Range(this.from, r2.from);
            newRange2[1] = new Range(this.to, r2.to);
            return newRange2;
        } else if (!isInside(r2.from) && isInside(r2.to)) {
            Range[] newRange2 = new Range[2];
            newRange2[0] = new Range(r2.from, this.from);
            newRange2[1] = new Range(r2.to, this.to);
            return newRange2;
        }
        return newRange;
    }

    //объединение
    public Range[] union(Range r2) {
        Range[] newRange = new Range[1];
        if (isInside(r2.from) || isInside(r2.to)) {
            Range r3 = new Range(Math.min(this.from, r2.from), Math.max(r2.to, this.to));
            newRange[0] = r3;
        } else if (this.to < r2.from || r2.to < this.from) {
            Range[] newRange2 = new Range[2];
            if (this.to < r2.to) {
                newRange2[0] = this;
                newRange2[1] = r2;
                return newRange2;
            } else {
                newRange2[0] = r2;
                newRange2[1] = this;
                return newRange2;
            }
        }
        return newRange;
    }
}