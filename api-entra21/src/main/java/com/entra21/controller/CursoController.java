package com.entra21.controller;

import com.entra21.controller.dto.CursoDto;
import com.entra21.model.Curso;
import com.entra21.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDto> listar(){

        List<Curso> cursoList = cursoRepository.findAll();


        return CursoDto.converter(cursoList);
    }

    @PostMapping
    public void cadastrar(@RequestBody Curso curso){
        cursoRepository.save(curso);
    }


}



