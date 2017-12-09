/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ataques;

import java.util.concurrent.ThreadLocalRandom;
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
    
    
    
    @Override
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario){
         if(super.getPpAtual() >= 1){
             super.setPpAtual(super.getPpAtual() - 1);
              if(calculoAcerto(pk_usuario, pk_adversario)){
                  double dano = 0.0;
                  int vezes = ThreadLocalRandom.current().nextInt(min - 1, max + 1);
                  boolean critico = calculoCritico(pk_usuario.getSpd());
                  for(int i = 0; i < vezes; i++) 
                    dano += super.calculoDano(pk_usuario, pk_adversario);
                    
                  comportamentoAtaque(pk_usuario, pk_adversario, dano);
              }
              else{
                  System.out.println("Ataque errou o alvo!");
              }
        }else{
              System.out.println("PP atual abaixo de 1, não pode atacar");
        }        
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
