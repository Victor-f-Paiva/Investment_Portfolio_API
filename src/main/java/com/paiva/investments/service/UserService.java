package com.paiva.investments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paiva.investments.exception.UserNotFoundException;
import com.paiva.investments.exception.WalletNotFoundException;
import com.paiva.investments.model.User;
import com.paiva.investments.model.Wallet;
import com.paiva.investments.repository.UserRepository;
import com.paiva.investments.repository.WalletRepository;

/**
 * Service class for managing users.
 * Contains business logic related to user operations.
 */
@Service
public class UserService {
	private final UserRepository repository;
	private final WalletRepository walletRepository;

	public UserService(UserRepository repository, WalletRepository walletRepository) {
		this.repository = repository;
		this.walletRepository = walletRepository;
	}
	
	// findAll, findById, create, update, delete
	/**
	 * Retrieves all users.
	 * 
	 * @return the list of all users
	 */
	public List<User> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves a user by ID.
	 * 
	 * @param id the ID of the user
	 * @return the User entity
	 * @throws UserNotFoundException if the user is not found
	 */
	public User findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User id "+id+" not found"));
	}
	
	/**
	 * Creates a new user.
	 * 
	 * @param user the user to create
	 * @returns the created user
	 */
	public User create(User user) {
		return repository.save(user);
	}
	
	/**
	 * Updates an existing user
	 * 
	 * @param id the ID of the user to update
	 * @param updatedUser the ID of updated user data
	 * @return the updated user
	 */
	public User update(Long id, User updatedUser) {
		User user = findById(id);
		user.setName(updatedUser.getName());
		user.setEmail(updatedUser.getEmail());
		return repository.save(user);
	}
	
	/**
	 * Removes an user by its ID
	 * 
	 * @param id the ID of the user to be remove
	 */
	public void delete(Long id) {
		User user = findById(id);
		repository.delete(user);
	}
	
	/**
	 * Method to add wallet to User's account
	 * 
	 * @param id is id of user that find by id
	 * @param walletId is id of wallet will be add to user.
	 */
	public void addWalletToUser(Long id, Long walletId) {
		User user = findById(id);
		Wallet walletToAdd = walletRepository.findById(walletId)
				.orElseThrow(() -> new WalletNotFoundException("Wallet not found. ID: "+ walletId));
		user.addWallet(walletToAdd);
		repository.save(user);
	}
}
