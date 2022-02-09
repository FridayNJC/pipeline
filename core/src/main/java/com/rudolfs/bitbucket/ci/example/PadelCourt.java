package com.rudolfs.bitbucket.ci.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Set;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Getter
@ToString
@EqualsAndHashCode
public class PadelCourt {

    private final @NonNull String id;
    private final @NonNull String name;
    private final @NonNull Set<PadelCourtReservation> reservations;
}
