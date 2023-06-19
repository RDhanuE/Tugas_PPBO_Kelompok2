package Characters;

import Games.GamePanel;

public class Mahasiswa_Pria_Teori extends Mahasiswa_Pria {
    public Mahasiswa_Pria_Teori(GamePanel gp) {
        super(gp);
        setDefaultValue();
        this.dialogue = new String[7];
    }

    public void setDefaultValue() {
        this.x = 320;
        this.y = 512;
        direction = "down";
        moveOnTalk = false;
    }
    public void setDialogue(){
        dialogue[0] = "Mahasiswa/nHalo";
        dialogue[1] = "Mahasiswa Pria/nYoiiii Browww";
        dialogue[2] = "Mahasiswa/nKampus ini keren ya!";
        dialogue[3] = "Mahasiswa Pria/nAffah iyaahh? ";
        dialogue[4] = "Mahasiswa/nEhmmm ngga jugaaa";
        dialogue[5] = "Mahasiswa Pria/nWkwkwkwkwk";
        dialogue[6] = "Mahasiswa/nXixixixi";
        gp.ui.currentDialogue = dialogue[counter];
    }
}
