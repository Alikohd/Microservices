package com.example.recommendationservice.service;

import com.example.recommendationservice.client.CompanyServiceClient;
import com.example.recommendationservice.client.PositionServiceClient;
import com.example.recommendationservice.dto.CompanyResponseDto;
import com.example.recommendationservice.dto.PositionResponseDto;
import com.example.recommendationservice.dto.RecommendationDto;
import com.example.recommendationservice.dto.RecommendationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RecommendationServiceService {
    private final CompanyServiceClient companyServiceClient;
    private final PositionServiceClient positionServiceClient;

    private CompanyResponseDto getCompanyInfo(int id) {
        CompanyResponseDto companyDto = companyServiceClient.getCompanyInfo(getRecommendationTable().get(id).companyId());
        return companyDto;
    }

    private PositionResponseDto getPositionInfo(int id) {
        PositionResponseDto positionDto = positionServiceClient.getPositionInfo(getRecommendationTable().get(id).positionId());
        return positionDto;
    }


    public RecommendationDto getRecommendation(int id) {
        RecommendationEntity recommendationEntity = getRecommendationTable().get(id);
        return new RecommendationDto(id, recommendationEntity.fullName(), getCompanyInfo(id).company(), getPositionInfo(id).position(), recommendationEntity.recommendation());
    }

    private Map<Integer, RecommendationEntity> getRecommendationTable() {
        Map<Integer, RecommendationEntity> recommendationTable = new HashMap<>();
        recommendationTable.put(1, new RecommendationEntity(1, "Ivan Ivanov", 1, 1, "Very responsible employee"));
        recommendationTable.put(2, new RecommendationEntity(2, "Aleksei Petrov", 2, 2, "Hardworking employee"));
        recommendationTable.put(3, new RecommendationEntity(3, "Alex Van", 3, 3, "Experienced employee"));
        return recommendationTable;
    }

}
