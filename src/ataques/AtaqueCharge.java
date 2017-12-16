
package ataques;

import pokemon.Ataque;
import pokemon.Pokemon;
import pokemon.Tipo;
/**
 *
 * @author Alan e Alisson
 */
public class AtaqueCharge extends Ataque {

    public AtaqueCharge(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
    }

    @Override
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario) {
        if(super.getPpAtual() >= 1){
             super.setPpAtual(super.getPpAtual() - 1);
              if(calculoAcerto(pk_usuario, pk_adversario)){
                  double dano = 0.0;
                  dano = calculoDano(pk_usuario, pk_adversario);
                  dano *=1.75;
                  comportamentoAtaque(pk_usuario, pk_adversario, dano);
              }
              else{
                  System.out.println("Ataque errou o alvo!");
              }
        }else{
              System.out.println("PP atual abaixo de 1, não pode atacar");
        }
    }
   
}
