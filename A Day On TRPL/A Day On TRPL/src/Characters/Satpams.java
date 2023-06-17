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
        this.dialogue = new String[14];
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
        dialogue[1] = "Satpam/nOhh iya nakk, ada yang bisa /nsaya bantu?";
        dialogue[2] = "Mahasiswa/nehmm begini pak, /nsaya mahasiswa baru di sini,/ndan saya belum tahu /nbanyak tentang prodi trpl./nBolehkah bapak jelaskan /napa itu prodi TRPL";
        dialogue[3] = "Satpam/nTRPL itu merupakan salah /nsatu prodi di SV UGM./nProdi ini termasuk ke dalam /nDTEDI";
        dialogue[4] = "Mahasiswa/nEhmm... selain itu pak?";
        dialogue[5] = "Satpam/nApa ya? banyak sebenernya?";
        dialogue[6] = "Mahasiswa/nYaa kalo banyak apa lagi pak /nastaghfirullah jangan /nbikin saya emosi pak.";
        dialogue[7] = "Satpam/nNah di TRPL inin kita akan /nmempelajari bagaimana cara /npengembangan perangkat /nlunak termasuk pembuatan, /npemeliharaan, pengembangan, /nmanajemen kualitas /nperangkat lunak. Selain itu /nTRPL erat kaitannya dengan /ncoding, desain, dan /nalgoritma";
        dialogue[8] = "Mahasiswa/nBaiklah okke pak.../nTombak tajam di tancapkan/nTerima kasih saya ucapkan";
        dialogue[9] = "Satpam/nOke, sama - sama nak/nowh iya, sepertinya kelas/nteori akan mulai sebentar/nlagi";
        dialogue[10] = "Mahasiswa/nOwh iya benar pak/nKelas teori ke/narah mana ya pak?";
        dialogue[11] = "Satpam/nKelas teori ada di/natas nak. Naik saja lewat/ntangga ini";
        dialogue[12] = "Mahasiswa/nBaik pak, terimakasih";
        dialogue[13] = "Satpam/nSelamat datang dan selamat /nbersenang - senang";
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

            rightIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Right1.png"));
            rightIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Right2.png"));
            rightIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Right3.png"));
            rightIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Right4.png"));
            rightIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Right5.png"));
            rightIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Right6.png"));

            
            leftIdle1 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Left1.png"));
            leftIdle2 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Left2.png"));
            leftIdle3 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Left3.png"));
            leftIdle4 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Left4.png"));
            leftIdle5 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Left5.png"));
            leftIdle6 = ImageIO.read(getClass().getResourceAsStream("/Characters/Satpam/Satpam_Idle_Left6.png"));

            
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
