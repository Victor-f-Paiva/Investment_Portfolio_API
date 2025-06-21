package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.RealStateFund;

/**
 * Repository interface for managing {@link RealStateFund} entities.
 * Provides CRUD operations and database access.
 */
public interface RealStateFundRepository extends JpaRepository<RealStateFund, Long>{

}
