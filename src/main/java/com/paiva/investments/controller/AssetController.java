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

@Controller
@RequestMapping("/api/assets")
public class AssetController {
	
	private final AssetService service;

	public AssetController(AssetService service) {
		this.service = service;
	}
	
	//CRUD - GET(all, by id), POST, PUT, DELETE
	@GetMapping
	public ResponseEntity<List<Asset>> getAllAssets(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Asset> createAsset(@RequestBody Asset asset){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(asset));
	}
	
	@PostMapping("/realstatefunds")
    public ResponseEntity<Asset> createRealStateFund(@RequestBody RealStateFund fund) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(fund));
    }
	
	@PostMapping("/stocks")
    public ResponseEntity<Asset> createStock(@RequestBody Stock stock) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(stock));
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset updatedAsset){
		return ResponseEntity.ok(service.updateAsset(id, updatedAsset));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
