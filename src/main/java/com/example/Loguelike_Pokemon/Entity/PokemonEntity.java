package com.example.Loguelike_Pokemon.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "pokemon_dict")
public class PokemonEntity {

    @Id
    @Column(name = "poke_id")
    private Integer pokeId; // 도감 번호 (PK)

    @Column(nullable = false, length = 50)
    private String name; // 포켓몬 이름

    @Column(nullable = false, length = 20)
    private String type; // 속성 (전기, 불꽃 등)

    private Integer hp;
    private Integer atk;
    private Integer def;
    private Integer speed;

    @Column(name = "img_path", nullable = false)
    private String imgPath; // 이미지 파일명 (예: 피카츄.webp)
}
