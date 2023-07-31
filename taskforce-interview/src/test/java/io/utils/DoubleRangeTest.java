package io.utils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DoubleRangeTest {

    @Test
    void testVDoubleInRange() {
        DoubleRange dr = new DoubleRange(10.0, 20.0);
        assertThat(dr.inRange(15.0)).isTrue();
    }
    @Test
    void testVDoubleNotInRange() {
        DoubleRange dr = new DoubleRange(10.0, 20.0);
        assertThat(dr.inRange(25.0)).isFalse();
    }
}