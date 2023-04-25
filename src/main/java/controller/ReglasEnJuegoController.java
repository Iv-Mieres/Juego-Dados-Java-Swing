
package controller;

import vista.ReglasEnJuego;


public class ReglasEnJuegoController {
    
    private static ReglasEnJuego reglas = new ReglasEnJuego();
    
    
    public static void iniciarVentana(){
        reglas.setVisible(true);
        reglas.setLocationRelativeTo(null);
    }
    
    public static void cerrarVentana(){
        reglas.setVisible(false);
    }

}
