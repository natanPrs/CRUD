package com.games.Games.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_game")
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    public Game(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public Game(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    private String publisher;

    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL)
    private BestOfTheYear bestOfTheYear;

    @JsonProperty("BestOfTheYear")
    public Object getBestOfTheYear() {
        return bestOfTheYear != null ? bestOfTheYear : "No";
    }

}
