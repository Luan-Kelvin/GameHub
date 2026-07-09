package com.Lk.GameHub.API_Externa;

import com.Lk.GameHub.DTOs.GameDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ConsumeApi {
    private ObjectMapper mapper = new ObjectMapper();

    public List<GameDTO> searchGame(){
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://www.freetogame.com/api/games"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200){
                throw new RuntimeException("Erro ao consumir api: "+response.statusCode());
            }

            List<GameDTO> gameDtos = mapper.readValue(
                    response.body(),
                    mapper.getTypeFactory()
                            .constructCollectionType(List.class, GameDTO.class)
            );

            return gameDtos;


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
