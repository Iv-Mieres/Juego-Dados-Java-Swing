package org.example;

import controller.InicioController;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

    public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        InicioController.iniciarVentana();

    }
}
