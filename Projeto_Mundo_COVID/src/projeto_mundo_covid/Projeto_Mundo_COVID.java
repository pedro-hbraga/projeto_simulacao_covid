/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_mundo_covid;

/**
 *
 * @author braga
 */
public class Projeto_Mundo_COVID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // INSTANCIANDO A CLASSE Mundo
        Mundo m = new Mundo();
        
        
        m.desenhaMundo();
        m.pessoasMundo();
        
        // DESENHANDO O MUNDO
        while(true){
            
            m.desenhaMundo();
            m.atualizaMundo();
            
            // EXCEÇÃO 
            try{
                // ATUALIZAÇÃO DO MUNDO
                // DELAY DE 500ms
                Thread.sleep(500);
            }
            
            catch(Exception e){
                e.printStackTrace();
            }
            
            
        }
        
        
    }
    
}
