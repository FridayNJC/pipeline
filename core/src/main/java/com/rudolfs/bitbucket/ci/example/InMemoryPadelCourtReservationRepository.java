package com.rudolfs.bitbucket.ci.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryPadelCourtReservationRepository implements PadelCourtReservationRepository {

    private final Map<String, PadelCourtReservation> reservations = new HashMap<>();

    @Override
    public void save(PadelCourtReservation padelCourtReservation) {
        this.reservations.put(padelCourtReservation.id(), padelCourtReservation);
    }

    @Override
    public Optional<PadelCourtReservation> findById(String id) {
        return Optional.ofNullable(this.reservations.get(id));
    }
}
