package com.paiva.investments.model;

import java.util.ArrayList;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
	@Getter 
	private List<Asset> assets = new ArrayList<>();

	public Wallet() {}
	
	public Wallet(String name, User user) {
		this.name = name;
		this.user = user;
	}
	
	public void addAsset(Asset asset) {
		assets.add(asset);
		asset.setWallet(this);
	}
	
	public void removeAsset(Asset asset) {
		assets.remove(asset);
		asset.setWallet(null);
	}
	
}
