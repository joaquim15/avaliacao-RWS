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
 * @class Classe que representa um submissão
 * 
 */
@Entity(name = "SubMission")
@Table(name = "submission")
public class SubMission implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private SubMissionPK id = new SubMissionPK();

	@Column(name = "score")
	private Double score;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "created_at")
	private Date createdAt;

	public SubMission() {
	}

	public SubMission(User user, Challenge challenge, Double score, Date createdAt) {
		super();
		this.id.setUser(user);
		this.id.setChallenge(challenge);
		this.score = score;
		this.createdAt = createdAt;
	}

	public SubMissionPK getId() {
		return id;
	}

	public void setId(SubMissionPK id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@JsonIgnore
	public User getUser() {
		return this.id.getUser();
	}

	public Challenge getChallenge() {
		return this.id.getChallenge();
	}

}
