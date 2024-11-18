package com.example.positionsservice.service;

import com.example.positionsservice.dto.PositionResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PositionService {
    public PositionResponseDto getPosition(int id) {
        return getPositionTable().get(id);
    }

    private Map<Integer, PositionResponseDto> getPositionTable() {
        Map<Integer, PositionResponseDto> map = new HashMap<>();
        map.put(1, new PositionResponseDto(1, "Project Manager"));
        map.put(2, new PositionResponseDto(2, "Business Analyst"));
        map.put(3, new PositionResponseDto(3, "Java programmer"));
        return map;
    }
}
