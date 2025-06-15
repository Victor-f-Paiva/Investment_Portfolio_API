package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long>{

}
