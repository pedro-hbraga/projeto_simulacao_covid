/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_mundo_covid;


import java.util.Random;
import java.util.ArrayList;



/**
 * Classe Mundo do Projeto
 * @author braga
 * 
 * 
 */
public class Mundo {
    
    
    /**
     * Atributos da Classe Mundo
     * 
     */
    
    private int cont = 0, contConts = 0;
    
    private Random random = new Random();
    private int coluna = 1;
    private int linha = 1;
    private int tempo = 0, obitos = 0, vacinados = 0, vacinados_contaminados = 0, saudaveis = 100, contaminados = 2;
    private int randX = 0, randY = 0;
    int auxLin = 0, auxCol = 0, auxPos = 0, i;
    
    // ATRIBUTO PARA CRIAR UMA LISTA DE INDIVIDUOS
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    // MATRIZ MAPA 
    private int[][] mapa = new int[][]
    {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,3,2,2,2,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,3,3,3,2,2,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,3,2,2,2,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,2,2,2,3,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,2,2,3,3,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,2,2,2,3,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,3,2,2,2,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,3,3,3,2,2,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,3,2,2,2,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        
    };
    
    // M??TODOS
    
    /**
     * 
     * M??TODO QUE REALIZA O MOVIMENTO DAS PESSOAS NA CLASSE MUNDO
     */
    public void mova(){
        
        // ATRIBUTOS AUXILIARES - UTILIZADOS PARA ARMAZENAR INFORMA????ES SOBRE AS POSI????ES NA MATRIZ
        auxLin = linha;
        auxCol = coluna;
        
        // MOVIMENTO
        pessoas.get(i).mover();
        coluna = pessoas.get(i).getX();
        linha = pessoas.get(i).getY();                               

        // LA??O PARA EVITAR A SOBREPOSI????O DE INDIVIDUOS
        while(true){

            if((mapa[linha][coluna] != 4) && 
               (mapa[linha][coluna] != 5) && 
               (mapa[linha][coluna] != 6) && 
               (mapa[linha][coluna] != 7) ){
                 
                    break;
            }
            else{
                pessoas.get(i).mover();
                coluna = pessoas.get(i).getX();
                linha = pessoas.get(i).getY(); 
            }
        }
        // ARMAZENA A INFORMA????O DA POSI????O FUTURA ANTES DE REALIZAR O MOVIMENTO
        pessoas.get(i).setPosAux(mapa[linha][coluna]);
        
        
        
    }
    
    /**
     * M??todo pessoasMundo realiza a inser????o de pessoas na matriz mapa
     * Em posi????es aleat??rias
     * 
     */
    public void pessoasMundo(){
        
        
        // DESENHANDO AS PESSOAS SAUDAVEIS NO MUNDO EM POSI????ES ALEATORIAS
        // LA??O CONFORME A QUANTIDADE DE PESSOAS
        
        // PESSOAS SAUDAVEIS - 4
        for(int i = 0; i<100; i++){
            
            while(true){
                while(true){

                    randY = random.nextInt(30);

                    if((randY > 0) && (randY < 30)){
                        break;
                    }
                }
                while(true){
                    randX = random.nextInt(60);
                    if((randX > 0) && (randY < 60)){
                        break;
                    }
                }
                if(mapa[randY][randX] != 1 && mapa[randY][randX] != 2 && mapa[randY][randX] != 3 && mapa[randY][randX] != 4){
                    break;
                }
            }
            
            mapa[randY][randX] = 4;
        }
        
        // DESENHANDO PESSOAS DOENTES EM POSI????ES ALEAT??RIAS NO MUNDO
        // LA??O PARA CRIAR A QUANTIDADE 2 DE PESSOAS CONTAMINADAS
        
        // PESSOAS CONTAMINADAS - 5
         for(int i = 0; i<2; i++){
            
            while(true){
                while(true){

                    randY = random.nextInt(30);

                    if((randY > 0) && (randY < 30)){
                        break;
                    }
                }
                while(true){
                    randX = random.nextInt(60);
                    if((randX > 0) && (randY < 60)){
                        break;
                    }
                }
                if(mapa[randY][randX] != 1 && mapa[randY][randX] != 2 && 
                   mapa[randY][randX] != 3 && mapa[randY][randX] != 4 &&
                   mapa[randY][randX] != 5){
                    
                    break;
                }
            }
            
            mapa[randY][randX] = 5;
        }
        
         // Acrescenta as pessoas na lista pessoas
        for(linha = 1; linha<mapa.length; linha++){
            for(coluna = 1; coluna<mapa[linha].length;coluna++){
                if(mapa[linha][coluna] == 4){                    
                    pessoas.add(new PessoaSaudavel(linha, coluna, 0));                                     
                }
                else if(mapa[linha][coluna] == 5){
                    pessoas.add(new PessoaDoente(linha, coluna, 0));
                }
            }
        }
    }
    
    
    /**
     * M??TODO atualizaMundo PARA ATUALIZAR O MUNDO
     * 
     */
    public void atualizaMundo(){

        /**
         * CONDI????O DE MOVIMENTO DA PESSOA
         */
        // PERCORRENDO O MAPA
        // PERCORRE AS LINHAS DO MAPA
        for(linha = 1; linha<mapa.length; linha++){
            // PERCORRE AS COLUNAS DO MAPA
            for(coluna = 1; coluna<mapa[linha].length;coluna++){
                
                /**
                 * IDENTIFICANDO UMA PESSOA SAUDAVEL
                 * 
                 */
                if(mapa[linha][coluna] == 4){
                    // CONFIRMANDO A POSI????O DA PESSOA
                    for(i = 0; i<pessoas.size(); i++){
                        // POSI????O X DA PESSOA
                        if(pessoas.get(i).getX() == coluna){
                            // POSI????O Y DA PESSOA
                            if(pessoas.get(i).getY() == linha){                               
                                                              
                               // RECEBE O VALOR DA POSI????O ANTERIOR AO ULTIMO MOVIMENTO
                               auxPos = pessoas.get(i).getPosAux();                             
                                
                                // CONDI????O PARA VACINAR UM INDIVIDUO
                                if(pessoas.get(i).getPosAux() == 2|| pessoas.get(i).getPosAux() == 3){
                                   pessoas.get(i).setVacinada(true);
                                   
                                   vacinados++;
                                   mapa[linha][coluna] = 6;
                                }
                                
                                // CONDI????O DE CONTAMINA????O DE UM INDIVIDUO SAUDAVEL
                                else if(mapa[linha + 1][coluna] == 5 ||
                                        mapa[linha][coluna + 1] == 5 ||
                                        mapa[linha - 1][coluna] == 5 ||
                                        mapa[linha][coluna - 1] == 5 ||
                                        mapa[linha + 1][coluna] == 7 ||
                                        mapa[linha][coluna + 1] == 7 ||
                                        mapa[linha - 1][coluna] == 7 ||
                                        mapa[linha][coluna - 1] == 7){
                                    
                                    // MOVIMENTO
                                    mova();                                   
                                    
                                    // REPOE O VALOR DA POSI????O ANTERIOR AO ??LTIMO MOVIMENTO DO INDIVIDUO
                                    mapa[auxLin][auxCol] = auxPos;
                                    
                                    // ADICIONA O CONTAMINADO NA LISTA COMO PESSOAS DOENTES
                                    pessoas.add(new PessoaDoente(linha, coluna, pessoas.get(i).getPosAux()));                                    
                                    pessoas.remove(i);
                                    
                                    saudaveis--;
                                    contaminados++;
                                    mapa[linha][coluna] = 5;
                                    
                                    
                                }
                                else{
                       
                                // MOVIMENTO
                                
                                    mova();
                                    
                                    
                                    
                                    if(mapa[linha + 1][coluna] == 5 ||
                                       mapa[linha][coluna + 1] == 5 ||
                                       mapa[linha - 1][coluna] == 5 ||
                                       mapa[linha][coluna - 1] == 5 ||
                                       mapa[linha + 1][coluna] == 7 ||
                                       mapa[linha][coluna + 1] == 7 ||
                                       mapa[linha - 1][coluna] == 7 ||
                                       mapa[linha][coluna - 1] == 7)
                                    {
                                        
                                        mapa[auxLin][auxCol] = auxPos;

                                        pessoas.add(new PessoaDoente(linha, coluna, pessoas.get(i).getPosAux()));
                                        pessoas.remove(i);
                                        
                                        saudaveis--;
                                        contaminados++;
                                        mapa[linha][coluna] = 5;
                                    
                                    }
                                    else{
                                        mapa[auxLin][auxCol] = auxPos;
                                        mapa[linha][coluna] = 4;
 
                                    }                                   
                               }
                            }
                        }
                    }
                }
                /**
                 * IDENTIFICANDO UMA PESSOA CONTAMINADA
                 */
                else if(mapa[linha][coluna] == 5){
                    for(i = 0; i<pessoas.size(); i++){ 
                        // CONFIRMANDO A PESSOA
                      if(pessoas.get(i).getX() == coluna){
                          if(pessoas.get(i).getY() == linha){
                              
                              auxPos = pessoas.get(i).getPosAux();
                              
                              // CONDI????O PARA UM INDIVIDUO ENTRAR EM ??BITO
                              if(pessoas.get(i).getTempo() > 30){
                                  pessoas.remove(i);
                                  mapa[linha][coluna] = auxPos;
                                  obitos++;
                                  contaminados--;
                              }
                              
                              // CONDI????O PARA CURAR UM CONTAMINADO
                              else if(pessoas.get(i).getPosAux() == 2|| pessoas.get(i).getPosAux() == 3){
                                  
                                  pessoas.add(new PessoaSaudavel(linha, coluna, pessoas.get(i).getPosAux()));
                                  pessoas.remove(i);
                                  saudaveis++;
                                  contaminados--;
                                  mapa[linha][coluna] = 4;
                              }
                              else{
                                
                                mova();
                                mapa[auxLin][auxCol] = auxPos;
                                mapa[linha][coluna] = 5;                                                              
                              }
                          }
                      }  
                    }
                }
                /**
                 * IDENTIFICANDO UMA PESSOA VACINADA
                 */
                else if(mapa[linha][coluna] == 6){
                    for(i = 0; i<pessoas.size(); i++){ 
                        // CONFIRMANDO A PESSOA
                      if(pessoas.get(i).getX() == coluna){
                          if(pessoas.get(i).getY() == linha){
                              
                              auxPos = pessoas.get(i).getPosAux();
                              // CONDI????O DE CONTAMINA????O DE UMA PESSOA VACINADA
                              if(mapa[linha + 1][coluna] == 5 ||
                                       mapa[linha][coluna + 1] == 5 ||
                                       mapa[linha - 1][coluna] == 5 ||
                                       mapa[linha][coluna - 1] == 5 ||
                                       mapa[linha + 1][coluna] == 7 ||
                                       mapa[linha][coluna + 1] == 7 ||
                                       mapa[linha - 1][coluna] == 7 ||
                                       mapa[linha][coluna - 1] == 7){
                                    
                                    mova();                                  
                                    mapa[auxLin][auxCol] = auxPos;

                                    pessoas.get(i).setVirus(true);                                    
                                    vacinados_contaminados++;
                                    mapa[linha][coluna] = 7;                                     
                                }
                              else{
                                  
                                  mova();
                                   
                                  if(mapa[linha + 1][coluna] == 5 ||
                                       mapa[linha][coluna + 1] == 5 ||
                                       mapa[linha - 1][coluna] == 5 ||
                                       mapa[linha][coluna - 1] == 5 ||
                                       mapa[linha + 1][coluna] == 7 ||
                                       mapa[linha][coluna + 1] == 7 ||
                                       mapa[linha - 1][coluna] == 7 ||
                                       mapa[linha][coluna - 1] == 7){
                                        
                                        mapa[auxLin][auxCol] = auxPos;                                        
                                        pessoas.get(i).setVirus(true);
                                        
                                        vacinados_contaminados++;
                                        mapa[linha][coluna] = 7;
                                    
                                    }
                                    else{
                                        mapa[auxLin][auxCol] = auxPos;
                                        mapa[linha][coluna] = 6;
 
                                    }
                              }
                          }
                      }
                    }
                }
                /**
                 * IDENTIFICANDO UMA PESSOA VACINADA CONTAMINADA
                 */
                else if(mapa[linha][coluna] == 7){
                    for(i = 0; i<pessoas.size(); i++){ 
                      if(pessoas.get(i).getX() == coluna){
                          if(pessoas.get(i).getY() == linha){
                              
                              auxPos = pessoas.get(i).getPosAux();
                              
                              // CONDI????O PARA CHECAR SE O VIRUS AINDA ESTA ATIVO
                              if(pessoas.get(i).getTempo() > 30){
                                  
                                  pessoas.get(i).setVirus(false);
                                  mova();
                                  mapa[auxLin][auxCol] = auxPos;
                                  vacinados_contaminados--;                                  
                                  mapa[linha][coluna] = 6;
                              }
                              
                              else{
                                  pessoas.get(i).setTempo(pessoas.get(i).getTempo() + 1);
                                  mova();
                                  mapa[auxLin][auxCol] = auxPos;
                                  mapa[linha][coluna] = 7;
                              }                              
                          }
                      }
                    }
                }          
            }
        }
     }
    
    /**
     * M??TODO desenhaMundo REALIZA O DESENHO DO MUNDO BASEADO NA MATRIZ mapa[30][60]
     * 
     */
    public void desenhaMundo(){
        
        System.out.println("====================================================================");
        // INFORMA????ES EM TEMPO REAL DA SITUA????O DO MUNDO
        System.out.println("Tempot de simula????o: "+ tempo + " segundos");
        System.out.println("");
        System.out.println("\033[44m \033[0m Saud??veis: "+ saudaveis + " \033[41m \033[0m Contaminadas: " + contaminados);
        System.out.println("");
        System.out.println("\033[46m \033[0m Vacinados: " + vacinados +" \033[43m \033[0m Vacinados Contaminados: " + vacinados_contaminados);
        System.out.println("??bitos: " + obitos);
        System.out.println("Total de pessoas: " + pessoas.size());
        System.out.println("");
        
        
        /**
         * Condi????es para realizar o desenho do Mundo 
         */
        //PERCORRENDO A MATRIZ
        // LINHAS
        for(int c =0; c<mapa.length;c++){
            // COLUNAS
            for(int j=0; j< mapa[c].length;j++){
                
                switch(mapa[c][j]){
                    
                    // 0 - ESPA??O VAZIO
                    case 0:
                        System.out.print(" ");
                        break;
                    
                    // 1 - PAREDE - LIMITES DO MUNDO
                    case 1:
                        // \033[ PARA ACIONAR ANSI E \033[0m RETORNAR AO PADR??O 
                        // [47 COR DO BLOCO( 01 CARACTERE) - 7 EM BRANCO
                        System.out.print("\033[47m \033[0m");
                        break;
                    // 2 - HOSPITAL    
                    case 2:
                        System.out.print("\033[42m \033[0m");
                        break;
                    // 3 -  HOSPITAL    
                    case 3:
                        System.out.print("\033[45m \033[0m");
                        break;
                    // 4 - PESSOA SAUDAVEL    
                    case 4:
                        System.out.print("\033[44m \033[0m");
                        break;
                    // 5 - PESSOA CONTAMINADA
                    case 5:
                        System.out.print("\033[41m \033[0m");
                        break;
                    // PESSOA VACINADA    
                    case 6:
                        System.out.print("\033[46m \033[0m");
                        break;
                    // PESSOA VACINADA CONTAMINADA
                    case 7:
                        System.out.print("\033[43m \033[0m");
                        break;
                    default:
                        break;
                        
                }
            }
            
            System.out.println();
        }
        // PULAR LINHA ENTRE ANIMA????ES
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        tempo++;

        
       
        
    }
}
