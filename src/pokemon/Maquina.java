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
        int n = 0;
        if(super.getTime().size()==1){
            n = 2;
        }else
        {
        //escolher o ataque aleatoriamente
        double escolha = 1 + Math.random() * 2;
         n = (int) escolha;
        }
        System.out.println("Computador escolheu comando "+n);
        super.setComandoEscolhido(n);
        //Ataque ataqueEscolhido = super.getTime().get(0).getAtaque().get(escolha);
                
    }
}
