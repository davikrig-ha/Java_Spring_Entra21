package com.entra21.controller;


import com.entra21.controller.dto.TopicoDto;
import com.entra21.model.Curso;
import com.entra21.model.Topico;
import com.entra21.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @GetMapping
    public List<TopicoDto> listarTopico(String nomeCurso){

        List<Topico> topicos;

        if (nomeCurso == null){
            topicos = topicoRepository.findAll();
        }
        else{
            topicos = topicoRepository.carregarPorNomeDoCurso(nomeCurso);
        }


        return TopicoDto.converter(topicos);
    }

    @PostMapping
    public void cadastrar(@RequestBody Topico topico){
        topicoRepository.save(topico);
    }


}
