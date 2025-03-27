package com.mycarejs.vacancy_management.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycarejs.vacancy_management.exceptions.UserFoundException;
import com.mycarejs.vacancy_management.modules.candidate.entities.CandidateEntity;
import com.mycarejs.vacancy_management.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundException();
        });
    var password = passwordEncoder.encode(candidateEntity.getPassword());
    candidateEntity.setPassword(password);
    return this.candidateRepository.save(candidateEntity);
  }
}
