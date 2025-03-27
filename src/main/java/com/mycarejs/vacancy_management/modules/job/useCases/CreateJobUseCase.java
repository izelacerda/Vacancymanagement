package com.mycarejs.vacancy_management.modules.job.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycarejs.vacancy_management.modules.job.entities.JobEntity;
import com.mycarejs.vacancy_management.modules.job.repositories.JobRepository;

@Service
public class CreateJobUseCase {

  @Autowired
  private JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity) {
    return this.jobRepository.save(jobEntity);
  }
}
