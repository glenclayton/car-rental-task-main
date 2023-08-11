package io.rental;
import io.utils.DatePeriod;
import io.utils.DatePeriodUtil;
import java.util.ArrayList;
import java.util.List;

public class CarRentalCompany {
    private List<Car> cars = new ArrayList<>();
    private List<Car> rentedCars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }
    public List<Car> matchingCars(Criteria criteria) {
        ArrayList<Car> matchingCars = new ArrayList<Car>();
        synchronized(cars) {
        for (Car car : cars) {
            if (criteria.matches(car))
                matchingCars
                .add(car);
            }
        }      
        return matchingCars;
    }

    public List<Car> matchingAvailableCars(Criteria criteria, DatePeriod dates) {
        ArrayList<Car> matchingAvailableCars = new ArrayList<Car>();
        synchronized(cars) {
        for (Car car : cars) {
            if (criteria.matches(car) && car.isAvailable(dates))
                matchingAvailableCars.add(car);
            }   
        }
        return matchingAvailableCars;
    }

    public boolean rentCar(Renter renter, Car car, DatePeriod period) {
        synchronized(car) {
            if(car.isAvailable(period)) {
                car.rent(new Rental(renter,period));
                synchronized(rentedCars) {
                    rentedCars.add(car); // add to list of rented cars
                }
                return true; //success
            }
        }
        return false;
    }


    public void returnCar(Renter renter, Car car) {
        // iterate through rented cars
        // find the car with the same registration number   
        // remove the car from the list of rented cars
        for(Car c : rentedCars) {
            if(c.getRegistrationNumber().equals(car.getRegistrationNumber())) {
                rentedCars.remove(c);
                break;
            }
        
    }
}
