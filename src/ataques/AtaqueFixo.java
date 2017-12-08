/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ataques;

import pokemon.Ataque;
import pokemon.Tipo;

/**
 *
 * @author sylar
 */
public class AtaqueFixo extends Ataque {
    
    private int val;

    public AtaqueFixo( int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy, int val) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.val = val;
    }
    
    
    
    public void efeito(){
        
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
    
    
}
