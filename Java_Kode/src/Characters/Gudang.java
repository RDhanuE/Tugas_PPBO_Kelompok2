package Characters;

import Games.GamePanel;

public class Gudang extends Entity{

    public Gudang(GamePanel gp) {
        super(gp);
        this.dialogue = new String[3];
    }
    
    public void setDialogue(){
        System.out.println(counter);
        dialogue[0] = "Mahasiswa/nHmmm";
        dialogue[1] = "Mahasiswa/nTempat ini sepertinya sebuah gudang.";
        dialogue[2] = "Mahasiswa/nTempat ini sepertinya sebuah gudang.";
        gp.ui.currentDialogue = dialogue[counter];
    }

}
