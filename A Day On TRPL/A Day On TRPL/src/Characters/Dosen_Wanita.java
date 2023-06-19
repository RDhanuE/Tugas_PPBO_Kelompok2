package Characters;

import Games.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Dosen_Wanita extends Mahasiswa_Wanita {
    public Dosen_Wanita(GamePanel gp){
        super(gp);
        setDefaultValue();
        this.dialogue = new String[9];
    }

    public void setDefaultValue() {
        this.x = 384;
        this.y = 172;
        direction = "down";
    }

    public void setDialogue(){
        dialogue[0] = "Dosen/nHalo selamat pagi /nrekan-rekan mahasiswa";
        dialogue[1] = "Mahasiswa/nSelamat pagi juga bu";
        dialogue[2] = "Dosen/nOkke selamat datang /ndi kampus ini /ndan juga di prodi ini./nSaya akan menjelaskan /napa saja yang akan dipelajari /ndalam kelas teori.";
        dialogue[3] = "Dosen/nNah dalam kelas teori kita /nakan mempelajari beberapa/nmateri dimana sebagai/nacuan untuk implementasi/ndalam kelas praktikum.";
        dialogue[4] = "Dosen/nApakah ada yang kurang jelas?";
        dialogue[5] = "Mahasiswa/nSudah jelas bu.";
        dialogue[6] = "Dosen/nCukup sekian penjelasan/ndari saya./nKelas teori akan segera/nsaya mulai./nSilahkan duduk di kursi/nmasing-masing";
        dialogue[7] = "Mahasiswa/nSIAPPPP BUUUU...";
        dialogue[8] = "Dosen/nSelamat berjuang semuanya!!";
        gp.ui.currentDialogue = dialogue[counter];
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

        if (direction == "down"){
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
