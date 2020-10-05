package br.com.solo.avaliacao.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Joaquim
 * 
 * @class Classe que representa a primary key de Candidato
 *
 */

@Embeddable
public class CandidatePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "acceleration_id")
	private Acceleration acceleration;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public CandidatePK() {
	}

	public CandidatePK(User user, Acceleration acceleration, Company company) {
		this.user = user;
		this.acceleration = acceleration;
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceleration == null) ? 0 : acceleration.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatePK other = (CandidatePK) obj;
		if (acceleration == null) {
			if (other.acceleration != null)
				return false;
		} else if (!acceleration.equals(other.acceleration))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Acceleration getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Acceleration acceleration) {
		this.acceleration = acceleration;
	}

}