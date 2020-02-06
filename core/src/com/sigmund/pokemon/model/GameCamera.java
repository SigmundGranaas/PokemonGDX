package com.sigmund.pokemon.model;

import com.badlogic.gdx.graphics.Camera;

public class GameCamera extends Camera {
    private int positionX, positionY;

    GameCamera(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public void update() {

    }

    @Override
    public void update(boolean updateFrustum) {

    }
}
