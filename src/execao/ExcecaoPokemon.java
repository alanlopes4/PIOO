/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execao;

/**
 * Classe responsavel por tratar as exeções.
 * @author Alan e Alisson
 */
public class ExcecaoPokemon extends Exception{
    
    private String erro;
    /**
     * Construtor que usa como paramêtro a mensagem da exceção que ocorreu.
     * @param msg 
     */
    public ExcecaoPokemon(String msg)
    {      
        super("ExceçãoPokemon: " + msg);
        this.erro = "ExceçãoPokemon: " + msg;
    }
    /**
     * Construtor que usa como paramêtro a mensagem da exceção que ocorreu e a causa do mesmo.
     * @param msg
     * @param causa 
     */
    public ExcecaoPokemon(String msg, Throwable causa)
    {
        super("ExceçãoPokemon: " + msg, causa);
    }
    
    public String getErro()
    {
        return this.erro;
    }
    
}
