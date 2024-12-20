package com.poke.zrp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.poke.zrp.dto.PokemonDetailsDTO;
import com.poke.zrp.dto.PokemonResponse;
import com.poke.zrp.dto.StatDTO;
import com.poke.zrp.exception.PokemonNotFoundException;

@Service
public class PokemonService {

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/";

    public List<String> getAbilities(String pokemonName) {
        RestTemplate restTemplate = new RestTemplate();
        PokemonResponse response; //= restTemplate.getForObject(POKEAPI_URL + pokemonName.toLowerCase(), PokemonResponse.class);
        
        try {
            response = restTemplate.getForObject(POKEAPI_URL + pokemonName.toLowerCase(), PokemonResponse.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == 404) {
                throw new PokemonNotFoundException("Pokemon '" + pokemonName + "' not found");
            } else {
                throw new RuntimeException("Error while finding Pokemon: " + e.getMessage(), e);
            }
        }

        if (response == null || response.getAbilities() == null) {
            throw new PokemonNotFoundException("It was not possible to find any habilities to the Pokemon" + pokemonName + "'.");
        }
        return response.getAbilities().stream()
                .map(a -> a.getAbility().getName())
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
    }

    public PokemonDetailsDTO getPokemonDetails(String pokemonName) {
        RestTemplate restTemplate = new RestTemplate();
        PokemonResponse response = restTemplate.getForObject(POKEAPI_URL + pokemonName.toLowerCase(), PokemonResponse.class);

        if (response == null || response.getStats() == null || response.getSprites() == null) {
            throw new RuntimeException("Couldn't find any information about the Pokemon " + pokemonName);
        }
        List<StatDTO> statsList = response.getStats().stream()
            .map(sw -> new StatDTO(sw.getStat().getName(), sw.getBase_stat()))
            .collect(Collectors.toList());

        String frontImageUrl = response.getSprites().getFront_default();
        String backImageUrl = response.getSprites().getBack_default();

        return new PokemonDetailsDTO(statsList, frontImageUrl, backImageUrl);
    }
}
