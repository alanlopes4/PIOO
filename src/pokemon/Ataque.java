/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
        //verificar para o tipo2
        else if(this.tipo == Tipo.FIRE  || this.tipo == Tipo.WATER || this.tipo == Tipo.ELETRIC || this.tipo == Tipo.GRASS || this.tipo == Tipo.ICE || this.tipo == Tipo.PSYCHIC || this.tipo == Tipo.DRAGON)
        {
             ataqueUsuario = pk_usuario.getSpe();
             defesaOponete = pk_adversario.getSpe();
        }
        
        if(calculoCritico(pk_usuario.getSpd()))
            pk_usuario.setLevel(pk_usuario.getLevel()*2); 
        
        
        
        if(pk_usuario.getPriStatus() == Status.BURN){
            pk_usuario.setAtk(pk_usuario.getAtk()/2);
            System.out.println("--------------------");
            System.out.println("Status BURN. Ataque reduzido em 50%");
            System.out.println("--------------------");
        }
        
        
        
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
        
        dano *= multiplicadorDanoTipo1( pk_adversario);
        if(pk_adversario.getEspecie().getTipo2() != null)
            dano *= multiplicadorDanoTipo2( pk_adversario);
        
        int r = ThreadLocalRandom.current().nextInt(217, 256);
        dano = (dano * r) / 255;
     
        return dano;
    }
    
    public void comportamentoAtaque(Pokemon pk_usuario, Pokemon pk_adversario, double dano){
        String ans = " ";
        if(pk_usuario.isConfusion()) {
            if(new Random().nextInt(100) < 50) {
                pk_usuario.setHpAtual(pk_usuario.getHpAtual() - dano);
                System.out.println("-------------------- INFORMAÇÃO --------------------");
                System.out.printf("Status CONFUSION. %s do jogador %d causou %.2f dano em si próprio.\n", pk_usuario.getEspecie().getNome(), pk_usuario.getIdentiricadorJogador(), dano);
            } else {
                if(pk_adversario.getHpAtual() - dano <= 0.0) {
                    pk_adversario.setHpAtual(0);
                    pk_adversario.setPriStatus(Status.FAINTED);
                } else {
                    pk_adversario.setHpAtual(pk_adversario.getHpAtual() - dano);
                }
                System.out.println("-------------------- INFORMAÇÃO --------------------");
                System.out.printf("%s do jogador %d causou %.2f em %s do jogador %d\n", pk_usuario.getEspecie().getNome(), pk_usuario.getIdentiricadorJogador(), dano, pk_adversario.getEspecie().getNome(), pk_adversario.getIdentiricadorJogador());
            }
        } else {
            if(pk_adversario.getHpAtual() - dano <= 0.0) {
                pk_adversario.setHpAtual(0);
                pk_adversario.setPriStatus(Status.FAINTED);
            } else {
                pk_adversario.setHpAtual(pk_adversario.getHpAtual() - dano);
            }
            System.out.println("-------------------- INFORMAÇÃO --------------------");
            System.out.printf("%s do jogador %d causou %.2f em %s do jogador %d\n", pk_usuario.getEspecie().getNome(), pk_usuario.getIdentiricadorJogador(), dano, pk_adversario.getEspecie().getNome(), pk_adversario.getIdentiricadorJogador());
        }
        System.out.println("Resultado: ");
        System.out.printf("%s do jogador %d - Hp Atual: %.2f\n", pk_adversario.getEspecie().getNome(), pk_adversario.getIdentiricadorJogador(), pk_adversario.getHpAtual());
        System.out.println("----------------------------------------");
    }
    
    
    public double multiplicadorDanoTipo1(Pokemon pk_adversario){
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
    
    public double multiplicadorDanoTipo2(Pokemon pk_adversario){
        if(this.tipo == Tipo.NORMAL){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.ROCK )
                return 0.5;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.GHOST)
                return 0;
        }
        else if(this.tipo == Tipo.FIGHTING){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.NORMAL || pk_adversario.getEspecie().getTipo2() == Tipo.ROCK || pk_adversario.getEspecie().getTipo2() == Tipo.ICE  )
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.FLYING || pk_adversario.getEspecie().getTipo2() == Tipo.POISON || pk_adversario.getEspecie().getTipo2() == Tipo.BUG
                    || pk_adversario.getEspecie().getTipo2() == Tipo.PSYCHIC)
                return 0.5;
        }
         else if(this.tipo == Tipo.FLYING){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.FIGHTING || pk_adversario.getEspecie().getTipo2() == Tipo.BUG || pk_adversario.getEspecie().getTipo2() == Tipo.GRASS  )
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.ROCK || pk_adversario.getEspecie().getTipo2() == Tipo.ELETRIC )
                return 0.5;
        }
        else if(this.tipo == Tipo.POISON){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.BUG || pk_adversario.getEspecie().getTipo2() == Tipo.GRASS )
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.POISON || pk_adversario.getEspecie().getTipo2() == Tipo.GROUND || pk_adversario.getEspecie().getTipo2() == Tipo.ROCK
                    || pk_adversario.getEspecie().getTipo2() == Tipo.GHOST)
                return 0.5;
        }
        else if(this.tipo == Tipo.GROUND){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.POISON || pk_adversario.getEspecie().getTipo2() == Tipo.ROCK || pk_adversario.getEspecie().getTipo2() == Tipo.FIRE
                    || pk_adversario.getEspecie().getTipo2() == Tipo.ELETRIC)
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.BUG || pk_adversario.getEspecie().getTipo2() == Tipo.GRASS)
                return 0.5;
             else if(pk_adversario.getEspecie().getTipo2() == Tipo.FLYING )
                 return 0;
        }
        else if(this.tipo == Tipo.ROCK){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.FLYING || pk_adversario.getEspecie().getTipo2() == Tipo.BUG || pk_adversario.getEspecie().getTipo2() == Tipo.FIRE
                    || pk_adversario.getEspecie().getTipo2() == Tipo.ICE)
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.FIGHTING || pk_adversario.getEspecie().getTipo2() == Tipo.GROUND)
                return 0.5;
        }
         else if(this.tipo == Tipo.BUG){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.POISON || pk_adversario.getEspecie().getTipo2() == Tipo.GRASS || pk_adversario.getEspecie().getTipo2() == Tipo.PSYCHIC
                    )
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.FIGHTING || pk_adversario.getEspecie().getTipo2() == Tipo.FLYING || pk_adversario.getEspecie().getTipo2() == Tipo.GHOST
                    || pk_adversario.getEspecie().getTipo2() == Tipo.FIRE)
                return 0.5;
        }
        else if(this.tipo == Tipo.GHOST){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.GHOST)
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.NORMAL || pk_adversario.getEspecie().getTipo2() == Tipo.PSYCHIC )
                return 0.0;
        }
        else if(this.tipo == Tipo.FIRE){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.BUG ||pk_adversario.getEspecie().getTipo2() == Tipo.GRASS || pk_adversario.getEspecie().getTipo2() == Tipo.ICE)
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.ROCK || pk_adversario.getEspecie().getTipo2() == Tipo.FIRE || pk_adversario.getEspecie().getTipo2() == Tipo.WATER
                    || pk_adversario.getEspecie().getTipo2() == Tipo.DRAGON)
                return 0.5;
        }
        else if(this.tipo == Tipo.WATER){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.GROUND ||pk_adversario.getEspecie().getTipo2() == Tipo.ROCK || pk_adversario.getEspecie().getTipo2() == Tipo.FIRE)
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.WATER || pk_adversario.getEspecie().getTipo2() == Tipo.GRASS
                    || pk_adversario.getEspecie().getTipo2() == Tipo.DRAGON)
                return 0.5;
        }
        else if(this.tipo == Tipo.GRASS){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.GROUND ||pk_adversario.getEspecie().getTipo2() == Tipo.ROCK || pk_adversario.getEspecie().getTipo2() == Tipo.WATER)
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.FLYING || pk_adversario.getEspecie().getTipo2() == Tipo.POISON
                    || pk_adversario.getEspecie().getTipo2() == Tipo.BUG || pk_adversario.getEspecie().getTipo2() == Tipo.FIRE || pk_adversario.getEspecie().getTipo2() == Tipo.GRASS
                    || pk_adversario.getEspecie().getTipo2() == Tipo.DRAGON)
                return 0.5;
        }
        else if(this.tipo == Tipo.ELETRIC){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.FLYING ||pk_adversario.getEspecie().getTipo2() == Tipo.WATER )
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.GRASS || pk_adversario.getEspecie().getTipo2() == Tipo.ELETRIC
                    || pk_adversario.getEspecie().getTipo2() == Tipo.DRAGON)
                return 0.5;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.GROUND )
                return 0;
        }
        else if(this.tipo == Tipo.PSYCHIC){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.FIGHTING ||pk_adversario.getEspecie().getTipo2() == Tipo.POISON )
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.PSYCHIC )
                return 0.5;
        }
        else if(this.tipo == Tipo.ICE){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.FLYING ||pk_adversario.getEspecie().getTipo2() == Tipo.GROUND ||pk_adversario.getEspecie().getTipo2() == Tipo.GRASS
                    ||pk_adversario.getEspecie().getTipo2() == Tipo.DRAGON)
                return 2;
            else if(pk_adversario.getEspecie().getTipo2() == Tipo.WATER ||pk_adversario.getEspecie().getTipo2() == Tipo.ICE )
                return 0.5;
        }
        else if(this.tipo == Tipo.DRAGON){
            if(pk_adversario.getEspecie().getTipo2() == Tipo.DRAGON )
                return 2;
        }
        return 1.0;
    }
    
    
    public boolean calculoAcerto(Pokemon pk_usuario, Pokemon pk_adversario){
        if(pk_usuario.getPriStatus() == Status.FROZEN || pk_usuario.getPriStatus() == Status.SLEEP || pk_usuario.isFlinch()){
            System.out.println("Ataque nao pode ser realizado! Status do pokemon é "+ (pk_usuario.isFlinch()? "FLINCH" : pk_usuario.getPriStatus()));
            return false;
        }else{
            double prob = this.accuracy * (getModifier(getModifier(pk_usuario.getModifierAccuracy())/getModifier(pk_adversario.getModifierEvasion())));
            if(pk_usuario.getPriStatus() == Status.PARALYSIS){
                System.out.println("Status: PARALYSIS, probabilidade de acerto reduzia em 25%");
                prob -= 25;
            }
        Random random = new Random();
        return (random.nextInt(100) < prob);
        }
        
    }
    
    public static int getModifier(int mod) {
        switch(mod){
            case -6:
                return 33;
            case -5:
                return 37;
            case -4:
                return 43;
            case -3:
                return 50;
            case -2:
                return 60;
            case -1:
                return 75;
            case 0:
                return 100;
            case 1:
                return 133;
            case 2:
                return 166;
            case 3:
                return 200;
            case 4:
                return 233;
            case 5:
                return 266;
            case 6:
                return 300;
            default:
                return 1;
        }
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
