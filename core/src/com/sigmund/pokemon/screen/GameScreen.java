package com.sigmund.pokemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sigmund.pokemon.PokemonGDX;
import com.sigmund.pokemon.Settings;
import com.sigmund.pokemon.model.Actor;
import com.sigmund.pokemon.model.TileMap;

public class GameScreen extends AbstractScreen {
    private TileMap map;
    private Texture Grass;
    private Texture redStandingSouth;
    private Actor player;
    private SpriteBatch batch;

    public GameScreen(PokemonGDX app) {
        super(app);
        Grass = new Texture("Grass.png");
        redStandingSouth = new Texture("Red_standing_south.png");

        batch = new SpriteBatch();
        //map = new TileMap(20,20);
        player = new Actor(map,0,0);

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
    batch.begin();
    float worldStartX = Gdx.graphics.getWidth()/2;
    float worldStartY = Gdx.graphics.getHeight()/2;
    for(int x = 0; x < 20; x++){
        for(int y = 0; y < 10; y++){
            batch.draw(Grass,
                    worldStartX+x*Settings.SCALED_TILE_SIZE,
                    worldStartY+y*Settings.SCALED_TILE_SIZE,
                    Settings.SCALED_TILE_SIZE,
                    Settings.SCALED_TILE_SIZE);
        }
    }
    batch.draw(Grass,
                worldStartX,
                worldStartY,
                Settings.SCALED_TILE_SIZE,
                Settings.SCALED_TILE_SIZE);

    batch.draw(redStandingSouth,
            worldStartX,
            worldStartY,
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
    }
}
