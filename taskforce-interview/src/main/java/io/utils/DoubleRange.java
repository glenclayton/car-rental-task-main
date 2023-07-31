package io.utils;

public class DoubleRange {
    private final double min;
    private final double max;
    public DoubleRange(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public boolean inRange(double x) {
        return ( (x>=min) && (x<=max));
    }
}
