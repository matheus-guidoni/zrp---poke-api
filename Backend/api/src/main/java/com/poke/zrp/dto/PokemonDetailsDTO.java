package com.poke.zrp.dto;

import java.util.List;

public class PokemonDetailsDTO {
  private List<StatDTO> stats;
  private String frontImageUrl;
  private String backImageUrl;


  public PokemonDetailsDTO(List<StatDTO> stats, String frontImageUrl, String backImageUrl) {
      this.stats = stats;
      this.frontImageUrl = frontImageUrl;
      this.backImageUrl = backImageUrl;
  }

  public List<StatDTO> getStats() {
      return stats;
  }

  public void setStats(List<StatDTO> stats) {
      this.stats = stats;
  }

  public String getFrontImageUrl() {
    return frontImageUrl;
  }

  public void setFrontImageUrl(String frontImageUrl) {
    this.frontImageUrl = frontImageUrl;
  }

  public String getBackImageUrl() {
    return backImageUrl;
  }

  public void setBackImageUrl(String backImageUrl) {
    this.backImageUrl = backImageUrl;
  }
}

