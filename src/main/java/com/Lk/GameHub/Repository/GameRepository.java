package com.Lk.GameHub.Repository;

import com.Lk.GameHub.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findById(Integer idGame);
}
