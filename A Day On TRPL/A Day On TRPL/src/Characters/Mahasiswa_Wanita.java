package Characters;

import Games.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mahasiswa_Wanita extends Entity{

    public Mahasiswa_Wanita(GamePanel gp) {
        super(gp);
        setDefaultValue();
        getPlayerImage();
        this.dialogue = new String[3];
    }

    public void setDefaultValue() {
        this.x = 768;
        this.y = 256;
        direction = "down";
    }

    public void setDialogue(){
        dialogue[0] = "Mahasiswa/nHalo, salam kenal";
        dialogue[1] = "Mahasiswa Wanita/nHai, salam kenal juga";
        dialogue[2] = "Mahasiswa Wanita/nKampus ini keren ya!";
        gp.ui.currentDialogue = dialogue[counter];
    }

    public void getPlayerImage(){
        try{
            downIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Down1.png"));
            downIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Down2.png"));
            downIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Down3.png"));
            downIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Down4.png"));
            downIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Down5.png"));
            downIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Down6.png"));

            rightIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Right1.png"));
            rightIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Right2.png"));
            rightIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Right3.png"));
            rightIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Right4.png"));
            rightIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Right5.png"));
            rightIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Right6.png"));

            leftIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Left1.png"));
            leftIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Left2.png"));
            leftIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Left3.png"));
            leftIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Left4.png"));
            leftIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Left5.png"));
            leftIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Left6.png"));

            upIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Up1.png"));
            upIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Up2.png"));
            upIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Up3.png"));
            upIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Up4.png"));
            upIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Up5.png"));
            upIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Woman/Woman_Up6.png"));


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
        if (direction == "up") {
            if (spriteNum == 1) {
                image = upIdle1;
            }
            if (spriteNum == 2) {
                image = upIdle2;
            }
            if (spriteNum == 3) {
                image = upIdle3;
            }
            if (spriteNum == 4) {
                image = upIdle4;
            }
            if (spriteNum == 5) {
                image = upIdle5;
            }
            if (spriteNum == 6) {
                image = upIdle6;
            }
        }
        else if (direction == "down"){
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
        }
        else if (direction == "left"){
            if (spriteNum == 1){
                image = leftIdle1;
            }
            if (spriteNum == 2){
                image = leftIdle2;
            }
            if (spriteNum == 3){
                image = leftIdle3;
            }
            if (spriteNum == 4){
                image = leftIdle4;
            }
            if (spriteNum == 5){
                image = leftIdle5;
            }
            if (spriteNum == 6){
                image = leftIdle6;
            }
        } else if (direction == "right"){
            if (spriteNum == 1){
                image = rightIdle1;
            }
            if (spriteNum == 2){
                image = rightIdle2;
            }
            if (spriteNum == 3){
                image = rightIdle3;
            }
            if (spriteNum == 4){
                image = rightIdle4;
            }
            if (spriteNum == 5){
                image = rightIdle5;
            }
            if (spriteNum == 6){
                image = rightIdle6;
            }
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

