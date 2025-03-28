package com.mycarejs.vacancy_management.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

  @Schema(example = "Java Developer")
  private String description;
  @Schema(example = "Richard")
  private String username;
  @Schema(example = "richard@gmail.com")
  private String email;

  private UUID id;
  @Schema(example = "Richard Peterson")
  private String name;
}
