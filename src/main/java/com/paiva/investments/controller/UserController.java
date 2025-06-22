package com.paiva.investments.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paiva.investments.model.User;
import com.paiva.investments.service.UserService;

/**
 * REST controller for managing users.
 * Provides endpoints for user-related operations.
 */
@RestController
@RequestMapping("api/users")
public class UserController {
	
	private final UserService service;

	/**
	 * Controller responsible for handling requests related to users.
	 *
	 * @param service the service that provides business logic for users
	 */
	public UserController(UserService service) {
		this.service = service;
	}
	
	//CRUD - POST, GET, PUT, DELETE
	/**
	 * Creates a new user.
	 *
	 * @param user the user to create
	 * @return HTTP 201 (Created) with the created user
	 */
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User created = service.create(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	/**
	 * Retrieves all users.
	 *
	 * @return the list of all users
	 */
	@GetMapping
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	/**
	 * Retrieves a user by its ID.
	 *
	 * @param id the ID of the user
	 * @return HTTP 200 (OK) with the user entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = service.findById(id);
		return ResponseEntity.ok(user);
	}
	
	/**
	 * Updates an existing user.
	 *
	 * @param id the ID of the user to update
	 * @param user the updated user data
	 * @return HTTP 200 (OK) with the updated user
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
		return ResponseEntity.ok(service.update(id, user));
	}
	
	/**
	 * Deletes a user by their ID.
	 *
	 * @param id the ID of the user to delete
	 * @return HTTP 204 (No Content) if deletion was successful
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Associates an existing wallet to the specified user.
	 * 
	 * @param userId the ID of the user who will own the wallet
	 * @param walletId the ID of the wallet to be added to the user
	 * @return HTTP 200 (OK) with an empty body if the association is successful
	 */
	@PutMapping("/{userId}/add-wallet/{walletId}")
	public ResponseEntity<Void> addWalletToUser(@PathVariable Long userId, @PathVariable Long walletId){
		service.addWalletToUser(userId, walletId);
		return ResponseEntity.ok().build();
	}

}
