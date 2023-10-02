package com.rankdat.models;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value=0, message="O valor do jogo deve ser positivo (maior que 0).")
    private BigDecimal valorJogo;

    @NotNull(message = "A data do jogo não pode estar vazia.")
    private LocalDate dataLancamento;

    @NotBlank(message = "A descrição do jogo não pode estar vazia.")
    @Size(min = 5, max = 255)
    private String descricaoJogo;
    
    @NotBlank(message = "O nome do jogo não pode estar vazio.")
    @Size(min = 5, max = 50)
    private String nomeJogo;

    // Muitos jogos para UMA conta
    @NotNull
    @ManyToOne
    private Account account;

    

}