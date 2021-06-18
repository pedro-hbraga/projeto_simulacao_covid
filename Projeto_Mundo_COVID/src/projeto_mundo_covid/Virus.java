/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_mundo_covid;

/**
 * Classe Virus - informa o status de saúde de um individuo
 * @author braga
 */
public class Virus {
    
    
    private boolean contaminada;

    public Virus(boolean contaminada){
        this.contaminada = contaminada;
    }
    
    public boolean isContaminada() {
        return contaminada;
    }

    public void setContaminada(boolean contaminada) {
        this.contaminada = contaminada;
    }
    
    
}
