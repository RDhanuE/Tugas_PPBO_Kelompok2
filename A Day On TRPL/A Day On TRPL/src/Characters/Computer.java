package Characters;

import Games.GamePanel;

import java.awt.*;

public class Computer extends Entity{
    int x = 1;

    public Computer(GamePanel gp) {
        super(gp);
        this.dialogue = new String[3];
    }

    public void setDialogue(){

        if (gp.ui.indexQuest == 4) {
            if (x == 1){
                doneTalking = false;
                counter = 0;
                x--;
            }
            this.dialogue = new String[10];
            dialogue[0] = "Mahasiswa/nMari kita berkuliah dulu";
            dialogue[1] = "Mahasiswa/nOhh gitu aja mah pasti bisa/nEzzz";
            dialogue[2] = "Mahasiswa/nEhh loh/nlohh kokkk makin pusingg";
            dialogue[3] = "Mahasiswa/nARGHHUARGHJAAJDDKGSDKJHS";
            dialogue[4] = "/nA few moments later...";
            dialogue[5] = "Dosen/nSekian kelas kita/nhari ini. Semoga/nkalian tidak kapok/nmasuk sini.";
            dialogue[6] = "Mahasiswa/nTerimakasih bu";
            dialogue[7] = "Mahasiswa/nOke, kelas hari/nini sudah selesai.";
            dialogue[8] = "Mahasiswa/nWaktunya pulang";
            dialogue[9] = "Mahasiswa/nWaktunya pulang";
            nextQuest = 5;

        } else {
            dialogue[0] = "Mahasiswa/nWah ini meja/nkuliahnya ya?";
            dialogue[1] = "Mahasiswa/nWalaupun kampusnya/nUGM, mejanya masih/ntetap sederhana.";
            dialogue[2] = "Mahasiswa/nNostalgia sekali...";
        }
        gp.ui.currentDialogue = dialogue[counter];
    }

    @Override
    public void draw(Graphics2D g2) {

    }

    @Override
    public void update() {

    }

}
