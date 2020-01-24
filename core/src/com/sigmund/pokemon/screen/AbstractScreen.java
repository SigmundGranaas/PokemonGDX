package com.sigmund.pokemon.screen;

import com.badlogic.gdx.Screen;
import com.sigmund.pokemon.PokemonGDX;

public abstract class AbstractScreen implements Screen {

    private PokemonGDX app;

    public AbstractScreen(PokemonGDX app) {
        this.app = app;
    }

    @Override
    public abstract void dispose();

    @Override
    public abstract void hide();

    @Override
    public abstract void pause();

    public abstract void update(float delta);

    @Override
    public abstract void render(float delta);

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void resume();

    @Override
    public abstract void show();

    public PokemonGDX getApp() {
        return app;
    }

}