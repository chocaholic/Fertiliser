package ie.woden.fertiliser;

import ie.woden.Screens.SplashScreen;
import ie.woden.helpers.AssetLoader;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

public class Fertiliser extends Game implements ApplicationListener{
	
	@Override
	public void create () {
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}
	
	@Override
    public void dispose() {
		super.dispose();
		AssetLoader.dispose();
    }
}
