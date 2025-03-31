package com.mycarejs.vacancy_management.modules.job.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {

  @Schema(example = "Vacancy for junior developer", requiredMode = RequiredMode.REQUIRED)
  private String description;
  @Schema(example = "GYMPass, Health Insurance", requiredMode = RequiredMode.REQUIRED)
  private String benefits;
  @Schema(example = "SENIOR", requiredMode = RequiredMode.REQUIRED)
  private String level;
}
