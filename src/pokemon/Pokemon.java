package pokemon;

import java.util.ArrayList;
import java.util.List;


public class Pokemon {
    
  //identificar o jogador dono do pokemon
  private int identiricadorJogador;
    
  private List<Ataque> ataque = new ArrayList<>();
  private Especie especie = new Especie();
  private Status priStatus, secStatus;

  private int level;
  private double hpAtual;
  private double hpMax;
  private double atk;
  private double def;
  private double spe;
  private double spd;
  private int modifierAccuracy;
  private int modifierEvasion;
  private int modifierAtk;
  private int modifierDef;
  private int modifierSpe;
  private int modifierSpd;
  private boolean confusion;
  private boolean flinch;

  //comentario adicionado
    public Pokemon() {
        
        //executa o calculo dos atribuso
        this.hpAtual = this.especie.calcularAtributo(this.level, 1);
        this.hpMax = this.especie.calcularAtributo(this.level, 1);
        this.atk = this.especie.calcularAtributo(this.level, 2);
        this.def = this.especie.calcularAtributo(this.level, 3);
        this.spe = this.especie.calcularAtributo(this.level, 4);
        this.spd = this.especie.calcularAtributo(this.level, 5);
       
        this.modifierAccuracy = 0;
        this.modifierAtk = 0;
        this.modifierDef = 0;
        this.modifierEvasion = 0;
        this.modifierSpd = 0;
        this.modifierSpe = 0;
        this.confusion = false;
        this.flinch = false;
        this.priStatus = Status.OK;
        
    }
    
    public Pokemon(Especie especie, int level) {
        
        //executa o calculo dos atribuso
        this.level = level;
        this.especie = especie;
        this.hpAtual = this.especie.calcularAtributo(this.level, 1);
        this.hpMax = this.especie.calcularAtributo(this.level, 1);
        this.atk = this.especie.calcularAtributo(this.level, 2);
        this.def = this.especie.calcularAtributo(this.level, 3);
        this.spe = this.especie.calcularAtributo(this.level, 4);
        this.spd = this.especie.calcularAtributo(this.level, 5);
       
        this.modifierAccuracy = 0;
        this.modifierAtk = 0;
        this.modifierDef = 0;
        this.modifierEvasion = 0;
        this.modifierSpd = 0;
        this.modifierSpe = 0;
        this.confusion = false;
        this.flinch = false;
        this.priStatus = Status.OK;
        
    }
  
  
  
  public double valorAtributo(int opcao){
      
      double retorno = 0.0;
      
      switch(opcao)
        {
            //calcula atak
            case 1 : retorno = this.atk + (((Math.max(2, 2 + Ataque.getModifier(this.modifierAtk))) / (Math.max(2, 2 - Ataque.getModifier(this.modifierEvasion)))) * 0.01); break;
            //calcula def
            case 2 : retorno = this.def + (((Math.max(2, 2 + Ataque.getModifier(this.modifierDef))) / (Math.max(2, 2 - Ataque.getModifier(this.modifierDef)))) * 0.01); break;
            //calcula spd
            case 3 : retorno = this.spd + (((Math.max(2, 2 + Ataque.getModifier(this.modifierSpd))) / (Math.max(2, 2 - Ataque.getModifier(this.modifierSpd)))) * 0.01); break;
            //calcula spe
            case 4 : retorno = this.spe + (((Math.max(2, 2 + Ataque.getModifier(this.modifierSpe))) / (Math.max(2, 2 - Ataque.getModifier(this.modifierSpe)))) * 0.01); break;
                         
        } 
      
      return retorno;
  }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getHpAtual() {
        return hpAtual;
    }

    public void setHpAtual(double hpAtual) {
        this.hpAtual = hpAtual;
    }

    public double getHpMax() {
        return hpMax;
    }

    public void setHpMax(double hpMax) {
        this.hpMax = hpMax;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getSpe() {
        return spe;
    }

    public void setSpe(double spe) {
        this.spe = spe;
    }

    public double getSpd() {
        return spd;
    }

    public void setSpd(double spd) {
        this.spd = spd;
    }

    public int getModifierAccuracy() {
        return modifierAccuracy;
    }

    public void setModifierAccuracy(int modifierAccuracy) {
        this.modifierAccuracy = modifierAccuracy;
    }

    public int getModifierEvasion() {
        return modifierEvasion;
    }

    public void setModifierEvasion(int modifierEvasion) {
        this.modifierEvasion = modifierEvasion;
    }

    public int getModifierAtk() {
        return modifierAtk;
    }

    public void setModifierAtk(int modifierAtk) {
        this.modifierAtk = modifierAtk;
    }

    public int getModifierDef() {
        return modifierDef;
    }

    public void setModifierDef(int modifierDef) {
        this.modifierDef = modifierDef;
    }

    public int getModifierSpe() {
        return modifierSpe;
    }

    public void setModifierSpe(int modifierSpe) {
        this.modifierSpe = modifierSpe;
    }

    public int getModifierSpd() {
        return modifierSpd;
    }

    public void setModifierSpd(int modifierSpd) {
        this.modifierSpd = modifierSpd;
    }

    public boolean isConfusion() {
        return confusion;
    }

    public void setConfusuion(boolean confusuion) {
        this.confusion = confusuion;
    }

    public boolean isFlinch() {
        return flinch;
    }

    public void setFlinch(boolean flinch) {
        this.flinch = flinch;
    }


    /**
     * @return the especie
     */
    public Especie getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    /**
     * @return the ataque
     */
    public List<Ataque> getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(Ataque ataque) {
        this.ataque.add(ataque);
    }

    /**
     * @return the priStatus
     */
    public Status getPriStatus() {
        return priStatus;
    }

    /**
     * @param priStatus the priStatus to set
     */
    public void setPriStatus(Status priStatus) {
        this.priStatus = priStatus;
    }

    /**
     * @return the secStatus
     */
    public Status getSecStatus() {
        return secStatus;
    }

    /**
     * @param secStatus the secStatus to set
     */
    public void setSecStatus(Status secStatus) {
        this.secStatus = secStatus;
    }


    /**
     * @return the identiricadorJogador
     */
    public int getIdentiricadorJogador() {
        return identiricadorJogador;
    }

    /**
     * @param identiricadorJogador the identiricadorJogador to set
     */
    public void setIdentiricadorJogador(int identiricadorJogador) {
        this.identiricadorJogador = identiricadorJogador;
    }
  
  
    
}
