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

/**
 * @author Joaquim
 * 
 * @class Classe que representa uma Aceleração
 *
 */
@Entity(name = "Acceleration")
@Table(name = "acceleration")
public class Acceleration implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String slug;

	@Column(name = "challenge_id")
	private Challenge challenge;

	private Date createdAt;

	@OneToMany(mappedBy = "id.acceleration", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Candidate> candidates = new ArrayList<>();

	public Acceleration() {
	}

	public Acceleration(Long id, String name, String slug, Challenge challenge, Date createdAt) {
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.challenge = challenge;
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

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
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
