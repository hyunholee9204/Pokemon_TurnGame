package com.example.Loguelike_Pokemon.Controller;

import com.example.Loguelike_Pokemon.Entity.PokemonEntity;
import com.example.Loguelike_Pokemon.Service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokedex")
    public String viewPokedex(Model model) {
        List<PokemonEntity> pokemonList = pokemonService.getAllPokemon();
        model.addAttribute("pokemonList", pokemonList);
        return "Pokemon_list"; //
    }

    @GetMapping("/game/cutscene")
    public String showCutscene(@RequestParam("name") String name, @RequestParam("slotId") Long slotId, Model model) {
        model.addAttribute("playerName", name);
        model.addAttribute("slotId", slotId);
        return "Cutscene";
    }

    @GetMapping("/game/lobby")
    public String showLobby() {
        return "Lobby";
    }

    @GetMapping("/game/map")
    public String showAdventureMap() {
        return "Adventure";
    }

    @GetMapping("/game/town")
    public String townHub() {
        return "Town";
    }

    @GetMapping("/game/relic")
    public String relicCenter() {
        return "RelicCenter";
    }

    @GetMapping("/game/enhance")
    public String enhanceCenter() {
        return "EnhanceCenter";
    }

    @GetMapping("/game/stage1_battle")
    public String stage1battle() {
        return "Stage1_battle";
    }
}