package com.Lk.GameHub.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "favoritos", schema = "gamehub")
@NoArgsConstructor
@Getter
@Setter
public class Favoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeLista;

    @OneToMany(mappedBy = "favoritado")
    List<Game> games = new ArrayList<>();

    public Favoritos(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    @Override
    public String toString() {
        return "Favoritos{" +
                "nomeLista='" + nomeLista + '\'' +
                '}';
    }
}
