package pokemon;


/**
 *
 * @author Alan e Alisson
 */
public class Maquina extends Jogador{
    
    /**
     * Responsável pela definição dos comandos da Maquina
     * Caso deseja trocar de pokémon ou atacar o adversário
     */
    @Override
    public void escolherComando(){
        int n = 0;
        if(super.getTime().size()==1){
            n = 2;
        }else
        {
        //escolher o ataque aleatoriamente
        double escolha = 1 + Math.random() * 2;
         n = (int) escolha;
        }
        System.out.println("Computador escolheu comando "+n);
        super.setComandoEscolhido(n);
        //Ataque ataqueEscolhido = super.getTime().get(0).getAtaque().get(escolha);
                
    }
}
