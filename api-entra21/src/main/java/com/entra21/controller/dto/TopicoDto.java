package com.entra21.controller.dto;

import com.entra21.model.Curso;
import com.entra21.model.Topico;
import com.entra21.model.Usuario;
import com.entra21.model.util.StatusTopico;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {

    private String titulo;
    private String mensagem;
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private Usuario autor;
    private Curso curso;

    public TopicoDto() {
    }

    public TopicoDto(Topico topico){
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.status = topico.getStatus();
        this.dataCriacao = topico.getDataCriacao();
        this.autor = topico.getAutor();
        this.curso = topico.getCurso();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public static List<TopicoDto> converter(List<Topico> topicos) {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());

    }
}
