package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.Wallet;

/**
 * Repository interface for managing {@link Wallet} entities.
 * Provides CRUD operations and database access.
 */
public interface WalletRepository extends JpaRepository<Wallet, Long>{

}
