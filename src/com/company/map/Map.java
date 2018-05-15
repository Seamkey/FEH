package com.company.map;

import com.company.Constants;
import com.company.Unit;

public class Map {


    private int height = Constants.MAP_HEIGHT;
    private int width = Constants.MAP_WIDTH;
    public Tile [][] map = new Tile[height][width];


    public Map(){
        init();
    }

    private void init (){
        for (int i = 0; i < height ;i++){
            for (int j = 0; j < width; j++){
                map[i][j] = new Tile();
            }
        }
    }

    public void draw (){
        for (int i = 0; i < height;i++){
            for (Tile tile : map[i]){
                System.out.print(tile.draw());
            }
            System.out.println();
        }
    }

    public void setUnit (Unit unit, int i, int j){
        if ( 0 <= i && i <height && 0 <= j && j <width){
            map[i][j].setOccupier(unit);
        }
    }

}
