/**
 *
 * @author juangalvis
 */
public class MainBinario {
  
    private Nodo Punta;
    
    //MÉTODO CONSTRUIR ÁRBOL
    public void ConstruirArbol (char[] Cadena, Nodo R)
    {
        Punta = R;
        int Punt = 1;
        Nodo Puntero = R;
        Nodo PunteroAux = null;
        
        while( Punt != Cadena.length)
        {   
            Puntero = R;
            
            if(Cadena[Punt] > Puntero.getDato() )
            {
                if(Puntero.getLD() == null)
                {
                    PunteroAux = new Nodo(Cadena[Punt]);
                    Puntero.setLD(PunteroAux);
                
                }else
                {
                    while(Puntero.getLD() != null && Puntero.getDato() < Cadena[Punt])
                    {
                        Puntero = Puntero.getLD();
                    }
                    
                    if(Puntero.getDato() < Cadena[Punt])
                    {
                        PunteroAux = new Nodo(Cadena[Punt]);
                        Puntero.setLD(PunteroAux);
                    }else
                    {
                        while(Puntero.getLI() != null && Puntero.getDato() > Cadena[Punt])
                        {
                            Puntero = Puntero.getLI();  
                        }
                        
                        if(Puntero.getDato() > Cadena[Punt])
                        {
                            PunteroAux = new Nodo(Cadena[Punt]);
                            Puntero.setLI(PunteroAux);  
                        }else
                        {
                            PunteroAux = new Nodo(Cadena[Punt]);
                            Puntero.setLD(PunteroAux);  
                        }
                        
                        
                        PunteroAux = new Nodo(Cadena[Punt]);
                        Puntero.setLI(PunteroAux);
                    }
                    
                    
                }
            }else
            {
                if(Puntero.getLI() == null)
                {
                    PunteroAux = new Nodo(Cadena[Punt]);
                    Puntero.setLI(PunteroAux);
                }else
                {
                    while(Puntero.getLI() != null && Puntero.getDato() > Cadena[Punt])
                    {
                        Puntero = Puntero.getLI();  
                    }
                        
                    if(Puntero.getDato() > Cadena[Punt])
                    {
                        PunteroAux = new Nodo(Cadena[Punt]);
                        Puntero.setLI(PunteroAux);
                    }else
                    {
                        while(Puntero.getLD() != null && Puntero.getDato() < Cadena[Punt])
                        {
                            Puntero = Puntero.getLD();  
                        }
                        
                        if(Puntero.getDato() > Cadena[Punt])
                        {
                            PunteroAux = new Nodo(Cadena[Punt]);
                            Puntero.setLI(PunteroAux);  
                        }else
                        {
                            PunteroAux = new Nodo(Cadena[Punt]);
                            Puntero.setLD(PunteroAux);  
                        }
                    }
                    
                }
            }
            Punt++;
        }
    }
    
    //MÉTODO MOSTRAR INORDEN
    public void MostrarInorden(Nodo Padre)
    {
        if(Padre != null)
        {
            MostrarInorden(Padre.getLI());
            System.out.println("|"+ Padre.getDato()+"|");
            MostrarInorden(Padre.getLD());
        }
    }
    
    /* ARREGLAR ESTOS DOS MÉTODOS */
    
    public void MostrarPreorden(Nodo Padre)
    {
        if(Padre != null)
        {
            System.out.println("|"+ Padre.getDato()+"|");
            MostrarPreorden(Padre.getLI());
            MostrarPreorden(Padre.getLD());
        }
    }
    
    public void MostrarPostorden(Nodo Padre)
    {
        if(Padre != null)
        {
            MostrarPostorden(Padre.getLI());
            MostrarPostorden(Padre.getLD());
            System.out.println("|"+ Padre.getDato()+"|");
        }
    }

    public MainBinario(Nodo Punta) {
        this.Punta = Punta;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }
    
    
}
