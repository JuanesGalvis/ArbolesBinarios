/**
 *
 * @author juangalvis
 */
public class Nodo {
    
    private char dato;
    private Nodo LD;
    private Nodo LI;

    public Nodo(char dato) {
        this.dato = dato;
        this.LD = null;
        this.LI = null;
    }
    
    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getLD() {
        return LD;
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }

    public Nodo getLI() {
        return LI;
    }

    public void setLI(Nodo LI) {
        this.LI = LI;
    }
    
    
}
