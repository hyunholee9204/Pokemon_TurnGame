package com.example.Loguelike_Pokemon.Service;

import com.example.Loguelike_Pokemon.Entity.SkillEntity;
import com.example.Loguelike_Pokemon.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<SkillEntity> getAllSkills() {
        return skillRepository.findAll();
    }
}
