/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execao;

/**
 *
 * @author ALISSON
 */
public class ExcecaoPokemon extends Exception{
    
    private String erro;
    
    public ExcecaoPokemon(String msg)
    {      
        super("ExceçãoPokemon: " + msg);
        this.erro = "ExceçãoPokemon: " + msg;
    }
    
    public ExcecaoPokemon(String msg, Throwable causa)
    {
        super("ExceçãoPokemon: " + msg, causa);
    }
    
    public String getErro()
    {
        return this.erro;
    }
    
}
