package io.rental;

import io.utils.DoubleRange;

public class Criteria {
    public static enum Field {MAKE,MODEL,GROUP,COSTPERDAY}

    private Field field;
    private String stringValue;
    private DoubleRange doubleRangeValue;

    public Criteria(Field field, String stringValue) {
        this.field = field;
        this.stringValue = stringValue;
    }

    public Criteria(DoubleRange doubleRangeValue) {
        this.field = Field.COSTPERDAY;
        this.doubleRangeValue = doubleRangeValue;
    }
    public boolean matches(Car car) {
        switch(field) {
            case MAKE:
                return stringValue.equals(car.getMake());
            case MODEL:
                return stringValue.equals(car.getModel());
            case GROUP:
                return stringValue.equals(car.getRentalGroup());
            case COSTPERDAY:
                return doubleRangeValue.inRange(car.getCostPerDay());

        }
        return false;
    }
}
