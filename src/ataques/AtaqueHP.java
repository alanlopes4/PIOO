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
public class AtaqueHP extends Ataque {
    
    private int valor;
    private int porcentagem;
    
    
    public void efeito(){
        
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }
    
    
}
