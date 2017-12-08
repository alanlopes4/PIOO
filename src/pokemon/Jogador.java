/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sylar
 */
public abstract class Jogador {
    
    private List<Pokemon> time = new ArrayList<Pokemon>();
    private String comandoEscolhido;
    
    public abstract void escolherComando();
    
    public void trocarPokemon(int posicao){
        
        //pokemon que sera subistituido
        Pokemon substituido = getTime().get(0);
        
        //realiza a troca dos pokemons
        getTime().set(0, getTime().get(posicao));    
        getTime().set(posicao, substituido);
        
        this.comandoEscolhido = "Troca!";
          
    }
    
    public void usarAtaque(int posicao){
        
        //usando o ataque
        getTime().get(0).getAtaque().get(posicao).efeito();
        
        this.comandoEscolhido = "Ataque!";
        
    }

    

    /**
     * @return the comandoEscolhido
     */
    public String getComandoEscolhido() {
        return comandoEscolhido;
    }

    /**
     * @return the time
     */
    public List<Pokemon> getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(List<Pokemon> time) {
        this.time = time;
    }
    
    
    
}
