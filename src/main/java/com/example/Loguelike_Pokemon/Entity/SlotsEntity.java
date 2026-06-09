package com.example.Loguelike_Pokemon.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table (name = "game_slots")
public class SlotsEntity {

    @Id
    private Integer slotId; // 1~5번 슬롯
    private String saveName; // 게임 이름
    private LocalDateTime lastPlayed; // 최근 플레이 시간

    @Column(name = "is_active")
    private boolean isActive; // 데이터 존재 여부

    @Column(name = "player_level")
    private Integer playerLevel = 1;

    @Column(name = "last_node")
    private String lastNode = "n1";
}
