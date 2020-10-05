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
 * @class Classe que representa um Desafio
 *
 */
@Entity(name = "Challenge")
@Table(name = "challenge")
public class Challenge implements Serializable {

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

	@OneToMany(mappedBy = "id.challenge", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubMission> subMissions = new ArrayList<>();

	@OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Acceleration> accelerations = new ArrayList<>();

	public Challenge() {
	}

	public Challenge(Long id, String name, String slug, Date createdAt) {
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

	public List<SubMission> getSubMissions() {
		return subMissions;
	}

	public void setSubMissions(List<SubMission> subMissions) {
		this.subMissions = subMissions;
	}

}
