package com.entra21.controller.dto;

import com.entra21.model.Curso;
import com.entra21.model.Topico;

import java.util.List;
import java.util.stream.Collectors;

public class CursoDto {

    private String nome;
    private String categoria;

    public CursoDto() {
    }

    public CursoDto(Curso curso){
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static List<CursoDto> converter(List<Curso> cursos) {
        return cursos.stream().map(CursoDto::new).collect(Collectors.toList());

    }
}
