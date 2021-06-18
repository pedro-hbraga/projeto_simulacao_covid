/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_mundo_covid;

import java.util.Random;

/**
 * Classe PessoaDoente implementa o método mover da interface IMovable e herda
 * da classe abstrata Pessoa.
 * @author braga
 */
public class PessoaDoente extends Pessoa implements IMovable{

    // ATRIBUTOS DA CLASSE PessoaDoente
    private Random random = new Random();
    private int randX, randY;
    
    
    // CONSTRUTOR DA CLASSE PessoaDoente
    public PessoaDoente(int y, int x, int pos_aux) {
        setX(x);
        setY(y);
        setPosAux(pos_aux);
        setVacinada(false);
        setVirus(true);
        
    }    
    
    // METODO IMPLEMENTADO DE IMovable PARA REALIZAR O MOVIMENTO DAS PESSOAS NO MAPA
    @Override
    public void mover() {
        // ATRIBUTOS DO METODO COM OS MOVIMENTOS POSSIVEIS
        int valoresX[] = new int[] {-1, 0, 1};
        int valoresY[] = new int[] {-1, 1};
         
        // GERA UM VALOR ALEATORIO PARA X
        randX = random.nextInt(3);
        

       // CONDIÇÕES DE MOVIMENTO
       
       // MOVIMENTOS DO EIXO Y
        if(valoresX[randX] == 0){
            // VALOR ALEATORIO PARA MOVIMENTO NO EIXO Y
            randY = random.nextInt(2);
            // CONDIÇÕES PARA REALIZAR O CICLO NO MAPA NO EIXO Y
            // RETORNA NO TOPO DO MAPA
            if(getY() + valoresY[randY] > 28){
                setY(1);
            }
            // RETORNA NA BASE DO MAPA 
            else if(getY() + valoresY[randY] < 1){
                setY(28);
            }
            
            // REALIZA O MOVIMENTO NO EIXO Y
            else{
               setY(getY() + valoresY[randY]);
            }
        }
        // MOVIMENTOS DO EIXO X
        else{
            // CONDIÇÕES DE MOVIMENTO NO EIXO X, MOVIMENTO LATERAL
            // RETORNA NO LADO ESQUERDO DO MAPA
            if((getX() + valoresX[randX])> 58){
                setX(1);
            }
            // RETORNA NO LADO DIREITO DO MAPA
            else if((getX() + valoresX[randX])< 1){
              setX(58);  
            }
            // REALIZA MOVIMENTO LATERAL
            else{
                setX(getX() + valoresX[randX]);
            }
        }
        setTempo(getTempo() + 1);
    }
    
}
