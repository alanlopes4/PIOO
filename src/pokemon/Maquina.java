/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.Random;

/**
 *
 * @author sylar
 */
public class Maquina extends Jogador{
    
    
    @Override
    public void escolherComando(){
        
        //escolher o ataque aleatoriamente
        Random ra = new Random(4);
        int escolha = ra.nextInt();       
        //Ataque ataqueEscolhido = super.getTime()[0].getAtaque()[escolha];
                
    }
}
