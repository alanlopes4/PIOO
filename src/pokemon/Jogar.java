/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sylar
 */
public class Jogar {
    
    private static Batalha ba;
    
    public static void main(String[] args){
        
        
        ba = new Batalha();
        ba.carregarTabelas();
        ba.inicializarJogadores();
        
        
    }
    
    
    
    
    public void primeiroAJogar(Batalha batalha)
    {
        
    }
    
    
    public void verificarStatusPokemons(List<Pokemon> pokemons)
    {
        for (Pokemon pokemon : pokemons) {
            //if(pokemon)
        }
    }
    
}
