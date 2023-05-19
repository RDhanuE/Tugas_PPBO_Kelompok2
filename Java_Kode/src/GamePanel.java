import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    //Variables
    final int originalTileSize = 32;
    final int scale = 2;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 9;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    KeyHandler keyhandler = new KeyHandler();
    Thread gameThread;

    int playerX  = 100;
    int playerY = 100;
    int playerSpeed = 4;

    int FPS = 60;

    //Code
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyhandler);
        this.setFocusable(true);
    
    
    }


    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1){
            update();
            repaint();
            delta--;
            }
        }
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        if(keyhandler.upPressed){
            playerY -= playerSpeed;
        }

        else if(keyhandler.leftPressed){
            playerX -= playerSpeed;
        }

        else if(keyhandler.rightPressed){
            playerX += playerSpeed;
        }

        else if(keyhandler.downPressed){
            playerY += playerSpeed;
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();

    }

}
