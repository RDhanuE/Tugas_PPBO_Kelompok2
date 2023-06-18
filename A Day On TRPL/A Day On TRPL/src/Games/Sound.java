package Games;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL SoundURL[] = new URL[10];

    public Sound(){
        SoundURL[0] = getClass().getResource("/Sound/talk.wav");
        SoundURL[1] = getClass().getResource("/Sound/ui_select.wav");
        SoundURL[2] = getClass().getResource("/Sound/ui_updown.wav");
        SoundURL[3] = getClass().getResource("/Sound/ui_back.wav");
        SoundURL[4] = getClass().getResource("/Sound/walk.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(SoundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void play(){
        clip.start();;
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }


}
