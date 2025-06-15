package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
