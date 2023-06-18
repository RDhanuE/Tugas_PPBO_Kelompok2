package Characters;

import Games.GamePanel;

public class Mahasiswa_Pria_Teori extends Mahasiswa_Pria {
    public Mahasiswa_Pria_Teori(GamePanel gp) {
        super(gp);
    }

    public void setDefaultValue() {
        this.x = 320;
        this.y = 512;
        direction = "down";
        moveOnTalk = false;
    }
}
