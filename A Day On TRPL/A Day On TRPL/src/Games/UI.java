package Games;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class UI {
    BufferedImage bubble;
    Font arial_40, arial_80B;
    GamePanel gp;
    Graphics2D g2;
    public String currentDialogue;
    public boolean talk;
    public int indexNPC = 0, indexQuest;
    public int startCounter = 0;
    public String[] quest = new String[3];
    String[] startDialogue = new String[4];
    int count = 1;
    public int commandNum = 0;
        
        


    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Poppins", Font.PLAIN, 40);
        try {
            bubble = ImageIO.read(getClass().getResourceAsStream("pixelbubble.png"));
        } catch (IOException e) {
             e.printStackTrace();
        }
        setQuest();
        indexQuest = 0;
    }

    public void setQuest(){
        quest[0] = "";
        quest[1] = "Bicara dengan pak/nsatpam";
        quest[2] = "Pergi ke kelas";
    }


    public void draw(Graphics2D g2){
        this.g2 = g2;
        
        if (gp.gameState == gp.titlestate){
            drawTittleScreen();
        }

        else if (gp.gameState == gp.playstate){
            drawQuestBar();
            if (count == 1 && startCounter <= startDialogue.length){
                startJourney();
                
            }
            if (indexNPC != 0 && !gp.player.keyH.isTalking){
                g2.drawImage(bubble, 0, gp.tileSize * 10, gp.tileSize * 2, gp.tileSize * 2, null);
            }
            if (gp.player.keyH.isTalking && talk && startCounter >= startDialogue.length){
                gp.interactable[indexNPC].setDialogue();
                drawDialogueScreen();
           }
        }
    }

    public void drawTittleScreen(){
        g2.setColor(Color.orange);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96));
        String text = "A DAY ON TRPL";
        int x = getcenterX(text);
        int y = gp.tileSize * 2;

        g2.setColor(Color.black);
        g2.drawString(text, x + 7, y + 7);
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40 ));

        g2.setColor(Color.black);
        text = "Start Game";
        x = getcenterX(text);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">>", x - gp.tileSize, y);
            g2.drawString("<<", x + gp.tileSize * 2 + (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth() / 2, y);
        }
        
        text = "Load Game";
        x = getcenterX(text);
        y += gp.tileSize ;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">>", x - gp.tileSize, y);
            g2.drawString("<<", x + gp.tileSize * 2 + (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth() / 2, y);
        }

        text = "Option";
        x = getcenterX(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">>", x - gp.tileSize, y);
            g2.drawString("<<", x + gp.tileSize * 1.25f + (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth() / 2, y);
        }
    
    }

    public void startJourney(){
        if (startCounter < startDialogue.length){
            gp.player.keyH.isTalking = true;
            talk = true;
        }
        startDialogue[0] = "Mahasiswa/nOke, hari ini adalah hari pertamaku kuliah di/njurusan TRPL";
        startDialogue[1] = "Mahasiswa/nEmm....";
        startDialogue[2] = "Mahasiswa/nSetelah dipikir - pikir, aku belom tahu banyak/ntentang TRPL";
        startDialogue[3] = "Mahasiswa/nCoba kutanyakan dengan pak satpam itu, mungkin/nsaja beliau tahu lebih banyak";
        if (startCounter >= startDialogue.length){
            count--;
            indexQuest = 1;
            gp.player.keyH.isTalking = false;
            talk = false;
        }
        else{
            currentDialogue = startDialogue[startCounter];
            drawDialogueScreen();
        }
    }

    public void drawQuestBar(){
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int width = gp.tileSize * 3;
        int height = gp.tileSize * 2;
        drawQuestWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN , 15));
        x += gp.tileSize / 3;
        y += gp.tileSize / 2;
        int whichLine = 0;
        g2.setColor(Color.BLACK);
        for (String line : quest[indexQuest].split("/n")){
            g2.drawString(line, x, y);
            if (whichLine == 0){
                y += 20;
            }
            whichLine++;
        }
    }

    public int getcenterX(String text){
        int textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth / 2 - textLength / 2;
    }

    public void drawDialogueScreen(){
        int x = gp.tileSize * 7;
        int y = gp.tileSize * 3;
        int width = gp.tileSize * 6;
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN , 15));
        x += gp.tileSize / 2;
        y += gp.tileSize / 1.5;
        int whichLine = 0;
        for (String line : currentDialogue.split("/n")){
            g2.drawString(line, x, y);
            if (whichLine == 0){
                y += 40;
            } else {
                y += 20;
            }
            whichLine++;

        }
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(255, 255, 255, 150);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
    
        c = new Color(165, 42, 42);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void drawQuestWindow(int x, int y, int width, int height){
        Color c = new Color(255, 255, 255, 100);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
    
        g2.setColor(Color.GREEN);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }
    
}