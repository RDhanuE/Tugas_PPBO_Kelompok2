package Tiles;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Games.GamePanel;

public class TilesManager {
    GamePanel gp;
    Tile[] tile;

    public TilesManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Floor_Tiles.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int x = 0;
        int y = 0;
        while (y <= 704) {
            while (x <= 1216){
                g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
                x = x + 64;    
            }
            y = y + 64;
            x = 0;
        }
    }
}
