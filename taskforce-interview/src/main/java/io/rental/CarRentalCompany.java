package io.rental;
import io.utils.DatePeriod;
import io.utils.DatePeriodUtil;
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

    public List<Car> matchingAvailableCars(Criteria criteria, DatePeriod dates) {
        ArrayList<Car> matchingAvailableCars = new ArrayList<Car>();
        for (Car car : cars) {
            if (criteria.matches(car) && car.isAvailable(dates))
                matchingAvailableCars.add(car);
        }
        return matchingAvailableCars;
    }

    public void rentCar(Renter renter, Car car) {}

    public void returnCar(Renter renter, Car car) {}
}
