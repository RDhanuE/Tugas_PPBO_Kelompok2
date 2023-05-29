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
            System.out.println("pressed");
            Entity target = gp.interactable[gp.ui.indexNPC];
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
