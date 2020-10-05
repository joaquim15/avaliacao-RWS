package br.com.solo.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.solo.avaliacao.model.User;
import br.com.solo.avaliacao.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
