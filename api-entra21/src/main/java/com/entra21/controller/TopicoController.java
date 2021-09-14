package com.entra21.controller;


import com.entra21.controller.dto.TopicoDto;
import com.entra21.controller.dto.TopicoForm;
import com.entra21.model.Curso;
import com.entra21.model.Topico;
import com.entra21.repositories.CursoRepository;
import com.entra21.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@Controller
@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

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
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriComponentsBuilder){

        Topico topico = topicoForm.converter(cursoRepository);

        topicoRepository.save(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }


}
