package com.poke.zrp.exception;

public class PokemonNotFoundException extends RuntimeException {
  public PokemonNotFoundException(String message) {
      super(message);
  }
}
