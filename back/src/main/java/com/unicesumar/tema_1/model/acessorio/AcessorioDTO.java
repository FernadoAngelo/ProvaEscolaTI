package com.unicesumar.tema_1.model.acessorio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessorioDTO {

    private String nome;

    AcessorioDTO(){
    }

    public AcessorioDTO(Acessorio acessorio){
        this.nome = acessorio.getNome();
    }
}
