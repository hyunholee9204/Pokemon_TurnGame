package com.example.Loguelike_Pokemon;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SlotsRequest {

    private Integer slotId;
    private String saveName;
    private String lastNode;
}
