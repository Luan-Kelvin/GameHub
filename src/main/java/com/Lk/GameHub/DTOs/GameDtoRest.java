package com.Lk.GameHub.DTOs;

public record GameDtoRest(
        Integer idGame,
        String titulo,
        String genero,
        String descricao,
        String plataforma,
        String desenvolvedora,
        String dataLancamento
) {
}
