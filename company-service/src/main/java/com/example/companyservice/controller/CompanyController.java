package com.example.companyservice.controller;

import com.example.companyservice.dto.CompanyResponseDto;
import com.example.companyservice.service.CompanyServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyServiceService service;

    @GetMapping("/{id}")
    public CompanyResponseDto getCompany(@PathVariable int id) {
        return service.getCompany(id);
    }
}
