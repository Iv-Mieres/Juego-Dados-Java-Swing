package controller;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Dado;
import model.DavyJonesAccion;
import model.PlayerAccion;
import model.Audio;
import vista.*;

public class TableroController {

    private static Dado player = new Dado();
    private static Dado davyJones = new Dado();
    private static Tablero tablero = new Tablero();
    private static String urlImg = "/imagenes/";
    private static String urlMusic = "/music/";
    private static PlayerAccion playerAccion = new PlayerAccion();
    private static DavyJonesAccion davyJonesAccion = new DavyJonesAccion();
    private static String titulo;
    private static String descripcion;
    private static String respuestaDavyJones = "";

    public TableroController() {
    }

    public static Dado getPlayer() {
	return player;
    }

    public static void setPlayer(Dado player) {
	TableroController.player = player;
    }

    public static Dado getDavyJones() {
	return davyJones;
    }

    public static void setDavyJones(Dado davyJones) {
	TableroController.davyJones = davyJones;
    }

    public static Tablero getTablero() {
	return tablero;
    }

    public static void setTablero(Tablero tablero) {
	TableroController.tablero = tablero;
    }

    // -------MÉTODO PARA INICIAR LA VENTANA DEL JFRAME JUEGO-------
    public static void iniciarVentana() {

	iniciarAudioDeVentanaYVoz();
	String nick = TableroController.crearNick();// pide al jugador ingresar su nick
	seleccionarAvatar();// pide al jugador elegir un avatar

	// Convierte la primer letra del nick elegido en mayúscula y las
	// siguientesletras en minúsculas
	char letraInicial = nick.charAt(0);
	nick = String.valueOf(letraInicial).toUpperCase() + nick.substring(1, nick.length()).toLowerCase();

	// Settea Labels del jFrame Juego

	tablero.getLbNombreJugador().setText(nick);
	tablero.getLbDavyJonesIcon()
		.setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "davyJones.png")));
	tablero.getLbTablero().setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "tableroJuego.png")));
	tablero.getLbOptions().setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "options.png")));
	tablero.getLbRules().setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "rules.png")));
	tablero.getLbSalir().setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "salir.png")));

	// Visibiliza ventana
	tablero.setVisible(true);
	tablero.setLocationRelativeTo(null);
    }

    // ------MÉTODO CERRAR VENTANA -----------
    public static void cerrarVentana() {
	Audio.stopAudio();
	tablero.setVisible(false);
    }

    // -------MÉTODO MOSTRAR JOPTIONPANE-------
    // Crea y settea un JOptionPane
    private static String mostrarJOptionPane(String titulo, String descripcion, int mjType, String resultado) {
	Icon icon = new ImageIcon(TableroController.class.getResource(urlImg + "davyJonesIcon2.png"));
	String respuesta = "";
	if (resultado.equals("")) {
	    JOptionPane.showMessageDialog(tablero, descripcion, titulo, mjType, icon);
	} else {
	    var objeto = JOptionPane.showInputDialog(tablero, titulo, descripcion, mjType, icon, null, "");
	    if (Objects.isNull(objeto))
		respuesta = "";
	    else
		respuesta = String.valueOf(objeto).replaceAll("\\s", "");
	}
	return respuesta;
    }

    // ------MÉTODO SELECCIÓN DE NICK -------
    private static String crearNick() {
	String nick = "";
	titulo = "Para continuar ingresa tu nick";
	descripcion = "Debe contener un min de 3 caracteres y un máx de 7";
	int mjType = JOptionPane.DEFAULT_OPTION;

	// Ingresar Nick
	while (nick.isBlank() || nick.isEmpty() || nick.length() >= 8 || nick.length() <= 2) {
	    nick = mostrarJOptionPane(titulo, descripcion, mjType, "nick");
	}
	return nick;
    }

    // ------ MÉTODO SELECCIÓN DE AVATAR-------
    private static void seleccionarAvatar() {
	String avatar = "";
	titulo = "Selecciona tu avatar.";
	descripcion = "1-Jack | 2-Calipso | 3-Elizabeth | 4-Barbosa.";
	int mjType = JOptionPane.DEFAULT_OPTION;

	// Elegir Avatar
	while (avatar == null || avatar.isBlank() || avatar.isEmpty() || avatar.matches("[1-4]") == false) {
	    avatar = mostrarJOptionPane(titulo, descripcion, mjType, "avatar");
	}
	// Settea el label con el avatar seleccionado
	switch (avatar) {
	case "1" -> tablero.getLbImagenJugador()
		.setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "jack2.png")));
	case "2" -> tablero.getLbImagenJugador()
		.setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "calypso.png")));
	case "3" -> tablero.getLbImagenJugador()
		.setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "elizabeth.png")));
	default -> tablero.getLbImagenJugador()
		.setIcon(new ImageIcon(TableroController.class.getResource(urlImg + "barbosa.png")));
	}
    }

    // ------ MÉTODO INICAR AUDIO AL TIRAR DADOS ------------
    public static void iniciarAudioDados() {
	try {
	    Audio.seleccionarVozYFX(TableroController.class.getResource(urlMusic + "agitar-dados.wav"));
	    Audio.startAudio();
	    try {
		Thread.sleep(1800);
	    } catch (InterruptedException ex) {
		Logger.getLogger(TableroController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	} catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
	    Logger.getLogger(TableroController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    // -------MÉTODO INICIAR AUDIO DE VENTANA-----------
    private static void iniciarAudioDeVentanaYVoz() {
	try {
	    Audio.seleccionarVozYFX(TableroController.class.getResource(urlMusic + "te-gustaria-servirme.wav"));
	    Audio.startAudio();
	    Audio.seleccionarMusica(TableroController.class.getResource(urlMusic + "tablero.wav"));
	    Audio.startAudio();
	} catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
	    Logger.getLogger(TableroController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    // ------ MÉTODO BUSCAR URL DE ARCHIVO -------
    // Llama a la url de la imagen con el numero y el color correspondiente
    private static String urlArchivo(String color, int numDado) {
	String devolverUrl;
	String urlDadoRojo = "/dadoRojo";
	String urlDadoVerde = "/dadoVerde";

	// Selecciona la ruta del numero de dado correspondiente
	if (color.equalsIgnoreCase("rojo")) {
	    switch (numDado) {
	    case 1 -> devolverUrl = urlDadoRojo + "1/";
	    case 2 -> devolverUrl = urlDadoRojo + "2/";
	    case 3 -> devolverUrl = urlDadoRojo + "3/";
	    case 4 -> devolverUrl = urlDadoRojo + "4/";
	    default -> devolverUrl = urlDadoRojo + "5/";
	    }
	} else {
	    switch (numDado) {
	    case 1 -> devolverUrl = urlDadoVerde + "1/";
	    case 2 -> devolverUrl = urlDadoVerde + "2/";
	    case 3 -> devolverUrl = urlDadoVerde + "3/";
	    case 4 -> devolverUrl = urlDadoVerde + "4/";
	    default -> devolverUrl = urlDadoVerde + "5/";
	    }
	}
	return devolverUrl;
    }

    // ------ MÉTODO RETURN IMAGEICON ----------
    // Retorna el ImageIcon para settear el label con la imagen correspondiente
    private static Icon asignarImagen(int valorDado, String color, int numDado) {
	String ruta = urlArchivo(color, numDado);

	return switch (valorDado) {// Asigna la imagen correspondiente al valorDado
	case 1 -> new ImageIcon(TableroController.class.getResource(ruta + "1.png"));
	case 2 -> new ImageIcon(TableroController.class.getResource(ruta + "2.png"));
	case 3 -> new ImageIcon(TableroController.class.getResource(ruta + "3.png"));
	case 4 -> new ImageIcon(TableroController.class.getResource(ruta + "4.png"));
	case 5 -> new ImageIcon(TableroController.class.getResource(ruta + "5.png"));
	default -> new ImageIcon(TableroController.class.getResource(ruta + "6.png"));
	};
    }

    // ------ MÉTODO SET LABELS DE DADOS -------
    // Settea los Icons de cada label
    public static void setLabelsDados(Dado playerOJones, String color) {

	playerOJones.btnTirarDados();
	int cont = 1;
	for (int numDado : playerOJones.getDados()) {
	    if (color.equalsIgnoreCase("rojo")) {
		switch (cont) {// settea los iconos de los dados rojos
		case 1 -> tablero.getLbDadoRojo1().setIcon(asignarImagen(numDado, color, cont));
		case 2 -> tablero.getLbDadoRojo2().setIcon(asignarImagen(numDado, color, cont));
		case 3 -> tablero.getLbDadoRojo3().setIcon(asignarImagen(numDado, color, cont));
		case 4 -> tablero.getLbDadoRojo4().setIcon(asignarImagen(numDado, color, cont));
		default -> tablero.getLbDadoRojo5().setIcon(asignarImagen(numDado, color, cont));
		}
	    } else {
		switch (cont) {// settea los iconos de los dados verdes
		case 1 -> tablero.getLbDadoVerde1().setIcon(asignarImagen(numDado, color, cont));
		case 2 -> tablero.getLbDadoVerde2().setIcon(asignarImagen(numDado, color, cont));
		case 3 -> tablero.getLbDadoVerde3().setIcon(asignarImagen(numDado, color, cont));
		case 4 -> tablero.getLbDadoVerde4().setIcon(asignarImagen(numDado, color, cont));
		default -> tablero.getLbDadoVerde5().setIcon(asignarImagen(numDado, color, cont));
		}
	    }
	    cont++;
	}
	cont = 1;
    }

    public static void btnDesconfiar() {
	
	if(davyJones.getApuestaCantDados() == null) {
	    Icon icon = new ImageIcon(TableroController.class.getResource("/imagenes/DavyJonesIcon2.png"));
	    JOptionPane.showMessageDialog(tablero, "No se puede desconfiar.",
		    "Debes tirar los dados ó realizar una apuesta.", JOptionPane.NO_OPTION, icon); 
	}
	String respuesta = playerAccion.desconfiar(player, davyJones, tablero);
	respuestaDavyJones = respuesta;
	retornarApuesta();
	
	int[] reset = null;
	player.setDados(reset);
	davyJones.setDados(reset);
	player.setApuestaCantDados(null);
	player.setApuestaNumDados(null);
	davyJones.setApuestaCantDados(null);
	davyJones.setApuestaNumDados(null);
    }

    // ------ MÉTODO APUESTA DE PLAYER-----------
    public static void btnApostar() {
	playerAccion.apostar(player, davyJones, 0, tablero);
	mostrarApuestasEnTxtArea();
	apuestaDavyJones();
	retornarApuesta();
    }

    // --------- MÉTODO SETTEAR txtArea CON LAS APUESTAS REALIZADAS------
    private static void mostrarApuestasEnTxtArea() {
	// Settea el txtArea con las apuestas
	tablero.getTxtArea().setText(tablero.getTxtArea().getText().concat(
		"\n" + " Tu apuesta es " + player.getApuestaCantDados() + " " + player.getApuestaNumDados() + "s"));
    }

    // ---------- MÉTODOS DE DAVY JONES ------------------

    // --------MÉTODO DESICIÓN DE APUESTA POR DAVY JONES----------
    public static void apuestaDavyJones() {
	int intCantApuesta = 0;
	int intNumDadoApuesta = 0;
	int recuentoDado = 0;
	int decision = 0;
	intCantApuesta = Integer.parseInt(player.getApuestaCantDados());
	intNumDadoApuesta = Integer.parseInt(player.getApuestaNumDados());

	// Si decisión = 1 "Apostar" | Decisión = 2 "Desconfiar" | Decisión = 3 "Mentir"
	while (decision == 0 || decision >= 3) {
	    decision = (int) (Math.random() * 10);
	}
	// Contar coincidencias entre los dados de Jones y la apuesta del Player
	for (int dadoVerde : davyJones.getDados()) {
	    if (dadoVerde == intNumDadoApuesta)
		recuentoDado += 1;
	}

	// Desconfiar si la cantidad apostada es igual a 10
	if (intCantApuesta == 10) {
	    respuestaDavyJones = davyJonesAccion.desconfiar(player, davyJones, tablero);
	}
	// ---PRIMERA RESPUESTA SI NO SE TIENE UN DADO DEL MISMO VALOR APOSTADO---
	else if (recuentoDado == 0) {
	    respuestaDavyJones = davyJonesAccion.primerApuesta(player, davyJones, tablero);   
	}
	// ----SEGUNDA RESPUESTA SI TIENE UN DADO Ó MÁS IGUALES AL APOSTADO---
	else if (recuentoDado <= 3 &&  recuentoDado > 0 && intNumDadoApuesta < 6) {
	    respuestaDavyJones = davyJonesAccion.segundaApuesta(player, davyJones, recuentoDado, tablero);
	}
	// -----TERCER RESPUESTA SI EL VALOR APOSTADO ES 6
	else if (recuentoDado < 10 && intNumDadoApuesta == 6) {
	    respuestaDavyJones = davyJonesAccion.tercerApuesta(player, davyJones, recuentoDado, tablero);
	}
	// ----TERCER REPUESTA SI LA CANTIDAD APOSTADA ES MÁYOR A 7 Y MÉNOR A 10
	else if (intCantApuesta >= 7 && intCantApuesta < 10) {
	    switch (decision) {
	    case 1: // Desconfiar
		respuestaDavyJones = davyJonesAccion.desconfiar(player, davyJones, tablero);
	    case 2: // Mentir
		respuestaDavyJones = davyJonesAccion.mentir(player, davyJones, tablero);
	    default: // Desconfiar
		respuestaDavyJones = davyJonesAccion.desconfiar(player, davyJones, tablero);
	    }
	}
	// -----CUARTA RESPUESTA SI RECUENTO ES IGUAL A 4 Ó 5-------
	else if (recuentoDado == 4 || recuentoDado == 5) {
	    switch (decision) {
	    case 1: // Apostar
		respuestaDavyJones = davyJonesAccion.primerApuesta(player, davyJones, tablero);
		break;
	    case 2: // Desconfiar
		respuestaDavyJones = davyJonesAccion.desconfiar(player, davyJones, tablero);
		break;
	    default: // Mentir
		respuestaDavyJones = davyJonesAccion.mentir(player, davyJones, tablero);
		break;
	    }
	}
    }

    private static void retornarApuesta() {
	tablero.getTxtArea().setText(tablero.getTxtArea().getText().concat(respuestaDavyJones));
    }

}
