package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.Stock;

/**
 * Repository interface for managing {@link Stock} entities.
 * Provides CRUD operations and database access.
 */
public interface StockRepository extends JpaRepository<Stock, Long>{

}
