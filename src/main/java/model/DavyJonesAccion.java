package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import vista.Tablero;

public class DavyJonesAccion extends AccionJugador {

    int apuestaCantDadosPlayer;
    int apuestaNumDadosPlayer;
    int recuentoDado;
    int decision;

    public DavyJonesAccion() {
	super();
    }

    @Override
    public String desconfiar(Dado dadosPlayer, Dado dadosDavyJones, Tablero tablero) {
	this.apuestaCantDadosPlayer = Integer.parseInt(dadosPlayer.getApuestaCantDados());
	this.apuestaNumDadosPlayer = Integer.parseInt(dadosPlayer.getApuestaNumDados());
	int conteoFinal = super.conteoFinal(dadosPlayer, dadosDavyJones, apuestaNumDadosPlayer);
	String ganadorFinal = "";

	if (conteoFinal >= this.apuestaCantDadosPlayer) {
	    ganadorFinal = super.restarHp(tablero.getLbNombreJugador().getText(), tablero);

	    this.setRespuesta("\n Davy Jones desconfia" + "\n Resultado: \n cantidad apostada al "
		    + dadosPlayer.getApuestaNumDados() + " = " + dadosPlayer.getApuestaCantDados()
		    + "\n cantidad total en mesa = " + conteoFinal + "\n " + tablero.getLbNombreJugador().getText()
		    + " gana." + ganadorFinal);
	} else {
	    ganadorFinal = super.restarHp("Davy Jones", tablero);

	    this.setRespuesta("\n Davy Jones desconfia" + "\n Resultado: \n cantidad apostada al "
		    + dadosPlayer.getApuestaNumDados() + " = " + dadosPlayer.getApuestaCantDados()
		    + "\n cantidad total en mesa = " + conteoFinal + "\n " + "Davy Jones gana." + ganadorFinal);
	}
	int[] reset = null;
	dadosPlayer.setDados(reset);
	dadosDavyJones.setDados(reset);
	dadosPlayer.setApuestaCantDados(null);
	dadosPlayer.setApuestaNumDados(null);
	dadosDavyJones.setApuestaCantDados(null);
	dadosDavyJones.setApuestaNumDados(null);
	return this.getRespuesta();
    }

    @Override
    public String primerApuesta(Dado dadosPlayer, Dado dadosDavyJones, Tablero tablero) {
	var dados = new ArrayList<Integer>();
	int[] cantidad = new int[6];
	this.setApuestaCant(Integer.parseInt(dadosPlayer.getApuestaCantDados()));
	this.setApuestaNum(Integer.parseInt(dadosPlayer.getApuestaNumDados()));

	// asigna al vector "cantidad" apostada por el player
	for (int i = 0; i < cantidad.length; i++) {
	    cantidad[i] = this.getApuestaCant();
	}
	// Cuenta y guarda cuantos dados repetidos contiene la mano de Davy Jones
	for (Integer dado : dadosDavyJones.getDados()) {
	    switch (dado) {
	    case 1:
		cantidad[0] += 1;
		dados.add(dado);
		break;
	    case 2:
		cantidad[1] += 1;
		dados.add(dado);
		break;
	    case 3:
		cantidad[2] += 1;
		dados.add(dado);
		break;
	    case 4:
		cantidad[3] += 1;
		dados.add(dado);
		break;
	    case 5:
		cantidad[4] += 1;
		dados.add(dado);
		break;
	    default:
		cantidad[5] += 1;
		dados.add(dado);
		break;
	    }

	}
	// Guarda solo los valores repetidos
	var nuevaLista = new ArrayList<Integer>();
	for (int i = 0; i < dados.size(); i++) {
	    for (int j = 0; j < dados.size(); j++) {
		if (dados.get(i) == dados.get(j)) {
		    nuevaLista.add(dados.get(i));
		}
	    }
	}
	// ordena nuevLista de máyor a ménor
	Comparator<Integer> comparador = Collections.reverseOrder();
	Collections.sort(nuevaLista, comparador);
	int cantFinal = cantidad[(nuevaLista.get(0) - 1)];

	// Si la cantidad a apostar no supera el valor de 10, hace una apuesta
	if (cantFinal < 10 && nuevaLista.get(0) > this.getApuestaNum()) {
	    this.setRespuesta("\n Davy Jones apuesta " + cantFinal + " " + nuevaLista.get(0) + "s");
	    dadosDavyJones.setApuestaCantDados(String.valueOf(cantFinal));
	    dadosDavyJones.setApuestaNumDados(String.valueOf(nuevaLista.get(0)));
	}
	// Desconfiar
	else {
	    this.setRespuesta(desconfiar(dadosPlayer, dadosDavyJones, tablero));
	}
	return this.getRespuesta();
    }

    @Override
    public String segundaApuesta(Dado dadosPlayer, Dado dadosDavyJones, int recuento, Tablero tablero) {
	this.setApuestaCant(Integer.parseInt(dadosPlayer.getApuestaCantDados()));
	this.setApuestaNum(Integer.parseInt(dadosPlayer.getApuestaNumDados()));
	int cantidad = 0;

	if (this.getApuestaCant() <= 6) {
	    // Apuesta la cantidad de sus dados más los de la apuesta actual al mismo valor
	    cantidad = recuento + this.getApuestaCant();
	    dadosDavyJones.setApuestaCantDados(String.valueOf(cantidad));
	    dadosDavyJones.setApuestaNumDados(dadosPlayer.getApuestaNumDados());
	    this.setRespuesta("\n Davy Jones apuesta " + cantidad + " " + this.getApuestaNum() + "s");
	}else {
	    desconfiar(dadosPlayer, dadosDavyJones, tablero);
	}
	return this.getRespuesta();
    }

    @Override
    public String tercerApuesta(Dado dadosPlayer, Dado dadosDavyJones, int recuento, Tablero tablero) {
	this.setApuestaCant(Integer.parseInt(dadosPlayer.getApuestaCantDados()));
	int cont = recuento + this.getApuestaCant();
	
	if(recuento == 0) {
	    desconfiar(dadosPlayer, dadosDavyJones, tablero);
	}
	else if(recuento == 1 && this.getApuestaCant() <= 3) {
	    this.setRespuesta("\n Davy Jones apuesta " + cont + " " + 6 + "s");
	    dadosDavyJones.setApuestaCantDados(String.valueOf(cont));
	    dadosDavyJones.setApuestaNumDados("6");
	}
	else if(recuento >= 2 && this.getApuestaCant() <= 4 ) {
	    this.setRespuesta("\n Davy Jones apuesta " + (cont - 1) + " " + 6 + "s");
	    dadosDavyJones.setApuestaCantDados(String.valueOf((cont - 1)));
	    dadosDavyJones.setApuestaNumDados("6");
	}
	else if(this.getApuestaCant() >= 4) {
	    desconfiar(dadosPlayer, dadosDavyJones, tablero);
	}
	else {
	    desconfiar(dadosPlayer, dadosDavyJones, tablero); 
	}
	return this.getRespuesta();
    }

    public String mentir(Dado dadosPlayer, Dado dadosDavyJones, Tablero tablero) {
	this.setApuestaCant(Integer.parseInt(dadosPlayer.getApuestaCantDados()));
	this.setApuestaNum(Integer.parseInt(dadosPlayer.getApuestaNumDados()));
	int dado = this.getApuestaNum();
	int cantidad = this.getApuestaCant();

	// Apostar la misma cantidad a un valor máyor
	if (this.getApuestaCant() >= 6 && this.getApuestaCant() < 10 && this.getApuestaNum() <= 5) {
	    dado += 1;
	    this.setRespuesta("\n Davy Jones apuesta " + this.getApuestaCant() + " " + dado + "s");
	    dadosDavyJones.setApuestaCantDados(dadosPlayer.getApuestaCantDados());
	    dadosDavyJones.setApuestaNumDados(String.valueOf(dado));
	}
	// Apostar máyor cantidad al mismo valor
	else if (this.getApuestaCant() <= 5) {
	    cantidad += 1;
	    this.setRespuesta("\n Davy Jones apuesta " + cantidad + " " + dado + "s");
	    dadosDavyJones.setApuestaCantDados(String.valueOf(cantidad));
	    dadosDavyJones.setApuestaNumDados(dadosPlayer.getApuestaNumDados());
	}
	// Desconfiar
	else if (this.getApuestaCant() == 10 || this.getApuestaNum() == 6) {
	    this.setRespuesta(desconfiar(dadosPlayer, dadosDavyJones, tablero));
	}
	return this.getRespuesta();
    }

    @Override
    public void apostar(Dado dadosJugador, Dado dadosDavyJones, int conteoFinal, Tablero tablero) {
    };
}
