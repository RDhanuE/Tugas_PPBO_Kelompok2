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
    public int indexNPC = 0;


    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Poppins", Font.PLAIN, 40);
        try {
            bubble = ImageIO.read(getClass().getResourceAsStream("pixelbubble.png"));
        } catch (IOException e) {
             e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2){
        this.g2 = g2;
        if (indexNPC != 0 && !gp.player.keyH.isTalking){
            g2.drawImage(bubble, 0, gp.tileSize * 10, gp.tileSize * 2, gp.tileSize * 2, null);
        }
        if (gp.player.keyH.isTalking && talk){
            gp.interactable[indexNPC].setDialogue();
            drawDialogueScreen();
            }
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
}
