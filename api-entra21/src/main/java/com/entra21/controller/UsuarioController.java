package com.entra21.controller;


import com.entra21.controller.dto.UsuarioDto;
import com.entra21.model.Usuario;
import com.entra21.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDto> listarUsuario(){

       List<Usuario> usuarioList = usuarioRepository.findAll();
       return UsuarioDto.converter(usuarioList);
    }

    @PostMapping
    public void cadastrar(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
