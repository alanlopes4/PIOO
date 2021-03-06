package pokemon;

/**
 *Classe responsável pelo objeto especie
 * @author Alan e Alisson
 */
public class Especie {
    
    private int id;
    private String  nome;
    private double baseHp;
    private double baseAtk;
    private double baseDef;
    private double baseSpe;
    private double baseSpd;
    
    private Tipo tipo1, tipo2;

    public Especie(){}
    /**
     * Construtor que usa como parâmetros os dados retirados dos arquivos .txt para contruir um objeto do tipo Pokemon
     * @param id
     * @param nome
     * @param tipo1
     * @param tipo2
     * @param baseHp
     * @param baseAtk
     * @param baseDef
     * @param baseSpe
     * @param baseSpd 
     */
    public Especie(int id, String nome, Tipo tipo1, Tipo tipo2, double baseHp, double baseAtk, double baseDef, double baseSpe, double baseSpd) {
        this.id = id;
        this.nome = nome;
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpe = baseSpe;
        this.baseSpd = baseSpd;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }
    
    
    
    /**
     * Retorna os atributos de um pokémon pertencente a espécie descrita, quando está no nível atual
     * @param level
     * @param opcao
     * @return 
     */
    public double calcularAtributo(int level, int opcao){
        
        double retorno = 0.0;
        //cacula o hp
        switch(opcao)
        {
            //calcula hp
            case 1 : retorno = 2 * this.baseHp * level / 100 + level + 10; break;
            //calcula ataque
            case 2 : retorno = 2 * this.baseAtk * level / 100 + 5; break;
            //calcula defesa
            case 3 : retorno = 2 * this.baseDef * level / 100 + 5; break;
            //calcula speed
            case 4 : retorno = 2 * this.baseSpe * level / 100 + 5; break;
            //calcula spd
            case 5 : retorno = 2 * this.baseSpd * level / 100 + 5; break;
                         
        }
        
        return retorno;
    }
    /**
     * 
     * @return id
     */
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(double baseHp) {
        this.baseHp = baseHp;
    }

    public double getBaseAtk() {
        return baseAtk;
    }

    public void setBaseAtk(double baseAtk) {
        this.baseAtk = baseAtk;
    }

    public double getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(double baseDef) {
        this.baseDef = baseDef;
    }

    public double getBaseSpe() {
        return baseSpe;
    }

    public void setBaseSpe(double baseSpe) {
        this.baseSpe = baseSpe;
    }

    public double getBaseSpd() {
        return baseSpd;
    }

    public void setBaseSpd(double baseSpd) {
        this.baseSpd = baseSpd;
    }

    /**
     * @return the tipo1
     */
    public Tipo getTipo1() {
        return tipo1;
    }

    /**
     * @param tipo1 the tipo1 to set
     */
    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    /**
     * @return the tipo2
     */
    public Tipo getTipo2() {
        return tipo2;
    }

    /**
     * @param tipo2 the tipo2 to set
     */
    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }
    
    
    
}
