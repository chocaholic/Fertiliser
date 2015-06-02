package ie.woden.GameWorld;

import ie.woden.helpers.AssetLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class GameRenderer {

	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	private SpriteBatch batcher;

	private BitmapFont font, nitro, phos, potA, pri;
	private Texture bo, woden, displayValue, settings, reset;
	private Stage mStage;
	private Skin skin;
	private TextField nitrogen, phosphorus, potAsh, price;

	float width = Gdx.graphics.getWidth();
	float height = Gdx.graphics.getHeight();
	float scale = width * .2f;

	private GameWorld myWorld;
	private int midPointY;

	public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
		myWorld = world;

		this.midPointY = midPointY;

		cam = new OrthographicCamera();
		cam.setToOrtho(false, 272, gameHeight);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		mStage = new Stage();
		mStage.getViewport().setCamera(cam);
		Gdx.input.setInputProcessor(mStage);
		skin = new Skin(Gdx.files.internal("uiskin.json"));

		font = new BitmapFont(Gdx.files.internal("arial.fnt"),
				Gdx.files.internal("arial.png"), false);
		nitro = new BitmapFont(Gdx.files.internal("arialBold.fnt"),
				Gdx.files.internal("arialBold.png"), false);
		phos = new BitmapFont(Gdx.files.internal("arialBold.fnt"),
				Gdx.files.internal("arialBold.png"), false);
		potA = new BitmapFont(Gdx.files.internal("arialBold.fnt"),
				Gdx.files.internal("arialBold.png"), false);
		pri = new BitmapFont(Gdx.files.internal("arialBold.fnt"),
				Gdx.files.internal("arialBold.png"), false);

		bo = AssetLoader.bo;
		woden = AssetLoader.woden;
		displayValue = AssetLoader.displayValue;
		settings = AssetLoader.settings;
		reset = AssetLoader.reset;

		nitrogen = new TextField("Nitrogen", skin);
		phosphorus = new TextField("Phosporus", skin);
		potAsh = new TextField("Pot Ash", skin);
		price = new TextField("Price", skin);
	}

	public void render(float delta, float runTime) {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		batcher.begin();
		font.draw(batcher, "Enter Mix Ratio and Price", 10, 390);
		nitro.draw(batcher, "Nitrogen", 10, 370);
		phos.draw(batcher, "Phosphorus", 10, 310);
		potA.draw(batcher, "Pot Ash", 10, 250);
		pri.draw(batcher, "Price", 10, 190);

		batcher.draw(bo, 220, 400);
		batcher.draw(woden, 10, 400);
		batcher.draw(displayValue, 5, 90);
		batcher.draw(settings, 5, 50);
		batcher.draw(reset, 5, 10);
		batcher.end();

		nitrogen.setPosition(10, 320);
		nitrogen.setSize(250, 30);
		nitrogen.setColor(255, 255, 255, 0);

		phosphorus.setPosition(10, 260);
		phosphorus.setSize(250, 30);
		phosphorus.setColor(255, 255, 255, 0);

		potAsh.setPosition(10, 200);
		potAsh.setSize(250, 30);
		potAsh.setColor(255, 255, 255, 0);

		price.setPosition(10, 140);
		price.setSize(250, 30);
		price.setColor(255, 255, 255, 0);

		mStage.addActor(nitrogen);
		mStage.addActor(phosphorus);
		mStage.addActor(potAsh);
		mStage.addActor(price);
		mStage.draw();

		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(57 / 255.0f, 166 / 255.0f, 241 / 255.0f, 1);
		shapeRenderer.rect(10, 320, 250, 30);

		shapeRenderer.setColor(57 / 255.0f, 166 / 255.0f, 241 / 255.0f, 1);
		shapeRenderer.rect(10, 260, 250, 30);

		shapeRenderer.setColor(57 / 255.0f, 166 / 255.0f, 241 / 255.0f, 1);
		shapeRenderer.rect(10, 200, 250, 30);

		shapeRenderer.setColor(57 / 255.0f, 166 / 255.0f, 241 / 255.0f, 1);
		shapeRenderer.rect(10, 140, 250, 30);

		shapeRenderer.end();
	}
}
