package com.mycarejs.vacancy_management.modules.job.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycarejs.vacancy_management.modules.job.entities.JobEntity;
import java.util.List;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
  // "contains - LIKE"
  List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
