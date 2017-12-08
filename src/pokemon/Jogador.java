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
    private int comandoEscolhido;
    
    public abstract void escolherComando();
    
    public void trocarPokemon(int posicao){
        
        //pokemon que sera subistituido
        Pokemon substituido = getTime().get(0);
        
        //realiza a troca dos pokemons
        getTime().set(0, getTime().get(posicao));    
        getTime().set(posicao, substituido);
        
        this.setComandoEscolhido(1);
          
    }
    
    public void usarAtaque(int posicao){
        
        //usando o ataque
        getTime().get(0).getAtaque().get(posicao).efeito();
        
        this.setComandoEscolhido(2);
        
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

    /**
     * @return the comandoEscolhido
     */
    public int getComandoEscolhido() {
        return comandoEscolhido;
    }

    /**
     * @param comandoEscolhido the comandoEscolhido to set
     */
    public void setComandoEscolhido(int comandoEscolhido) {
        this.comandoEscolhido = comandoEscolhido;
    }
    
    
    
}
