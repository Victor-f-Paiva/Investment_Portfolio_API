package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

}
