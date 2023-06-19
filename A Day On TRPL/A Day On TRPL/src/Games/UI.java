package Games;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class UI {
    BufferedImage bubble;
    Font retroC;
    GamePanel gp;
    Graphics2D g2;
    public String currentDialogue;
    public boolean talk;
    public int indexNPC = 0, indexQuest;
    public int startCounter = 0;
    public String[] quest = new String[6];
    String[] startDialogue = new String[4];
    int count = 1;
    public int commandNum = 0;
        
        


    public UI(GamePanel gp){
        this.gp = gp;
        try {
            InputStream is = getClass().getResourceAsStream("/Fonts/retroC.ttf");
            retroC = Font.createFont(Font.TRUETYPE_FONT, is);
            
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }



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
        quest[1] = "Bicara /ndengan Pak /nsatpam";
        quest[2] = "Pergi ke /nkelas";
        quest[3] = "Bicara dengan/nBu dosen";
        quest[4] = "Ikuti kelas/nteori";
        quest[5] = "Pulang";
    }


    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(retroC);


        if (gp.getGameState() == gp.titlestate){
            drawTittleScreen();
        }

        else if (gp.getGameState() == gp.tutorialstate){
            drawTutorial();
        }

        else if (gp.getGameState() == gp.creditstate){
            drawCredits();
        }

        else if (gp.getGameState() == gp.finalstate) {
            drawGameover();
        }

        else if (gp.getGameState() == gp.playstatelobby || gp.getGameState() == gp.playstateteori || gp.getGameState() == gp.playstatepraktikum){
            drawQuestBar();
            if (count == 1 && startCounter <= startDialogue.length){
                startJourney();
                
            }
            if (indexNPC != 0 && !gp.player.keyH.isTalking){
                g2.drawImage(bubble, 0, gp.tileSize * 10, gp.tileSize * 2, gp.tileSize * 2, null);
            }
            if (gp.player.keyH.isTalking && talk && startCounter >= startDialogue.length){
                if (gp.getGameState() == gp.playstatelobby){
                    gp.LobbyInteract[indexNPC].setDialogue();
                } else if (gp.getGameState() == gp.playstateteori) {
                    gp.TeoriInteract[indexNPC].setDialogue();
                } else if (gp.getGameState() == gp.playstatepraktikum) {
                    gp.PraktikumInteract[indexNPC].setDialogue();
                }
                drawDialogueScreen();
           }
        }
    }

    public void drawTutorial(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80));

        String text = "Tutorial";
        int x = getcenterX(text);
        int y = gp.tileSize * 3;
        g2.setColor(Color.black);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));
        text = "Use W A S D to move";
        x = getcenterX(text);
        y += gp.tileSize * 3;
        g2.drawString(text, x, y);

        text = "Use ENTER to interact or talk";
        x = getcenterX(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);

        text = "Press ENTER to continue";
        x = getcenterX(text);
        y += gp.tileSize * 3;
        g2.drawString(text, x, y);

        text = "Press ESCAPE to go back";
        x = getcenterX(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);

    }

    public void drawCredits(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96));
        
        String text = "Credits";
        int x = getcenterX(text);
        int y = gp.tileSize * 3;
        g2.setColor(Color.black);
        g2.drawString(text, x, y);

        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40 ));

        g2.setColor(Color.black);
        text = "Ryvalino Dhanu Ekaputra";
        x = getcenterX(text);
        y += gp.tileSize * 2;
        g2.drawString(text, x, y);

        g2.setColor(Color.black);
        text = "Lutfi Lisana Shidqi";
        x = getcenterX(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);

        g2.setColor(Color.black);
        text = "Naufal Manaf";
        x = getcenterX(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);

        g2.setColor(Color.black);
        text = "Tsania Qurrota A'yunin Qulub";
        x = getcenterX(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);

        g2.setColor(Color.black);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30 ));
        text = "Press ESCAPE to get back to main menu";
        x = getcenterX(text);
        y += gp.tileSize * 3;
        g2.drawString(text, x, y);
        
    
    }

    public  void drawGameover(){
        g2.setColor(Color.white);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 120));

        String text = "GAME OVER";
        int x = getcenterX(text);
        int y = gp.tileSize * 3;
        g2.setColor(Color.black);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));

        text = "Kamu sudah survive satu hari di trpl";
        x = getcenterX(text);
        y += gp.tileSize * 2;
        g2.setColor(Color.black);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 40));

        text = "Semoga kamu survive di hari selanjutnya...";
        x = getcenterX(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40));

        text = ">>EXIT<<";
        x = getcenterX(text);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);



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
            g2.drawString(">>", x - (int) g2.getFontMetrics().getStringBounds("<<", g2).getWidth(), y);
            g2.drawString("<<", x + (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth()  , y);
        }
        
        text = "Credits";
        x = getcenterX(text);
        y += gp.tileSize ;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">>", x - (int) g2.getFontMetrics().getStringBounds("<<", g2).getWidth(), y);
            g2.drawString("<<", x + (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth(), y);
        }

        text = "Quit";
        x = getcenterX(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">>", x - (int) g2.getFontMetrics().getStringBounds("<<", g2).getWidth(), y);
            g2.drawString("<<", x + (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth(), y);
        }
    
    }

    public void startJourney(){
        if (startCounter < startDialogue.length){
            gp.player.keyH.isTalking = true;
            talk = true;
        }
        startDialogue[0] = "Mahasiswa/nOke, hari ini adalah hari /npertamaku kuliah di/njurusan TRPL";
        startDialogue[1] = "Mahasiswa/nEmm....";
        startDialogue[2] = "Mahasiswa/nSetelah dipikir - pikir, aku /nbelom tahu banyak/ntentang TRPL";
        startDialogue[3] = "Mahasiswa/nCoba kutanyakan dengan pak /nsatpam itu, mungkin/nsaja beliau tahu lebih /nbanyak";
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
                y += 20;
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
        int height = gp.tileSize * 5;
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
