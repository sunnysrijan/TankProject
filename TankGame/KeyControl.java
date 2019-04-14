/**
 * @author        Sunny Srijan
 * @version       1.0
 * @since         03/22/2019
 */
package TankGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter {
    private GameEvents gameEvents;

    public KeyControl(GameEvents gameEvents) {
        this.gameEvents = gameEvents;
    }

    public void keyPressed(KeyEvent e) {
        gameEvents.setValue(e);
    }

    public void keyReleased(KeyEvent e) {
        gameEvents.setKeys(e);
    }
}

