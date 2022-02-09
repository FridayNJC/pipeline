package com.rudolfs.bitbucket.ci.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultPadelCourtReservationServiceIT {

    private PadelCourtReservationService service;

    @BeforeEach
    void setup() {
        PadelCourtReservationRepository repository = new InMemoryPadelCourtReservationRepository();
        PadelCourtReservationValidator validator = new DefaultPadelCourtReservationValidator();
        service = new DefaultPadelCourtReservationService(repository, validator);
    }

    @Test
    void makeSuccessfulReservation() {
        PadelCourt padelCourt = TestData.mainCourt();
        LocalDate reservationDate = TestData.validReservationDate();
        LocalTime reservationStartTime = TestData.validReservationStartTime();
        Set<PadelPlayer> players = TestData.players(4);

        Optional<PadelCourtReservation> reservationOptional =
                service.makeReservation(padelCourt, reservationDate, reservationStartTime, players);

        assertThat(reservationOptional).isPresent()
                .hasValueSatisfying(reservation -> {
                    assertThat(reservation.id()).isNotEmpty();
                    assertThat(reservation.padelCourt()).isEqualTo(padelCourt);
                    assertThat(reservation.date()).isEqualTo(reservationDate);
                    assertThat(reservation.startTime()).isEqualTo(reservationStartTime);
                    assertThat(reservation.players()).isEqualTo(players);
                });
    }

    @Test
    void makeReservationWithInvalidNumberOfPlayers() {
        PadelCourt padelCourt = TestData.mainCourt();
        LocalDate reservationDate = TestData.validReservationDate();
        LocalTime reservationStartTime = TestData.validReservationStartTime();
        Set<PadelPlayer> players = TestData.players(6);

        Optional<PadelCourtReservation> reservationOptional =
                service.makeReservation(padelCourt, reservationDate, reservationStartTime, players);

        assertThat(reservationOptional).isNotPresent();
    }

    // more tests...
}
