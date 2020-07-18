package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

@Service
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired EstudanteRepository repository;

	@Override
	public void cadastrarEstudante(@Valid final Estudante estudante) {
		this.repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid final Estudante estudante) {
		this.repository.save(estudante);
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		return this.repository.findAll();
	}

	@Override
	public Estudante buscarEstudante(final Long id) {

		final Optional<Estudante> objEstudante = this.repository.findById(id);

		if (objEstudante.isPresent()) {
			return objEstudante.get();
		}
		throw new IllegalArgumentException("Identificador inválido:" + id);
	}

}
