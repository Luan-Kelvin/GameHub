package com.Lk.GameHub.Repository;

import com.Lk.GameHub.Entity.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosRepository extends JpaRepository<Favoritos, Long> {
}
