package com.sigmund.pokemon.model;

public class TileMap {
    private int width, height;
    private Tile[][] tiles;

    public TileMap(int width, int height){
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

}
