package Characters;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Games.GamePanel;

public class Satpams extends Entity{
    GamePanel gp;

    public Satpams(GamePanel gp){
        this.gp = gp;
        setDefaultValue();
        getPlayerImage();

        hitBox = new Rectangle(0, 32, 62, 26);
    }

    public void setDefaultValue() {
        this.x = 868;
        this.y = 172;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            downIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle1.png"));
            downIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle2.png"));
            downIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle3.png"));
            downIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle4.png"));
            downIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle5.png"));
            downIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle6.png"));
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        spriteCounter++;
            if (spriteCounter > 8){
                if (spriteNum == 6){
                    spriteNum = 1;
                } else {
                    spriteNum++;
                }
                spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        if (spriteNum == 1){
            image = downIdle1;
        }
        if (spriteNum == 2){
            image = downIdle2;
        }
        if (spriteNum == 3){
            image = downIdle3;
        }
        if (spriteNum == 4){
            image = downIdle4;
        }
        if (spriteNum == 5){
            image = downIdle5;
        }
        if (spriteNum == 6){
            image = downIdle6;
        } 
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    
    }
}
