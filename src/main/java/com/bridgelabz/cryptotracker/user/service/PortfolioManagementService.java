package com.bridgelabz.cryptotracker.user.service;

import com.bridgelabz.cryptotracker.user.entity.PortfolioManagementEntity;
import com.bridgelabz.cryptotracker.user.repository.PortfolioManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioManagementService {

    @Autowired
    private PortfolioManagementRepository repository;

    public PortfolioManagementEntity create(PortfolioManagementEntity crypto) {
        return repository.save(crypto);
    }

    public List<PortfolioManagementEntity> getAll() {
        return repository.findAll();
    }

    public Optional<PortfolioManagementEntity> update(Long id, PortfolioManagementEntity newCrypto) {
        return repository.findById(id).map(existing -> {
            existing.setId(newCrypto.getId());
            existing.setUserId(newCrypto.getUserId());
            existing.setQuantityHeld(newCrypto.getQuantityHeld());
            existing.setBuyPrice(newCrypto.getBuyPrice());
            existing.setCoinName(newCrypto.getCoinName());
            existing.setSymbol(newCrypto.getSymbol());
            existing.setBuyDate(newCrypto.getBuyDate());
            return repository.save(existing);
        });
    }
    public boolean delete(Long id) {
        return repository.findById(id).map(existing -> {
            repository.delete(existing);
            return true;
        }).orElse(false);
    }
}