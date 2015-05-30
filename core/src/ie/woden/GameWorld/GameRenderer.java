package ie.woden.GameWorld;

import ie.woden.TweenAccessors.Value;
import ie.woden.helpers.AssetLoader;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class GameRenderer {
	
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	private SpriteBatch batcher;

	private int midPointY;
	private TweenManager manager;
	private Value alpha = new Value();
	private Color transitionColor;
	private BitmapFont font, nitro, phos, potA, pri;
	private Texture bo, woden, displayValue, settings, reset;
	private Stage mStage;
	private Skin skin;
	private TextField nitrogen, phosphorus, potAsh, price;
	
	private Sprite bo2;
	
	float width = Gdx.graphics.getWidth();
	float height = Gdx.graphics.getHeight();
	float scale = width * .2f;
	
	public GameRenderer(GameWorld world, int gameHeight, int midPointY){
		myWorld = world;

		this.midPointY = midPointY;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, gameHeight);

		batcher = new SpriteBatch();
//		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer = new ShapeRenderer();
//		shapeRenderer.setProjectionMatrix(cam.combined);
		
//		mStage = new Stage(new ExtendViewport(136, gameHeight));
//		mStage.getViewport().update(136, gameHeight, false);
		mStage = new Stage();
		Gdx.input.setInputProcessor(mStage);
		skin = new Skin(Gdx.files.internal("uiskin.json"));

		font = new BitmapFont(Gdx.files.internal("arial.fnt"), Gdx.files.internal("arial.png"), false);
		nitro = new BitmapFont(Gdx.files.internal("arialBold.fnt"), Gdx.files.internal("arialBold.png"), false);
		phos = new BitmapFont(Gdx.files.internal("arialBold.fnt"), Gdx.files.internal("arialBold.png"), false);
		potA = new BitmapFont(Gdx.files.internal("arialBold.fnt"), Gdx.files.internal("arialBold.png"), false);
		pri = new BitmapFont(Gdx.files.internal("arialBold.fnt"), Gdx.files.internal("arialBold.png"), false);
		
		bo = new Texture("bo3.jpg");
		woden = new Texture("woden.png");
		displayValue = new Texture("DisplayValue.jpg");
		settings = new Texture("Settings.jpg");
		reset = new Texture("Reset.jpg");
		
		nitrogen = new TextField("Nitrogen", skin);
		phosphorus = new TextField("Phosporus", skin);
		potAsh = new TextField("Pot Ash", skin);
		price = new TextField("Price", skin);
		
		bo2 = new Sprite(AssetLoader.bo);
//		scale = desiredWidth / bo.getWidth();
		bo2.setSize(bo2.getWidth() * (scale / bo.getWidth()), bo2.getHeight() * (scale / bo.getHeight()));
		bo2.setPosition((width / 1.2f) - (bo2.getWidth() / 2), (height / 1.1f)
				- (bo2.getHeight() / 2));
		
//		initGameObjects();
//		initAssets();
//		transitionColor = new Color();
//		prepareTransition(255, 255, 255, .5f);
	}
	
	public void render(float delta, float runTime) {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		batcher.begin();
		font.draw(batcher, "Enter Mix Ratio and Price", 10, 400);
		nitro.draw(batcher, "Nitrogen", 10, 370);
		phos.draw(batcher, "Phosphorus", 10, 310);
		potA.draw(batcher, "Pot Ash", 10, 250);
		pri.draw(batcher, "Price", 10, 190);
		
		bo2.draw(batcher);
		
//		batcher.draw(bo, 220, 420);
		
//		batcher.draw(bo, (width / 1.2f) - (bo.getWidth() / 2), (height / 2f)
//				- (bo.getHeight() / 2), bo.getWidth() * (scale / bo.getWidth()), bo.getHeight() * (scale / bo.getHeight()));

		batcher.draw(woden, 10, 420);
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
	
//	public void prepareTransition(int r, int g, int b, float duration) {
//		transitionColor.set(r / 255.0f, g / 255.0f, b / 255.0f, 1);
//		alpha.setValue(1);
//		Tween.registerAccessor(Value.class, new ValueAccessor());
//		manager = new TweenManager();
//		Tween.to(alpha, -1, duration).target(0)
//				.ease(TweenEquations.easeOutQuad).start(manager);
//	}
//	
//	private void drawTransition(float delta) {
//		if (alpha.getValue() > 0) {
//			manager.update(delta);
//			Gdx.gl.glEnable(GL30.GL_BLEND);
//			Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
//			shapeRenderer.begin(ShapeType.Filled);
//			shapeRenderer.setColor(1, 1, 1, alpha.getValue());
//			shapeRenderer.rect(0, 0, 136, 300);
//			shapeRenderer.end();
//			Gdx.gl.glDisable(GL30.GL_BLEND);
//		}
//	}
}
