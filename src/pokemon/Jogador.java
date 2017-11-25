/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author sylar
 */
public abstract class Jogador {
    
    private Pokemon[] time = new Pokemon[6];
    
    public abstract void escolherComando();
    
    public void trocarPokemon(int posicao){
        
        //pokemon que sera subistituido
        Pokemon substituido = time[0];
        
        //realiza a troca dos pokemons
        time[0] = time[posicao];    
        time[posicao] = substituido;
          
    }
    
    public void usarAtaque(int posicao){
        
        //usando o ataque
        time[0].getAtaque()[posicao].efeito();
        
    }

    /**
     * @return the time
     */
    public Pokemon[] getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Pokemon[] time) {
        this.time = time;
    }
    
    
    
}
