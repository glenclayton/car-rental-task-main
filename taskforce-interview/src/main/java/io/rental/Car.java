package io.rental;

import java.util.SortedSet;
import java.util.TreeSet;

import io.utils.DatePeriod;
import io.utils.DatePeriodUtil;

public class Car {
    private final String make;
    private final String model;
    private final String registrationNumber;
    private String rentalGroup;
    private double costPerDay;
    private SortedSet<Rental> rentals;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getRentalGroup() {
        return rentalGroup;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void rent(Rental rental) {
        rentals.add(rental);
    }

    public Car(String make, String model, String registrationNumber, String rentalGroup, double costPerDay) {
        this.make = make;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.rentalGroup = rentalGroup;
        this.costPerDay = costPerDay;
        rentals = new TreeSet<Rental>();
    }

	public boolean isAvailable(DatePeriod dates) {
        for (Rental rental : rentals) {
            if (DatePeriodUtil.areOverlapping(rental.getPeriod(), dates))
                return false;
        }
		return true;
	}

   

}
