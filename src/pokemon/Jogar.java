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
        
        Ataque a = ba.getAtaques().get(31 - 1);
               
        Scanner entrada = new Scanner(System.in);
        int j1 = entrada.nextInt();
        int qnt_pokemon_j1 = entrada.nextInt();
        int pokemons_j1[][] = new int[qnt_pokemon_j1][6];
        for(int i=0;i<qnt_pokemon_j1;i++){
            for(int j =0;j<6;j++){
                pokemons_j1[i][j] = entrada.nextInt();
            }
        }
        
        int j2 = entrada.nextInt();
        int qnt_pokemon_j2 = entrada.nextInt();
        int pokemons_j2[][] = new int[qnt_pokemon_j2][6];
        for(int i=0;i<qnt_pokemon_j2;i++){
            for(int j =0;j<6;j++){
                pokemons_j2[i][j] = entrada.nextInt();
            }
        }
        
        
        Pokemon pk1 = new Pokemon();
        pk1.setEspecie(ba.getEspecies().get(pokemons_j1[0][2]));
        
        
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
                    escolherPokemons(jogador1);
                }
                else
                {
                    jogador1 = new Maquina();
                }
                
                //escolha dos pokemons
                
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
            pokemon.setEspecie(ba.getEspecies().get(codigo));
            
            System.out.println("Level do pokemon:");
            int level = entrada.nextInt();
            pokemon.setLevel(level);
            
            
            for(int j = 0; j < 4; i++)
            {
                System.out.println( (j + 1) + "° Ataque:");
                int codigoAtaque = entrada.nextInt();
                pokemon.setAtaque(ba.getAtaques().get(codigo - 1));                             
            }
        }
    }
    
    
    public static Ataque buscarAtaque(int codigo)
    {
      /*  Ataque ata = new Ataque();
        ata.setId(codigo);
        if(ba.getAtaquesCharge().contains(ata))
        {
            for (Ataque charge : ba.getAtaquesCharge()) {
                if(charge.getId() == codigo)
                    return charge;
            }
        }
        */
        return null;
    }
}
