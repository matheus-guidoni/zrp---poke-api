package com.poke.api.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.poke.zrp.dto.PokemonDetailsDTO;
import com.poke.zrp.dto.StatDTO;
import com.poke.zrp.services.PokemonService;

import java.util.List;

public class PokemonServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PokemonService pokemonService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPokemonDetails() {
        // Mock the service response
        PokemonDetailsDTO mockResponse = new PokemonDetailsDTO(
            List.of(new StatDTO("hp", 35), new StatDTO("attack", 55)),
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/25.png"
        );

        // Define the behavior of the mock
        when(restTemplate.getForObject(anyString(), eq(PokemonDetailsDTO.class)))
            .thenReturn(mockResponse);

        // Call the method to test
        PokemonDetailsDTO result = pokemonService.getPokemonDetails("pikachu");

        // Verify the result
        assertNotNull(result);
        assertEquals(6, result.getStats().size());
        assertEquals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png", result.getFrontImageUrl());
        assertEquals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/25.png", result.getBackImageUrl());
    }
}