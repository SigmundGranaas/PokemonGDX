package com.sigmund.pokemon.utility;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sigmund.pokemon.model.DIRECTION;

import java.util.HashMap;
import java.util.Map;

public class AnimationSet {
    private Map<DIRECTION, Animation> walking;
    private Map<DIRECTION, TextureRegion> standing;

    public AnimationSet(Animation walkNorth,
                        Animation walkEast,
                        Animation walkWest,
                        Animation walkSouth,
                        TextureRegion standNorth,
                        TextureRegion standWest,
                        TextureRegion standEast,
                        TextureRegion standSouth
                        ){
        walking = new HashMap<>();
        walking.put(DIRECTION.EAST, walkEast);
        walking.put(DIRECTION.NORTH, walkNorth);
        walking.put(DIRECTION.WEST, walkWest);
        walking.put(DIRECTION.SOUTH, walkSouth);
        walking.put(DIRECTION.SOUT_EAST, walkEast);
        walking.put(DIRECTION.SOUTH_WEST, walkWest);
        walking.put(DIRECTION.NORT_EAST, walkEast);
        walking.put(DIRECTION.NORT_WEST, walkWest);
        standing = new HashMap<>();
        standing.put(DIRECTION.NORTH, standNorth);
        standing.put(DIRECTION.WEST, standWest);
        standing.put(DIRECTION.SOUTH, standSouth);
        standing.put(DIRECTION.EAST, standEast);
        standing.put(DIRECTION.NORT_WEST, standWest);
        standing.put(DIRECTION.SOUTH_WEST, standWest);
        standing.put(DIRECTION.NORT_EAST, standEast);
        standing.put(DIRECTION.SOUT_EAST, standEast);


    }

    public Animation getWalking (DIRECTION dir){
        return walking.get(dir);
    }
    public TextureRegion getStanding(DIRECTION dir){
        return standing.get(dir);
    }
}
