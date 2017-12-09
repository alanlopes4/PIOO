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
public class AtaqueMultihit extends Ataque {
    
    private int min;
    private int max;

    public AtaqueMultihit(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy, int min, int max) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.min = min;
        this.max = max;
    }
    
    
    
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario){
        
        double dano = super.calculoDano(pk_usuario, pk_adversario);
        pk_adversario.setHpAtual(pk_adversario.getHpAtual() - dano);
        
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    
    
}
