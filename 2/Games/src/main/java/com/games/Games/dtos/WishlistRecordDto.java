package com.games.Games.dtos;

import com.games.Games.models.Game;
import com.games.Games.models.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record WishlistRecordDto(UUID user,
                                List<UUID> games) {
}
