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
    public int mapTileNum[][];

    public int mapTeoriTileNum[][];

    public int mapPraktikumTilenum[][];

    public int currentTileMap[][];
    public TilesManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[40];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        mapTeoriTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        mapPraktikumTilenum = new int[gp.maxScreenCol][gp.maxScreenRow];
        currentTileMap = mapTileNum;

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Top_CWalls.png"));
            tile[0].collision = true;
        
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Lower_Walls.png"));
            tile[1].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Upper_Walls.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Floor_Yellow.png"));
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("Tiles/TopRight_CWalls.png"));
            tile[4].collision = true;
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Lower_Stairs.png"));
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Middle_Stairs.png"));
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Upper_Stairs.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Middle_Walls.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("Tiles/TopLeft_CWalls.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Right_HWalls.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Left_HWalls.png"));
            tile[11].collision = true;
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("Tiles/Blank_Walls.png"));
            
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("Tiles/LeftUpper_Walls.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("Tiles/LeftMiddle_Walls.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("Tiles/LeftLower_Walls.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("Tiles/LeftLower_Walls.png"));






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
                    mapTileNum[col][row] = num;
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

        try{
            InputStream in = getClass().getResourceAsStream("Maps/MapsTheory.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while (col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTeoriTileNum[col][row] = num;
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

        try{
            InputStream in = getClass().getResourceAsStream("Maps/MapsPraktikum.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while (col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapPraktikumTilenum[col][row] = num;
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
        if (gp.gameState == gp.playstatelobby){
            currentTileMap = mapTileNum;
        }
        else if(gp.gameState == gp.playstateteori){
            currentTileMap = mapTeoriTileNum;
        }
        else if(gp.gameState == gp.playstatepraktikum){
            currentTileMap = mapPraktikumTilenum;
        }
        while (row < gp.maxScreenRow) {
            while (col < gp.maxScreenCol){
                g2.drawImage(tile[currentTileMap[col][row]].image, gp.tileSize * col, gp.tileSize * row, gp.tileSize, gp.tileSize, null);
                col++;
            }
            row++;
            col = 0;
        }
    }
}
