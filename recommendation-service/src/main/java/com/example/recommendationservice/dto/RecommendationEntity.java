package com.example.recommendationservice.dto;

public record RecommendationEntity(int id, String fullName, int companyId, int positionId, String recommendation) {
}
