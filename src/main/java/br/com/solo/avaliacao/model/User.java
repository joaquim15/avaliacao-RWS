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
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Joaquim
 *
 * @class Classe que representa um usuário
 * 
 */
@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "nickname")
	private String nickName;

	@Column(name = "created_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date createdAt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<SubMission> subMissions = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Candidate> candidates = new ArrayList<>();

	public User() {
	}

	public User(Long id, String fullName, String email, String nickName, Date createdAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.nickName = nickName;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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