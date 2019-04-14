/**
 * @author        Sunny Srijan
 * @version       1.0
 * @since         03/22/2019
 */
package TankGame;

import java.awt.Graphics;
import java.awt.Rectangle;

abstract public class Thing {
    private int x, y;
    private final GameWorld game;

    protected Thing(int x, int y, GameWorld game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }

    abstract public void draw(Graphics g);

    abstract public Rectangle getRec();

    protected int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    protected GameWorld getGame() {
        return game;
    }
}


