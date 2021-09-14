package com.entra21.controller;


import com.entra21.controller.dto.RespostaDto;
import com.entra21.model.Resposta;
import com.entra21.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    RespostaRepository respostaRepository;

    @GetMapping
    public List<RespostaDto> listar(){

        List<Resposta> respostaList = respostaRepository.findAll();


        return RespostaDto.converter(respostaList);
    }

    @PostMapping
    public void cadastrar(@RequestBody Resposta resposta){
        respostaRepository.save(resposta);
    }
}
