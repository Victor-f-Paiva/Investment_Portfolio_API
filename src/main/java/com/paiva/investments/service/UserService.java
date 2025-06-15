package com.paiva.investments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paiva.investments.exception.UserNotFoundException;
import com.paiva.investments.model.User;
import com.paiva.investments.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	// findAll, findById, create, update, delete
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User id "+id+" not found"));
	}
	
	public User create(User user) {
		return repository.save(user);
	}
	
	public User update(Long id, User updatedUser) {
		User user = findById(id);
		user.setName(updatedUser.getName());
		user.setEmail(updatedUser.getEmail());
		return repository.save(user);
	}
	
	public void delete(Long id) {
		User user = findById(id);
		repository.delete(user);
	}
}
