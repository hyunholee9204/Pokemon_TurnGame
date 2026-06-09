package com.example.Loguelike_Pokemon.Service;

import com.example.Loguelike_Pokemon.Entity.RelicEntity;
import com.example.Loguelike_Pokemon.Repository.RelicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelicService {

    private final RelicRepository relicRepository;

    public List<RelicEntity> getAllRelics() {
        return relicRepository.findAll();
    }

    public RelicEntity getRelicById(Integer id) {
        return relicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유물입니다. ID: " + id));
    }
}
