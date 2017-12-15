package pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa os jogadores que participam da batalha
 * @author Alan e Alisson
 */
public abstract class Jogador {
    private int nome;
    private List<Pokemon> time = new ArrayList<Pokemon>();
    private int comandoEscolhido;
    
    public abstract void escolherComando();
    
    /**
     * Troca o pokemon da posição zero pela posição passada como parâmetro
     * @param posicao 
     */
    public void trocarPokemon(int posicao){
        
        //pokemon que sera subistituido
        Pokemon substituido = getTime().get(0);
        Pokemon novo = getTime().get(posicao);
        
        //realiza a troca dos pokemons
        getTime().set(0, novo);    
        getTime().set(posicao, substituido);
        
        this.setComandoEscolhido(1);
        System.out.println("--------------------");
        System.out.println("Pokemon " + substituido.getEspecie().getNome() + " foi trocado por " + novo.getEspecie().getNome());
        System.out.println("--------------------");  
    }
    /**
     * Usa o ataque escolhido no pokemon adversário
     * @param posicao
     * @param pk_usuario
     * @param pk_adversario 
     */
    public void usarAtaque(int posicao, Pokemon pk_usuario, Pokemon pk_adversario){
        
        //usando o ataque
        getTime().get(0).getAtaque().get(posicao).efeito(pk_usuario, pk_adversario);
        
        this.setComandoEscolhido(2);
        
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
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
