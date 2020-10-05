package br.com.solo.avaliacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Joaquim
 *
 * @class Classe que representa uma Compania
 * 
 */
@Entity(name = "Company")
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "slug")
	private String slug;

	@Column(name = "created_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date createdAt;

	@OneToMany(mappedBy = "id.company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Candidate> candidates = new ArrayList<>();

	public Company() {
		super();
	}

	public Company(Long id, String name, String slug, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

}
