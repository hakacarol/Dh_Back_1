package com.haka._api_rest.service;

import com.haka._api_rest.dao.PokemonDAO;
import com.haka._api_rest.domain.Pokemon;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PokemonService {

    private static Map<Integer, Pokemon> flyweight = new HashMap<>();

    public Map<Integer, Pokemon> buscarPokemon() {
        return flyweight;
    }

    public Pokemon criarPokemon(PokemonDAO dao) {

        // definição do id
        Integer id = flyweight.size()+1;
        // criando pokemon
        Pokemon pokemon = new Pokemon(dao.getNome(), dao.getTipo(), dao.getPokedex(), dao.getHabilidades());
        flyweight.put(id, pokemon);
        return flyweight.get(id);
    }

    public Pokemon editarPokemon(PokemonDAO dao) {

            // retornar o pokemon q irá ser editado
            Pokemon pokemon = flyweight.get(dao.getId());

            pokemon.setTipo(dao.getTipo());
            pokemon.setHabilidades(dao.getHabilidades());

            return pokemon;
    }

    public String deletarPokemon(PokemonDAO dao) {
        flyweight.remove(dao.getId());

        return "Pokemon deletado";
    }

    public Pokemon buscarPokemonId(PokemonDAO dao) { // Integer id
        Pokemon pokemon = flyweight.get(dao.getId());

        return pokemon;
    }
}