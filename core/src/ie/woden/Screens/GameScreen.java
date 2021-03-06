package ie.woden.Screens;

import ie.woden.GameWorld.GameRenderer;
import ie.woden.GameWorld.GameWorld;
import ie.woden.helpers.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;

	public GameScreen() {

		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 272;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		int midPointY = (int) (gameHeight / 2);

		world = new GameWorld(midPointY);
		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth
				/ gameWidth, screenHeight / gameHeight));
		renderer = new GameRenderer(world, (int) gameHeight, midPointY);
		world.setRenderer(renderer);
	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		// Gdx.app.log("GameScreen", "resizing");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		// Gdx.app.log("GameScreen", "show called");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		// Gdx.app.log("GameScreen", "pause called");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		// Gdx.app.log("GameScreen", "resume called");
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		// Gdx.app.log("GameScreen", "hide called");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
}
