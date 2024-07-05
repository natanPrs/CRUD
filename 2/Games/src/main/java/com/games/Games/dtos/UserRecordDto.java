package com.games.Games.dtos;

import com.games.Games.models.Account;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

public record UserRecordDto(
        @NotEmpty(message = "Name cannot be empty")
        String name,

        @Valid
        Account account,

        Set<UUID> games){}