package ie.woden.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture logoTexture, bo, woden, displayValue, settings,
			reset;
	public static TextureRegion logo;

	public static void load() {
		logoTexture = new Texture(Gdx.files.internal("logo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		logo = new TextureRegion(logoTexture, 0, 0, 512, 114);

		bo = new Texture("bo3.jpg");
		bo.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		woden = new Texture("woden.png");
		woden.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		displayValue = new Texture("DisplayValue.jpg");
		displayValue.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		settings = new Texture("Settings.jpg");
		settings.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		reset = new Texture("Reset.jpg");
		reset.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
	}

	public static void dispose() {
		logoTexture.dispose();
		bo.dispose();
		woden.dispose();
		displayValue.dispose();
		settings.dispose();
		reset.dispose();
	}

}
