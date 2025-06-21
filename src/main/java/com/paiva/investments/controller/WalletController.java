package com.paiva.investments.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paiva.investments.model.Asset;
import com.paiva.investments.model.Wallet;
import com.paiva.investments.service.WalletService;

/**
 * REST controller for managing wallets.
 * Provides endpoints for wallet-related operations.
 */
@Controller
@RequestMapping("/api/wallets")
public class WalletController {
	
	private final WalletService service;

	public WalletController(WalletService service) {
		this.service = service;
	}
	
	//CRUD - POST, GET (all, id), PUT, DELETE
	/**
	 * Retrieves all users
	 * 
	 * @return the list of all users
	 */
	@GetMapping
	public ResponseEntity<List<Wallet>> getAllWallets(){
		return ResponseEntity.ok(service.findAll());
	}
	
	/**
	 * Retrieves all assets of the specified wallet
	 * 
	 * @param id the ID of the wallet
	 * @return the list of all assets belonging to the wallet
	 */
	@GetMapping("/{id}/assets")
	public ResponseEntity<List<Asset>> getAssetsByWalletId(@PathVariable Long id){
		Wallet wallet = service.findById(id);
		return ResponseEntity.ok(wallet.getAssets());
	}
	
	/**
	 * Creates a new wallet
	 * 
	 * @param wallet the wallet to be created
	 * @return HTTP 201 (Created) status with the created wallet in the response body
	 */
	@PostMapping
	public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet){
		Wallet created = service.create(wallet);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	/**
	 * Updates a wallet
	 * 
	 * @param id the ID of the wallet to update
	 * @param updatedWallet the wallet data to update
	 * @return HTTP 200 (OK) wallet with the updated wallet in the response body
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Wallet> updateWallet(@PathVariable Long id, @RequestBody Wallet updatedWallet){
		return ResponseEntity.ok(service.update(id, updatedWallet));
	}
	
	/**
	 * Removes a wallet
	 * 
	 * @param id the ID of the wallet to remove
	 * @return HTTP 204 (No content) if the deletion was successful
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWallet(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	/**
	 * Calculates the total value of the wallet.
	 *
	 * @param id the ID of the wallet
	 * @return HTTP 200 (OK) with the total value of the wallet
	 */
	@GetMapping("/{id}/total-value")
	public ResponseEntity<Double> calculateWalletTotalValue(@PathVariable Long id){
		return ResponseEntity.ok(service.calculateTotalValue(id));
	}
	
	/**
	 * Calculates the total taxes of the wallet.
	 *
	 * @param id the ID of the wallet
	 * @return HTTP 200 (OK) with the total tax amount of the wallet
	 */
	@GetMapping("/{id}/total-taxes")
	public ResponseEntity<Double> calculateWalletTax(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.calculateTotalTax(id));
	}
	
	//add addAsset and removeAsset
	/**
	 * Adds an asset to the specified wallet.
	 *
	 * @param id the ID of the wallet
	 * @param assetId the ID of the asset to be added
	 * @return HTTP 200 (OK) if the asset was successfully added
	 */
	@PutMapping("/{id}/add-asset/{assetId}")
	public ResponseEntity<Void> addAssetInWallet(@PathVariable Long id,@PathVariable Long assetId){
		service.addAssetInWallet(id, assetId);
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Removes an asset from the specified wallet.
	 *
	 * @param id the ID of the wallet
	 * @param assetId the ID of the asset to be removed
	 * @return HTTP 204 (No Content) if the asset was successfully removed
	 */
	@DeleteMapping("/{id}/remove-asset/{assetId}")
	public ResponseEntity<Void> removeAssetFromWallet(@PathVariable Long id,@PathVariable Long assetId){
		service.removeAsset(id, assetId);
		return ResponseEntity.noContent().build();
	}
	
}
