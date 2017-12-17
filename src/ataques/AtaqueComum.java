package ataques;

import pokemon.Ataque;
import pokemon.Pokemon;
import pokemon.Tipo;

/**
 *
 * @author Alan e Alisson
 */
public class AtaqueComum extends Ataque {

    public AtaqueComum(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
    }

    /**
     * Responsável por aplicar o efeito de um AtaqueComum
     * @param pk_usuario
     * @param pk_adversario 
     */
    @Override
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario) {
        super.setPpAtual(super.getPpAtual() - 1);
        
        if(calculoAcerto(pk_usuario, pk_adversario)){
            double dano = calculoDano(pk_usuario, pk_adversario);
            comportamentoAtaque(pk_usuario, pk_adversario, dano);
                        
        }
        
    }
    
    
    
    
    
}
