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
    
    //verificar
    public  boolean calculoCritico(double spd){
        
        double retorno = spd / 512;
        
        return true;
    }
    
    public boolean calculoDano(int level, Pokemon usuario, Pokemon oponente, String tipo){
        double ataqueUsuario = 0.0, defesaOponete = 0.0;
        if(tipo.equals("Normal") || tipo.equals("Fighting") || tipo.equals("Flying") || tipo.equals("Ground") || tipo.equals("Rock") || tipo.equals("Bug") || tipo.equals("Ghost") || tipo.equals("Poison"))
        {
            ataqueUsuario = usuario.getAtk();
            defesaOponete = oponente.getDef();
        }
        else if(tipo.equals("Fire") || tipo.equals("Water") || tipo.equals("Electric") || tipo.equals("Grass") || tipo.equals("Ice") || tipo.equals("Psychic") || tipo.equals("Dragon"))
        {
             ataqueUsuario = usuario.getSpe();
             defesaOponete = oponente.getSpe();
        }
        
        if(calculoCritico(usuario.getSpd()))
        {
            level *= 2;
        }
        else
        {
            ataqueUsuario /= 2;
        }
        
        return true;
    }
    
    public boolean calculoAcerto(){
        return true;
    }
}
