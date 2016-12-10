package me.bramhaag.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.bramhaag.pong.Game;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Game.TITLE;
		config.width = Game.WIDTH;
		config.height = Game.HEIGHT;

		config.useGL30 = true;

		config.resizable = false;

		//Uncomment the line below for fullscreen. Running the application in full screen is not useful when debugging.
		//config.fullscreen = true;

		new LwjglApplication(new Game(), config);
	}
}
