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
import com.paiva.investments.model.RealStateFund;
import com.paiva.investments.model.Stock;
import com.paiva.investments.service.AssetService;

/**
 * REST controller for managing assets.
 * Provides endpoints for asset-related operations.
 */
@Controller
@RequestMapping("/api/assets")
public class AssetController {
	
	private final AssetService service;

	/**
	 * Controller responsible for handling requests related to assets.
	 *
	 * @param service the service that provides business logic for assets
	 */
	public AssetController(AssetService service) {
		this.service = service;
	}
	
	//CRUD - GET(all, by id), POST, PUT, DELETE
	/**
	 * Retrieves all assets.
	 *
	 * @return HTTP 200 (OK) with the list of all assets
	 */
	@GetMapping
	public ResponseEntity<List<Asset>> getAllAssets(){
		return ResponseEntity.ok(service.findAll());
	}
	
	/**
	 * Retrieves an asset by its ID.
	 *
	 * @param id the ID of the asset
	 * @return HTTP 200 (OK) with the asset entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	/**
	 * Creates a new asset.
	 *
	 * @param asset the asset to be created
	 * @return HTTP 201 (Created) with the created asset
	 */
	@PostMapping
	public ResponseEntity<Asset> createAsset(@RequestBody Asset asset){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(asset));
	}
	
	/**
	 * Creates a new Real State Fund asset.
	 *
	 * @param fund the real state fund to be created
	 * @return HTTP 201 (Created) with the created real state fund asset
	 */
	@PostMapping("/realstatefunds")
    public ResponseEntity<Asset> createRealStateFund(@RequestBody RealStateFund fund) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(fund));
    }
	
	/**
	 * Creates a new stock asset.
	 *
	 * @param stock the stock to be created
	 * @return HTTP 201 (Created) with the created stock asset
	 */
	@PostMapping("/stocks")
    public ResponseEntity<Asset> createStock(@RequestBody Stock stock) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(stock));
    }
	
	/**
	 * Updates an existing asset.
	 *
	 * @param id the ID of the asset to update
	 * @param updatedAsset the updated asset data
	 * @return HTTP 200 (OK) with the updated asset
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset updatedAsset){
		return ResponseEntity.ok(service.updateAsset(id, updatedAsset));
	}
	
	/**
	 * Deletes an asset by its ID.
	 *
	 * @param id the ID of the asset to delete
	 * @return HTTP 204 (No Content) if deletion was successful
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
