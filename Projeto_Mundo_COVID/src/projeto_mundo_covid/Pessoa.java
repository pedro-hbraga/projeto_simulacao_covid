/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_mundo_covid;

//import java.util.Random;

/**
 * Classe Abstrata Pessoa
 * @author braga
 */

public abstract class Pessoa{

    // ATRIBUTOS DA CLASSE Pessoa
    
    private int x, y, posAux, tempo = 0;
    private boolean vacinada, virus;
      


    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }  

    
    public int getPosAux() {
        return posAux;
    }

    /**
     * ESTE MÉTODO ARMAZENA O VALOR DA POSIÇÃO FUTURA, COM OBJETIVO DE REESCREVER A MATRIZ
     * CORRETAMENTE
     * @param posAux 
     */
    public void setPosAux(int posAux) {
        this.posAux = posAux;
    }

    public boolean isVacinada() {
        return vacinada;
    }

    public void setVacinada(boolean vacinada) {
        this.vacinada = vacinada;
    }

   

    public boolean isVirus() {
        return virus;
    }

    public void setVirus(boolean virus) {
        this.virus = virus;
    }

    public int getTempo() {
        return tempo;
    }

    /**
     * CONTAGEM DO TEMPO DA SIMULAÇÃO
     * @param tempo 
     */
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    
    /**
     *  Méotod mover UTILIZADO PARA REALIZAR O MOVIMENTO DOS INDIVIDUOS NO MUNDO
     */
    public void mover(){
        
    }  

   
    
    
    
}
