package com.mycarejs.vacancy_management.modules.job.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycarejs.vacancy_management.exceptions.CompanyNotFoundException;
import com.mycarejs.vacancy_management.modules.company.repositories.CompanyRepository;
import com.mycarejs.vacancy_management.modules.job.entities.JobEntity;
import com.mycarejs.vacancy_management.modules.job.repositories.JobRepository;

@Service
public class CreateJobUseCase {

  @Autowired
  private JobRepository jobRepository;

  @Autowired
  private CompanyRepository companyRepository;

  public JobEntity execute(JobEntity jobEntity) {
    companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
      throw new CompanyNotFoundException();
    });
    return this.jobRepository.save(jobEntity);
  }
}
