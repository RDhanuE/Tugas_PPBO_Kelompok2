package Games;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Characters.Entity;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, isTalking = false;
    public Entity target;

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
                gp.playSE(2);
                if (gp.ui.commandNum == 0){
                    gp.ui.commandNum = 2;
                } else {
                    gp.ui.commandNum--;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.playSE(2);
                if (gp.ui.commandNum == 2){
                    gp.ui.commandNum = 0;
                } else {
                    gp.ui.commandNum++;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if (gp.ui.commandNum == 0){
                    gp.playSE(1);
                    gp.gameState = gp.tutorialstate;
                }

                if (gp.ui.commandNum == 1){
                    gp.playSE(1);
                    gp.gameState = gp.creditstate;
                }

                if (gp.ui.commandNum == 2){
                    gp.playSE(1);
                    System.exit(0);
                }
            }
        }

        else if (gp.gameState == gp.tutorialstate){
            if(code == KeyEvent.VK_ENTER) {
                gp.playSE(1);
                gp.gameState = gp.playstatelobby;
            }
        }

        else if (gp.gameState == gp.creditstate){
            if(code == KeyEvent.VK_ENTER){
                gp.playSE(1);
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
                gp.playSE(0);
                if (gp.gameState == gp.playstatelobby){
                    target = gp.LobbyInteract[gp.ui.indexNPC];
                }
                else if (gp.gameState == gp.playstateteori){
                    target = gp.TeoriInteract[gp.ui.indexNPC];
                }
                else if(gp.gameState == gp.playstatepraktikum){
                    target = gp.PraktikumInteract[gp.ui.indexNPC];
                }
                if (gp.player.direction == "right" && target != null && target.moveOnTalk){
                    target.direction = "left";
                } else if (gp.player.direction == "left" && target != null && target.moveOnTalk){
                    target.direction = "right";
                } else if (gp.player.direction == "up" && target != null && target.moveOnTalk){
                    target.direction = "down";
                } else if(gp.player.direction == "down" && target != null && target.moveOnTalk){
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
