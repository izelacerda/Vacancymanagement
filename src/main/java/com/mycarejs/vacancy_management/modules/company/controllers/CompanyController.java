package com.mycarejs.vacancy_management.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycarejs.vacancy_management.modules.company.entities.CompanyEntity;
import com.mycarejs.vacancy_management.modules.company.useCases.CreateCompanyUseCase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CreateCompanyUseCase createCompanyUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {

    try {
      var result = this.createCompanyUseCase.execute(companyEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
