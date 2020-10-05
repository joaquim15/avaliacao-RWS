package br.com.solo.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.solo.avaliacao.model.User;
import br.com.solo.avaliacao.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
@Api(value = "User")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "Buscar um usuário por id")
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable(value = "id") Long id) {
		return userService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Adicionar um usuário")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody @Validated User user) {
		return userService.save(user);
	}
	
	@ApiOperation(value = "Alterar um usuário")
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
		return userService.findById(id).map(userObj -> {
			userObj.setId(id);
			return ResponseEntity.ok(userService.updateUser(userObj));
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
