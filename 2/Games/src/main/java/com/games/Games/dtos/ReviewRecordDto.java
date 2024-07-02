package com.games.Games.dtos;

import java.util.Set;
import java.util.UUID;

public record ReviewRecordDto(String title,
                              String description,
                              Float rating,
                              UUID user,
                              UUID game) {}
