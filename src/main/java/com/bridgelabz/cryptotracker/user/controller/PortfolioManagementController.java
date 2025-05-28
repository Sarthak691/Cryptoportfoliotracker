package com.bridgelabz.cryptotracker.user.controller;

import com.bridgelabz.cryptotracker.user.entity.PortfolioManagementEntity;
import com.bridgelabz.cryptotracker.user.service.PortfolioManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/portfolio")
public class PortfolioManagementController {

    @Autowired
    private PortfolioManagementService service;

    @PostMapping("/add") 
    public ResponseEntity<?> create(@Valid @RequestBody PortfolioManagementEntity crypto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(service.create(crypto));
    }

    @GetMapping("/my") 
    public List<PortfolioManagementEntity> getAll() {
        return service.getAll();
    }

    @PutMapping("/update/{id}") 
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PortfolioManagementEntity newCrypto) {
        if (newCrypto.getId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return service.update(id, newCrypto)
                .map(updated -> ResponseEntity.ok("Cryptoportfolio updated"))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.ok("Cryptoportfolio deleted")
                : ResponseEntity.notFound().build();
    }
}
