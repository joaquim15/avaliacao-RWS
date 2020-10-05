package br.com.solo.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.solo.avaliacao.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	//Optional<User> findCandidateByEmail(String email);
}
