package com.example.Loguelike_Pokemon.Service;

import com.example.Loguelike_Pokemon.Entity.SlotsEntity;
import com.example.Loguelike_Pokemon.Repository.SlotsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SlotsService {

    @Autowired
    private SlotsRepository slotsRepository;

    public List<SlotsEntity> getSortedSlots() {
        return slotsRepository.findAll(Sort.by(
                Sort.Order.desc("isActive"),
                Sort.Order.desc("lastPlayed"),
                Sort.Order.asc("slotId")
        ));
    }

    @Transactional
    public void saveNewGame(Integer slotId, String saveName) {
        SlotsEntity slot = slotsRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("슬롯을 찾을 수 없습니다."));
        slot.setSaveName(saveName);
        slot.setLastPlayed(LocalDateTime.now());
        slot.setActive(true);
        slot.setPlayerLevel(1);
        slot.setLastNode("n1");
        slotsRepository.save(slot);
    }

    @Transactional
    public void updateProgress(Integer slotId, String lastNode) {
        SlotsEntity slot = slotsRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("슬롯을 찾을 수 없습니다."));
        if (lastNode != null && !lastNode.isEmpty()) {
            slot.setLastNode(lastNode);
        }

        slot.setLastPlayed(LocalDateTime.now());
        slotsRepository.save(slot);
    }

    @Transactional
    public void deleteSlotById(Integer slotId) {
        SlotsEntity slot = slotsRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("삭제하려는 슬롯을 찾을 수 없습니다."));

        slot.setSaveName(null);
        slot.setActive(false);
        slot.setPlayerLevel(1);
        slot.setLastNode("n1");
        slot.setLastPlayed(null);

        slotsRepository.save(slot);
    }
}