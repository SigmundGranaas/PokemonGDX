package com.sigmund.pokemon.model;

import com.sigmund.pokemon.Settings;

public enum DIRECTION {
    NORTH(0,1),
    NORT_EAST(1,1),
    EAST(1,0),
    NORT_WEST(-1,1),
    WEST(-1,0),
    SOUTH(0,-1),
    SOUT_EAST(1,-1),
    SOUTH_WEST(-1,-1);

    private int dx, dy;

    DIRECTION(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }
    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
