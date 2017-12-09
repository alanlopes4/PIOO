/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.Scanner;

/**
 *
 * @author sylar
 */
public class Humano extends Jogador{
    
       
    @Override
    public void escolherComando(){
        int escolha = 0;
        do{
            System.out.println("Escolha dos comandos:");
            System.out.println("1 - Troca e 2 - Ataque?");
            Scanner opcao = new Scanner(System.in);
            escolha = opcao.nextInt();
            if(super.getTime().size()<=1 && escolha == 1)
                System.out.println("Não é possível trocar, possui apenas 1 pokemon");
        }while(super.getTime().size() <=1 && escolha == 1);
        super.setComandoEscolhido(escolha);
        
        
    }
}
