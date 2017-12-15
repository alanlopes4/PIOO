package pokemon;

import java.util.Scanner;

/**
 * Classe respoonsável pelo jogador humano
 * 
 * @author Alan e Alisson
 */
public class Humano extends Jogador{
    
       
    /**
     * Responsável pela definição dos comandos do Humano
     * Caso deseja trocar de pokémon ou atacar o adversário
     */
    @Override
    public void escolherComando(){
        int escolha = 0;
        do{
            System.out.println("Escolha dos comandos:");
            System.out.println("1 - Troca e 2 - Ataque?");
            Scanner opcao = new Scanner(System.in);
            escolha = opcao.nextInt();
            if(super.getTime().size()<=1 && escolha == 1)
                System.out.println("Não é possível trocar, possui apenas 1 pokemon");
        }while(super.getTime().size() <=1 && escolha == 1);
        super.setComandoEscolhido(escolha);
        
        
    }
}
