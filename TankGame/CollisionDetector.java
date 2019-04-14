/**
 * @author        Sunny Srijan
 * @version       1.0
 * @since         03/22/2019
 */
package TankGame;

import java.util.List;
public class CollisionDetector {
    GameEvents gameEvents;
    GameWorld game;

    public CollisionDetector(GameWorld game) {
        this.game = game;
        gameEvents = game.getObservable();
    }

    public void collideWith(Unit caller, Thing target) {
        if (!caller.isDamaged() && caller.getRec().intersects(target.getRec())) {  // bullet for no damage

            if (caller instanceof Bullet && target instanceof Tank) {
                Bullet bullet = (Bullet) caller;
                Tank tank = (Tank) target;
                if (bullet.isGood() == tank.isGood()) {  // own bullet for no colusion
                    return;
                }
            }

            if (caller instanceof Bullet || caller instanceof Tank || caller instanceof PowerUp) {  //no explosion
                gameEvents.setValue(caller, target);
            }

            if (caller instanceof Tank && target instanceof PowerUp) {
                PowerUp powerUp = (PowerUp) target;
                gameEvents.setValue(caller, target, powerUp.getIndex());
            }
        }
    }

    public void collideWith(Unit caller, List<? extends Thing> things) {
        for (int i = 0; i < things.size(); i++) {
            collideWith(caller, things.get(i));
        }
    }
}
