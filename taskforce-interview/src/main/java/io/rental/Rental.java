package io.rental;
import io.utils.DatePeriod;
import io.utils.DatePeriodUtil;

public class Rental implements Comparable<Rental> {
    private final Renter renter;
    private final DatePeriod period;

    public Renter getRenter() {
        return renter;
    }

    public DatePeriod getPeriod() {
        return period;
    }

    public Rental(Renter renter, DatePeriod period) {
        this.renter = renter;
        this.period = period;
    }

    public int compareTo(Rental rental) {
        return period.getStart().compareTo(rental.getPeriod().getStart());
    }
}
