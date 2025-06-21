package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.User;

/**
 * Repository interface for managing {@link User} entities.
 * Provides CRUD operations and database access.
 */
public interface UserRepository extends JpaRepository<User, Long>{

}
