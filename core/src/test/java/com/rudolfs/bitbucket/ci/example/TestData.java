package com.rudolfs.bitbucket.ci.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.emptySet;

public final class TestData {

    private TestData() {
    }

    public static PadelCourt mainCourt() {
        return new PadelCourt(UUID.randomUUID().toString(), "main-court", emptySet());
    }

    public static PadelCourtReservation reservationWithXPlayers(int nrPlayers) {
        return PadelCourtReservation.builder()
                .id(UUID.randomUUID().toString())
                .padelCourt(mainCourt())
                .date(validReservationDate())
                .startTime(validReservationStartTime())
                .players(players(nrPlayers))
                .build();
    }

    public static PadelCourtReservation reservationOnSunday() {
        return PadelCourtReservation.builder()
                .id(UUID.randomUUID().toString())
                .padelCourt(mainCourt())
                .date(startDateOnSunday())
                .startTime(validReservationStartTime())
                .players(players(4))
                .build();
    }

    private static PadelPlayer player(int number) {
        return new PadelPlayer(UUID.randomUUID().toString(), "surname" + number, "lastname" + number);
    }

    public static Set<PadelPlayer> players(int nrPlayers) {
        return IntStream.rangeClosed(1, nrPlayers)
                .mapToObj(i -> player(i))
                .collect(Collectors.toSet());
    }

    public static LocalDate validReservationDate() {
        return LocalDate.of(2020, 10, 9);
    }

    public static LocalDate startDateOnSunday() {
        return LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
    }

    public static LocalTime validReservationStartTime() {
        return LocalTime.of(21, 0);
    }
}
