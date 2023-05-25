package Games;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import Characters.Player;
import Tiles.TilesManager;

public class GamePanel extends JPanel implements Runnable{
    //Variables
    final int originalTileSize = 32;
    final int scale = 2;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //Game Component
    TilesManager tileM = new TilesManager(this);
    KeyHandler keyhandler = new KeyHandler();
    Thread gameThread;
    public CollisionChecker collider = new CollisionChecker(this);

    Player player = new Player(this, keyhandler);
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
        player.update();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();

    }

}
