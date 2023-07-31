package io.rental;
import io.utils.DoubleRange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.Factory.CreationAction;
import net.bytebuddy.agent.utility.nullability.NeverNull.ByDefault;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRentalTest {

    private static final Car CAR1 = new Car("VW", "Golf", "XX11 1UR", "B2", 90);
    private static final Car CAR2 = new Car("VW", "Passat", "XX12 2UR",  "C1", 110);
    private static final Car CAR3 = new Car("VW", "Polo", "XX13 3UR",  "A1", 65);
    private static final Car CAR4 = new Car("VW", "Polo", "XX14 4UR",  "A1", 70);

    private static final Renter RENTER1 = new Renter("Hydrogen", "Joe", "HYDRO010190JX8NM", LocalDate.of(1990, 1, 1));
    private static final Renter RENTER2 = new Renter("Calcium", "Sam", "CALCI010203SX8NM", LocalDate.of(2003, 2, 1));
    private static final Renter RENTER3 = new Renter("Neon", "Maisy", "NEONN010398MX8NM", LocalDate.of(1998, 3, 1));
    private static final Renter RENTER4 = new Renter("Carbon", "Greta", "CARBO010497GX8NM", LocalDate.of(1997, 4, 1));

   
    @Test
    public void testListCarsAvailableToRentGivesMoreThanOneCar() {
        CarRentalCompany carRentalCompany = new CarRentalCompany();
        carRentalCompany.addCar(CAR1);
        carRentalCompany.addCar(CAR2);
        carRentalCompany.addCar(CAR3);
        carRentalCompany.addCar(CAR4);

        Criteria criteria = new Criteria(Criteria.Field.MAKE,"VW");
        List<Car> carsAvailable = carRentalCompany.matchingCars(criteria);

        assertThat(carsAvailable.size()).isGreaterThan(1);
    }

    @Test
    public void testListCarAvailableByGroupReturnOneCar() {
        CarRentalCompany carRentalCompany = new CarRentalCompany();
        carRentalCompany.addCar(CAR1);
        carRentalCompany.addCar(CAR2);
        carRentalCompany.addCar(CAR3);
        carRentalCompany.addCar(CAR4);

        Criteria criteria = new Criteria(Criteria.Field.GROUP,"C1");
        List<Car> carsAvailable = carRentalCompany.matchingCars(criteria);

        assertThat(carsAvailable.size()).isEqualTo(1);  

    }
    @Test
    public void testListCarAvailableByModleReturnOneCar() {
        CarRentalCompany carRentalCompany = new CarRentalCompany();
        carRentalCompany.addCar(CAR1);
        carRentalCompany.addCar(CAR2);
        carRentalCompany.addCar(CAR3);
        carRentalCompany.addCar(CAR4);

        Criteria criteria = new Criteria(Criteria.Field.MODEL,"Golf");
        List<Car> carsAvailable = carRentalCompany.matchingCars(criteria);

        assertThat(carsAvailable.size()).isEqualTo(1);  

    }

    @Test
    public void testListCarAvailableByPriceReturnOneCar() {
        CarRentalCompany carRentalCompany = new CarRentalCompany();
        carRentalCompany.addCar(CAR1);
        carRentalCompany.addCar(CAR2);
        carRentalCompany.addCar(CAR3);
        carRentalCompany.addCar(CAR4);

        Criteria criteria = new Criteria(new DoubleRange(85,96));
        List<Car> carsAvailable = carRentalCompany.matchingCars(criteria);

        assertThat(carsAvailable.size()).isEqualTo(1);  

    }

    @Test
    public void testListCarAvailableByPriceReturnTwoCars() {
        CarRentalCompany carRentalCompany = new CarRentalCompany();
        carRentalCompany.addCar(CAR1);
        carRentalCompany.addCar(CAR2);
        carRentalCompany.addCar(CAR3);
        carRentalCompany.addCar(CAR4);

        Criteria criteria = new Criteria(new DoubleRange(85,120));
        List<Car> carsAvailable = carRentalCompany.matchingCars(criteria);

        assertThat(carsAvailable.size()).isEqualTo(2);  

    }
}
