/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author sylar
 */
public abstract class Ataque {
    
    private int id;
    private String nome;
    private Tipo tipo;
    private double ppMax;
    private double ppAtual;
    private double power;
    private double accuracy;
    
    public Ataque(){
        
    }

    public Ataque(int id, String nome, Tipo tipo, double ppMax, double ppAtual, double power, double accuracy) {
        this.id = id;
        this.nome = nome;
        this.ppMax = ppMax;
        this.ppAtual = ppAtual;
        this.power = power;
        this.accuracy = accuracy;
        this.tipo = tipo;
    }
    
    
    
    
    public abstract void efeito(Pokemon pk_usuario, Pokemon pk_adversario);
    
    //verificar
    public  boolean calculoCritico(double spd){
        double retorno = spd / 512;
        if(ThreadLocalRandom.current().nextInt(0, 100) <retorno)
            return true;
        else
            return false;

    }
    
    public double calculoDano(Pokemon pk_usuario, Pokemon pk_adversario){
        double ataqueUsuario = 0.0, defesaOponete = 0.0;
        if(this.tipo == Tipo.NORMAL || this.tipo == Tipo.FIGHTING || this.tipo == Tipo.FLYING  || this.tipo == Tipo.GROUND || this.tipo == Tipo.ROCK || this.tipo == Tipo.BUG  || this.tipo == Tipo.GHOST  || this.tipo == Tipo.POISON )
        {
            ataqueUsuario = pk_usuario.getAtk();
            defesaOponete = pk_adversario.getDef();
        }
        else if(this.tipo == Tipo.FIRE  || this.tipo == Tipo.WATER || this.tipo == Tipo.ELETRIC || this.tipo == Tipo.GRASS || this.tipo == Tipo.ICE || this.tipo == Tipo.PSYCHIC || this.tipo == Tipo.DRAGON)
        {
             ataqueUsuario = pk_usuario.getSpe();
             defesaOponete = pk_adversario.getSpe();
        }
        
        if(calculoCritico(pk_usuario.getSpd()))
            pk_usuario.setLevel(pk_usuario.getLevel()*2); 
        
        if(pk_usuario.getPriStatus() == Status.BURN)
            pk_usuario.setAtk(pk_usuario.getAtk()/2);
        
        if(pk_usuario.getAtk()<0)
            pk_usuario.setAtk(0);
        if(pk_adversario.getDef()<0)
            pk_adversario.setDef(0);
        if(pk_usuario.getAtk()>255)
            pk_usuario.setAtk(255);
        if(pk_adversario.getDef()>255)
            pk_adversario.setDef(255);
        
        double dano = (pk_usuario.getLevel()*pk_usuario.getAtk()*this.power/pk_adversario.getDef()/50)+2;
             
        if(this.tipo == pk_usuario.getEspecie().getTipo1() || this.tipo == pk_usuario.getEspecie().getTipo2())
            dano *= 1.5;
        
        dano *= multiplicadorDano( pk_adversario);
        
        int r = ThreadLocalRandom.current().nextInt(217, 255);
        
        dano = (dano * r) / 255;
     
        
        return dano;
    }
    
    
    public double multiplicadorDano(Pokemon pk_adversario){
        if(this.tipo == Tipo.NORMAL){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.ROCK )
                return 0.5;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.GHOST)
                return 0;
        }
        else if(this.tipo == Tipo.FIGHTING){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.NORMAL || pk_adversario.getEspecie().getTipo1() == Tipo.ROCK || pk_adversario.getEspecie().getTipo1() == Tipo.ICE  )
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.FLYING || pk_adversario.getEspecie().getTipo1() == Tipo.POISON || pk_adversario.getEspecie().getTipo1() == Tipo.BUG
                    || pk_adversario.getEspecie().getTipo1() == Tipo.PSYCHIC)
                return 0.5;
          
        }
         else if(this.tipo == Tipo.FLYING){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.FIGHTING || pk_adversario.getEspecie().getTipo1() == Tipo.BUG || pk_adversario.getEspecie().getTipo1() == Tipo.GRASS  )
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.ROCK || pk_adversario.getEspecie().getTipo1() == Tipo.ELETRIC )
                return 0.5;
        }
        else if(this.tipo == Tipo.POISON){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.BUG || pk_adversario.getEspecie().getTipo1() == Tipo.GRASS )
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.POISON || pk_adversario.getEspecie().getTipo1() == Tipo.GROUND || pk_adversario.getEspecie().getTipo1() == Tipo.ROCK
                    || pk_adversario.getEspecie().getTipo1() == Tipo.GHOST)
                return 0.5;
        }
        else if(this.tipo == Tipo.GROUND){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.POISON || pk_adversario.getEspecie().getTipo1() == Tipo.ROCK || pk_adversario.getEspecie().getTipo1() == Tipo.FIRE
                    || pk_adversario.getEspecie().getTipo1() == Tipo.ELETRIC)
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.BUG || pk_adversario.getEspecie().getTipo1() == Tipo.GRASS)
                return 0.5;
             else if(pk_adversario.getEspecie().getTipo1() == Tipo.FLYING )
                 return 0;
        }
        else if(this.tipo == Tipo.ROCK){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.FLYING || pk_adversario.getEspecie().getTipo1() == Tipo.BUG || pk_adversario.getEspecie().getTipo1() == Tipo.FIRE
                    || pk_adversario.getEspecie().getTipo1() == Tipo.ICE)
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.FIGHTING || pk_adversario.getEspecie().getTipo1() == Tipo.GROUND)
                return 0.5;
        }
         else if(this.tipo == Tipo.BUG){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.POISON || pk_adversario.getEspecie().getTipo1() == Tipo.GRASS || pk_adversario.getEspecie().getTipo1() == Tipo.PSYCHIC
                    )
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.FIGHTING || pk_adversario.getEspecie().getTipo1() == Tipo.FLYING || pk_adversario.getEspecie().getTipo1() == Tipo.GHOST
                    || pk_adversario.getEspecie().getTipo1() == Tipo.FIRE)
                return 0.5;
        }
        else if(this.tipo == Tipo.GHOST){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.GHOST)
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.NORMAL || pk_adversario.getEspecie().getTipo1() == Tipo.PSYCHIC )
                return 0.0;
        }
        else if(this.tipo == Tipo.FIRE){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.BUG ||pk_adversario.getEspecie().getTipo1() == Tipo.GRASS || pk_adversario.getEspecie().getTipo1() == Tipo.ICE)
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.ROCK || pk_adversario.getEspecie().getTipo1() == Tipo.FIRE || pk_adversario.getEspecie().getTipo1() == Tipo.WATER
                    || pk_adversario.getEspecie().getTipo1() == Tipo.DRAGON)
                return 0.5;
        }
        else if(this.tipo == Tipo.WATER){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.GROUND ||pk_adversario.getEspecie().getTipo1() == Tipo.ROCK || pk_adversario.getEspecie().getTipo1() == Tipo.FIRE)
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.WATER || pk_adversario.getEspecie().getTipo1() == Tipo.GRASS
                    || pk_adversario.getEspecie().getTipo1() == Tipo.DRAGON)
                return 0.5;
        }
        else if(this.tipo == Tipo.GRASS){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.GROUND ||pk_adversario.getEspecie().getTipo1() == Tipo.ROCK || pk_adversario.getEspecie().getTipo1() == Tipo.WATER)
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.FLYING || pk_adversario.getEspecie().getTipo1() == Tipo.POISON
                    || pk_adversario.getEspecie().getTipo1() == Tipo.BUG || pk_adversario.getEspecie().getTipo1() == Tipo.FIRE || pk_adversario.getEspecie().getTipo1() == Tipo.GRASS
                    || pk_adversario.getEspecie().getTipo1() == Tipo.DRAGON)
                return 0.5;
        }
        else if(this.tipo == Tipo.ELETRIC){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.FLYING ||pk_adversario.getEspecie().getTipo1() == Tipo.WATER )
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.GRASS || pk_adversario.getEspecie().getTipo1() == Tipo.ELETRIC
                    || pk_adversario.getEspecie().getTipo1() == Tipo.DRAGON)
                return 0.5;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.GROUND )
                return 0;
        }
        else if(this.tipo == Tipo.PSYCHIC){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.FIGHTING ||pk_adversario.getEspecie().getTipo1() == Tipo.POISON )
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.PSYCHIC )
                return 0.5;
        }
        else if(this.tipo == Tipo.ICE){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.FLYING ||pk_adversario.getEspecie().getTipo1() == Tipo.GROUND ||pk_adversario.getEspecie().getTipo1() == Tipo.GRASS
                    ||pk_adversario.getEspecie().getTipo1() == Tipo.DRAGON)
                return 2;
            else if(pk_adversario.getEspecie().getTipo1() == Tipo.WATER ||pk_adversario.getEspecie().getTipo1() == Tipo.ICE )
                return 0.5;
        }
        else if(this.tipo == Tipo.DRAGON){
            if(pk_adversario.getEspecie().getTipo1() == Tipo.DRAGON )
                return 2;
        }
        
            
        return 1.0;
    }
    
    public boolean calculoAcerto(Pokemon pk_usuario, Pokemon pk_adversario){
        double prob = this.accuracy * (pk_usuario.getModifierAccuracy()/pk_adversario.getModifierEvasion());
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the ppMax
     */
    public double getPpMax() {
        return ppMax;
    }

    /**
     * @param ppMax the ppMax to set
     */
    public void setPpMax(double ppMax) {
        this.ppMax = ppMax;
    }

    /**
     * @return the ppAtual
     */
    public double getPpAtual() {
        return ppAtual;
    }

    /**
     * @param ppAtual the ppAtual to set
     */
    public void setPpAtual(double ppAtual) {
        this.ppAtual = ppAtual;
    }

    /**
     * @return the power
     */
    public double getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * @return the accuracy
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * @param accuracy the accuracy to set
     */
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Ataque))
            return false;
        
        Ataque a = (Ataque) obj;
        if(this.id != a.getId())
            return false;
        
        return true;
    }
   
}
