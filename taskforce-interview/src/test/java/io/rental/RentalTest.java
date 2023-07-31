package io.rental;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import io.utils.DatePeriod;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RentalTest {
    private static final Renter RENTER1 = new Renter("Hydrogen", "Joe", "HYDRO010190JX8NM", LocalDate.of(1990, 1, 1));
    private static final Renter RENTER2 = new Renter("Calcium", "Sam", "CALCI010203SX8NM", LocalDate.of(2003, 2, 1));
    @Test
    public void testComparisonLessThan() {
        DatePeriod one = new DatePeriod(LocalDate.of(2023, 01, 15), LocalDate.of(2023, 01, 16)); 
        DatePeriod two = new DatePeriod(LocalDate.of(2023, 01, 21), LocalDate.of(2023, 01, 23)); 
        Rental rental1 = new Rental(RENTER1, one);
        Rental rental2 = new Rental(RENTER2, two);
        assertThat(rental1.compareTo(rental2)).isLessThan(0);
    }
}
