package ie.woden.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture logoTexture, boTexture;
	public static TextureRegion logo, bo;

	public static void load() {
		logoTexture = new Texture(Gdx.files.internal("logo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		logo = new TextureRegion(logoTexture, 0, 0, 512, 114);
		
		boTexture = new Texture(Gdx.files.internal("bo3.jpg"));
		boTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		bo = new TextureRegion(boTexture, 0, 0, 50, 45);
	}
	
	public static void dispose(){
//		texture.dispose();
	}

}
