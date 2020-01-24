package com.sigmund.pokemon.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Actor {
    private TileMap map;
    private int x,y;

    public Actor(TileMap map, int x, int y){
        this.map = map;
        this.x = x;
        this.y = y;
    }


    public TileMap getMap() {
        return map;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
