package com.example.recommendationservice.client;

import com.example.recommendationservice.dto.CompanyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CompanyServiceClient {
    private final RestTemplate template;
    public CompanyResponseDto getCompanyInfo(int companyId) {
        return template.getForObject("http://COMPANY-SERVICE/company/" + companyId, CompanyResponseDto.class);
    }
}
