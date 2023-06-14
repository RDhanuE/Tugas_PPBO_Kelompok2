//package Games;
//
//import java.net.URL;
//
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//
//public class Sound {
//    Clip clip;
//    URL SoundURL[] = new URL[10];
//
//    public Sound(){
//        SoundURL[0] = getClass().getResource("Path");
//    }
//
//    public void setFile(int i){
//        try {
//            AudioInputStream ais = AudioSystem.getAudioInputStream(SoundURL[i]);
//            clip = AudioSystem.getClip();
//            clip.open(ais);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//    public void Play(){
//        clip.start();;
//    }
//
//    public void Loop(){
//        clip.loop(Clip.LOOP_CONTINUOUSLY);
//    }
//
//    public void stop(){
//        clip.stop();
//    }
//
//
//}
