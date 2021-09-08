package com.entra21.controller;

import com.entra21.model.Curso;
import com.entra21.model.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TopicoController {

    @RequestMapping("/topicos")
    @ResponseBody

    public List<Topico> listarTopico(){

        Curso c = new Curso();
        c.setId(4L);
        c.setNome("java");


    Topico t = new Topico("duvida", "oba to com uma duvida ae", new Curso(c));

    return Arrays.asList(t,t,t,t);
    }
}
