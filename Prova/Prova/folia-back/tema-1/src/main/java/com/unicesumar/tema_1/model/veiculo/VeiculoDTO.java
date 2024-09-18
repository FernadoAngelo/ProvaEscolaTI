package com.unicesumar.tema_1.model.veiculo;

import com.unicesumar.tema_1.model.acessorio.AcessorioDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VeiculoDTO {

    private String modelo;
    private Integer anoFabricacao;
    private String placa;
    private List<AcessorioDTO> acessorio;

    VeiculoDTO(){

    }

    VeiculoDTO(Veiculo veiculo){
        this.modelo = veiculo.getModelo();
        this.anoFabricacao = veiculo.getAnoFabricacao();
        this.placa = veiculo.getPlaca();
        this.acessorio = veiculo.getAcessorio().stream().map(AcessorioDTO::new).toList();
    }
}
