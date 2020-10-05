package br.com.solo.avaliacao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Joaquim
 * 
 * @class Classe que representa um Candidato
 *
 */
@Entity(name = "Candidate")
@Table(name = "candidate")
public class Candidate implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private CandidatePK id = new CandidatePK();

	@Column(name = "status")
	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "created_at")
	private Date createdAt;

	public Candidate() {
	}

	public Candidate(User user, Company company, Acceleration acceleration, Integer status, Date createdAt) {
		super();
		this.id.setUser(user);
		this.id.setCompany(company);
		this.id.setAcceleration(acceleration);
		this.status = status;
		this.createdAt = createdAt;
	}

	public CandidatePK getId() {
		return id;
	}

	public void setId(CandidatePK id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
