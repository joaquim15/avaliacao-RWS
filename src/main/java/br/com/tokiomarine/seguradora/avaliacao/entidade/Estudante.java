package br.com.tokiomarine.seguradora.avaliacao.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "tb_estudante")
public class Estudante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull(message = "Nome é obrigatório")
	@NotBlank(message = "Nome é obrigatório")
	@Column(name = "nome")
	private String nome;

	@NotNull(message = "Email é obrigatório")
	@NotBlank(message = "Email é obrigatório")
	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@NotNull(message = "Matrícula é obrigatório")
	@NotBlank(message = "Matrícula é obrigatório")
	@Column(name = "matricula")
	private String matricula;

	private String curso;

	public Estudante() {
		super();
	}

	public Estudante(Long id, String nome, String email, String telefone, String matricula, String curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.matricula = matricula;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
