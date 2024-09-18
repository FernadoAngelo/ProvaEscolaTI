package com.unicesumar.tema_1.model.acessorio;

import com.unicesumar.tema_1.model.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ACESSORIO")
@Table(name = "ACESSORIO")
@Getter
@Setter
public class Acessorio {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NOME", nullable = false, length = 32)
    private String nome;

    public Acessorio() {
    }

    public Acessorio(AcessorioDTO dto) {
        if (dto.getNome().isBlank()) {
            throw new RuntimeException("Nome vazio. Informe o Nome do Veiculo");
        }

        this.nome = dto.getNome();

    }
}
