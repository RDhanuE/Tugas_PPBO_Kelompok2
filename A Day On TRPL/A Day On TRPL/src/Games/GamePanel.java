package Games;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Characters.Entity;
import Characters.Gudang;
import Characters.Player;
import Characters.Satpams;
import Tiles.DecorManager;
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
    DecorManager decoM = new DecorManager(this);
    KeyHandler keyhandler = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker collider = new CollisionChecker(this);
    public Entity[] interactable = new Entity[3];

    public Gudang gudang = new Gudang(this);
    public Player player = new Player(this, keyhandler);
    public Satpams npc1 = new Satpams(this);
    
    public UI ui = new UI(this);

    public int gameState;
    public final int playstate = 1;
    public final int titlestate = 2;
    public final int creditstate = 3;
    
    

    int FPS = 60;

    //Code
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyhandler);
        this.setFocusable(true);

        this.setInteractable();
        gameState = titlestate;
    }
    

    public void setInteractable(){
        this.interactable[1] = npc1;
        this.interactable[2] = gudang;

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
        npc1.update();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        if (gameState == titlestate){
            ui.draw(g2);
        } else {
            tileM.draw(g2);
            decoM.draw(g2);
            npc1.draw(g2);
            player.draw(g2);
            ui.draw(g2);     
        }

        g2.dispose();

    }

}
