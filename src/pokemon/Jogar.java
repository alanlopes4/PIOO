/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import ataques.AtaqueCharge;
import java.util.Scanner;

/**
 *
 * @author sylar
 */
public class Jogar {
    
    private static Jogador jogador1, jogador2;
    private static Batalha ba;
    
    public static void main(String[] args){
        
        ba = new Batalha();
        ba.carregarTabelas();
        
        iniciarJogadores();
        
    }
    
    
    public static void iniciarJogadores()
    {
        Scanner entrada = new Scanner(System.in);
        for(int i = 1; i <= 2; i++)
        {
            System.out.println("Escolha o " + i + "° Jogador:");
            System.out.println("Deseja ser 1 - Humano ou 0 - Computador?"); 
            int escolha = entrada.nextInt();
            if(i == 1)
            {
                //escolha dos jogadores
                if(escolha == 1)
                {
                    jogador1 = new Humano();   
                }
                else
                {
                    jogador1 = new Maquina();
                }
                
                //escolha dos pokemons
                escolherPokemons(jogador1);
                
            }
            else
            {
                if(escolha == 1)
                {
                    jogador2 = new Humano();
                }
                else
                {
                    jogador2 = new Maquina();
                }
                
                escolherPokemons(jogador2);
            }
        }
    }
    
    
    public static void escolherPokemons(Jogador jogador)
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantidade de pokemons:");
        int quantidade = entrada.nextInt();
        for(int i = 0; i < quantidade; i++)
        {
            
            Pokemon pokemon = new Pokemon();
            
            System.out.println( (i + 1) + "° Pokemon:");
            System.out.println("Código do pokemon:");
            int codigo = entrada.nextInt();
            pokemon.setEspecie(ba.getEspecies().get(codigo - 1));
            
            System.out.println("Level do pokemon:");
            int level = entrada.nextInt();
            pokemon.setLevel(level);
            
            
            for(int j = 0; j < 4; j++)
            {
                System.out.println( (j + 1) + "° Ataque:");
                int codigoAtaque = entrada.nextInt();
                if(codigoAtaque != 0)
                    pokemon.setAtaque(ba.getAtaques().get(codigoAtaque - 1));                             
            }
            
            //adcionando no time o pokemon do jogador
            jogador.getTime().add(pokemon);
        }
    }
    
}
