package com.example.Loguelike_Pokemon.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "skill_pedia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "skill_name", nullable = false, length = 50)
    private String skillName;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "skill_category", length = 20)
    private String skillCategory;

    @Column(name = "power")
    private Integer power;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_discovered")
    private Boolean isDiscovered;

    @Column(name = "img_path")
    private String imgPath;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "sacrifice_amount")
    private Integer sacrificeAmount = 0; // 체력 소모량

    @Column(name = "buff_multiplier", precision = 3, scale = 1)
    private BigDecimal buffMultiplier = BigDecimal.valueOf(1.0); // 데미지 배율

    @Column(name = "exclude_self")
    private Boolean excludeSelf = false; // 시전자 제외 여부

    @Column(name = "cleanse_effect")
    private Boolean cleanseEffect = false; // 정화 효과 여부

    @Column(name = "tier")
    private Integer tier;

    @Column(name = "hit_count")
    private Integer hitCount = 1;

    @Column(name = "status_effect", length = 30)
    private String statusEffect; // 부여하는 상태 이상 종류 (예: "WET", "BURN")

    @Column(name = "status_duration")
    private Integer statusDuration = 0; // 상태 이상 지속 턴 수 (기본값 0: 부여 안 함)

    @Column(name = "reflect_damage")
    private Integer reflectDamage;
}