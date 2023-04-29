package model;

import java.util.Objects;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.TableroController;
import vista.Tablero;

public class PlayerAccion extends AccionJugador {

    private String cantTitulo;
    private String cantDescripcion;
    private String numTitulo;
    private String numDescripcion;

    public PlayerAccion() {
	super();

    }

    @Override
    public void apostar(Dado dadosPlayer, Dado dadosDavyJones, int conteoFinal, Tablero tablero) {
	String apuestaCantDavyJones = dadosDavyJones.getApuestaCantDados();
	String apuestaNumDavyJones = dadosDavyJones.getApuestaNumDados();
	// Realizar primer apuesta
	if (apuestaCantDavyJones == null || apuestaCantDavyJones.isEmpty() || apuestaCantDavyJones.isBlank()) {
	    this.cantTitulo = "Puedes ingresar un máximo de 10";
	    this.cantDescripcion = "Elige la cantidad de dados del 1 al 10";
	    this.numTitulo = "Ingresa un numero del 1 al 6";
	    this.numDescripcion = "Elige el numero de dado";
	    primerApuesta(dadosPlayer, dadosDavyJones, tablero);
	}
	// Entra si el player y Davy Jones realizaron una apuesta
	else if (!apuestaCantDavyJones.equals("10") && !apuestaNumDavyJones.equals("6")) {
	    this.cantTitulo = "Elige la cantidad de dados del 1 al 10";
	    this.cantDescripcion = "La cantidad debe ser igual o máyor a " + apuestaCantDavyJones;
	    segundaApuesta(dadosPlayer, dadosDavyJones, 0, tablero);
	}
	// Si la cantidad apostada por Davy Jones es ménor a 10, pero el valor es igual
	// a 6 apuesa solo cantidad
	else if (!apuestaCantDavyJones.equals("10") && apuestaNumDavyJones.equals("6")) {
	    this.cantTitulo = "la cantidad debe ser máyor a " + apuestaCantDavyJones;
	    this.cantDescripcion = "Valor = 6. Solo puedes apostar la cantidad de 6s";
	    tercerApuesta(dadosPlayer, dadosDavyJones, 0, tablero);
	}
	// Si la cantidad apostada por de Davy Jones es igual a 10 no se puede realizar
	// una apuesta
	else if (apuestaCantDavyJones.equals("10")) {
	    this.cantTitulo = "No puedes realizar una apuesta.";
	    this.cantDescripcion = "La cantidad a apostar alzanzó su máximo. Debes Desconfiar para finalizar la mano.";
	    this.mostrarJOptionPane(this.cantTitulo, this.cantDescripcion, JOptionPane.OK_OPTION);
	}
    }

    @Override
    public String desconfiar(Dado dadosPlayer, Dado dadosDavyJones, Tablero tablero) {
	this.setApuestaCant(Integer.parseInt(dadosDavyJones.getApuestaCantDados()));
	this.setApuestaNum(Integer.parseInt(dadosDavyJones.getApuestaNumDados()));
	int conteoFinal = super.conteoFinal(dadosPlayer, dadosDavyJones, this.getApuestaNum());
	String ganadorFinal = "";

	if (conteoFinal >= this.getApuestaCant()) {
	    ganadorFinal = super.restarHp("Davy Jones", tablero);
	    this.setRespuesta(
		    "\n Resultado: \n cantidad apostada al " + this.getApuestaNum() + " = " + this.getApuestaCant()
			    + "\n cantidad total en mesa = " + conteoFinal + "\n " + "Davy Jones gana." + ganadorFinal);
	} else {
	    ganadorFinal = super.restarHp(tablero.getLbNombreJugador().getText(), tablero);
	    this.setRespuesta("\n Resultado: \n cantidad apostada al " + this.getApuestaNum() + " = "
		    + this.getApuestaCant() + "\n cantidad total en mesa = " + conteoFinal + "\n "
		    + tablero.getLbNombreJugador().getText() + " gana." + ganadorFinal);
	}
	return this.getRespuesta();
    }

    @Override
    public String primerApuesta(Dado dadosPlayer, Dado dadosDavyJones, Tablero tablero) {
	dadosPlayer.setApuestaCantDados("");
	dadosPlayer.setApuestaNumDados("");
	this.elegirCantDados(dadosPlayer);
	this.elegirNumDado(dadosPlayer);
	return "";
    }

    @Override
    public String segundaApuesta(Dado dadosPlayer, Dado dadosDavyJones, int recuento, Tablero tablero) {
	dadosPlayer.setApuestaCantDados("0");
	this.setApuestaCant(Integer.parseInt(dadosDavyJones.getApuestaCantDados()));
	this.setApuestaNum(Integer.parseInt(dadosDavyJones.getApuestaNumDados()));

	// Pide ingresar una cantidad de dados igual ó máyor a la apuesta de davy Jones
	this.elegirCantDados(dadosPlayer);

	if (dadosPlayer.getApuestaCantDados().equals(dadosDavyJones.getApuestaCantDados())) {
	    this.numTitulo = "Elige un valor máyor";
	    this.numDescripcion = "El numero de dado debe ser máyor a " + this.getApuestaNum();
	    this.elegirNumDado(dadosPlayer);
	} else {
	    this.numTitulo = "Elige un valor igual o máyor";
	    this.numDescripcion = "El numero de dado debe ser igual ó máyor a " + this.getApuestaNum();
	    this.elegirNumDado(dadosPlayer);
	}
	return "";
    }

    @Override
    public String tercerApuesta(Dado dadosPlayer, Dado dadosDavyJones, int recuento, Tablero tablero) {
	dadosPlayer.setApuestaCantDados("0");
	this.setApuestaCant(Integer.parseInt(dadosDavyJones.getApuestaCantDados()));
	this.elegirCantDados(dadosPlayer);
	dadosPlayer.setApuestaNumDados("6");
	return "";
    }

    private void elegirNumDado(Dado dadosPlayer) {
	boolean centinela = false;
	int comparar = 0;
	String respuesta = "";

	// Pide ingresar el numero de dado a apostar
	while (dadosPlayer.getApuestaNumDados() == null || dadosPlayer.getApuestaNumDados().isBlank()
		|| dadosPlayer.getApuestaNumDados().isEmpty() || centinela == false) {
	    respuesta = this.mostrarJOptionPane(this.numTitulo, this.numDescripcion, JOptionPane.DEFAULT_OPTION);

	    if (respuesta.matches("[1-6]") == true) {
		dadosPlayer.setApuestaNumDados(respuesta);
		comparar = Integer.parseInt(respuesta);
	    }
	    if (this.numDescripcion.contains("Elige el numero de dado")) {
		centinela = true;
	    } else if (this.numDescripcion.contains("El numero de dado debe ser máyor")
		    && comparar > this.getApuestaNum()) {
		centinela = true;
	    } else if (this.numDescripcion.contains("El numero de dado debe ser igual ó máyor")
		    && comparar >= this.getApuestaNum()) {
		centinela = true;
	    }
	}
    }

    private void elegirCantDados(Dado dadosPlayer) {
	boolean centinela = false;
	int comparar = 0;
	String respuesta = "";

	// Pide ingresar la cantidad de dados a apostar
	while (dadosPlayer.getApuestaCantDados() == null || dadosPlayer.getApuestaCantDados().isBlank()
		|| dadosPlayer.getApuestaCantDados().isEmpty() || centinela == false) {

	    respuesta = this.mostrarJOptionPane(this.cantTitulo, this.cantDescripcion, JOptionPane.DEFAULT_OPTION);
	    if (respuesta.matches("[1-9]") == true || respuesta.equals("10")) {
		dadosPlayer.setApuestaCantDados(respuesta);
		comparar = Integer.parseInt(respuesta);
	    }
	    if (this.cantDescripcion.contains("Elige la cantidad de dados del 1 al 10")) {
		centinela = true;
	    } else if (this.cantDescripcion.contains("La cantidad debe ser igual o máyor a ")
		    && comparar >= this.getApuestaCant()) {
		centinela = true;
	    } else if (this.cantDescripcion.contains("Valor = 6.") && comparar > this.getApuestaCant()) {
		centinela = true;
	    }
	}
    }

    private String mostrarJOptionPane(String titulo, String descripcion, int optionType) {
	Icon icon = new ImageIcon(TableroController.class.getResource("/imagenes/davyJonesIcon2.png"));
	String respuesta = "";
	if (optionType == 0) {
	    JOptionPane.showMessageDialog(null, descripcion, titulo, optionType, icon);
	} else {
	    var objeto = JOptionPane.showInputDialog(null, titulo, descripcion, optionType, icon, null, "");
	    if (Objects.isNull(objeto))
		respuesta = "";
	    else
		respuesta = String.valueOf(objeto).replaceAll("\\s", "");
	}
	return respuesta;
    }

}
