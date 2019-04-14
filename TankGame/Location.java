/**
 * @author        Sunny Srijan
 * @version       1.0
 * @since         03/22/2019
 */
package TankGame;

public class Location {
    private int x;
    private int y;
    private String thing;

    public Location(int x, int y, String thing) {
        this.x = x;
        this.y = y;
        this.thing = thing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getThing() {
        return thing;
    }
}