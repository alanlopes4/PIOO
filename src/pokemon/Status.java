package pokemon;

/**
 *  Enum utilizado para representar os Status dos pokemons
 * @author Alan e Alisson
 */
public enum Status {
    OK("Ok"),
    FAINTED("Fainted "), 
    BURN("Burn"), 
    FROZEN("Frozen"), 
    PARALYSIS("Paralysis"), 
    POISON("Poison"), 
    SLEEP("Sleep"),
    CONFUSION(false),
    FLINCH(false);
    
    private String status;
    private boolean statusSecundario;

    private Status(String status) {
        this.status = status;
    }
    
    private Status (boolean status)
    {
        this.statusSecundario = status;
    }

    /**
     * @return the status
     */
    public String getStatusPrimario() {
        return status;
    }
    
    /**
     * @return the status
     */
    public boolean getStatusSecundario() {
        return statusSecundario;
    }
    
    
    
    
    
}
