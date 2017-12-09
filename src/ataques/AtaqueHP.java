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
public class AtaqueHP extends Ataque {
    
    private int valor;
    private double porcentagem;

    public AtaqueHP(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy, int valor, double porcentagem) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.valor = valor;
        this.porcentagem = porcentagem;
    }
    
    
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario){
        
        double dano = super.calculoDano(pk_usuario, pk_adversario);
        pk_adversario.setHpAtual(pk_adversario.getHpAtual() - dano);
        
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }
    
    
}
