package com.bridgelabz.cryptotracker.user.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "portfoliomanagement")

public class PortfolioManagementEntity {
    @Id

    @NotNull(message="id cannot be null")
    private Long id;
    @NotNull(message="userId cannot be null")
    private Integer userId;
    @NotBlank(message="coinName is required")
    private String coinName;
    @NotBlank(message="symbol is required")
    private String symbol;
    @Min(value = 1, message = "quantity held shound not be lesser than 1")
    private Integer quantityHeld;
    @Positive(message="buyPrice cannot be negative")
    private Double buyPrice;
    @NotNull(message="buyDate is required")
    private LocalDate buyDate;

    public PortfolioManagementEntity() {}

    public PortfolioManagementEntity(Long id, String coinName, String symbol, int quantityHeld, double buyPrice, LocalDate  buyDate ) {
        this.id=id;
        this.userId=userId;
        this.coinName = coinName;
        this.symbol = symbol;
        this.quantityHeld = quantityHeld;
        this.buyPrice=buyPrice;
        this.buyDate=buyDate;

    }

    public Long getId() { return id; }
    public void setId(Long Id) { this.id=Id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId=userId; }

    public String getCoinName() { return coinName; }
    public void setCoinName(String coinName) { this.coinName = coinName; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public int getQuantityHeld() { return quantityHeld; }
    public void setQuantityHeld(int  quantityHeld) { this.quantityHeld = quantityHeld; }

    public double getBuyPrice() { return buyPrice; }
    public void setBuyPrice(double  buyPrice) { this.buyPrice = buyPrice; }

    public LocalDate getBuyDate() { return buyDate; }
    public void setBuyDate(LocalDate  buyDate) { this.buyDate = buyDate; }
}