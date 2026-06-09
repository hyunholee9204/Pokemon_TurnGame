package com.example.Loguelike_Pokemon.Controller;

import com.example.Loguelike_Pokemon.Entity.RelicEntity;
import com.example.Loguelike_Pokemon.Service.RelicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/relics")
@RequiredArgsConstructor
public class RelicController {

    private final RelicService relicService;

    @GetMapping("/pedia")
    public ResponseEntity<List<RelicEntity>> getRelicPedia() {
        List<RelicEntity> relics = relicService.getAllRelics();
        return ResponseEntity.ok(relics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelicEntity> getRelicDetail(@PathVariable Integer id) {
        return ResponseEntity.ok(relicService.getRelicById(id));
    }
}
