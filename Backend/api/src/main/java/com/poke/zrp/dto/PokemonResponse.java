package com.poke.zrp.dto;

import java.util.List;

public class PokemonResponse {

    private List<AbilityWrapper> abilities;

    public List<AbilityWrapper> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityWrapper> abilities) {
        this.abilities = abilities;
    }

    public static class AbilityWrapper {
        private Ability ability;

        public Ability getAbility() {
            return ability;
        }

        public void setAbility(Ability ability) {
            this.ability = ability;
        }
    }

    public static class Ability {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
           this.name = name;
        }
    }
    
}
