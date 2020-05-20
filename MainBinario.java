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

    public void MostrarHojas(Nodo Padre)
    {
        if(Padre != null)
        {
            MostrarHojas(Padre.getLI());
            if( Padre.getLD() == null && Padre.getLI() == null){
                
                System.out.println("|"+ Padre.getDato()+"|");
            }
            MostrarHojas(Padre.getLD());
        }
    }
    
    public void MostrarPadres(Nodo Padre)
    {
        if(Padre != null)
        {
            MostrarHojas(Padre.getLI());
            if( Padre.getLD() != null || Padre.getLI() != null){
                
                System.out.println("|"+ Padre.getDato()+"|");
            }
            MostrarHojas(Padre.getLD());
        }
    }
    
    public int MostrarNivel(Nodo Padre, int contador ,char Dato)
    {
        while(Padre != null)
        {
            contador++;
            if(Padre.getDato() == Dato)
            {
                return contador;
            }
            
            if(Padre.getDato() > Dato)
            {
                Padre = Padre.getLI();
            }else
            {
                Padre = Padre.getLD();
            }
        }
        
        return 0;
    }
    
    public boolean ValidarRegistro(Nodo Padre , char Dato)
    {
        while(Padre != null)
        {
            if(Padre.getDato() == Dato)
            {
                return true;
            }
            
            if(Dato < Padre.getDato()){
                
                Padre= Padre.getLI();
            
            }else{
                
                Padre= Padre.getLD();
            }
           
        }
        
        return false;
        
    }
    
    public void MostrarHermanos(Nodo Padre, char Dato)
    {
        Nodo q = Padre;
        boolean Bandera = false;
        if(Dato == Padre.getDato())
        {
            
            System.out.println("No tiene hermanos!");
            
        }else 
        {
            if(Dato < Padre.getDato())
            {
                q = q.getLI();
            }else
            {
                q = q.getLD();
            }
            
            Padre = q;
            q = q.getLI();
            
            if(ValidarRegistro(Padre, Dato))
            {
                
                while(!Bandera)
                {

                    while (q.getLD() != null && q.getDato() < Dato) {
                        Padre = q;
                        q = q.getLD();
                    }

                    while (q.getLI() != null && q.getDato() > Dato) {
                        Padre = q;
                        q = q.getLI();
                    }

                    if(q.getDato() == Dato)
                    {
                        if(Padre.getLD() == q && Padre.getLI() != null)
                        {
                            System.out.println("EL HERMANO DE "+ Dato +" es: "+Padre.getLI().getDato());
                            Bandera = true;
                        }else if( Padre.getLI() == q && Padre.getLD() != null )
                        {
                            System.out.println("EL HERMANO DE "+ Dato +" es: "+Padre.getLD().getDato());
                            Bandera = true;
                        }else
                        {
                            System.out.println("NO TIENE HERMANOS :(");
                            Bandera = true;
                        }
                    }
                }
                
            }else
            {
                System.out.println("ESTE DATO NO EXISTE!");
            }
    }
    }
    
    public void Ancestros(Nodo Padre, char Dato)
    {
        Nodo q = Padre;
        String Familia = "";
        boolean Bandera = false;
        
        if(ValidarRegistro(Padre, Dato))
        {
            
            if(Padre.getDato() == Dato)
            {
                System.out.println("No tiene ancestros!");
            
            }else 
            {
                if(Dato < Padre.getDato())
                {
                    q = q.getLI();
                }else
                {
                    q = q.getLD();
                }

                Padre = q;
                q = q.getLI();

                if(ValidarRegistro(Padre, Dato))
                {

                    while(!Bandera)
                    {

                        while (q.getLD() != null && q.getDato() < Dato) {
                            Padre = q;
                            q = q.getLD();
                            Familia += Padre.getDato();
                        }

                        while (q.getLI() != null && q.getDato() > Dato) {
                            Padre = q;
                            q = q.getLI();
                            Familia += Padre.getDato();
                        }

                        if(q.getDato() == Dato)
                        {
                            Familia += Padre.getDato();
                            Bandera = true;
                        }
                    }
                    
                    System.out.println("Ancestro de " + Dato + "son: " + Familia);

                }
            }
        // FIN VALIDAR REGISTROS
        }else
        {
           System.out.println("ESTE DATO NO EXISTE!");
        }
    }
    
    public void Primos(Nodo Padre, char Dato)
    {
       if(ValidarRegistro(Padre, Dato))
       {
           int NivelDato = MostrarNivel(Padre, 0, Dato);
           if(Dato == Padre.getDato())
           {
               System.out.println("Al ser raiz no tiene primos");
           }else
           {
               if(NivelDato == 2)
               {
                   /* SI ES HIJO DE RAIZ (NIVEL = 1) */
                   System.out.println("Al ser hijo de raiz no tiene primos");
               
               }else if(NivelDato == 3)
               {
                   /* PRIMOS PARA REGISTRO EN NIVEL 3 */
                   if(Dato > Padre.getDato())
                    {
                        Padre = Padre.getLI();

                    }else
                    {
                        Padre = Padre.getLD();
                    }
                   
                    System.out.println("PRIMOS: ");
                    if(Padre.getLD() != null)
                    {
                        System.out.println(Padre.getLD().getDato());
                    }
                    
                    if(Padre.getLI() != null)
                    {
                        System.out.println(Padre.getLI().getDato());
                    }
                    
                    if(Padre.getLI() == null && Padre.getLD() == null)
                    {
                        System.out.println("No tiene primos");
                    }
                   
               }else
               {
                   Nodo Abuelo = Padre;
                   int contador = 1;
                   /* MostrarNivel(Padre, 0, Padre.getDato()) !=   */
                   while(contador != NivelDato-1)
                   {
                        while (Padre.getLD() != null && Padre.getDato() < Dato && contador != NivelDato-1) {
                           Abuelo = Padre;
                           Padre = Padre.getLD();
                           contador++;
                        }
                       
                        while (Padre.getLI() != null && Padre.getDato() > Dato && contador != NivelDato-1) {
                           Abuelo = Padre;
                           Padre = Padre.getLI();
                           contador++;
                        }
                   }
                   
                   if(Abuelo.getLD() == Padre && Abuelo.getLI() != null)
                   {
                       Abuelo = Abuelo.getLI();
                       System.out.println("PRIMOS:");
                       if(Abuelo.getLD() != null)
                        {
                            System.out.println(Abuelo.getLD().getDato());
                        }

                        if(Abuelo.getLI() != null)
                        {
                            System.out.println(Abuelo.getLI().getDato());
                        }

                        if(Abuelo.getLI() == null && Abuelo.getLD() == null)
                        {
                            System.out.println("No tiene primos");
                        }
                   
                   }else if(Abuelo.getLI() == Padre && Abuelo.getLD() != null)
                   {
                       Abuelo = Abuelo.getLD();
                       System.out.println("PRIMOS:");
                       if(Abuelo.getLD() != null)
                        {
                            System.out.println(Abuelo.getLD().getDato());
                        }

                        if(Abuelo.getLI() != null)
                        {
                            System.out.println(Abuelo.getLI().getDato());
                        }

                        if(Abuelo.getLI() == null && Abuelo.getLD() == null)
                        {
                            System.out.println("No tiene primos");
                        }
                   }else
                   {
                       System.out.println("NO TIENE TÍO");
                   }
               }
           }
       }else
       {
           System.out.println("ESTE DATO NO EXISTE!");
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
