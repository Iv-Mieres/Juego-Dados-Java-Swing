package model;

import vista.Tablero;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class Dado{

    private int[] dados;
    
    private String apuestaNumDados;
    private String apuestaCantDados;

    public Dado() {
    }
 
    public Dado(int[] dados, String apuestaNumDados, String apuestaCantDados) {
	this.dados = dados;
	this.apuestaNumDados = apuestaNumDados;
	this.apuestaCantDados = apuestaCantDados;
    }

    public int[] getDados() {
        return dados;
    }

    public void setDados(int[] dados) {
        this.dados = dados;
    }

    public String getApuestaNumDados() {
        return apuestaNumDados;
    }

    public void setApuestaNumDados(String apuestaNumDados) {
        this.apuestaNumDados = apuestaNumDados;
    }

    public String getApuestaCantDados() {
        return apuestaCantDados;
    }

    public void setApuestaCantDados(String apuestaCantDados) {
        this.apuestaCantDados = apuestaCantDados;
    }

    //Boton Tirar Dados

    public void btnTirarDados() {
        this.dados = new int[5];
        //recorre el vector y asigna valor a cada uno de los dados
        for (int i = 0; i < dados.length; i++) {
            while (dados[i] >= 7 || dados[i] <= 0) {
                dados[i] = (int) (Math.random() * 10);
            }
        }
    }


}
