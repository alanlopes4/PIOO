/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import util.Leitor;

/**
 *
 * @author sylar
 */
public class Batalha {
    
    private Jogador jogador1, jogador2;
    private ArrayList<Especie> especies = new ArrayList<Especie>();
    private ArrayList<Ataque> ataques = new ArrayList<Ataque>();
    
    
    
    public void carregarTabelas(){
        try{
            this.especies = Leitor.leitorEspecies();
            this.ataques = Leitor.leitorAtaques();
            
        }catch(Exception e){
            System.out.println("Erro:"+e);
        }
        
    }
    
    public void inicializarJogadores(){
        
        Scanner entrada = new Scanner(System.in);
        for(int i = 1; i <= 2; i++)
        {
            System.out.println("Escolha o " + i + "° Jogador:");
            System.out.println("Deseja ser 1 - Humano ou 0 - Computador?"); 
            int escolha = entrada.nextInt();
            if(i == 1)
            {
                //escolha dos jogadores
                if(escolha == 1)
                {
                    jogador1 = new Humano();
                }
                else
                {
                    jogador1 = new Maquina();
                }
                
                //escolha dos pokemons
                jogador1.setNome(1);
                escolherPokemons(jogador1);
                
            }
            else
            {
                if(escolha == 1)
                {
                    jogador2 = new Humano();
                }
                else
                {
                    jogador2 = new Maquina();
                }
                jogador2.setNome(2);
                escolherPokemons(jogador2);
            }
        }
        
        //Escolha dos comenandos
        System.out.println("Primeiro jogador");
        jogador1.escolherComando();
        System.out.println("Segundo jogador");
        jogador2.escolherComando();
        
        //decide o primeiro a jogar e começa o turno
        primeiroAJogar();
        
    }
    
    public void escolherPokemons(Jogador jogador)
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantidade de pokemons:");
        int quantidade = entrada.nextInt();
        for(int i = 0; i < quantidade; i++)
        {
            
            Pokemon pokemon = new Pokemon();
            
            System.out.println( (i + 1) + "° Pokemon:");
            System.out.println("Código do pokemon:");
            int codigo = entrada.nextInt();
            pokemon.setEspecie(getEspecies().get(codigo - 1));
            
            System.out.println("Level do pokemon:");
            int level = entrada.nextInt();
            pokemon.setLevel(level);
            
            
            for(int j = 0; j < 4; j++)
            {
                System.out.println( (j + 1) + "° Ataque:");
                int codigoAtaque = entrada.nextInt();
                if(codigoAtaque != 0)
                    pokemon.setAtaque(getAtaques().get(codigoAtaque - 1));                             
            }
            
            //adcionando no time o pokemon do 
            pokemon.setIdentiricadorJogador(jogador.getNome());
            jogador.getTime().add(pokemon);
        }
    }
    
    public void executarturno(Jogador usuario, Jogador adversario){
        
        int opcao = usuario.getComandoEscolhido();
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Jogador: "+usuario.getNome());
        //troca
        if(opcao == 1)
        {
            System.out.println("Qual pokemon será trocado?"); // 1 a 5
            if(usuario instanceof Humano){
                int posicaoPokemon = entrada.nextInt();
                usuario.trocarPokemon(posicaoPokemon);
            }else{
                usuario.trocarPokemon(ThreadLocalRandom.current().nextInt(1, usuario.getTime().size() - 1));
            }
            
        }
        //ataque
        else if(opcao == 2)
        {
            System.out.println("Qual ataque será executado?"); // 0 a 3
             if(usuario instanceof Humano){
                int posicaoAtaque = entrada.nextInt();
                usuario.usarAtaque(posicaoAtaque, usuario.getTime().get(0), adversario.getTime().get(0));
             }
             else
             {
                 if(usuario.getTime().size() == 1)
                        usuario.usarAtaque(0, usuario.getTime().get(0), adversario.getTime().get(0));
                 else
                        usuario.usarAtaque(ThreadLocalRandom.current().nextInt(0, usuario.getTime().size() - 1), usuario.getTime().get(0), adversario.getTime().get(0));
             }
            
        }
        else
        {
           System.out.println("Opção invalida!"); 
        }
    }
    
    //verificar o comportamento dos status
    public void verificarComportamentoStatus()
    {
        
    }
    
    public void primeiroAJogar()
    {
        
        //escolheu comando trocar pokemon
        if(this.jogador1.getComandoEscolhido() == 1)
        {
            executarturno(jogador1, jogador2);
            executarturno(jogador2, jogador1);
        }
        else if(this.jogador2.getComandoEscolhido() == 1)
        {
           executarturno(jogador2, jogador1);
           executarturno(jogador1, jogador2); 
        }
        else
        {
            double spd1 = jogador1.getTime().get(0).getSpd();
            double spd2 = jogador2.getTime().get(0).getSpd();
            
            if(spd1 > spd2)
            {
                executarturno(jogador1, jogador2);
                executarturno(jogador2, jogador1); 
            }
            else
            {
                executarturno(jogador2, jogador1);
                executarturno(jogador1, jogador2); 
            }
            
        }
        
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

    public ArrayList<Especie> getEspecies() {
        return especies;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }
    
    
    
    
}
