package Characters;

import Games.GamePanel;

public class Mahasiswa_Wanita_Lobby extends Mahasiswa_Wanita{

    public Mahasiswa_Wanita_Lobby(GamePanel gp) {
        super(gp);
    }
    public void setDefaultValue() {
        this.x = 320;
        this.y = 452;
        direction = "down";
        moveOnTalk = false;
    }
}
