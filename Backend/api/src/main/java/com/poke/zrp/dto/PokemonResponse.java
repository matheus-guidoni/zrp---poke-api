package com.poke.zrp.dto;

import java.util.List;

public class PokemonResponse {

    private List<AbilityWrapper> abilities;
    private List<StatsWrapper> stats;
    private Sprites sprites;

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<StatsWrapper> getStats() {
        return stats;
    }   

    public void setStats(List<StatsWrapper> stats) {
        this.stats = stats;
    }

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

    public static class StatsWrapper {

        private int base_stat;
        private int effort;
        private Stat stat;

        public int getBase_stat() {
            return base_stat;
        }
        public void setBase_stat(int base_stat) {
            this.base_stat = base_stat;
        }
        public int getEffort() {
            return effort;
        }
        public void setEffort(int effort) {
            this.effort = effort;
        }
        public Stat getStat() {
            return stat;
        }
        public void setStat(Stat stat) {
            this.stat = stat;
        }
    }
    public static class Stat {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Sprites {
        private String front_default;
        private String back_default;

        public String getFront_default() {
            return front_default;
        }

        public void setFront_default(String front_default) {
            this.front_default = front_default;
        }

        public String getBack_default() {
            return back_default;
        }

        public void setBack_default(String back_default) {
            this.back_default = back_default;
        }
    }

    
    
}
