package com.example.recommendationservice.controller;

import com.example.recommendationservice.dto.CompanyResponseDto;
import com.example.recommendationservice.dto.RecommendationDto;
import com.example.recommendationservice.service.RecommendationServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationServiceService service;
    @GetMapping("/{id}")
    public RecommendationDto getRecommendationById(@PathVariable int id) {
        return service.getRecommendation(id);
    }
}
