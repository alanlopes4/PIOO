/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import execao.ExcecaoPokemon;
import java.util.List;
/**
 *
 * @author sylar
 */
public class Jogar {
    
    private static Batalha ba;
    
    public static void main(String[] args){
        
     try
     {
        ba = new Batalha();
        ba.carregarTabelas();
        ba.inicializarJogadores();
     }
     catch(Exception e)
     {
         System.out.println(new ExcecaoPokemon("Um erro ocorreu durante a execução!")); 
     }
        
        
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
