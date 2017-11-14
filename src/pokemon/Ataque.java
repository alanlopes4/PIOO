/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author sylar
 */
public class Ataque {
    
    private int id;
    private String nome;
    private double ppMax;
    private double ppAtual;
    private double power;
    private double accuracy;
    
    public void efeito(){
        
    }
    
    public  boolean calculoCritico(){
        return true;
    }
    
    public boolean calculoDano(){
        return true;
    }
    
    public boolean calculoAcerto(){
        return true;
    }
}
