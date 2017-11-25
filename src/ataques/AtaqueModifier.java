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
public class AtaqueModifier extends Ataque {
    private int mod;
    private int n;
    private int chance;
    
    
    public void efeito(){
        
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    
    
}
