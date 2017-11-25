/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ataques;

import pokemon.Ataque;

/**
 *
 * @author sylar
 */
public class AtaqueMultihit extends Ataque {
    
    private int min;
    private int max;
    
    public void efeito(){
        
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
