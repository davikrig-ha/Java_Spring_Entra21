package com.entra21.controller.dto;

import com.entra21.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDto {

    private String nome;
    private String email;


    public UsuarioDto(Usuario usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public static List<UsuarioDto> converter(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());

    }

}
