package amm.milestone3.eccezioni;

/**
 *
 * @author ricca
 */
public class NoMatchesFound extends RuntimeException {
    
    public NoMatchesFound(){
    System.out.println("Nessuna corrispondeza trovata.");
    }
    
}