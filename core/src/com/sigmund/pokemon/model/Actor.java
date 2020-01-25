package com.sigmund.pokemon.model;

public class Actor {
    private TileMap map;
    private int x,y;
    private DIRECTION facing;
    private ACTOR_STATE state;
    private float moveTimer = 0.5f;
    private int sourceX, sourceY;
    private int destX, destY;

    public Actor(TileMap map, int x, int y){
        this.map = map;
        this.x = x;
        this.y = y;
        //map.getTile(x,y).setActor(this);
        this.state = ACTOR_STATE.STANDING;
        this.facing = DIRECTION.SOUTH;

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

    public enum ACTOR_STATE{
        WALKING,
        STANDING,
        JUMPING;
    }
    public boolean requestMove(){
        return true;
    }

    public boolean move(DIRECTION dir){
        if(requestMove()) {
            x += dir.getDx();
            y += dir.getDy();
            state = ACTOR_STATE.WALKING;
            return true;
        }else{
            return false;
        }
    }

    public boolean select(){
        return true;
    }

    public boolean jump() {
        y += 2;
        state = ACTOR_STATE.JUMPING;
        return true;
    }

}
