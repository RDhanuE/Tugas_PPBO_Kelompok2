package Characters;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Games.GamePanel;

public class Satpams extends Entity{

    public Satpams(GamePanel gp){
        super(gp);
        setDefaultValue();
        getPlayerImage();
        this.dialogue = new String[11];
        nextQuest = 2;
        

        hitBox = new Rectangle(0, 32, 62, 26);
    }

    public void setDefaultValue() {
        this.x = 896;
        this.y = 176;
        direction = "down";
    }
    
    public void setDialogue(){
        dialogue[0] = "Mahasiswa/nHalo, permisi";
        dialogue[1] = "Satpam/nOhh iya nakk, ada yang bisa saya /nbantu?";
        dialogue[2] = "Mahasiswa/nehmm begini pak, saya mahasiswa baru di sini,/ndan saya belum tahu banyak tentang prodi trpl./nBolehkah bapak jelaskan apa itu prodi TRPL";
        dialogue[3] = "Satpam/nTRPL itu merupakan salah satu prodi di SV UGM./nProdi ini termasuk ke dalam DTEDI";
        dialogue[4] = "Mahasiswa/nEhmm... selain itu pak?";
        dialogue[5] = "Satpam/nApa ya? banyak sebenernya?";
        dialogue[6] = "Mahasiswa/nYaa kalo banyak apa lagi pak astaghfirullah/njangan bikin saya emosi pak.";
        dialogue[7] = "Satpam/nNah di TRPL inin kita akan mempelajari/nbagaimana cara pengembangan perangkat lunak/ntermasuk pembuatan, pemeliharaan/npengembangan manajemen kualitas/nperangkat lunak. Selain itu TRPL erat kaitannya/ndengan coding, desain, dan algoritma";
        dialogue[8] = "Mahasiswa/nBaiklah okke pak.../nTombak tajam di tancapkan/nTerima kasih saya ucapkan";
        dialogue[9] = "Satpam/nOke, sama - sama nak";
        dialogue[10] = "Satpam/nSelamat datang dan selamat bersenang - senang";
        gp.ui.currentDialogue = dialogue[counter];
    
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
