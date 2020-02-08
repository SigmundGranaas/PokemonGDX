package com.sigmund.pokemon.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.sigmund.pokemon.Settings;
import com.sigmund.pokemon.screen.GameScreen;

public class Actor {
    private TileMap map;
    private int x,y;
    private DIRECTION facing;
    private ACTOR_STATE state;
    private int sourceX, sourceY;
    private int destX, destY;
    private Animation<Texture> animation;
    private Texture redStandingSouth;
    public float animtimer;

    public Actor(TileMap map, int x, int y){
        this.map = map;
        this.x = x;
        this.y = y;
        this.state = ACTOR_STATE.STANDING;
        this.facing = DIRECTION.SOUTH;
        redStandingSouth = new Texture("Red_standing_south.png");
        this.animation = new Animation<Texture>(0.2f,redStandingSouth);

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
    public void update(float delta){
    if (state == ACTOR_STATE.WALKING || state == ACTOR_STATE.JUMPING){
        animtimer += delta;
        if(animtimer > animation.getAnimationDuration()){
            completeMove(facing);

            }
        }
    }

    public boolean requestMove(DIRECTION dir){
        if ((x + dir.getDx()) >= (map.getWidth()-1)*Settings.TILE_SIZE || (y + dir.getDy() >= (map.getHeight()-1)*Settings.TILE_SIZE || ((x + dir.getDx()) < 0 || ((y + dir.getDy()) < 0)))){return false; }
        if(state == ACTOR_STATE.WALKING){ return false; }

        initilaliseMove(dir);
        this.facing = dir;
        System.out.println(destY + "," + destX);
        return true;
    }

    public boolean initilaliseMove(DIRECTION dir){
        state = ACTOR_STATE.WALKING;
        this.sourceX = x;
        this.sourceY = y;
        this.destX = (x + dir.getDx()*Settings.TILE_SIZE);
        this.destY = (y + dir.getDy()*Settings.TILE_SIZE);
        animtimer = 0f;
        return true;
    }

    public boolean completeMove(DIRECTION dir) {
        x = destX;
        y = destY;
        state = ACTOR_STATE.STANDING;
        this.sourceX = 0;
        this.sourceY = 0;
        this.destX = 0;
        this.destY = 0;
        return true;

    }


    public boolean select(){
        return true;
    }

    public boolean jump(){
        y += 2;
        state = ACTOR_STATE.JUMPING;
        return true;
    }

    public Texture getAnimTexture(){
        return animation.getKeyFrame(animtimer);
    }

}

