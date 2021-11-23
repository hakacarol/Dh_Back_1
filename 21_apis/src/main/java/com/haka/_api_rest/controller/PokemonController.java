package com.haka._api_rest.controller;

import com.haka._api_rest.dao.PokemonDAO;
import com.haka._api_rest.domain.Pokemon;
import com.haka._api_rest.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping
    public Map<Integer, Pokemon> getPokemon() {
        return service.buscarPokemon();
    }

    @PostMapping
    public Pokemon postPokemon(@RequestBody PokemonDAO dao) {
        return service.criarPokemon(dao);
    }

    @PutMapping
    public Pokemon putPokemon(@RequestBody PokemonDAO dao) {
        return service.editarPokemon(dao);
    }

    @DeleteMapping
    public String deletarPokemon(@RequestBody PokemonDAO dao) {
        return service.deletarPokemon(dao);
    }

    @GetMapping
    public Pokemon getPokemonId(@RequestBody PokemonDAO dao) {
        return service.buscarPokemonId(dao);
    }
}
