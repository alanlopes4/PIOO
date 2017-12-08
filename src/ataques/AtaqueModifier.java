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
public class AtaqueModifier extends Ataque {
    private int mod;
    private int n;
    private int chance;

    public AtaqueModifier( int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy, int mod, int n, int chance) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.mod = mod;
        this.n = n;
        this.chance = chance;
    }
    
    
    
    
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
