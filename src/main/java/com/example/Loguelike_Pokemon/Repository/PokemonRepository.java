package com.example.Loguelike_Pokemon.Repository;

import com.example.Loguelike_Pokemon.Entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
    List<PokemonEntity> findByType(String type);
    List<PokemonEntity> findByPokeIdBetween(Integer start, Integer end);
}
