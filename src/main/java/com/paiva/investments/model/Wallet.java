package com.paiva.investments.model;

import java.util.ArrayList;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity that represents a wallet in the system.
 * Contains wallet details and relationships with assets.
 */
@Entity
@Setter
@Getter
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	
	//ManyToOne se usa JsonBackReference
	@ManyToOne
	@JsonBackReference
	private User user;
	
	//OneToMany se usa ManageReference
	@OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Getter 
	private List<Asset> assets = new ArrayList<>();

	/**
	 * Default constructor required by JPA.
	 */
	public Wallet() {}
	
	/**
	 * Creates a Wallet with the specified name and associated user.
	 *
	 * @param name the name of the wallet
	 * @param user the user who owns the wallet
	 */
	public Wallet(String name, User user) {
		this.name = name;
		this.user = user;
	}
	
	/**
	 * Adds an asset to the specified wallet
	 * 
	 * @param asset the asset to add to wallet
	 */
	public void addAsset(Asset asset) {
		assets.add(asset);
		asset.setWallet(this);
	}
	
	/**
	 * Removes an asset from the specified wallet
	 * 
	 * @param asset the asset to remove from wallet
	 */
	public void removeAsset(Asset asset) {
		assets.remove(asset);
		asset.setWallet(null);
	}
	
}
