package com.paiva.investments.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity that represents a user in the system.
 * Contains user details and relationships with wallets.
 */
@Entity
@Setter
@Getter
@Table(name= "users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	
	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference
	@Getter private List<Wallet> wallets = new ArrayList<>();

	/**
	 * Default constructor required by JPA.
	 */
	public User() {}
	
	/**
	 * Creates a user with the specified name and email,
	 * 
	 * @param name the name of the user
	 * @param email the email of the user
	 */
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	/**
	 * Adds a wallet to the specified user
	 * 
	 * @param wallet the wallet to add
	 */
	public void addWallet(Wallet wallet) {
		wallets.add(wallet);
		wallet.setUser(this);
	}

}
