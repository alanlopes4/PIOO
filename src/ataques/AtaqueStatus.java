package ataques;

import java.util.Random;
import pokemon.Ataque;
import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

/**
 *
 * @author Alan e Alisson
 */
public class AtaqueStatus extends Ataque {
    
    private Status status;
    private int chance;

    public AtaqueStatus(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy, Status status, int chance) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.status = status;
        this.chance = chance;
    }
    
    
    /**
     * Responsável por aplicar o efeito de um AtaqueStatus
     * @param pk_usuario
     * @param pk_adversario 
     */
    @Override
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario){
         if(super.getPpAtual() >= 1){
             super.setPpAtual(super.getPpAtual() - 1);
              if(calculoAcerto(pk_usuario, pk_adversario)){
                  double dano = 0.0;
                  dano = super.calculoDano(pk_usuario, pk_adversario);
                  boolean aplicar = new Random().nextInt(100) < chance; 
                  if(status == Status.FLINCH){
                      if(aplicar)
                          pk_adversario.setFlinch(true);
                  }
                  else if(status == Status.CONFUSION){
                      if(aplicar)
                          pk_adversario.setConfusuion(true);
                  }else{
                      if(aplicar)
                          pk_adversario.setPriStatus(status);
                  }
                  
                  comportamentoAtaque(pk_usuario, pk_adversario, dano);
              }
              else{
                  System.out.println("Ataque errou o alvo!");
              }
        }else{
              System.out.println("PP atual abaixo de 1, não pode atacar");
        }
        
        
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
