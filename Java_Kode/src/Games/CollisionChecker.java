package Games;

import Characters.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTiles(Entity entity){
        int leftTiles = entity.x + entity.hitBox.x;
        int rightTiles = entity.x + entity.hitBox.x + entity.hitBox.width;
        int upTiles = entity.y + entity.hitBox.y;
        int downTiles = entity.y + entity.hitBox.y + entity.hitBox.height;
        
        int LeftCol = leftTiles / gp.tileSize;
        int rightCol = rightTiles / gp.tileSize;
        int upRow = upTiles / gp.tileSize;
        int downRow = downTiles / gp.tileSize;

        int tileNum1, tileNum2, decoNum1, decoNum2;

        if (entity.direction.equals("up")){
            upRow = (upTiles - entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTIleNum[LeftCol][upRow];
            tileNum2 = gp.tileM.mapTIleNum[rightCol][upRow];
            decoNum1 = gp.decoM.mapTIleNum[LeftCol][upRow];
            decoNum2 = gp.decoM.mapTIleNum[rightCol][upRow];
            if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true || gp.decoM.tile[decoNum1].collision == true || gp.decoM.tile[decoNum2].collision == true){
                entity.collisionOn = true;
            }
            if (gp.decoM.tile[decoNum1].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum1].Entityindex;
            } else if (gp.decoM.tile[decoNum2].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum2].Entityindex;

            } else {
                gp.ui.talk = false;
                gp.ui.indexNPC = 0;
            }
        } 
        else if (entity.direction.equals("right")){
            rightCol = (rightTiles + entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTIleNum[rightCol][upRow];
            tileNum2 = gp.tileM.mapTIleNum[rightCol][downRow];
            decoNum1 = gp.decoM.mapTIleNum[rightCol][upRow];
            decoNum2 = gp.decoM.mapTIleNum[rightCol][downRow];
            if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true || gp.decoM.tile[decoNum1].collision == true || gp.decoM.tile[decoNum2].collision == true){
                entity.collisionOn = true;
                }
            if (gp.decoM.tile[decoNum1].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum1].Entityindex;
            } else if (gp.decoM.tile[decoNum2].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum2].Entityindex;

            } else {
                gp.ui.talk = false;
                gp.ui.indexNPC = 0;
            }
        }
        else if (entity.direction.equals("down")){
            downRow = (downTiles + entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTIleNum[LeftCol][downRow];
            tileNum2 = gp.tileM.mapTIleNum[rightCol][downRow];
            decoNum1 = gp.decoM.mapTIleNum[LeftCol][downRow];
            decoNum2 = gp.decoM.mapTIleNum[rightCol][downRow];
            if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true || gp.decoM.tile[decoNum1].collision == true || gp.decoM.tile[decoNum2].collision == true){
                entity.collisionOn = true;
            }
            if (gp.decoM.tile[decoNum1].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum1].Entityindex;
            } else if (gp.decoM.tile[decoNum2].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum2].Entityindex;

            } else {
                gp.ui.talk = false;
                gp.ui.indexNPC = 0;
            }
        }
        else if (entity.direction.equals("left")){
            LeftCol = (leftTiles - entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTIleNum[LeftCol][upRow];
            tileNum2 = gp.tileM.mapTIleNum[LeftCol][downRow];
            decoNum1 = gp.decoM.mapTIleNum[LeftCol][upRow];
            decoNum2 = gp.decoM.mapTIleNum[LeftCol][downRow];
            if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true || gp.decoM.tile[decoNum1].collision == true || gp.decoM.tile[decoNum2].collision == true){
                entity.collisionOn = true;
            }
            if (gp.decoM.tile[decoNum1].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum1].Entityindex;
            } else if (gp.decoM.tile[decoNum2].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum2].Entityindex;

            } else {
                gp.ui.talk = false;
                gp.ui.indexNPC = 0;
            }
        }
    }
}
