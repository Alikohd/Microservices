package com.example.positionsservice.controller;

import com.example.positionsservice.dto.PositionResponseDto;
import com.example.positionsservice.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    @GetMapping("/{id}")
    public PositionResponseDto getPosition(@PathVariable int id) {
        PositionResponseDto position = positionService.getPosition(id);
        return position;
    }
}
