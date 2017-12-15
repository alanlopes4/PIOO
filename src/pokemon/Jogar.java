package pokemon;

import execao.ExcecaoPokemon;
import java.util.List;
/**
 * Classe executável responsável pela
 * @author Alan e Alisson
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
