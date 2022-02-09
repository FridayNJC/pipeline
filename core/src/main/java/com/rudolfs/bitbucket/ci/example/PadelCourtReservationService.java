package com.rudolfs.bitbucket.ci.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;

public interface PadelCourtReservationService {

    Optional<PadelCourtReservation> makeReservation(PadelCourt padelCourt, LocalDate day, LocalTime startTime, Set<PadelPlayer> players);

    Optional<PadelCourtReservation> findReservationById(String id);
}
