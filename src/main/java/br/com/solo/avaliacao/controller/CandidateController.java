package br.com.solo.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solo.avaliacao.model.Candidate;
import br.com.solo.avaliacao.service.AccelerationService;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
	
	@Autowired
	AccelerationService accelerationService;

	@GetMapping("/{id}")
	public ResponseEntity<Candidate> findByAccelerationName(@PathVariable(value = "nameAcceleration") String nameAcceleration) {

		return null;
	}

}
