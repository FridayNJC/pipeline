package com.rudolfs.bitbucket.ci.example;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class PadelCourtReservation {

    private final @NonNull String id;
    private final @NonNull PadelCourt padelCourt;
    private final @NonNull LocalDate date;
    private final @NonNull LocalTime startTime;
    private final @NonNull Set<PadelPlayer> players;
}
