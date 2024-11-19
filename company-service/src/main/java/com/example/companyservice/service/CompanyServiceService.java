package com.example.companyservice.service;

import com.example.companyservice.dto.CompanyResponseDto;
import com.example.companyservice.entity.Company;
import com.example.companyservice.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CompanyServiceService {
    private final CompanyRepository companyRepository;
    public CompanyResponseDto getCompany(int id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new CompanyResponseDto(id, company.getName());
    }
}
