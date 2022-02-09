package com.rudolfs.bitbucket.ci.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class DefaultPadelCourtReservationService implements PadelCourtReservationService {

    private final PadelCourtReservationRepository repository;
    private final PadelCourtReservationValidator validator;

    public DefaultPadelCourtReservationService(PadelCourtReservationRepository repository,
                                               PadelCourtReservationValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public Optional<PadelCourtReservation> makeReservation(PadelCourt padelCourt, LocalDate date, LocalTime startTime, Set<PadelPlayer> players) {

        final PadelCourtReservation reservation = new PadelCourtReservation(UUID.randomUUID().toString(), padelCourt, date, startTime, players);

        if (validator.isValidReservation(reservation)) {
            repository.save(reservation);
            return Optional.of(reservation);
        }
        return Optional.empty();
    }

    @Override
    public Optional<PadelCourtReservation> findReservationById(String id) {
        return repository.findById(id);
    }


}
