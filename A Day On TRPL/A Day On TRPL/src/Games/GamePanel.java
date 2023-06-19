package Games;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Characters.*;
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
    Sound sound = new Sound();
    TilesManager tileM = new TilesManager(this);
    DecorManager decoM = new DecorManager(this);
    KeyHandler keyhandler = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker collider = new CollisionChecker(this);
    public Entity[] LobbyInteract = new Entity[5];
    public Entity[] TeoriInteract = new Entity[4];
    public Entity[] PraktikumInteract = new Entity[4];

    public Gudang gudang = new Gudang(this);
    public Player player = new Player(this, keyhandler);
    public Satpams npc1 = new Satpams(this);
    public Mahasiswa_Wanita npcTeori1 = new Mahasiswa_Wanita(this);
    public Mahasiswa_Pria npcToya1 = new Mahasiswa_Pria(this);
    public Mahasiswa_Wanita_Lobby npcToya2 = new Mahasiswa_Wanita_Lobby(this);
    public Dosen_Pria npcPraktikum1 = new Dosen_Pria(this);
    public Dosen_Wanita npcTeori2 = new Dosen_Wanita(this);
    public Kursi computer = new Kursi(this);
    public Mahasiswa_Wanita_Praktikum npcPraktikum2 =  new Mahasiswa_Wanita_Praktikum(this);
    public Mahasiswa_Pria_Teori npcTeori3 = new Mahasiswa_Pria_Teori(this);
    
    public UI ui = new UI(this);

    public int gameState;
    public final int playstatelobby = 1;
    public final int playstateteori = 4;
    public final int titlestate = 2;
    public final int creditstate = 3;
    public final int playstatepraktikum = 5;
    public final int tutorialstate = 6;

    public  boolean visitedTeori = false;
    public boolean visitedPraktikum = false;

    

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
        this.LobbyInteract[1] = npc1;
        this.LobbyInteract[2] = gudang;
        this.LobbyInteract[3] = npcToya1;
        this.LobbyInteract[4] = npcToya2;

        this.TeoriInteract[1] = npcTeori1;
        this.TeoriInteract[2] = npcTeori3;
        this.TeoriInteract[3] = npcTeori2;

        this.PraktikumInteract[1] = npcPraktikum1;
        this.PraktikumInteract[2] = computer;
        this.PraktikumInteract[3] = npcPraktikum2;
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
        if (gameState == playstatelobby){
            for (int x = 1; x < LobbyInteract.length ; x++){
                LobbyInteract[x].update();
            }
        }
        else if (gameState == playstateteori){
            for (int x = 1; x < TeoriInteract.length ; x++){
                TeoriInteract[x].update();
            }
        }
        else if (gameState == playstatepraktikum){
            for (int x = 1; x < PraktikumInteract.length ; x++){
                PraktikumInteract[x].update();
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        if (gameState == titlestate || gameState == creditstate || gameState == tutorialstate){
            ui.draw(g2);
        } else {
            System.out.println(player.x + " " + player.y);
            tileM.draw(g2);
            decoM.draw(g2);
            if (gameState == playstatelobby){
                for (int x = 1; x < LobbyInteract.length ; x++){
                    LobbyInteract[x].draw(g2);
                }
            }
            else if (gameState == playstateteori){
                for (int x = 1; x < TeoriInteract.length ; x++){
                    TeoriInteract[x].draw(g2);
                }
            }
            else if (gameState == playstatepraktikum){
                for (int x = 1; x < PraktikumInteract.length ; x++){
                    PraktikumInteract[x].draw(g2);
                }
            }
            player.draw(g2);
            ui.draw(g2);     
        }

        g2.dispose();

    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }

}
