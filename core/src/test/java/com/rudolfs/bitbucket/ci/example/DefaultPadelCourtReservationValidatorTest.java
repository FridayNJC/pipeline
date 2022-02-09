package com.rudolfs.bitbucket.ci.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultPadelCourtReservationValidatorTest {

    private PadelCourtReservationValidator validator;

    @BeforeEach
    void setup() {
        validator = new DefaultPadelCourtReservationValidator();
    }

    @Test
    void hasValidNumerOfPlayers() {
        PadelCourtReservation reservation = TestData.reservationWithXPlayers(4);
        assertThat(validator.isValidReservation(reservation)).isTrue();
    }

    @Test
    void hasInvalidNumerOfPlayers() {
        PadelCourtReservation reservation = TestData.reservationWithXPlayers(6);
        assertThat(validator.isValidReservation(reservation)).isFalse();
    }

    @Test
    void hasInvalidStartDate() {
        PadelCourtReservation reservation = TestData.reservationOnSunday();
        assertThat(validator.isValidReservation(reservation)).isFalse();
    }

    // more tests...
}
