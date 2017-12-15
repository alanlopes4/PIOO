package pokemon;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import util.Leitor;

/**
 *
 * @author Alan e Alisson
 */
public class Batalha {
    
    private Jogador jogador1, jogador2;
    private ArrayList<Especie> especies = new ArrayList<Especie>();
    private ArrayList<Ataque> ataques = new ArrayList<Ataque>();
    
    
    /**
     * Popula os ArrayList de especies e ataques com os dados retirados dos arquivos .txt
     */
    public void carregarTabelas(){
        try{
            this.especies = Leitor.leitorEspecies();
            this.ataques = Leitor.leitorAtaques();
            
        }catch(Exception e){
            System.out.println("Erro:"+e);
        }
        
    }
    /**
     * Inicializa os jogadores
     * Define qual jogador (Humano ou Computador) o player será
     */
    public void inicializarJogadores(){
        
        Scanner entrada = new Scanner(System.in);
        for(int i = 1; i <= 2; i++)
        {
            System.out.println("Escolha o " + i + "° Jogador:");
            System.out.println("Deseja ser 1 - Humano ou 0 - Computador?"); 
            int escolha = entrada.nextInt();
            while(escolha != 0  && escolha != 1){
                System.out.println("Opção inválida! Por favor, escolha 0 ou 1");
                escolha = entrada.nextInt();
            }
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
        int turno =0;
        while(verificarRodada(jogador1, jogador2)){
            System.out.println("###################### TURNO "+ ++turno +" ######################");
            System.out.println("");
            //Escolha dos comenandos
            System.out.println(" ---------- Jogador " + jogador1.getNome() + " ---------- ");
            showInformacaoTime(jogador1);
            jogador1.escolherComando();
            System.out.println(" ---------- Jogador " + jogador2.getNome() + " ---------- ");
            showInformacaoTime(jogador2);
            jogador2.escolherComando();

            //decide o primeiro a jogar e começa o turno
            primeiroAJogar();
        }
        System.out.println("GAME OVER!! Jogador tal perdeu");
        
    }
    /**
     * Mostra informações sobre o time do jogador, isto é, os pokemons que compõe o time e seus ataques
     * @param jogador 
     */
    public void showInformacaoTime(Jogador jogador)
    {
            System.out.println("############### TIME ############### ");
            ArrayList<Pokemon> time = (ArrayList<Pokemon>) jogador.getTime();
             
            for(Pokemon poke : time)
            {
                ArrayList<Ataque> ataques = (ArrayList<Ataque>) poke.getAtaque();
               System.out.println("");
                System.out.println("Pokemon - " + time.indexOf(poke) + " : " + poke.getEspecie().getNome());
                System.out.println("HP Atual: " + poke.getHpAtual());
                System.out.println("Status: " + poke.getPriStatus());
                System.out.println("Ataques: ");
                for(Ataque atk : ataques )
                {
                    System.out.println("Ataque - " + ataques.indexOf(atk) + " : " + atk.getNome());
                }
            }
             System.out.println("");
            System.out.println("############################## ");
            System.out.println("");
    }
    
    /**
     * Verificar se os pokemons dos jogadores estão todos com o Status FAINTED
     * @param j1
     * @param j2
     * @return 
     */
    public boolean verificarRodada(Jogador j1, Jogador j2){
        ArrayList<Pokemon> pokemons_j1 = (ArrayList)j1.getTime();
        ArrayList<Pokemon> pokemons_j2 = (ArrayList)j2.getTime();
        boolean retorno_j1 = false, retorno_j2 = false;
        Pokemon pkRemover = null;
        for(Pokemon pk : pokemons_j1){
            if(pk.getPriStatus() != Status.FAINTED)
                retorno_j1 = true;  
            else
                pkRemover = pk;
            
        }
        if(pkRemover != null){
            pokemons_j1.remove(pkRemover);
            pkRemover = null;
        }
        for(Pokemon pk : pokemons_j2){
            if(pk.getPriStatus() != Status.FAINTED)
                retorno_j2 = true;
            else
                pkRemover = pk;
        }
        if(pkRemover != null)
            pokemons_j2.remove(pkRemover);
        return (retorno_j1 && retorno_j2);
    }
    
    /**
     * Escolhe os pokemons do jogador e os ataques 
     * @param jogador 
     */
    public void escolherPokemons(Jogador jogador)
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantidade de pokemons:");
        int quantidade = entrada.nextInt();
        while(quantidade >6){
            System.out.println("Quantidade acima de 6, por favor selecione um valor menor");
            System.out.println("Quantidade de pokemons:");
            quantidade = entrada.nextInt();
        }
        
        for(int i = 0; i < quantidade; i++)
        {
            
           
            
            System.out.println( (i + 1) + "° Pokemon:");
            System.out.println("Código do pokemon:");
            int codigo = entrada.nextInt();
            System.out.println("Level do pokemon:");
            int level = entrada.nextInt();
            Especie especie = getEspecies().get(codigo - 1);
            Pokemon pokemon = new Pokemon(especie, level);
            pokemon.setEspecie(getEspecies().get(codigo - 1));
            System.out.println("Pokemon escolhido: "+pokemon.getEspecie().getNome());
            
            
            
            
            for(int j = 0; j < 4; j++)
            {
                System.out.println( (j + 1) + "° Ataque:");
                int codigoAtaque = entrada.nextInt();
                if(codigoAtaque != 0){
                    pokemon.setAtaque(getAtaques().get(codigoAtaque - 1));   
                    System.out.println("Ataque escolhido: "+getAtaques().get(codigoAtaque - 1).getNome());
                }
            }
            
            //adcionando no time o pokemon do 
            pokemon.setIdentiricadorJogador(jogador.getNome());
            jogador.getTime().add(pokemon);
            
            System.out.printf("");
        }
    }
    /**
     * Responsável por executar as rodadas 
     * Define qual ação o jogador deseja executar na rodada
     * Verifica se o jogador deseja trocar o pokemon atual ou atacar o oponente
     * @param usuario
     * @param adversario 
     */
    public void executarturno(Jogador usuario, Jogador adversario){
        if(verificarRodada(usuario, adversario)){
        int opcao = usuario.getComandoEscolhido();
        Scanner entrada = new Scanner(System.in);
        System.out.println(" ---------- Jogador " + usuario.getNome() + " ---------- ");
            //troca
           
            if(opcao == 1)
            {              
                
                if(usuario instanceof Humano){
                    showInformacaoTime(usuario);
                    System.out.println("Informe o código do novo pokemon?"); // 1 a 5
                    int posicaoPokemon = entrada.nextInt();
                    usuario.trocarPokemon(posicaoPokemon);
                }else{
                    
                    if(usuario.getTime().size() >= 3)
                    {
                        usuario.trocarPokemon(ThreadLocalRandom.current().nextInt(1, usuario.getTime().size() - 1)); 
                    }
                    else
                    {
                        usuario.trocarPokemon(1);
                    }
                }

            }
            //ataque
            else if(opcao == 2)
            {
                
                 if(usuario instanceof Humano){
                     System.out.println("Qual ataque será executado?"); // 0 a 3
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
        
        
    }
    
    
    public void verificarComportamentoStatus()
    {
        
    }
    /**
     * 
     */
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
