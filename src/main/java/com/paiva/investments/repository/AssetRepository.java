package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.Asset;

/**
 * Repository interface for managing {@link Asset} entities.
 * Provides CRUD operations and database access.
 */
public interface AssetRepository extends JpaRepository<Asset, Long>{

}
