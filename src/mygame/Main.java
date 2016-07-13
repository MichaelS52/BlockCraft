package mygame;

import com.jme3.system.AppSettings;

/**
 * test
 * @author normenhansen
 */
public class Main{

    public static String NAME="BlockCraft";
    
    
    public static void main(String[] args) {
        Game game = new Game();
        AppSettings settings = new AppSettings(true);
        settings.setTitle(NAME);
        game.setSettings(settings);
        game.start();
    }
}
