package com.poke.api.controller;

import com.poke.zrp.ApiApplication;
import com.poke.zrp.controller.PokemonController;
import com.poke.zrp.dto.PokemonDetailsDTO;
import com.poke.zrp.dto.StatDTO;
import com.poke.zrp.services.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PokemonController.class)
@ContextConfiguration(classes = ApiApplication.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Test
    public void testGetPokemonDetails() throws Exception {
        // Mock the service response
        PokemonDetailsDTO mockResponse = new PokemonDetailsDTO(
            List.of(new StatDTO("hp", 35), new StatDTO("attack", 55)),
            "https://some-url.com/front.png",
            "https://some-url.com/back.png"
        );

        when(pokemonService.getPokemonDetails("pikachu")).thenReturn(mockResponse);

        // Perform the request and verify the result
        mockMvc.perform(get("/api/pokemons/pikachu/details"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.stats[0].name").value("hp"))
            .andExpect(jsonPath("$.stats[0].value").value(35))
            .andExpect(jsonPath("$.stats[1].name").value("attack"))
            .andExpect(jsonPath("$.stats[1].value").value(55))
            .andExpect(jsonPath("$.frontImageUrl").value("https://some-url.com/front.png"))
            .andExpect(jsonPath("$.backImageUrl").value("https://some-url.com/back.png"));
    }
}