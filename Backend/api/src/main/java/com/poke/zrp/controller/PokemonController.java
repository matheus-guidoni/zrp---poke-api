package com.poke.zrp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poke.zrp.dto.PokemonDetailsDTO;
import com.poke.zrp.dto.StatDTO;
import com.poke.zrp.services.PokemonService;

@RestController
@RequestMapping("/api/pokemons")
@CrossOrigin(origins = "http://localhost:3000") // Permite requisições do front-end
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{name}")
    public List<String> getPokemonAbilities(@PathVariable String name) {
        return pokemonService.getAbilities(name);
    }

    @GetMapping("/{name}/details")
    public PokemonDetailsDTO getPokemonDetails(@PathVariable String name) {
        return pokemonService.getPokemonDetails(name);
    }
}
