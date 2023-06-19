package Characters;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Games.GamePanel;
import Games.KeyHandler;

public class Player extends Entity{
    boolean isMoving = false;
    boolean isPlayingPhone = false;
    public KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        this.x = 600;
        this.y = 664;
        this.speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            upIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Idle1.png"));
            upIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Idle2.png"));
            upIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Idle3.png"));
            upIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Idle4.png"));
            upIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Idle5.png"));
            upIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Idle6.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Up_Move6.png"));
            
            downIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Idle1.png"));
            downIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Idle2.png"));
            downIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Idle3.png"));
            downIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Idle4.png"));
            downIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Idle5.png"));
            downIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Idle6.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Down_Move6.png"));
            
            leftIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Idle1.png"));
            leftIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Idle2.png"));
            leftIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Idle3.png"));
            leftIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Idle4.png"));
            leftIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Idle5.png"));
            leftIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Idle6.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Left_Move6.png"));
            
            rightIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Idle1.png"));
            rightIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Idle2.png"));
            rightIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Idle3.png"));
            rightIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Idle4.png"));
            rightIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Idle5.png"));
            rightIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Idle6.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Right_Move6.png"));

            phone1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone1.png"));
            phone2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone2.png"));
            phone3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone3.png"));
            phone4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone4.png"));
            phone5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone5.png"));
            phone6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone6.png"));
            phone7 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone7.png"));
            phone8 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone8.png"));
            phone9 = ImageIO.read(getClass().getResourceAsStream("/Characters/Mahasiswa/Mahasiswa_Phone9.png"));
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void interactNPC(){
        
    }

    public void update() {
        if(!keyH.isTalking){
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
                isPlayingPhone = false;
            }
        }
        else{
            isMoving = false;
            isPlayingPhone = false;
            phoneIdleTimer = 0;
        }
        collisionOn = false;
        gp.collider.checkTiles(this);
        if(!collisionOn && isMoving && !keyH.isTalking){
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
            spriteIdleNum = 1;
            spriteIdleCounter = 0;

            phoneIdleTimer = 0;
            phoneIdleNum = 0;
            phoneIdleCounter = 0;

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

            spriteIdleCounter++;
            if(phoneIdleTimer > 20 && !keyH.isTalking){
                isPlayingPhone = true;
                direction = "down";
                phoneIdleCounter++;
                if(phoneIdleCounter > 8){
                    if (phoneIdleNum == 9){
                        phoneIdleNum = 4;
                    } else {
                        phoneIdleNum++;
                    }
                    phoneIdleCounter = 0;
                }
            }

            else if(spriteIdleCounter > 8){
                phoneIdleTimer++;
                if(spriteIdleNum == 6){
                    spriteIdleNum = 1;
                } else {
                    spriteIdleNum++;
                }
                spriteIdleCounter = 0;
            }
        }

    }

    @Override
    public void setDialogue() {

    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;

        if (direction.equals("up")){
            if (!isMoving) {
                if (spriteIdleNum == 1){
                    image = upIdle1;
                }
                if (spriteIdleNum == 2){
                    image = upIdle2;
                }
                if (spriteIdleNum == 3){
                    image = upIdle3;
                }
                if (spriteIdleNum == 4){
                    image = upIdle4;
                }
                if (spriteIdleNum == 5){
                    image = upIdle5;
                }
                if (spriteIdleNum == 6){
                    image = upIdle6;
                } 
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
        }else if (direction.equals("left")){
            if (!isMoving) {
                if (spriteIdleNum == 1){
                    image = leftIdle1;
                }
                if (spriteIdleNum == 2){
                    image = leftIdle2;
                }
                if (spriteIdleNum == 3){
                    image = leftIdle3;
                }
                if (spriteIdleNum == 4){
                    image = leftIdle4;
                }
                if (spriteIdleNum == 5){
                    image = leftIdle5;
                }
                if (spriteIdleNum == 6){
                    image = leftIdle6;
                } 
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
                if (spriteIdleNum == 1){
                    image = downIdle1;
                }
                if (spriteIdleNum == 2){
                    image = downIdle2;
                }
                if (spriteIdleNum == 3){
                    image = downIdle3;
                }
                if (spriteIdleNum == 4){
                    image = downIdle4;
                }
                if (spriteIdleNum == 5){
                    image = downIdle5;
                }
                if (spriteIdleNum == 6){
                    image = downIdle6;
                } 
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
                if (spriteIdleNum == 1){
                    image = rightIdle1;
                }
                if (spriteIdleNum == 2){
                    image = rightIdle2;
                }
                if (spriteIdleNum == 3){
                    image = rightIdle3;
                }
                if (spriteIdleNum == 4){
                    image = rightIdle4;
                }
                if (spriteIdleNum == 5){
                    image = rightIdle5;
                }
                if (spriteIdleNum == 6){
                    image = rightIdle6;
                } 
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
        if (isPlayingPhone){
            if (phoneIdleNum == 1){
                image = phone1;
            }
            if (phoneIdleNum== 2){
                image = phone2;
            }
            if (phoneIdleNum== 3){
                image = phone3;
            }
            if (phoneIdleNum== 4){
                image = phone4;
            }
            if (phoneIdleNum== 5){
                image = phone5;
            }
            if (phoneIdleNum== 6){
                image = phone6;
            }
            if (phoneIdleNum== 7){
                image = phone7;
            }
            if (phoneIdleNum== 8){
                image = phone8;
            }
            if (phoneIdleNum== 9){
                image = phone9;
            }
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    
}