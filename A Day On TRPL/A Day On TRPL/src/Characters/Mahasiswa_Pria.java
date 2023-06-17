package Characters;

import Games.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mahasiswa_Pria extends Entity{

    public Mahasiswa_Pria(GamePanel gp) {
        super(gp);
        setDefaultValue();
        getPlayerImage();
        this.dialogue = new String[8];
        moveOnTalk = false;
    }

    public void setDefaultValue() {
        this.x = 320;
        this.y = 512;
        direction = "up";
    }

    public void setDialogue(){
        dialogue[0] = "Mahasiswa Pria/nAduh, minumku abis nih";
        dialogue[1] = "Mahasiswa Wanita/nIya, minumku juga./nKita beli minum yuk!";
        dialogue[2] = "Mahasiswa Pria/nEh daripada beli, gimana/nkalo kita isi/naja di toyagama";
        dialogue[3] = "Mahasiswa Wanita/nToyagama?";
        dialogue[4] = "Mahasiswa Pria/nIya, toyagama. UGM kan/nmenyediakan tempat/nmengisi air minum/gratis.";
        dialogue[5] = "Mahasiswa Wanita/nOwh iya aku/ningat. Tadi aku baca/ndi brosur kampus./nKatanya itu salah satu/nupaya agar UGM bisa/nmemproduksi air/nminum berkualitas sendiri.";
        dialogue[6] = "Mahasiswa Pria/nIya benar, yang itu./nYa sudah, ayo kita/nisi air minum";
        dialogue[7] = "Mahasiswa Wanita/nEhm... toyagamanya/ndi sebelah mana ya?";
        gp.ui.currentDialogue = dialogue[counter];
    }

    public void getPlayerImage(){
        try{
            downIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Down1.png"));
            downIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Down2.png"));
            downIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Down3.png"));
            downIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Down4.png"));
            downIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Down5.png"));
            downIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Down6.png"));

            rightIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Right1.png"));
            rightIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Right2.png"));
            rightIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Right3.png"));
            rightIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Right4.png"));
            rightIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Right5.png"));
            rightIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Right6.png"));

            leftIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Left1.png"));
            leftIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Left2.png"));
            leftIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Left3.png"));
            leftIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Left4.png"));
            leftIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Left5.png"));
            leftIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Left6.png"));

            upIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Up2.png"));
            upIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Up1.png"));
            upIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Up3.png"));
            upIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Up4.png"));
            upIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Up5.png"));
            upIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Man/Man_Up6.png"));
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

