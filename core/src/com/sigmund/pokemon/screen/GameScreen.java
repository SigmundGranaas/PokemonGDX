package com.sigmund.pokemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sigmund.pokemon.PokemonGDX;
import com.sigmund.pokemon.Settings;
import com.sigmund.pokemon.controller.PlayerController;
import com.sigmund.pokemon.model.Actor;
import com.sigmund.pokemon.model.TileMap;

public class GameScreen extends AbstractScreen {
    private TileMap map;
    private Texture Grass;
    private Texture redStandingSouth;
    private Actor player;
    private SpriteBatch batch;
    private PlayerController controller;
    private Camera gameCamera;

    public GameScreen(PokemonGDX app) {
        super(app);
        Grass = new Texture("Grass.png");
        redStandingSouth = new Texture("Red_standing_south.png");

        batch = new SpriteBatch();
        map = new TileMap(20,20);
        player = new Actor(map,0,0);
        controller = new PlayerController(player);

    }

    @Override
    public void dispose() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        controller.update(delta);
    batch.begin();
    player.update(delta);

    float worldStartX = Gdx.graphics.getWidth()/2;
    float worldStartY = Gdx.graphics.getHeight()/2;
    for(int x = 0; x < map.getWidth(); x++){
        for(int y = 0; y < map.getHeight(); y++){
            batch.draw(Grass,
                    worldStartX+x*Settings.SCALED_TILE_SIZE - player.getX()+0.5f,
                    worldStartY+y*Settings.SCALED_TILE_SIZE - player.getY()+0.5f,
                    Settings.SCALED_TILE_SIZE,
                    Settings.SCALED_TILE_SIZE);
        }
    }

    batch.draw(player.getAnimTexture(),
            worldStartX+player.getX(),
            worldStartY+player.getY(),
            Settings.SCALED_TILE_SIZE,
            Settings.SCALED_TILE_SIZE);

    batch.end();

    }



    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(controller);
    }
}
