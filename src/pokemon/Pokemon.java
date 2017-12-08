package pokemon;


public class Pokemon {
    
  private Ataque[] ataque = new Ataque[4];
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
  private boolean confusuion;
  private boolean flinch;

    public Pokemon() {
        
        
        
        
        this.modifierAccuracy = 0;
        this.modifierAtk = 0;
        this.modifierDef = 0;
        this.modifierEvasion = 0;
        this.modifierSpd = 0;
        this.modifierSpe = 0;
    }
  
  
  
  public double valorAtributo(int opcao){
      
      double retorno = 0.0;
      
      switch(opcao)
        {
            //calcula atak
            case 1 : retorno = this.atk + (Math.max(2, 2 + this.modifierAccuracy)) / (Math.max(2, 2 - this.modifierEvasion)); break;
            //calcula def
            case 2 : retorno = this.def + (Math.max(2, 2 + this.modifierAccuracy)) / (Math.max(2, 2 - this.modifierEvasion)); break;
            //calcula spd
            case 3 : retorno = this.spd + (Math.max(2, 2 + this.modifierAccuracy)) / (Math.max(2, 2 - this.modifierEvasion)); break;
            //calcula spe
            case 4 : retorno = this.spe + (Math.max(2, 2 + this.modifierAccuracy)) / (Math.max(2, 2 - this.modifierEvasion)); break;
                         
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

    public boolean isConfusuion() {
        return confusuion;
    }

    public void setConfusuion(boolean confusuion) {
        this.confusuion = confusuion;
    }

    public boolean isFlinch() {
        return flinch;
    }

    public void setFlinch(boolean flinch) {
        this.flinch = flinch;
    }

    /**
     * @return the ataque
     */
    public Ataque[] getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(Ataque[] ataque) {
        this.setAtaque(ataque);
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
  
  
    
}
