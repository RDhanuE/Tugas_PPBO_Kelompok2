package Characters;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Games.GamePanel;

public class Dosen_Pria extends Entity{

    public Dosen_Pria(GamePanel gp){
        super(gp);
        setDefaultValue();
        getPlayerImage();
        this.dialogue = new String[11];
        nextQuest = 3;


        hitBox = new Rectangle(0, 32, 62, 26);
    }

    public void setDefaultValue() {
        this.x = 572;
        this.y = 248;
        direction = "down";
    }

    public void setDialogue(){
        dialogue[0] = "Mahasiswa/nHalo, Selamat pagi, Pak.";
        dialogue[1] = "Dosen/nSelamat pagi";
        dialogue[2] = "Mahasiswa/nMaaf, saya mahasiswa baru di /nprodi TRPL./nApakah ini benar /nkelas praktikum ya, Pak?";
        dialogue[3] = "Mahasiswa/nKalau boleh tahu kapan /nsaja mahasiswa memakai /nruang ini, Pak?";
        dialogue[4] = "Dosen/nBetul sekali, ini adalah /nlab praktikum atau lab/nkomputer./nJadi lab akan digunakan /nketika mahasiswa harus /nmelakukan praktik dengan/nkomputer.";
        dialogue[5] = "Dosen/nDi sini ada sekitar 26/nkomputer yang nantinya /ndapat digunakan oleh/nkalian";
        dialogue[6] = "Mahasiswa/nOh begitu, Pak./nLalu apakah ada/nperaturan tertentu saat/nberada di lab?";
        dialogue[7] = "Dosen/nTentu saja,/nselama menggunakan lab ini/nmahasiswa dilarang minum/nataupun makan di dalam/nlab karena dikhawatirkan/nakan tumpah dan merusak/nperalatan di sini.";
        dialogue[8] = "Dosen/nUntuk tempat duduknya, /nmahasiswa akan duduk sesuai/nnomor urut tertentu,/njadi mahasiswa tersebut/nyang bertanggung jawab/nsesuai dengan komputer/nyang dipakainya sendiri";
        dialogue[9] = "Mahasiswa/nBaik, Pak. Terima kasih/natas informasinya.";
        dialogue[10] ="Dosen/nOke,n/silakan menjalani kuliah/ndi lab ini./nTetap semangat!";
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
