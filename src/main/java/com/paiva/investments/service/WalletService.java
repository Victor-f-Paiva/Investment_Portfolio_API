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

/**
 * Service class for managing wallets.
 * Contains business logic related to wallet operations.
 */
@Service
public class WalletService {

	private final WalletRepository repository;
	private final AssetRepository assetRepo;

	public WalletService(WalletRepository repository, AssetRepository assetRepo) {
		this.repository = repository;
		this.assetRepo = assetRepo;
	}
	
	//findAll, findById, create(save), update, delete
	/**
	 * Retrieves all wallets.
	 * 
	 * @return the list of all wallets
	 */
	public List<Wallet> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves a wallet by ID.
	 * 
	 * @param id the ID of the wallet
	 * @return the Wallet entity
	 * @throws WalletNotFoundException if the wallet is not found
	 */
	public Wallet findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new WalletNotFoundException("Wallet not found: id "+id));
	}
	
	/**
	 * Creates a new wallet.
	 * 
	 * @param wallet the wallet to create
	 * @returns the created wallet
	 */
	public Wallet create(Wallet wallet) {
		return repository.save(wallet);
	}
	
	/**
	 * Updates an existing wallet
	 * 
	 * @param id the ID of the wallet to update
	 * @param updatedWallet the ID of updated wallet data
	 * @return the updated wallet
	 */
	public Wallet update(Long id, Wallet updatedWallet) {
		Wallet wallet = findById(id);
		wallet.setName(updatedWallet.getName());
		wallet.setUser(updatedWallet.getUser());
		return repository.save(wallet);
	}
	
	/**
	 * Removes a wallet by its ID
	 * 
	 * @param id the ID of the wallet to be remove
	 */
	public void delete(Long id) {
		Wallet wallet = findById(id);
		repository.delete(wallet);
	}
	
	/**
	 * Calculates the total value of the wallet
	 * 
	 * @param walletId the ID of the wallet
	 * @return the total value of the wallet
	 */
	public double calculateTotalValue(Long walletId) {
		Wallet wallet = findById(walletId);
		return wallet.getAssets().stream()
				.mapToDouble(asset -> asset.getValue())
				.sum();
	}
	
	/**
	 * Calculates total taxes for a wallet
	 * 
	 * @param walletId the ID of the wallet
	 * @return the total amount of taxes to be paid
	 */
	public double calculateTotalTax(Long walletId) {
		Wallet wallet = findById(walletId);
		return wallet.getAssets().stream()
				.filter(asset -> asset instanceof Taxable)
				.mapToDouble(asset -> ((Taxable)asset).calculateTax())
				.sum();
	}
	
	//add addAsset and removeAsset
	/**
	 * Adds an asset to the wallet
	 * 
	 * @param walletId the ID of the wallet
	 * @param assetId the ID of the asset to be added
	 * @throws AssetNotFoundException if the wallet is not found
	 */
	public void addAssetInWallet(Long walletId, Long assetId) {
		Wallet wallet = findById(walletId);
		Asset assetToAdd = assetRepo.findById(assetId)
				.orElseThrow(() -> new AssetNotFoundException("Asset not found. Id: "+ assetId));;
		wallet.addAsset(assetToAdd);
		repository.save(wallet);
	}
	
	/**
	 * Removes an asset of the wallet
	 * 
	 * @param walletId the ID of the wallet
	 * @param assetId the ID of the asset to be removed
	 * @throws AssetNotFoundException if the wallet is not found
	 */
	public void removeAsset(Long walletId, Long assetId) {
		Wallet wallet = findById(walletId);
		Asset assetToRemove = assetRepo.findById(assetId)
				.orElseThrow(() -> new AssetNotFoundException("Asset not found. Id: "+ assetId));
		wallet.removeAsset(assetToRemove);
		repository.save(wallet);
	}
	
}
