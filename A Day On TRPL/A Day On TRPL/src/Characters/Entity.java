package Characters;
import java.awt.*;
import java.awt.image.BufferedImage;

import Games.GamePanel;;

public class Entity {
    GamePanel gp;
    public int x, y;
    public int speed;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public int counter = -1;

    public int defaultx = 0, defaulty = 32;
    public BufferedImage up1, up2, up3, up4, up5, up6, left1, left2, left3, left4, left5, left6;
    public BufferedImage down1, down2, down3, down4, down5, down6,  right1, right2, right3, right4, right5, right6;
    public BufferedImage upIdle1, upIdle2, upIdle3, upIdle4, upIdle5, upIdle6, leftIdle1, leftIdle2, leftIdle3, leftIdle4, leftIdle5, leftIdle6;
    public BufferedImage downIdle1, downIdle2, downIdle3, downIdle4, downIdle5, downIdle6, rightIdle1, rightIdle2, rightIdle3, rightIdle4, rightIdle5, rightIdle6;
    public BufferedImage phone1, phone2, phone3, phone4, phone5, phone6, phone7, phone8, phone9; 
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public int spriteIdleCounter = 0;
    public int spriteIdleNum = 1;

    public int phoneIdleTimer = 0;
    public int phoneIdleCounter = 0;
    public int phoneIdleNum = 1;

    public Rectangle hitBox = new Rectangle(0, 32, 62, 26);
    public boolean collisionOn = false;
    public boolean doneTalking = false;
    public boolean moveOnTalk = true;
    public String dialogue[];
    public int nextQuest;

    public void setDialogue(){}
    public void draw(Graphics2D g2){};
    public void update(){};
}
