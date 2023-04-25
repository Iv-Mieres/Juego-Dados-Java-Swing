package controller;



import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import model.Audio;
import vista.Regla;

public class ReglasController{

    private static Regla regla = new Regla();
   
    public ReglasController(){
    }

    public static void iniciarVentana() {
        
        try {
            Audio.seleccionarMusica(ReglasController.class.getResource("/music/reglas.wav"));
            Audio.startAudio();
            regla.getLbIconDavyJones().setIcon(new ImageIcon(ReglasController.class.getResource("/imagenes/davyJonesIcon.png")));
            regla.getLbImgFondo().setIcon(new ImageIcon(ReglasController.class.getResource("/imagenes/tableroJuego.png")));
            regla.getLbVolver().setIcon(new ImageIcon(ReglasController.class.getResource("/imagenes/volver.png")));
            regla.setVisible(true);
            regla.setLocationRelativeTo(null);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(ReglasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cerrarVentana() {
         Audio.stopAudio();
        regla.setVisible(false);
    }

}
