package Characters;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage upIdle, up1, up2, up3, up4, up5, up6, leftIdle, left1, left2, left3, left4, left5, left6;
    public BufferedImage downIdle, down1, down2, down3, down4, down5, down6, rightIdle, right1, right2, right3, right4, right5, right6;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle hitBox;
    public boolean collisionOn = false;
}
