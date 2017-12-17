package ataques;

import pokemon.Ataque;
import pokemon.Pokemon;
import pokemon.Status;
import pokemon.Tipo;

/**
 *
 * @author Alan e Alisson
 */
public class AtaqueHP extends Ataque {
    
    private int valor;
    private double porcentagem;

    public AtaqueHP(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy, int valor, double porcentagem) {
        super(id, nome, tipo, ppMax, ppAtual, power, accuracy);
        this.valor = valor;
        this.porcentagem = porcentagem;
    }
    
    /**
     * Responsável por aplicar o efeito de um AtaqueHP
     * @param pk_usuario
     * @param pk_adversario 
     */
    @Override
    public void efeito(Pokemon pk_usuario, Pokemon pk_adversario){
        if(super.getPpAtual() >= 1){
             super.setPpAtual(super.getPpAtual() - 1);
              if(calculoAcerto(pk_usuario, pk_adversario)){
                  double dano = 0.0, heal = 0.0;
                  dano = super.calculoDano(pk_usuario, pk_adversario);
                  if(valor == -1)
                      heal = dano * porcentagem;
                  else if(valor == -2)
                      heal =  pk_usuario.getHpMax() * porcentagem;
                  
                  comportamentoAtaque(pk_usuario, pk_adversario, dano);
                  
                  if(pk_usuario.getPriStatus() != Status.FAINTED){
                    if (pk_usuario.getHpAtual() + heal > pk_usuario.getHpMax())
                        pk_usuario.setHpAtual(pk_usuario.getHpMax());
                    else
                        pk_usuario.setHpAtual(pk_usuario.getHpAtual() + heal);
                    
                    if (heal > 0) 
                        System.out.printf("%s se curou %.2f\n", pk_usuario.getEspecie().getNome(), heal);
                    else
                        System.out.printf("%s consumiu %.2f\n", pk_usuario.getEspecie().getNome(),heal);
                    
                  }
              }
              else{
                  System.out.println("Ataque errou o alvo!");
              }
        }else{
              System.out.println("PP atual abaixo de 1, não pode atacar");
        }
        
        
        
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
