package com.example.recommendationservice.client;

import com.example.recommendationservice.dto.PositionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PositionServiceClient {
    private final RestTemplate restTemplate;
    public PositionResponseDto getPositionInfo(int positionId) {
        return restTemplate.getForObject("http://POSITION-SERVICE/position/" + positionId, PositionResponseDto.class);
    }
}
