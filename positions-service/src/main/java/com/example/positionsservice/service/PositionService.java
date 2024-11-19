package com.example.positionsservice.service;

import com.example.positionsservice.dto.PositionResponseDto;
import com.example.positionsservice.entity.Position;
import com.example.positionsservice.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionResponseDto getPosition(int id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new PositionResponseDto(position.getId(), position.getName());
    }
}
