package com.mycarejs.vacancy_management.modules.job.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycarejs.vacancy_management.modules.job.dto.CreateJobDTO;
import com.mycarejs.vacancy_management.modules.job.entities.JobEntity;
import com.mycarejs.vacancy_management.modules.job.useCases.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/company/job")
public class JobController {

  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping("/")
  @PreAuthorize("hasRole('COMPANY')")
  public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
    var companyId = request.getAttribute("company_id");
    var jobEntity = JobEntity.builder()
        .benefits(createJobDTO.getBenefits())
        .companyId(UUID.fromString(companyId.toString()))
        .description(createJobDTO.getDescription()) //
        .level(createJobDTO.getLevel())
        .build();
    // jobEntity.setCompanyId(UUID.fromString(companyId.toString()));
    try {
      var result = this.createJobUseCase.execute(jobEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
