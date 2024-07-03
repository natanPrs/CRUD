package com.games.Games.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_wishlist")
public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1L;

    public Wishlist(Set<Game> games) {
        this.games = games;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(
            name = "wishlist_games",
            joinColumns = @JoinColumn(name = "wishlist_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> games = new HashSet<>();

    @JsonProperty("User")
    public String getNameUser(){
        return user.getName();
    }

    @JsonProperty("games")
    public Set<String> getGameTitles() {
        Set<String> gameTitles = new HashSet<>();
        for (Game game : games) {
            gameTitles.add(game.getTitle());
        }
        return gameTitles;
    }
}
