package com.paiva.investments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paiva.investments.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

}
