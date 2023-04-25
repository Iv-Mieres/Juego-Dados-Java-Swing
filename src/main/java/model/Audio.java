package model;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
 
    private static Clip clip;
    private static float volumeMusic;
    private static float volumeVoices;
    private static float volumeFX;
    private static FloatControl music;
    private static FloatControl voices;
     private static FloatControl fx;
    
    public Audio() throws LineUnavailableException {
        Audio.clip = AudioSystem.getClip();
    }
    
    public static void seleccionarMusica(URL url) throws LineUnavailableException, UnsupportedAudioFileException, IOException {   
        AudioInputStream audio = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audio);
        music = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeMusic = -5.0f;
        music.setValue(volumeMusic);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
      public static void seleccionarVozYFX(URL url) throws LineUnavailableException, UnsupportedAudioFileException, IOException {   
        AudioInputStream audio = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audio);
        voices = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeVoices = 3.0f;
        voices.setValue(volumeVoices);
       
    }
      
      public static void volumenUpMusic(){
          volumeMusic += 2.0f;        
          if(volumeMusic > 6.0f){
              volumeMusic = 6.0f;
          }
          music.setValue(volumeMusic);
      }
      
       public static void volumenDownMusic(){
          volumeMusic -= 2.0f;
          if(volumeMusic < -80.0f){
              volumeMusic= -80.0f;
          }
          music.setValue(volumeMusic);
      }
       
        public static void volumenUpVoices(){
          volumeVoices += 2.0f;
          if(volumeVoices > 6.0f){
              volumeVoices = 6.0f;
          }
          voices.setValue(volumeVoices);
      }
      
       public static void volumenDownVoices(){
          volumeVoices -= 2.0f;
          if(volumeVoices < -80.0f){
              volumeVoices= -80.0f;
          }
          voices.setValue(volumeVoices);
      }
       
        public static void volumenUpFX(){
          volumeFX += 2.0f;         
          if(volumeFX > 6.0f){
              volumeFX = 6.0f;
          }
          fx.setValue(volumeFX);
      }
      
       public static void volumenDownFX(){
          volumeFX -= 2.0f;        
          if(volumeFX < -80.0f){
              volumeFX= -80.0f;
          }
          fx.setValue(volumeFX);
      }
    
    public static void startAudio(){
        Audio.clip.start();
    }
    
    public static void stopAudio() {
       Audio.clip.stop();
    }

}
