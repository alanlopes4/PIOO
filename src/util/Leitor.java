/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import ataques.AtaqueCharge;
import ataques.AtaqueFixo;
import ataques.AtaqueHP;
import ataques.AtaqueModifier;
import ataques.AtaqueMultihit;
import ataques.AtaqueStatus;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import pokemon.Ataque;
import pokemon.Especie;
import pokemon.Status;
import pokemon.Tipo;

/**
 *
 * @author sylar
 */
public class Leitor {
    
    private    ArrayList<AtaqueHP> ataquesHP = new ArrayList<AtaqueHP>();
    private    ArrayList<AtaqueMultihit> ataquesMultihit = new ArrayList<AtaqueMultihit>();
    private    ArrayList<AtaqueModifier> ataquesModifier = new ArrayList<AtaqueModifier>();
    private    ArrayList<AtaqueFixo> ataquesFixo = new ArrayList<AtaqueFixo>();
    private    ArrayList<AtaqueStatus> ataquesStatus = new ArrayList<AtaqueStatus>();
    private    ArrayList<AtaqueCharge> ataquesCharge= new ArrayList<AtaqueCharge>();
    private    ArrayList<Ataque> ataquesComum = new ArrayList<Ataque>();
    
    
    public static void main (String[]args){
        
        try{
		//leitorAtaques();
                //leitorEspecies();
        }catch(Exception e){
            System.out.println("Erro:"+e);
            System.out.println("Message:"+e.getMessage());
        }
    }
    
    public Leitor(){
            
    }
    
    
    
    public void leitorAtaques(){
        try{
        BufferedReader br = new BufferedReader(new FileReader("/alan/UEM/PPIOO/trabalho/TabelaDeAtaques.txt"));
    
        
        //pulando a leitura da primeira linha
        String linha = br.readLine();
		while(br.ready()){ 
                    linha = br.readLine();
                    String[] param =null;
                    String[] dados = linha.split("\t");
                    
                    switch(dados[6]){
                        case "hp":
                            param = dados[7].trim().split(",");
                            this.ataquesHP.add(new AtaqueHP(Integer.parseInt(dados[0]), dados[1],verificadorTipo(dados[2]), 0.0, Double.parseDouble(dados[3]), 
                                    Double.parseDouble(dados[4]), Double.parseDouble(dados[5]), 0, Double.parseDouble(param[1].trim())));
                            break;
                        case "multihit":
                            param = dados[7].trim().split(",");
                            this.ataquesMultihit.add(new AtaqueMultihit(Integer.parseInt(dados[0]), dados[1],verificadorTipo(dados[2]), 0.0, Double.parseDouble(dados[3]), 
                                    Double.parseDouble(dados[4]), Double.parseDouble(dados[5]), Integer.parseInt(param[0].trim()), Integer.parseInt(param[1].trim())));
                            break;
                        case "modifier":
                            param = dados[7].trim().split(",");
                            this.ataquesModifier.add(new AtaqueModifier(Integer.parseInt(dados[0]), dados[1],verificadorTipo(dados[2]), 0.0, Double.parseDouble(dados[3]), 
                                    Double.parseDouble(dados[4]), Double.parseDouble(dados[5]),0, Integer.parseInt(param[1].trim()), Integer.parseInt(param[2].trim())));
                            break;
                        case "fixo":
                            param = dados[7].trim().split(",");
                            this.ataquesFixo.add(new AtaqueFixo(Integer.parseInt(dados[0]), dados[1],verificadorTipo(dados[2]), 0.0, Double.parseDouble(dados[3]), 
                                    Double.parseDouble(dados[4]), Double.parseDouble(dados[5]), param[0].equals("lvl")?0:Integer.parseInt(param[0].trim())));
                            break;
                        case "status":
                            param = dados[7].trim().split(",");
                            this.ataquesStatus.add(new AtaqueStatus(Integer.parseInt(dados[0]), dados[1],verificadorTipo(dados[2]), 0.0, Double.parseDouble(dados[3]), 
                                    Double.parseDouble(dados[4]), Double.parseDouble(dados[5]), verificarStatus(param[0].trim()), Integer.parseInt(param[1].trim())));
                            break;
                        case "charge":
                            this.ataquesCharge.add(new AtaqueCharge(Integer.parseInt(dados[0]), dados[1],verificadorTipo(dados[2]), 0.0, Double.parseDouble(dados[3]), 
                                    Double.parseDouble(dados[4]), Double.parseDouble(dados[5])));
                            break;
                        default:
                            this.ataquesComum.add(new Ataque(Integer.parseInt(dados[0]), dados[1],verificadorTipo(dados[2]), 0.0, Double.parseDouble(dados[3]), 
                                    Double.parseDouble(dados[4]), Double.parseDouble(dados[5])));
                            break;
                        
                    }
		} 
		br.close(); 
        }catch(Exception e){
            System.out.println("ERRO:"+e);
        }
    }
    
    
    
    public static Status verificarStatus(String status){
        switch(status){
            case "Paralysis":
                return Status.PARALYSIS;
            case "Burn":
                return Status.BURN;
            case "Flinch":
                return Status.FLINCH;
            case "Confusion":
                return Status.CONFUSION;
            case "Poison":
                return Status.POISON;
            case "Sleep":
                return Status.SLEEP;
            case "Frozen":
                return Status.FROZEN;
            case "Fainted":
                return Status.FAINTED;
            default:
                return Status.OK;
        }
    }
    
    public static ArrayList<Especie> leitorEspecies() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("/alan/UEM/PPIOO/trabalho/TabelaDeEspecies.txt")); 
        ArrayList<Especie> especies = new ArrayList<Especie>();
        String linha = br.readLine(); 
        Tipo tipo1 =  Tipo.NONE, tipo2 = Tipo.NONE;
		while(br.ready()){ 
                    linha = br.readLine();
                    String[] dados = linha.split("\t");
                    
                    especies.add(new Especie(Integer.parseInt(dados[0]),dados[1],verificadorTipo(dados[2]), verificadorTipo(dados[3]), 
                            Double.parseDouble(dados[4]),Double.parseDouble(dados[5]), Double.parseDouble(dados[6]), Double.parseDouble(dados[7]),
                            Double.parseDouble(dados[8])));
                    
		} 
		br.close(); 
        return especies;
    }
    
    
    
    public static Tipo verificadorTipo(String tipo){
        switch(tipo){
            case "Grass":
                return Tipo.GRASS;
            case "Poison":
                return Tipo.POISON;
            case "Fire":
                return Tipo.FIRE;
            case "Flying":
                return Tipo.FLYING;
            case "Water":
                return Tipo.WATER;
            case "Bug":
                return Tipo.BUG;
            case "Normal":
                return Tipo.NORMAL;
            case "Electric":
                return Tipo.ELETRIC;
            case "Ground":
                return Tipo.GROUND;
            case "Fighting":
                return Tipo.FIGHTING;
            case "Psychic":
                return Tipo.PSYCHIC;
            case "Rock":
                return Tipo.ROCK;
            case "Ice":
                return Tipo.ICE;
            case "Ghost":
                return Tipo.GHOST;
            case "Dragon":
                return Tipo.DRAGON;
            default:
                return Tipo.NONE;
            
        }
    }

    public ArrayList<AtaqueHP> getAtaquesHP() {
        return ataquesHP;
    }

    public ArrayList<AtaqueMultihit> getAtaquesMultihit() {
        return ataquesMultihit;
    }

    public ArrayList<AtaqueModifier> getAtaquesModifier() {
        return ataquesModifier;
    }

    public ArrayList<AtaqueFixo> getAtaquesFixo() {
        return ataquesFixo;
    }

    public ArrayList<AtaqueStatus> getAtaquesStatus() {
        return ataquesStatus;
    }

    public ArrayList<AtaqueCharge> getAtaquesCharge() {
        return ataquesCharge;
    }

    public ArrayList<Ataque> getAtaquesComum() {
        return ataquesComum;
    }
    
    
    
    
}
