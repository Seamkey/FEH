package com.company.map;

import com.company.Unit;

public class Tile {

    private String terrain;
    private Unit occupier;
    private boolean occupied = false;

    public Tile(){
        setTerrain("Plain");
    }

    public char draw(){
        if (!occupied || occupier.isDefeated()){
            return '-';
        }else
            return occupier.draw();
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
        occupied = true;
        this.occupier = occupier;
    }

    public void removeOccupier(){
        occupied = false;
    }
}
