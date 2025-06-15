package com.paiva.investments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paiva.investments.exception.AssetNotFoundException;
import com.paiva.investments.model.Asset;
import com.paiva.investments.repository.AssetRepository;

@Service
public class AssetService {
	
	private final AssetRepository repository;

	public AssetService(AssetRepository repository) {
		this.repository = repository;
	}
	
	//findAll, findById, create(save), update, delete(byId)
	public List<Asset> findAll(){
		return repository.findAll();
	}
	
	public Asset findById(Long id){
		return repository.findById(id)
				.orElseThrow(() -> new AssetNotFoundException("Asset not found: "+id));
	}
	
	public Asset create(Asset asset) {
		return repository.save(asset);
	}
	
	public Asset updateAsset(Long id, Asset updatedAsset) {
		Asset asset = findById(id);
		asset.setName(updatedAsset.getName());
		asset.setValue(updatedAsset.getValue());
		return repository.save(asset);
	}
	
	public void delete(Long id) {
		Asset asset = findById(id);
		repository.delete(asset);
	}
	
}
