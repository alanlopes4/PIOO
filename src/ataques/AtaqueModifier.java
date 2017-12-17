package ataques;

import java.util.Random;
import pokemon.Ataque;
import pokemon.Pokemon;
import pokemon.Tipo;

/**
 *
 * @author Alan e Alisson
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
    
    
    
    /**
     * Responsável por aplicar o efeito de um AtaqueModifier
     * @param pk_usuario
     * @param pk_adversario 
     */
    @Override
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario){
         if(super.getPpAtual() >= 1){
             super.setPpAtual(super.getPpAtual() - 1);
              if(calculoAcerto(pk_usuario, pk_adversario)){
                  double dano = 0.0;
                  boolean aplicar = new Random().nextInt(100) < chance;
                  if(aplicar)
                      alterarModifier(pk_usuario, pk_adversario);
 
                  dano = super.calculoDano(pk_usuario, pk_adversario);
                  comportamentoAtaque(pk_usuario, pk_adversario, dano);
              }
              else{
                  System.out.println("Ataque errou o alvo!");
              }
        }else{
              System.out.println("PP atual abaixo de 1, não pode atacar");
        }     
        
    }
    
    public void alterarModifier(Pokemon pk_usuario, Pokemon pk_adversario){
        //acuracy
        if(this.mod == 1)
        {
            if(n > 0)
            {
               pk_usuario.setModifierAccuracy(pk_usuario.getModifierAccuracy() + n);
            }
            else
            {
               pk_adversario.setModifierAccuracy(pk_usuario.getModifierAccuracy() + n); 
            }
        }
        else if(this.mod == 2)
        {
            if(n > 0)
            {
               pk_usuario.setModifierAtk(pk_usuario.getModifierAtk()+ n);
            }
            else
            {
               pk_adversario.setModifierAtk(pk_usuario.getModifierAtk() + n); 
            }   
        }
        else if(this.mod == 3)
        {
            if(n > 0)
            {
               pk_usuario.setModifierDef(pk_usuario.getModifierDef()+ n);
            }
            else
            {
               pk_adversario.setModifierDef(pk_usuario.getModifierDef() + n); 
            }
        }
        else if(this.mod == 4)
        {
            if(n > 0)
            {
               pk_usuario.setModifierEvasion(pk_usuario.getModifierEvasion()+ n);
            }
            else
            {
               pk_adversario.setModifierEvasion(pk_usuario.getModifierEvasion() + n); 
            }
        }
        else if(this.mod == 5)
        {
            if(n > 0)
            {
               pk_usuario.setModifierSpd(pk_usuario.getModifierSpd()+ n);
            }
            else
            {
               pk_adversario.setModifierSpd(pk_usuario.getModifierSpd() + n); 
            }
        }
        else if(this.mod == 6)
        {
            if(n > 0)
            {
               pk_usuario.setModifierSpe(pk_usuario.getModifierSpe()+ n);
            }
            else
            {
               pk_adversario.setModifierSpe(pk_usuario.getModifierSpe() + n); 
            }
        }
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
