package br.com.solo.avaliacao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.solo.avaliacao.model.Candidate;
import br.com.solo.avaliacao.repository.AccelerationRepository;

@Service
@Transactional
public class AccelerationService {

	private final AccelerationRepository accelerationRepository;

	@Autowired
	public AccelerationService(AccelerationRepository accelerationRepository) {
		this.accelerationRepository = accelerationRepository;
	}

	public List<Candidate> findByAccelerationName(String nameAcceleration) {
		// TODO Auto-generated method stub
		return null;
	}
}
