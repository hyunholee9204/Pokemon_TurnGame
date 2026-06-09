package com.example.Loguelike_Pokemon.Repository;

import com.example.Loguelike_Pokemon.Entity.SlotsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SlotsRepository extends JpaRepository<SlotsEntity, Integer> {

    List<SlotsEntity> findAllByOrderByIsActiveDescLastPlayedDesc();
}
