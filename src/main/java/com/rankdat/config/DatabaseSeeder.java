package com.rankdat.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rankdat.models.Account;
import com.rankdat.models.Game;
import com.rankdat.models.Review;
import com.rankdat.repository.AccountRepository;
import com.rankdat.repository.GameRepository;
import com.rankdat.repository.ReviewRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void run(String... args) throws Exception {

        Account acc1 = new Account(1L, "toshi", "curto programar!", "toshi.jpeg");
        Account acc2 = new Account(2L, "lucas", "curto futebol sei la!", "lucas.jpeg");
        Account acc3 = new Account(3L, "joao", "curto dar aula acho!", "joaopiggy.jpeg");

        accountRepository.saveAll(List.of(acc1, acc2, acc3));

        gameRepository.saveAll(List.of(
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("nadinha").descricaoJogo("nsei ainda").dataLancamento(LocalDate.now()).account(acc1).build(),
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("tudinho").descricaoJogo("seila ainda").dataLancamento(LocalDate.now()).account(acc1).build(),
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("testando").descricaoJogo("etc ainda").dataLancamento(LocalDate.now()).account(acc1).build(),
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("mk151").descricaoJogo("mortal kombat 11").dataLancamento(LocalDate.now()).account(acc2).build(),
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("mario party").descricaoJogo("marioooo").dataLancamento(LocalDate.now()).account(acc2).build(),
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("dumdum").descricaoJogo("dumdudmd").dataLancamento(LocalDate.now()).account(acc2).build(),
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("steve lacy").descricaoJogo("steveee").dataLancamento(LocalDate.now()).account(acc3).build(),
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("lovee loe love").descricaoJogo("idkkk").dataLancamento(LocalDate.now()).account(acc3).build(),
            Game.builder().valorJogo(new BigDecimal(100)).nomeJogo("babeeeee").descricaoJogo("etce tec").dataLancamento(LocalDate.now()).account(acc3).build()
        ));
        

        Review r1 = new Review(1L, "Review n1", "Mid jogo n odiei nem gostei");
        Review r2 = new Review(2L, "Review n2", "Pessimo jogo eu odiei");
        Review r3 = new Review(3L, "Review n3", "Otimo jogo eu amei");

        reviewRepository.saveAll(List.of(r1, r2, r3));
    }
}
