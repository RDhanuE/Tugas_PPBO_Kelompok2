package Characters;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Games.GamePanel;
import Games.KeyHandler;

public class Player extends Entity{
    boolean isMoving = false;
    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValue();
        getPlayerImage();

        hitBox = new Rectangle(0, 32, 62, 26);
    }

    public void setDefaultValue() {
        this.x = 600;
        this.y = 664;
        this.speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            upIdle = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move6.png"));
            
            downIdle = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move6.png"));
            
            leftIdle = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move6.png"));
            
            rightIdle = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move6.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed){
            isMoving = true;
            direction = "up";
        }

        else if(keyH.leftPressed){
            isMoving = true;
            direction = "left";
        }

        else if(keyH.rightPressed){
            isMoving = true;
            direction = "right";
        }

        else if(keyH.downPressed){
            isMoving = true;
            direction = "down";

        }
        else {
            isMoving = false;
        }

        collisionOn = false;
        gp.collider.checkTiles(this);
        if(!collisionOn && isMoving){
            if (direction.equals("up")){
                y -= speed;
            }
            else if (direction.equals("left")){
                x -= speed;
            }
            else if (direction.equals("down")){
                y += speed;
            }
            else if (direction.equals("right")){
                x += speed;
            }
        }

        if (isMoving) {
        spriteCounter++;
        if (spriteCounter > 8){
            if (spriteNum == 6){
                spriteNum = 1;
            } else {
                spriteNum++;
            }
            spriteCounter = 0;
        }
        } else {
            spriteNum = 1;
            spriteCounter = 0;
        }

    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;

        if (direction.equals("up")){
            if (!isMoving) {
                image = upIdle;
            } else {
            if (spriteNum == 1){
                image = up1;
            }
            if (spriteNum == 2){
                image = up2;
            }
            if (spriteNum == 3){
                image = up3;
            }
            if (spriteNum == 4){
                image = up4;
            }
            if (spriteNum == 5){
                image = up5;
            }
            if (spriteNum == 6){
                image = up6;
            }
        }
        } else if (direction.equals("left")){
            if (!isMoving) {
                image = leftIdle;
            } else {
            if (spriteNum == 1){
                image = left1;
            }
            if (spriteNum == 2){
                image = left2;
            }
            if (spriteNum == 3){
                image = left3;
            }
            if (spriteNum == 4){
                image = left4;
            }
            if (spriteNum == 5){
                image = left5;
            }
            if (spriteNum == 6){
                image = left6;
            }
        }
        } else if (direction.equals("down")){
            if (!isMoving) {
                image = downIdle;
            } else {
            if (spriteNum == 1){
                image = down1;
            }
            if (spriteNum == 2){
                image = down2;
            }
            if (spriteNum == 3){
                image = down3;
            }
            if (spriteNum == 4){
                image = down4;
            }
            if (spriteNum == 5){
                image = down5;
            }
            if (spriteNum == 6){
                image = down6;
            }
        }
        } else if (direction.equals("right")) {
            if (!isMoving) {
                image = rightIdle;
            } else {
            if (spriteNum == 1){
                image = right1;
            }
            if (spriteNum == 2){
                image = right2;
            }
            if (spriteNum == 3){
                image = right3;
            }
            if (spriteNum == 4){
                image = right4;
            }
            if (spriteNum == 5){
                image = right5;
            }
            if (spriteNum == 6){
                image = right6;
            }
        }
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    
}