package com.rankdat.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rankdat.models.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
