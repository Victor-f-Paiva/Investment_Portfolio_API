package com.paiva.investments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paiva.investments.exception.AssetNotFoundException;
import com.paiva.investments.exception.WalletNotFoundException;
import com.paiva.investments.model.Asset;
import com.paiva.investments.model.Taxable;
import com.paiva.investments.model.Wallet;
import com.paiva.investments.repository.AssetRepository;
import com.paiva.investments.repository.WalletRepository;

@Service
public class WalletService {

	private final WalletRepository repository;
	private final AssetRepository assetRepo;

	public WalletService(WalletRepository repository, AssetRepository assetRepo) {
		this.repository = repository;
		this.assetRepo = assetRepo;
	}
	
	//findAll, findById, create(save), update, delete
	public List<Wallet> findAll(){
		return repository.findAll();
	}
	
	public Wallet findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new WalletNotFoundException("Wallet not found: id "+id));
	}
	
	public Wallet create(Wallet wallet) {
		return repository.save(wallet);
	}
	
	public Wallet update(Long id, Wallet updatedWallet) {
		Wallet wallet = findById(id);
		wallet.setName(updatedWallet.getName());
		wallet.setUser(updatedWallet.getUser());
		return repository.save(wallet);
	}
	
	public void delete(Long id) {
		Wallet wallet = findById(id);
		repository.delete(wallet);
	}
	
	public double calculateTotalValue(Long walletId) {
		Wallet wallet = findById(walletId);
		return wallet.getAssets().stream()
				.mapToDouble(asset -> asset.getValue())
				.sum();
	}
	
	public double calculateTotalTax(Long walletId) {
		Wallet wallet = findById(walletId);
		return wallet.getAssets().stream()
				.filter(asset -> asset instanceof Taxable)
				.mapToDouble(asset -> ((Taxable)asset).calculateTax())
				.sum();
	}
	
	//add addAsset and removeAsset
	public void addAssetInWallet(Long walletId, Long assetId) {
		Wallet wallet = findById(walletId);
		Asset assetToAdd = assetRepo.findById(assetId)
				.orElseThrow(() -> new AssetNotFoundException("Asset not found. Id: "+ assetId));;
		wallet.addAsset(assetToAdd);
		repository.save(wallet);
	}
	
	public void removeAsset(Long walletId, Long assetId) {
		Wallet wallet = findById(walletId);
		Asset assetToRemove = assetRepo.findById(assetId)
				.orElseThrow(() -> new AssetNotFoundException("Asset not found. Id: "+ assetId));
		wallet.removeAsset(assetToRemove);
		repository.save(wallet);
	}
	
}
