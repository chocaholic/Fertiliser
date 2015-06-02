package ie.woden.fertiliser.desktop;

import ie.woden.fertiliser.Fertiliser;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Fertiliser";
		cfg.width = 600;
		cfg.height = 900;

		new LwjglApplication(new Fertiliser(), cfg);
	}
}
