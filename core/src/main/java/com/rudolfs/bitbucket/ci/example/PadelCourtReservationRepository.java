package com.rudolfs.bitbucket.ci.example;

import java.util.Optional;

public interface PadelCourtReservationRepository {

    void save(PadelCourtReservation padelCourtReservation);

    Optional<PadelCourtReservation> findById(String id);
}
