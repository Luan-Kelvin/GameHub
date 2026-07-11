package com.Lk.GameHub.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "games", schema = "gamehub")
@NoArgsConstructor
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idGame;

    private String titulo;

    private String genero;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String plataforma;

    private String desenvolvedora;

    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "id_lista_favoritos")
    Favoritos favoritado;
    public Game(
            Integer idGame, String titulo, String genero,
            String descricao, String plataforma,
            String desenvolvedora, LocalDate dataLancamento
    ) {
        this.idGame = idGame;
        this.titulo = titulo;
        this.genero = genero;
        this.descricao = descricao;
        this.plataforma = plataforma;
        this.desenvolvedora = desenvolvedora;
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "Game{" +
                "idGame=" + idGame +
                ", titulo='" + titulo + '\'' +
                ", desenvolvedora='" + desenvolvedora + '\'' +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
