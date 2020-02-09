package com.sigmund.pokemon.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.sigmund.pokemon.Settings;
import com.sigmund.pokemon.screen.GameScreen;
import com.sigmund.pokemon.utility.AnimationSet;

public class Actor {
    private TileMap map;
    private int x,y;
    private DIRECTION facing;
    private ACTOR_STATE state;
    private int sourceX, sourceY;
    private int destX, destY;
    private Animation<Texture> animation;
    private Texture redStandingSouth;
    private float walkTimer;
    private boolean moveRequestThisFrame;
    private float animtime = 0.15f;
    private float animtimer;
    private float animX, animY;
    private AnimationSet animations;

    public float getAnimX() {
        return animX;
    }

    public float getAnimY() {
        return animY;
    }

    public Actor(TileMap map, int x, int y, AnimationSet animations){
        this.animations = animations;
        this.map = map;
        this.x = x;
        this.y = y;
        this.state = ACTOR_STATE.STANDING;
        this.facing = DIRECTION.SOUTH;
        redStandingSouth = new Texture("Red_standing_south.png");
        this.animation = new Animation<Texture>(animtime,redStandingSouth);


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
        animX = Interpolation.linear.apply(sourceX,destX,animtimer/animtime);
        animY = Interpolation.linear.apply(sourceY,destY,animtimer/animtime);

        if(animtimer > animation.getAnimationDuration()){
            walkTimer = animtimer-animtime;
            completeMove(facing);
            if(moveRequestThisFrame){
                requestMove(facing);
            }else{
                walkTimer = 0f;
            }
            }
        }
    moveRequestThisFrame = false;
    }

    public boolean requestMove(DIRECTION dir){
        if ((x + dir.getDx()) >= (map.getWidth())*Settings.SCALED_TILE_SIZE || (y + dir.getDy() >= (map.getHeight())*Settings.SCALED_TILE_SIZE || ((x + dir.getDx()) < 0 || ((y + dir.getDy()) < 0)))){return false; }
        if(state == ACTOR_STATE.WALKING){
            if(facing == dir){
                moveRequestThisFrame = true;
            }
            return false; }

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
        this.sourceX = 0;
        this.sourceY = 0;
        this.destX = 0;
        this.destY = 0;
        state = ACTOR_STATE.STANDING;
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

    public TextureRegion getSPrite(){
        if(state == ACTOR_STATE.WALKING){
            return (TextureRegion) animations.getWalking(facing).getKeyFrame(walkTimer);
        }
        else if(state == ACTOR_STATE.STANDING){
            return animations.getStanding(facing);
        }
        return animations.getStanding(DIRECTION.SOUTH);
    }

}

