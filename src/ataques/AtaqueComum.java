/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ataques;

import pokemon.Ataque;
import pokemon.Pokemon;
import pokemon.Tipo;

/**
 *
 * @author sylar
 */
public class AtaqueComum extends Ataque {

    public AtaqueComum(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
    }

    @Override
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario) {
        super.setPpAtual(super.getPpAtual() - 1);
        
        if(calculoAcerto(pk_usuario, pk_adversario)){
            double dano = calculoDano(pk_usuario, pk_adversario);
            comportamentoAtaque(pk_usuario, pk_adversario, dano);
                        
        }
        
    }
    
    
    
    
    
}
