package Characters;

import Games.GamePanel;

public class Kursi extends Entity{

    public Kursi(GamePanel gp) {
        super(gp);
        this.dialogue = new String[4];
    }

    public void setDialogue(){
        dialogue[0] = "Mahasiswa/nMari kita berkuliah dulu";
        dialogue[1] = "Mahasiswa/nOhh gitu aja mah pasti bisa/nEzzz";
        dialogue[2] = "Mahasiswa/nEhh loh/nlohh kokkk makin pusingg";
        dialogue[3] = "Mahasiswa/nARGHHUARGHJAAJDDKGSDKJHS";

        gp.ui.currentDialogue = dialogue[counter];
    }

}
