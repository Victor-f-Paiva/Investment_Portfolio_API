package com.paiva.investments.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
	@Getter private List<Wallet> wallets = new ArrayList<>();

	public User() {}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public void addWallet(Wallet wallet) {
		wallets.add(wallet);
		wallet.setUser(this);
	}

}
