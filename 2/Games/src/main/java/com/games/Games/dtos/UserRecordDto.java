package com.games.Games.dtos;

import com.games.Games.models.Account;

import java.util.Set;
import java.util.UUID;

public record UserRecordDto(String name,
                            Account account,
                            Set<UUID> games){}