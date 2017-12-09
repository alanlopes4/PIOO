
package ataques;

import pokemon.Ataque;
import pokemon.Pokemon;
import pokemon.Tipo;


public class AtaqueFixo extends Ataque {
    
    private int val;

    public AtaqueFixo( int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy, int val) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.val = val;
    }
    
    
  

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario) {
        if(super.getPpAtual() >= 1){
             super.setPpAtual(super.getPpAtual() - 1);
              if(calculoAcerto(pk_usuario, pk_adversario)){
                  double dano = 0.0;
                  //Se for ataque do tipo level
                  if(val == -1)
                      dano = pk_usuario.getLevel();
                  else
                      dano = val;  
                  
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
