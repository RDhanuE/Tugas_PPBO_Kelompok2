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
            tileNum1 = gp.tileM.currentTileMap[LeftCol][upRow];
            tileNum2 = gp.tileM.currentTileMap[rightCol][upRow];
            decoNum1 = gp.decoM.selectedDecoNum[LeftCol][upRow];
            decoNum2 = gp.decoM.selectedDecoNum[rightCol][upRow];

            if (upTiles == 0 && gp.ui.indexQuest >= 2) {
                gp.gameState = gp.playstateteori;
                gp.player.x = 1144;
                gp.player.y = 248;
                gp.player.direction = "left";
                if (!gp.visitedTeori){
                    gp.ui.indexQuest = 3;
                    gp.visitedTeori = true;
                }
            }
            else if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true || gp.decoM.tile[decoNum1].collision == true || gp.decoM.tile[decoNum2].collision == true || upTiles == 0){
                entity.collisionOn = true;
            }
            if (gp.decoM.tile[decoNum1].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum1].Entityindex;
            } else if (gp.decoM.tile[decoNum2].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum2].Entityindex;

            } else {
                if (gp.ui.startCounter >= gp.ui.startDialogue.length){
                    gp.ui.talk = false;
                }
                gp.ui.indexNPC = 0;
            }
        } 
        else if (entity.direction.equals("right")){
            rightCol = (rightTiles + entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.currentTileMap[rightCol][upRow];
            tileNum2 = gp.tileM.currentTileMap[rightCol][downRow];
            decoNum1 = gp.decoM.selectedDecoNum[rightCol][upRow];
            decoNum2 = gp.decoM.selectedDecoNum[rightCol][downRow];
            if(rightTiles >= 1274){
                if (gp.gameState == gp.playstatelobby){
                    gp.gameState = gp.playstatepraktikum;
                    gp.player.x = 1144;
                    gp.player.y = 240;
                    gp.player.direction = "left";
                }
                else if (gp.gameState == gp.playstatepraktikum){
                    gp.gameState = gp.playstatelobby;
                    gp.player.x = 1144;
                    gp.player.y = 240;
                    gp.player.direction = "left";
                }
                else if(gp.gameState == gp.playstateteori){
                    gp.gameState = gp.playstatelobby;
                    gp.player.x = 612;
                    gp.player.y = 28;
                    gp.player.direction = "down";
                }
            }

            if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true || gp.decoM.tile[decoNum1].collision == true || gp.decoM.tile[decoNum2].collision == true || rightTiles >= 1274){
                entity.collisionOn = true;
                }
            if (gp.decoM.tile[decoNum1].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum1].Entityindex;
            } else if (gp.decoM.tile[decoNum2].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum2].Entityindex;

            } else {
                if (gp.ui.startCounter >= gp.ui.startDialogue.length){
                    gp.ui.talk = false;
                }
                gp.ui.indexNPC = 0;
            }
        }
        else if (entity.direction.equals("down")){
            downRow = (downTiles + entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.currentTileMap[LeftCol][downRow];
            tileNum2 = gp.tileM.currentTileMap[rightCol][downRow];
            decoNum1 = gp.decoM.selectedDecoNum[LeftCol][downRow];
            decoNum2 = gp.decoM.selectedDecoNum[rightCol][downRow];
            if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true || gp.decoM.tile[decoNum1].collision == true || gp.decoM.tile[decoNum2].collision == true || downTiles >= 760){
                entity.collisionOn = true;
            }
            if (gp.decoM.tile[decoNum1].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum1].Entityindex;
            } else if (gp.decoM.tile[decoNum2].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum2].Entityindex;

            } else {
                if (gp.ui.startCounter >= gp.ui.startDialogue.length){
                    gp.ui.talk = false;
                }
                gp.ui.indexNPC = 0;
            }
        }
        else if (entity.direction.equals("left")){
            LeftCol = (leftTiles - entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.currentTileMap[LeftCol][upRow];
            tileNum2 = gp.tileM.currentTileMap[LeftCol][downRow];
            decoNum1 = gp.decoM.selectedDecoNum[LeftCol][upRow];
            decoNum2 = gp.decoM.selectedDecoNum[LeftCol][downRow];
            if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true || gp.decoM.tile[decoNum1].collision == true || gp.decoM.tile[decoNum2].collision == true || leftTiles == 0){
                entity.collisionOn = true;
            }
            if (gp.decoM.tile[decoNum1].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum1].Entityindex;
            } else if (gp.decoM.tile[decoNum2].isInteracable == true){
                gp.ui.talk = true;
                gp.ui.indexNPC = gp.decoM.tile[decoNum2].Entityindex;

            } else {
                if (gp.ui.startCounter >= gp.ui.startDialogue.length){
                    gp.ui.talk = false;
                }
                gp.ui.indexNPC = 0;
            }
        }
    }
}
