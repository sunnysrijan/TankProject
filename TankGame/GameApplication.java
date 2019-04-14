/**
 * GameApplication.java	-A program responsible for launching game application
 * @author        Sunny Srijan
 * @version       1.0
 * @since         03/22/2019
 */
package TankGame;

import javax.swing.*;
import java.awt.*;

/* Runnable game application */
public class GameApplication {
    private GameWorld game;

    public static void main(String argv[]) {
        GameWorld game = GameWorld.getInstance();
        JFrame f = new JFrame("TANK GAME");
        f.addKeyListener(new KeyControl(game.getObservable()));
        f.getContentPane().add("Center", game);
        f.pack();
        f.setSize(new Dimension(800, 480));
        game.init();
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.start();
    }

}