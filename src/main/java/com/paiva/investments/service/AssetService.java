package com.paiva.investments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paiva.investments.exception.AssetNotFoundException;
import com.paiva.investments.model.Asset;
import com.paiva.investments.repository.AssetRepository;

/**
 * Service class for managing assets.
 * Contains business logic related to assets operations.
 */
@Service
public class AssetService {
	
	private final AssetRepository repository;

	public AssetService(AssetRepository repository) {
		this.repository = repository;
	}
	
	//findAll, findById, create(save), update, delete(byId)
	/**
	 * Retrieves all assets.
	 * 
	 * @return the list of all assets
	 */
	public List<Asset> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves an asset by ID.
	 * 
	 * @param id the ID of the asset
	 * @return the Asset entity
	 * @throws AssetNotFoundException if the asset is not found
	 */
	public Asset findById(Long id){
		return repository.findById(id)
				.orElseThrow(() -> new AssetNotFoundException("Asset not found: "+id));
	}
	
	/**
	 * Creates a new asset.
	 * 
	 * @param asset the asset to create
	 * @returns the created asset
	 */
	public Asset create(Asset asset) {
		return repository.save(asset);
	}
	
	/**
	 * Updates an existing asset
	 * 
	 * @param id the ID of the asset to update
	 * @param updatedAsset the ID of updated asset data
	 * @return the updated asset
	 */
	public Asset updateAsset(Long id, Asset updatedAsset) {
		Asset asset = findById(id);
		asset.setName(updatedAsset.getName());
		asset.setValue(updatedAsset.getValue());
		return repository.save(asset);
	}
	
	/**
	 * Removes an asset by ID
	 * 
	 * @param id the ID of the asset to be remove
	 */
	public void delete(Long id) {
		Asset asset = findById(id);
		repository.delete(asset);
	}
	
}
