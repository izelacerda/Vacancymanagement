package com.mycarejs.vacancy_management.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "company")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "The [username] cannot contain spaces.")
  private String username;

  @Email(message = " The [e-mail] must be a valid e-mail address.")
  private String email;

  @Length(min = 10, max = 100, message = "The length of the password must be between 10 and 100.")
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String name;
  private String website;
  private String description;

}
