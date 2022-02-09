package com.rudolfs.bitbucket.ci.example;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DefaultPadelCourtReservationValidator implements PadelCourtReservationValidator {

    @Override
    public boolean isValidReservation(PadelCourtReservation reservation) {
        return hasValidDateAndStartTimeForReservation(reservation) && hasValidNumberOfPlayers(reservation);
    }

    private boolean hasValidDateAndStartTimeForReservation(PadelCourtReservation reservation) {
        return !DayOfWeek.SUNDAY.equals(reservation.date().getDayOfWeek()) &&
                reservation.startTime().isAfter(LocalTime.of(8, 59)) &&
                reservation.startTime().isBefore(LocalTime.of(22, 1));
    }

    private boolean hasValidNumberOfPlayers(PadelCourtReservation reservation) {
        return reservation.players().size() == 4;
    }
}
