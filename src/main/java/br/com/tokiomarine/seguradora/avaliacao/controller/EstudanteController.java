package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

	@Autowired EstudandeService service;

	@GetMapping("criar")
	public String iniciarCastrado(final Estudante estudante) {
		return "cadastrar-estudante";
	}

	@GetMapping("listar")
	public String listarEstudantes(final Model model) {
		model.addAttribute("estudantes", this.service.buscarEstudantes());
		return "index";
	}

	@PostMapping("add")
	public String adicionarEstudante(@Valid final Estudante estudante, final BindingResult result, final Model model) {
		if (result.hasErrors()) {
			return "cadastrar-estudante";
		}

		this.service.cadastrarEstudante(estudante);

		return "redirect:listar";
	}

	@GetMapping("editar/{id}")
	public String exibirEdicaoEstudante(@PathVariable("id") final Long id, final Model model) {
		Estudante estudante = this.service.buscarEstudante(id);
		model.addAttribute("estudante", estudante);
		return "atualizar-estudante";
	}

	@PostMapping("atualizar/{id}")
	public String atualizarEstudante(@PathVariable("id") final Long id, @Valid final Estudante estudante, final BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "atualizar-estudante";
		}

		this.service.atualizarEstudante(estudante);

		model.addAttribute("estudantes", this.service.buscarEstudantes());
		return "index";
	}

	@GetMapping("apagar/{id}")
	public String apagarEstudante(@PathVariable("id") final Long id, Model model) {
		// TODO IMPLEMENTAR A EXCLUSAO DE ESTUDANTES
		model.addAttribute("estudantes", this.service.buscarEstudantes());
		return "index";
	}
}
