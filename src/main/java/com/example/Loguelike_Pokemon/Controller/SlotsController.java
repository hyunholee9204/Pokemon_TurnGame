package com.example.Loguelike_Pokemon.Controller;

import com.example.Loguelike_Pokemon.Entity.SlotsEntity;
import com.example.Loguelike_Pokemon.Service.SlotsService;
import com.example.Loguelike_Pokemon.SlotsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SlotsController {

    @Autowired
    private SlotsService slotsService;

    @GetMapping("/slots")
    public String slotsPage(Model model) {
        List<SlotsEntity> slots = slotsService.getSortedSlots();
        model.addAttribute("slots", slots);
        return "Slots";
    }

    @PostMapping("/api/slots/create")
    @ResponseBody
    public ResponseEntity<String> createGame(@RequestBody SlotsRequest request) {
        slotsService.saveNewGame(request.getSlotId(), request.getSaveName());
        return ResponseEntity.ok("게임이 성공적으로 생성되었습니다.");
    }

    @GetMapping("/api/slots")
    @ResponseBody
    public ResponseEntity<List<SlotsEntity>> getAllSlots() {
        return ResponseEntity.ok(slotsService.getSortedSlots());
    }

    @PostMapping("/api/slots/update")
    @ResponseBody
    public ResponseEntity<String> updateGameProgress(@RequestBody SlotsRequest request) {
        try {
            slotsService.updateProgress(request.getSlotId(), request.getLastNode());
            return ResponseEntity.ok("성공적으로 저장되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("저장 실패: " + e.getMessage());
        }
    }

    @DeleteMapping("/api/slots/delete/{slotId}")
    @ResponseBody
    public ResponseEntity<String> deleteSlot(@PathVariable("slotId") int slotId) {
        try {
            System.out.println("🔥 [API] 세이브 슬롯 삭제 요청 접수 완료! 슬롯 번호: " + slotId);

            slotsService.deleteSlotById(slotId);

            return ResponseEntity.ok("슬롯이 성공적으로 삭제(초기화)되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("슬롯 삭제 실패: " + e.getMessage());
        }
    }
}