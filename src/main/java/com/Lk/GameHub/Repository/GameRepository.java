package com.Lk.GameHub.Repository;

import com.Lk.GameHub.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
