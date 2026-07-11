package com.Lk.GameHub;

import com.Lk.GameHub.API_Externa.ConsumeApi;
import com.Lk.GameHub.DTOs.GameDTO;
import com.Lk.GameHub.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GameHubApplication implements CommandLineRunner {

	@Autowired
	ConsumeApi consumeApi;

	@Autowired
	GameService gameService;

	public static void main(String[] args) {
		SpringApplication.run(GameHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<GameDTO> games = consumeApi.searchGame();

		gameService.adicionarGameListDto(games);


	}
}
