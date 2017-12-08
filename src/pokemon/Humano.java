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
       
        System.out.println("Escolha dos comandos:");
        System.out.println("1 - Troca e 2 - Ataque?");
        Scanner opcao = new Scanner(System.in);
        int escolha = opcao.nextInt();
        super.setComandoEscolhido(escolha);
        
        
    }
}
