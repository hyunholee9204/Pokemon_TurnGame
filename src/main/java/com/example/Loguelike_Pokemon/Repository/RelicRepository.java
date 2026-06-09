package com.example.Loguelike_Pokemon.Repository;

import com.example.Loguelike_Pokemon.Entity.RelicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelicRepository extends JpaRepository<RelicEntity, Integer> {

    RelicEntity findByRelicName(String relicName);
}
