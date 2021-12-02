package com.haka._excecoes.controller;

import com.haka._excecoes.exception.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {

    @GetMapping("/{num}")
    public String validarCalculo(@PathVariable String num) throws BadRequestException { // numero q recebemos pela url

        try {
            Integer i = Integer.valueOf(num) * 2; // converte para um integer
            return "É um numero";

        } catch (Exception e) {
            throw new BadRequestException("Não é um numero");
        }
    }
}
