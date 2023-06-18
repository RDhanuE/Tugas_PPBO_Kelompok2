package Characters;

import Games.GamePanel;

public class Mahasiswa_Wanita_Praktikum extends Mahasiswa_Wanita{

    public Mahasiswa_Wanita_Praktikum(GamePanel gp) {
        super(gp);
        setDefaultValue();
        getPlayerImage();
        this.dialogue = new String[3];
    }

    public void setDefaultValue() {
        this.x = 388;
        this.y = 384;
        direction = "up";
    }

    public void setDialogue(){
        dialogue[0] = "Mahasiswa/nHalo, salam kenal";
        dialogue[1] = "Mahasiswa Wanita/nHai, salam kenal juga";
        dialogue[2] = "Mahasiswa Wanita/nKampus ini keren ya!";
        gp.ui.currentDialogue = dialogue[counter];
    }
}
