package Tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Games.GamePanel;

public class DecorManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTIleNum[][];

    public DecorManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[20];
        mapTIleNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blank_Walls.png"));
            

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("Decor/Door_TopRight.png"));
            tile[1].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("Decor/Door_BottomLeft.png"));
            tile[2].collision = true;
            tile[2].isInteracable = true;
            tile[2].Entityindex = 2;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("Decor/Door_BottomRight.png"));
            tile[3].collision = true;
            tile[3].isInteracable = true;
            tile[3].Entityindex = 2;
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("Decor/Door_TopLeft.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("Decor/Sofa_FRight.png"));
            tile[5].collision = true;
            tile[5].setFull = true;
        
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("Decor/Sofa_FLeft.png"));
            tile[6].collision = true;
            tile[6].setFull = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("Decor/Arrow_Left.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("Decor/Arrow_Right.png"));
            tile[8].collision = true;
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blank_Walls_Solid.png"));
            tile[9].collision = true;
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blank_Walls_Interactable.png"));
            tile[10].collision = true;
            tile[10].isInteracable = true;
            tile[10].Entityindex = 1;
            
        
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(){
        try{
            InputStream in = getClass().getResourceAsStream("Maps/Decor.txt");
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
                if (tile[mapTIleNum[col][row]].setFull){
                    g2.drawImage(tile[mapTIleNum[col][row]].image, gp.tileSize * col, gp.tileSize * row, tile[mapTIleNum[col][row]].image.getWidth(), tile[mapTIleNum[col][row]].image.getHeight(), null);
                } else
                g2.drawImage(tile[mapTIleNum[col][row]].image, gp.tileSize * col, gp.tileSize * row, gp.tileSize, gp.tileSize, null);
                col++;    
            }
            row++;
            col = 0;
        }
    }
}