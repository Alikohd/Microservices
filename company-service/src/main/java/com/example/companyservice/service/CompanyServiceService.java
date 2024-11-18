package com.example.companyservice.service;

import com.example.companyservice.dto.CompanyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CompanyServiceService {
    public CompanyResponseDto getCompany(int id) {
        return getCompanyTable().get(id);
    }

    private Map<Integer, CompanyResponseDto> getCompanyTable() {
        Map<Integer, CompanyResponseDto> companyTable = new HashMap<>();
        companyTable.put(1, new CompanyResponseDto(1, "Amazon"));
        companyTable.put(2, new CompanyResponseDto(2, "Google"));
        companyTable.put(3, new CompanyResponseDto(3, "Microsoft"));
        return companyTable;
    }
}
