package com.example.Loguelike_Pokemon.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "relic_pedia")
@NoArgsConstructor
@AllArgsConstructor
public class RelicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relic_id")
    private Integer relicId;

    @Column(name = "relic_name", nullable = false, length = 50)
    private String relicName;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "img_path", length = 255)
    private String imgPath;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
