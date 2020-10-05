package br.com.solo.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.solo.avaliacao.model.Acceleration;
import br.com.solo.avaliacao.model.Candidate;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

	//List<Candidate> findByAccelerationName(String nameAcceleration);

}
