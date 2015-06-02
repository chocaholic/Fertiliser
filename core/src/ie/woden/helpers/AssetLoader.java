package ie.woden.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture logoTexture, bo, woden, displayValue, settings, reset;
	public static TextureRegion logo;

	public static void load() {
		logoTexture = new Texture(Gdx.files.internal("logo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		logo = new TextureRegion(logoTexture, 0, 0, 512, 114);
		
		bo = new Texture("bo3.jpg");
//		boTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
//		bo = new TextureRegion(boTexture, 0, 0, 50, 45);
//		bo.flip(false, true);
		
		woden = new Texture("woden.png");
//		wodenTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
//		woden = new TextureRegion(wodenTexture, 0, 0, 127, 35);
//		woden.flip(false, true);
		
		displayValue = new Texture("DisplayValue.jpg");
//		displayValueTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
//		displayValue = new TextureRegion(displayValueTexture, 0, 0, 260, 37);
//		displayValue.flip(false, true);
		
		settings = new Texture("Settings.jpg");
//		settingsTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
//		settings = new TextureRegion(settingsTexture, 0, 0, 260, 37);
//		settings.flip(false, true);
		
		reset = new Texture("Reset.jpg");
//		resetTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
//		reset = new TextureRegion(resetTexture, 0, 0, 260, 37);
//		reset.flip(false, true);
	}
	
	public static void dispose(){
//		texture.dispose();
	}

}
