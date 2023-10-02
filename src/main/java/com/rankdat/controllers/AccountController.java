package com.rankdat.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rankdat.models.Account;
import com.rankdat.repository.AccountRepository;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired // Princípio da Injeção de Dependência (> Pesquisar mais Sobre! <)
    AccountRepository repository;

    @GetMapping
    public List<Account> returnAccounts() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> createAccount(@RequestBody  @Valid Account account) {
        log.info("cadastrando conta: " + account);

        repository.save(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        log.info("buscando por conta com id: " + id);

        return ResponseEntity.ok(getAccountId(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Long id) {
        log.info("deletando conta com id: " + id);

        repository.delete(getAccountId(id));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> putAccount(@PathVariable Long id, @RequestBody @Valid Account account) {
        log.info("alterando conta com id: " + id);
        getAccountId(id);
        
        account.setId(id);

        repository.save(account);

        return ResponseEntity.ok(account);

    }

    private Account getAccountId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A conta não foi encontrada"));
    }

}