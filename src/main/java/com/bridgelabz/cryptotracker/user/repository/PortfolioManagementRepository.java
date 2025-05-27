package com.bridgelabz.cryptotracker.user.repository;

import com.bridgelabz.cryptotracker.user.entity.PortfolioManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioManagementRepository extends JpaRepository<PortfolioManagementEntity, Long> {

}
