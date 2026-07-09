package com.Lk.GameHub.DTOs;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GameDTO(
        @JsonAlias("id") Integer idGame,
        @JsonAlias("title") String titulo,
        @JsonAlias("thumbnail") String imagemMiniatura,
        @JsonAlias("short_description") String descricao,
        @JsonAlias("genre") String genero,
        @JsonAlias("platform") String plataforma,
        @JsonAlias("publisher") String publicadora,
        @JsonAlias("developer") String desenvolvedora,
        @JsonAlias("release_date") String dataLancamento
) {
}
