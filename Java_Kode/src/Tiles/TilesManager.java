package Tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Games.GamePanel;

public class TilesManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTIleNum[][];

    public TilesManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[10];
        mapTIleNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Floor_Tiles.png"));
        
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Lower_Walls.png"));
            tile[1].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Upper_Walls.png"));
            tile[2].collision = true;

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(){
        try{
            InputStream in = getClass().getResourceAsStream("Maps/Maps.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while (col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTIleNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
        }
    }

    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        while (row < gp.maxScreenRow) {
            while (col < gp.maxScreenCol){
                g2.drawImage(tile[mapTIleNum[col][row]].image, gp.tileSize * col, gp.tileSize * row, gp.tileSize, gp.tileSize, null);
                col++;    
            }
            row++;
            col = 0;
        }
    }
}
