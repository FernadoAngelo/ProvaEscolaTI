package com.unicesumar.tema_1.model.veiculo;

import com.unicesumar.tema_1.model.acessorio.Acessorio;
import com.unicesumar.tema_1.model.acessorio.AcessorioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "VEICULO")
@Table(name = "VEICULO")
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "MODELO", nullable = false, length = 32)
    private String modelo;
    @Column(name = "ANO_FABRICACAO", nullable = false)
    private Integer anoFabricacao;
    @Column(name = "PLACA", nullable = false, length = 7)
    private String placa;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "VEICULO_ID")
    private List<Acessorio> acessorio = new ArrayList<>();;

    public Veiculo() {
    }

    public Veiculo(VeiculoDTO dto) {
        if (dto.getModelo().isBlank()) {
            throw new RuntimeException("Modelo vazio. Informe o Modelo do Veiculo");
        }
        if (dto.getPlaca().isBlank()) {
            throw new RuntimeException("Placa vazio. Informe a Placa do Veiculo");
        }
        if (dto.getAnoFabricacao() < 1800 || dto.getAnoFabricacao() > 2025) {
            throw new RuntimeException("Ano de Fabricação não valido");
        }
        if (dto.getAnoFabricacao() < 1800 || dto.getAnoFabricacao() > 2025) {
            throw new RuntimeException("Ano de Fabricação não valido");
        }
        if (dto.getAcessorio().isEmpty()) {
            throw new RuntimeException("Acessorio não informado");
        }

        this.modelo = dto.getModelo();
        this.anoFabricacao = dto.getAnoFabricacao();
        this.placa = dto.getPlaca();
        this.acessorio = dto.getAcessorio().stream().map(Acessorio::new).toList();;
    }

}
