package com.sigmund.pokemon.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.sigmund.pokemon.model.Actor;
import com.sigmund.pokemon.model.DIRECTION;

public class PlayerController extends InputAdapter {

    private Actor player;
    private boolean up, down, left, right, space, enter;

    public PlayerController(Actor player){
        this.player = player;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Keys.UP){
            up = false;
        }
        if(keycode == Keys.DOWN){
            down = false;
        }
        if(keycode == Keys.LEFT){
            left = false;
        }
        if(keycode == Keys.RIGHT){
            right= false;
        }
        if(keycode == Keys.ENTER){
            enter = false;
        }
        if(keycode == Keys.SPACE){
            space = false;
        }
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Keys.UP){
            up = true;
        }
        if(keycode == Keys.DOWN){
            down = true;
        }
        if(keycode == Keys.LEFT){
            left = true;
        }
        if(keycode == Keys.RIGHT){
            right= true;
        }
        if(keycode == Keys.ENTER){
            enter = true;
        }
        if(keycode == Keys.SPACE){
            space = true;
        }
        return false;
    }

    public void update(float delta){
        if(up){
            player.move(DIRECTION.NORTH);
        }
        if(down){
            player.move(DIRECTION.SOUTH);
        }
        if(left){
            player.move(DIRECTION.WEST);
        }
        if(right){
            player.move(DIRECTION.EAST);
        }
        if(space){
            player.jump();
        }
        if(enter){
            player.select();
        }
    }
}
