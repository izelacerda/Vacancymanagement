package com.mycarejs.vacancy_management.modules.candidate.useCases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mycarejs.vacancy_management.exceptions.JobNotFoundException;
import com.mycarejs.vacancy_management.exceptions.UserNotFoundException;
import com.mycarejs.vacancy_management.modules.candidate.entities.ApplyJobEntity;
import com.mycarejs.vacancy_management.modules.candidate.entities.CandidateEntity;
import com.mycarejs.vacancy_management.modules.candidate.repositories.ApplyJobRepository;
import com.mycarejs.vacancy_management.modules.candidate.repositories.CandidateRepository;
import com.mycarejs.vacancy_management.modules.job.entities.JobEntity;
import com.mycarejs.vacancy_management.modules.job.repositories.JobRepository;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

  @InjectMocks
  private ApplyJobCandidateUseCase applyJobCandidateUseCase;

  @Mock
  private CandidateRepository candidateRepository;

  @Mock
  private JobRepository jobRepository;

  @Mock
  private ApplyJobRepository applyJobRepository;

  @Test
  @DisplayName("Should not be able to apply to a job with candidate not found")
  public void should_not_be_able_to_apply_job_with_candidate_not_found() {
    try {
      applyJobCandidateUseCase.execute(null, null);

    } catch (Exception e) {
      assertInstanceOf(UserNotFoundException.class, e);
      // TODO: handle exception
    }
  }

  @Test
  @DisplayName("Should not be able to apply to a job with a job not found")
  public void should_not_be_able_to_apply_job_with_job_not_found() {
    var idCandidate = UUID.randomUUID();

    var candidate = new CandidateEntity();
    candidate.setId(idCandidate);

    when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

    try {
      applyJobCandidateUseCase.execute(idCandidate, null);
    } catch (Exception e) {
      assertInstanceOf(JobNotFoundException.class, e);
      // TODO: handle exception
    }

  }

  @Test
  @DisplayName("should be able to create a new apply job")
  public void should_be_able_to_create_a_new_apply_job() {
    var idCandidate = UUID.randomUUID();
    var idJob = UUID.randomUUID();

    var applyJob = ApplyJobEntity.builder().candidateId(idCandidate)
        .jobId(idJob).build();

    var candidate = new CandidateEntity();
    candidate.setId(idCandidate);

    var job = new JobEntity();
    job.setId(idJob);

    when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));
    when(jobRepository.findById(idJob)).thenReturn(Optional.of(job));

    // applyJob.setId(UUID.randomUUID());
    when(applyJobRepository.save(applyJob)).thenReturn(new ApplyJobEntity());

    var result = applyJobCandidateUseCase.execute(idCandidate, idJob);
    assertThat(result).hasFieldOrProperty("id");
    // assertNotNull(result.getCandidateId());
  }
}
