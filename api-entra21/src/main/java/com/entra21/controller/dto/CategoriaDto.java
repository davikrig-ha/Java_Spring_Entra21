package com.entra21.controller.dto;

import com.entra21.model.Categoria;


import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDto {

    private String descricao;

    public CategoriaDto(Categoria categoria){
        this.descricao = categoria.getDescricao();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static List<CategoriaDto> converter(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());

    }
}
