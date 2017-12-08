/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import ataques.AtaqueCharge;
import ataques.AtaqueFixo;
import ataques.AtaqueHP;
import ataques.AtaqueModifier;
import ataques.AtaqueMultihit;
import ataques.AtaqueStatus;
import java.util.ArrayList;
import util.Leitor;

/**
 *
 * @author sylar
 */
public class Batalha {
    
    private Jogador jogador1, jogador2;
    private ArrayList<Especie> especies = new ArrayList<Especie>();
    private ArrayList<AtaqueHP> ataquesHP = new ArrayList<AtaqueHP>();
    private ArrayList<AtaqueMultihit> ataquesMultihit = new ArrayList<AtaqueMultihit>();
    private ArrayList<AtaqueModifier> ataquesModifier = new ArrayList<AtaqueModifier>();
    private ArrayList<AtaqueFixo> ataquesFixo = new ArrayList<AtaqueFixo>();
    private ArrayList<AtaqueStatus> ataquesStatus = new ArrayList<AtaqueStatus>();
    private ArrayList<AtaqueCharge> ataquesCharge= new ArrayList<AtaqueCharge>();
    private ArrayList<Ataque> ataquesComum = new ArrayList<Ataque>();
    
    
    
    public void carregarTabelas(){
        try{
            this.especies = Leitor.leitorEspecies();
            Leitor leitor = new Leitor();
            leitor.leitorAtaques();
            this.ataquesHP = leitor.getAtaquesHP();
            this.ataquesMultihit = leitor.getAtaquesMultihit();
            this.ataquesModifier = leitor.getAtaquesModifier();
            this.ataquesFixo = leitor.getAtaquesFixo();
            this.ataquesStatus = leitor.getAtaquesStatus();
            this.ataquesCharge = leitor.getAtaquesCharge();
            this.ataquesComum = leitor.getAtaquesComum();
            
        }catch(Exception e){
            System.out.println("Erro:"+e);
        }
        
    }
    
    public void inicializarJogador(){
        
    }
    
    public void executarturno(){
        
    }

    /**
     * @return the jogador1
     */
    public Jogador getJogador1() {
        return jogador1;
    }

    /**
     * @param jogador1 the jogador1 to set
     */
    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    /**
     * @return the jogador2
     */
    public Jogador getJogador2() {
        return jogador2;
    }

    /**
     * @param jogador2 the jogador2 to set
     */
    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }
    
    
}
