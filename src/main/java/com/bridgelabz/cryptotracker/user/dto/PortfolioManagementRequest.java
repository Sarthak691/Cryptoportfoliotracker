package com.bridgelabz.cryptotracker.user.dto;
import lombok.Data;

import java.time.LocalDate;



@Data
public class PortfolioManagementRequest {
    private Long id;
    private int userId;
    private String coinName;
    private String symbol;
    private int quantityHeld;
    private double buyPrice;
    private LocalDate buyDate;

    public PortfolioManagementRequest() {}

    public PortfolioManagementRequest(Long id, int userId, String coinName, String symbol, int quantityHeld, double buyPrice, LocalDate buyDate) {
        this.id=id;
        this.userId=userId;
        this.coinName = coinName;
        this.symbol = symbol;
        this.quantityHeld = quantityHeld;
        this.buyPrice = buyPrice;
        this.buyDate = buyDate;
    }


    public int getQuantityHeld() {
        return quantityHeld;
    }

    public void setQuantityHeld(int quantityHeld) {
        this.quantityHeld = quantityHeld;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }
}