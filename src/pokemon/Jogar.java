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
public class Jogar {
    public static void main(String[] args){
        
        Batalha batalha = new Batalha();
        batalha.carregarTabelas();
        
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
        pk1.setEspecie(batalha.getEspecies().get(pokemons_j1[0][2]));
        
        
    }
}
