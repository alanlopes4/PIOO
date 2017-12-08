/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;


/**
 *
 * @author sylar
 */
public class Maquina extends Jogador{
    
    
    @Override
    public void escolherComando(){
        
        //escolher o ataque aleatoriamente
        double escolha = 1 + Math.random() * 2;
        int n = (int) escolha;
        super.setComandoEscolhido(n);
        //Ataque ataqueEscolhido = super.getTime().get(0).getAtaque().get(escolha);
                
    }
}
