package com.company.map;

import com.company.Unit;

public class Tile {

    private String terrain;
    private Unit occupier;

    public Tile(){
        setTerrain("Plain");
        occupier = new Unit();
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Unit getOccupier() {
        return occupier;
    }

    public void setOccupier(Unit occupier) {
        this.occupier = occupier;
    }
}
