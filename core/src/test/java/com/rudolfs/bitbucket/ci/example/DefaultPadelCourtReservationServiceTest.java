package com.rudolfs.bitbucket.ci.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultPadelCourtReservationServiceTest {

    @Mock
    private PadelCourtReservationRepository repository;

    @Mock
    private PadelCourtReservationValidator validator;

    private PadelCourtReservationService service;

    @BeforeEach
    void setup() {
        service = new DefaultPadelCourtReservationService(repository, validator);
    }

    @Test
    void makeSuccessfulReservation() {
        when(validator.isValidReservation(any())).thenReturn(true);

        Optional<PadelCourtReservation> reservationOptional = service.makeReservation(TestData.mainCourt(),
                TestData.validReservationDate(),
                TestData.validReservationStartTime(),
                TestData.players(4));

        assertThat(reservationOptional).isPresent();

        verify(repository, times(1)).save(reservationOptional.get());
    }

    // more tests...
}
