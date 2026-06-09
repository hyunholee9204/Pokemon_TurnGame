package com.example.Loguelike_Pokemon.Controller;

import com.example.Loguelike_Pokemon.Entity.SkillEntity;
import com.example.Loguelike_Pokemon.Service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody; // 추가

import java.util.List;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skill")
    public String getSkillList(Model model) {
        List<SkillEntity> skillList = skillService.getAllSkills();
        model.addAttribute("skillList", skillList);
        return "skill_list";
    }

    @GetMapping("/game/center")
    public String showPokemonCenter() {
        return "PokemonCenter";
    }

    @GetMapping("/api/skills/pedia")
    @ResponseBody
    public List<SkillEntity> getSkillPediaApi() {
        return skillService.getAllSkills();
    }
}