
package controller;

import javax.swing.ImageIcon;
import vista.Options;

public class OptionsController {
    
    private static Options options = new Options();

    public OptionsController() {
    }
    
    public static void iniciarVentana(){
       
        options.getLbGif().setIcon(new ImageIcon("src/main/resources/imagenes/pcIcon.gif"));
        options.getLbMusic().setIcon(new ImageIcon("src/main/resources/imagenes/music.png"));
        options.getLbVoices().setIcon(new ImageIcon("src/main/resources/imagenes/voices.png"));
        options.getLbVolume().setIcon(new ImageIcon("src/main/resources/imagenes/volume.png"));
         options.setVisible(true);
        options.setLocationRelativeTo(null);
     
    }
    
    public static void cerrarVentana(){
        options.setVisible(false);
    }
    
    

}
