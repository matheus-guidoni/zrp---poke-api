package com.poke.zrp.dto;

public class StatDTO {
  private String name;
  private int value;

  public StatDTO(String name, int value) {
      this.name = name;
      this.value = value;
  }

  public String getName() {
      return name;
  }

  public int getValue() {
      return value;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void setValue(int value) {
      this.value = value;
  }
}

