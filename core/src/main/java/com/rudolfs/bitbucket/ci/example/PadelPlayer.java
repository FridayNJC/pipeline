package com.rudolfs.bitbucket.ci.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Getter
@ToString
@EqualsAndHashCode
public class PadelPlayer {

    private final @NonNull String id;
    private final @NonNull String surname;
    private final @NonNull String lastname;
}
