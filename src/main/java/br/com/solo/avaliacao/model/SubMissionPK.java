package br.com.solo.avaliacao.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Joaquim
 * 
 * @Class Classe que representa a primary key de submissão
 *
 */
@Embeddable
public class SubMissionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "challenge_id")
	private Challenge challenge;

	public SubMissionPK() {
	}

	public SubMissionPK(User user, Challenge challenge) {
		this.user = user;
		this.challenge = challenge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((challenge == null) ? 0 : challenge.hashCode());
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
		SubMissionPK other = (SubMissionPK) obj;
		if (challenge == null) {
			if (other.challenge != null)
				return false;
		} else if (!challenge.equals(other.challenge))
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

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

}