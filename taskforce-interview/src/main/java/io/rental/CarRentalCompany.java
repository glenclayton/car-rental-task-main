package io.rental;

import java.util.ArrayList;
import java.util.List;

public class CarRentalCompany {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> matchingCars(Criteria criteria) {
        ArrayList<Car> matchingCars = new ArrayList<Car>();
        for (Car car : cars) {
            if (criteria.matches(car))
                matchingCars.add(car);
        }
        return matchingCars;
    }

    public void rentCar(Renter renter, Car car) {}

    public void returnCar(Renter renter, Car car) {}
}
