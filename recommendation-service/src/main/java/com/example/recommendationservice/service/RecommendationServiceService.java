package com.example.recommendationservice.service;

import com.example.recommendationservice.client.CompanyServiceClient;
import com.example.recommendationservice.client.PositionServiceClient;
import com.example.recommendationservice.dto.CompanyResponseDto;
import com.example.recommendationservice.dto.PositionResponseDto;
import com.example.recommendationservice.dto.RecommendationDto;
import com.example.recommendationservice.entity.Recommendation;
import com.example.recommendationservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class RecommendationServiceService {
    private final CompanyServiceClient companyServiceClient;
    private final PositionServiceClient positionServiceClient;
    private final RecommendationRepository recommendationRepository;

    private CompanyResponseDto getCompanyInfo(int id) {
        return companyServiceClient.getCompanyInfo(id);
    }

    private PositionResponseDto getPositionInfo(int id) {
        return positionServiceClient.getPositionInfo(id);
    }

    public RecommendationDto getRecommendation(int id) {
        Recommendation recommendationEntity = recommendationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new RecommendationDto(id, recommendationEntity.getFullname(), getCompanyInfo(id).companyName(), getPositionInfo(id).positionName(), recommendationEntity.getRecommendation());
    }
}
