package com.example.Loguelike_Pokemon.Service;

import com.example.Loguelike_Pokemon.Entity.PokemonEntity;
import com.example.Loguelike_Pokemon.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    // 모든 포켓몬 조회
    public List<PokemonEntity> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    // 특정 속성별 조회 (나중에 버튼 클릭 시 서버 필터링을 쓸 경우)
    public List<PokemonEntity> getPokemonByType(String type) {
        return pokemonRepository.findByType(type);
    }
}
