package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import model.Audio;
import vista.Inicio;

public class InicioController {

    private static Inicio inicio = new Inicio();

    public InicioController() {
    }

    public static void iniciarVentana() {
        try {
            //Inicia el audio de la ventana
            Audio.seleccionarMusica(InicioController.class.getResource("/music/inicio.wav"));
//            Audio.startAudio();
            //Settea los labels
		 inicio.getLbGif().setIcon(new ImageIcon(InicioController.class.getResource("/imagenes/pcIcon.gif")));
            inicio.getLbPlay().setIcon(new ImageIcon(InicioController.class.getResource("/imagenes/play.png")));
            inicio.getLbRules().setIcon(new ImageIcon(InicioController.class.getResource("/imagenes/rules.png")));
            inicio.getLbTitulo().setIcon(new ImageIcon(InicioController.class.getResource("/imagenes/titulo.png")));
            //Inicia la ventana
            inicio.setVisible(true);
            inicio.setLocationRelativeTo(null);
           
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cerrarVentana() {
        Audio.stopAudio();
        inicio.setVisible(false);

    }
}
