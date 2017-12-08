/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ataques;

import pokemon.Ataque;
import pokemon.Status;
import pokemon.Tipo;

/**
 *
 * @author sylar
 */
public class AtaqueStatus extends Ataque {
    
    private Status status;
    private int chance;

    public AtaqueStatus(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy, Status status, int chance) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.status = status;
        this.chance = chance;
    }
    
    
    
    public void efeito(){
        
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    
    
}
