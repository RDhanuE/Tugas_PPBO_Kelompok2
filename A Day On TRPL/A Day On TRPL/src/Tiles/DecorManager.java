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
    public int mapDecoNum[][];
    public int mapDecoTheoryNum[][];
    public int mapDecoPraktikumNum[][];
    public int selectedDecoNum[][];

    public DecorManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[40];
        mapDecoNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        mapDecoPraktikumNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        mapDecoTheoryNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        selectedDecoNum = mapDecoNum;

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

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blackboard_TopLeft.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blackboard_TopCenter.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blackboard_TopRight.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blackboard_BottomLeft.png"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blackboard_BottomCenter.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blackboard_BottomRight.png"));
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("Decor/Table_book.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("Decor/Table_empty.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("Decor/Chair_Up.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("Decor/Lecturer_Table.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("Decor/Ventilator.png"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("Decor/Window.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("Decor/Computer_Lab.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blank_Walls_Interactable.png"));
            tile[24].collision = true;
            tile[24].isInteracable = true;
            tile[24].Entityindex = 2;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("Decor/Blank_Walls_Interactable.png"));
            tile[25].collision = true;
            tile[25].isInteracable = true;
            tile[25].Entityindex = 3;


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
                    mapDecoNum[col][row] = num;
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
            InputStream in = getClass().getResourceAsStream("Maps/DecorPraktikum.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while (col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapDecoPraktikumNum[col][row] = num;
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
            InputStream in = getClass().getResourceAsStream("Maps/DecorTheory.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while (col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapDecoTheoryNum[col][row] = num;
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
            selectedDecoNum = mapDecoNum;
        }
        else if(gp.gameState == gp.playstateteori){
            selectedDecoNum = mapDecoTheoryNum;
        }
        else if(gp.gameState == gp.playstatepraktikum){
            selectedDecoNum = mapDecoPraktikumNum;
        }
        while (row < gp.maxScreenRow) {
            while (col < gp.maxScreenCol){
                if (tile[mapDecoNum[col][row]].setFull){
                    g2.drawImage(tile[selectedDecoNum[col][row]].image, gp.tileSize * col, gp.tileSize * row, tile[mapDecoNum[col][row]].image.getWidth(), tile[mapDecoNum[col][row]].image.getHeight(), null);
                } else
                    g2.drawImage(tile[selectedDecoNum[col][row]].image, gp.tileSize * col, gp.tileSize * row, gp.tileSize, gp.tileSize, null);
                col++;
            }
            row++;
            col = 0;
        }
    }
}