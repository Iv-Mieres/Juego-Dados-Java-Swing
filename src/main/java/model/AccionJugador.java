package model;

import vista.Tablero;

public abstract class AccionJugador {

    private int cantRojos;
    private int cantVerdes;
    private int cantTotal;
    private int numApuestaTotal;
    private int apuestaNum;
    private int apuestaCant;
    private String respuesta;

    public AccionJugador() {

    }

    public int getCantRojos() {
	return cantRojos;
    }

    public void setCantRojos(int cantRojos) {
	this.cantRojos = cantRojos;
    }

    public int getCantVerdes() {
	return cantVerdes;
    }

    public void setCantVerdes(int cantVerdes) {
	this.cantVerdes = cantVerdes;
    }

    public int getCantTotal() {
	return cantTotal;
    }

    public void setCantTotal(int cantTotal) {
	this.cantTotal = cantTotal;
    }

    public int getNumApuestaTotal() {
	return numApuestaTotal;
    }

    public void setNumApuestaTotal(int numApuestaTotal) {
	this.numApuestaTotal = numApuestaTotal;
    }

    public String getRespuesta() {
	return respuesta;
    }

    public void setRespuesta(String respuesta) {
	this.respuesta = respuesta;
    }
 
    public int getApuestaNum() {
        return apuestaNum;
    }

    public void setApuestaNum(int apuestaNum) {
        this.apuestaNum = apuestaNum;
    }

    public int getApuestaCant() {
        return apuestaCant;
    }

    public void setApuestaCant(int apuestaCant) {
        this.apuestaCant = apuestaCant;
    }

    public void apostar(Dado dadosJugador, Dado dadosDavyJones, int conteoFinal, Tablero tablero) {
    };

    public String primerApuesta(Dado dadosPlayer, Dado davyJones, Tablero tablero) {
	return "";
    };

    public String segundaApuesta(Dado dadosPlayer, Dado dadosDavyJones, int recuento, Tablero tablero) {
	return "";
    };

    public String tercerApuesta(Dado dadosPlayer, Dado dadosDavyJones, int recuento, Tablero tablero) {
	return "";
    };

    public String desconfiar(Dado dadosPlayer, Dado dadosDavyJones, Tablero tablero) {
	return "";
    };

    public int conteoFinal(Dado dadosPlayer, Dado dadosDavyJones, int ultimoNumApostado) {
	this.cantRojos = 0;
	this.cantVerdes = 0;
	this.cantTotal = 0;
	this.numApuestaTotal = ultimoNumApostado;
	// Contar cuantos dados de la mano del player coinciden con la apuesta
	for (int dadoRojo : dadosPlayer.getDados()) {
	    if (dadoRojo == numApuestaTotal)
		cantRojos += 1;
	}
	// Contar cuantos dados de la mano de Davy Jones coinciden con la apuesta
	for (int dadoVerde : dadosDavyJones.getDados()) {
	    if (dadoVerde == numApuestaTotal)
		cantVerdes += 1;
	}
	this.cantTotal = cantRojos + cantVerdes;
	return cantTotal;
    }
    
    public String restarHp(String ganador, Tablero tablero) {
	int width = 0;
	String respuesta = "";
	if (ganador.equals("Davy Jones")) {
	    width = tablero.getTxtPlayerHP().getWidth() - 65;
	    tablero.getTxtPlayerHP().setSize(width, 40);
	} else if (ganador.equals(tablero.getLbNombreJugador().getText())) {
	    ganador = tablero.getLbNombreJugador().getText();
	    width = tablero.getTxtDavidJoneSHP().getWidth() - 65;
	    tablero.getTxtDavidJoneSHP().setSize(width, 40);
	}
	if (width <= 0) {
	    tablero.getTxtPlayerHP().setSize(310, 40);
	    tablero.getTxtDavidJoneSHP().setSize(310, 40);
	    respuesta = " El ganador del juego ha sido " + ganador;
	}
	tablero.getLbDadoVerdeTapar().setSize(0, 0);
	return respuesta;
    }
    
}
