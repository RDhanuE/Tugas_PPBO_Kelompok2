package Games;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Characters.Entity;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, isTalking = false;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (gp.gameState == gp.titlestate){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                if (gp.ui.commandNum == 0){
                    gp.ui.commandNum = 2;
                } else {
                    gp.ui.commandNum--;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                if (gp.ui.commandNum == 2){
                    gp.ui.commandNum = 0;
                } else {
                    gp.ui.commandNum++;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if (gp.ui.commandNum == 0){
                    gp.gameState = gp.playstatelobby;
                }

                if (gp.ui.commandNum == 1){
                    gp.gameState = gp.creditstate;
                }

                if (gp.ui.commandNum == 2){
                    System.exit(0);
                }
            }
        }

        else if (gp.gameState == gp.creditstate){
            if(code == KeyEvent.VK_ENTER){
                gp.gameState = gp.titlestate;
            }
        }

        else if (gp.gameState == gp.playstatelobby || gp.gameState == gp.playstateteori || gp.gameState == gp.playstatepraktikum){
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                upPressed = true;
            }
            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                downPressed = true;
            }
            if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
                rightPressed = true;
            }
            if(code == KeyEvent.VK_ENTER && gp.ui.talk){
                Entity target = gp.LobbyInteract[gp.ui.indexNPC];
                if (gp.player.direction == "right" && target != null){
                    target.direction = "left";
                } else if (gp.player.direction == "left" && target != null){
                    target.direction = "right";
                } else if (gp.player.direction == "up" && target != null){
                    target.direction = "down";
                } else if(gp.player.direction == "down" && target != null){
                    target.direction = "up";
                }
                if (gp.ui.startCounter < gp.ui.startDialogue.length){
                    gp.ui.startCounter++;
                }
                else if (!isTalking){
                    isTalking = true;
                    if (target.doneTalking){
                        target.counter = target.dialogue.length - 1;
                    }else{
                        target.counter++;
                    }
                }
                else if (isTalking && gp.ui.startCounter >= gp.ui.startDialogue.length){
                    if (!target.doneTalking){
                        target.counter++;
                        if (target.counter >= target.dialogue.length - 1){
                            if (gp.ui.indexQuest == target.nextQuest - 1){
                                gp.ui.indexQuest = target.nextQuest;
                            }
                            target.doneTalking = true;
                            isTalking = false;
                        }
                    }
                    else if (target.doneTalking){
                        isTalking = false;
                    }
                }
            } 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }
    
}
