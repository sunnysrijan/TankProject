/**
 * @author        Sunny Srijan
 * @version       1.0
 * @since         03/22/2019
 */
package TankGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends Thing {
    private boolean dead = false;
    private int step = 0;
    private boolean large;
    private static BufferedImage [] smallExplosionImg = new BufferedImage[6];
    private static BufferedImage [] largeExplosionImg = new BufferedImage[7];
    private static SoundPlayer sp;

    static {
        try {
            BufferedImage tempImg1 = ImageIO.read(GameWorld.class.getResource("../Resources/Explosion_large.png"));
            for (int i = 0, xCoord = 0, yCoord = 0, width = tempImg1.getWidth() / 7, height = tempImg1.getHeight(); i < 7; i++) {
                largeExplosionImg[i] = tempImg1.getSubimage(xCoord, yCoord, width, height);
                xCoord += width;
            }

            BufferedImage tempImg2 = ImageIO.read(GameWorld.class.getResource("../Resources/Explosion_small.png"));
            for (int i = 0, xCoord = 0, yCoord = 0, width = tempImg2.getWidth() / 6, height = tempImg2.getHeight(); i < 6; i++) {
                smallExplosionImg[i] = tempImg2.getSubimage(xCoord, yCoord, width, height);
                xCoord += width;
            }

            sp = new SoundPlayer(2, "../Resources/Explosion_large.wav");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Explosion(int x, int y, GameWorld game, boolean large) {
        super(x, y, game);
        this.large = large;
        sp = new SoundPlayer(2, "../Resources/Explosion_large.wav");
    }

    @Override
    public void draw(Graphics g) {
        if (dead) {
            super.getGame().explosions.remove(this);
            return;
        }

        if ((large && step >= 7) || (!large && step >= 6)) {
            dead = true;
            return;
        }

        g.drawImage(large ? largeExplosionImg[step] : smallExplosionImg[step], super.getX(), super.getY(), null);
        step++;
    }

    @Override
    public Rectangle getRec() {
        return null;
    }


}
