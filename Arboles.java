/**
 * @author juangalvis
 */
import java.util.Scanner;

public class Arboles {
    
    public static void Menu1()
    {
        System.out.println("ÁRBOLES");
        System.out.println("-----------------");
        System.out.println("[1] BINARIO");
        System.out.println("[2] SALIR");
        System.out.println("-----------------");
        System.out.println("Opción: ");
    }
    
    public static void Menu2()
    {
        System.out.println("ÁRBOLES BINARIOS");
        System.out.println("-----------------");
        System.out.println("[1] MOSTRAR INORDEN");
        System.out.println("[2] MOSTRAR PREORDEN");
        System.out.println("[3] MOSTRAR POSTORDEN");
        System.out.println("-----------------");
        System.out.println("[4] MOSTRAR HOJAS");
        System.out.println("[5] MOSTRAR PADRES");
        System.out.println("[6] NIVEL DE UN REGISTRO");
        System.out.println("[7] MOSTRAR HERMANOS");
        System.out.println("[8] PADRES Y ANCESTROS");
        System.out.println("[9] MOSTRAR PRIMOS");
        System.out.println("[10] MOSTRAR REGISTRO");
        System.out.println("-----------------");
        System.out.println("[11] SALIR");
    }
    
    public static void main(String[] args) {
        
        MainBinario Arbol = new MainBinario(null);
        Scanner sc = new Scanner(System.in);
        Scanner date = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        int opc1 = 0;
        int opc2 = 0;
        int opc3 = 0;
        
        System.out.println("DIGITE LA CADENA: ");
        String Cadena = sc.nextLine();
        char[] Caracter = Cadena.toCharArray();        
        // PADRE
        Nodo R = new Nodo(Caracter[0]);
        
        do
        {
            Menu1();
            opc1 = in1.nextInt();
            switch(opc1)
            {
                case 1: 
                    
                    Arbol.ConstruirArbol(Caracter, R);
                    
                    do
                    {
                        Menu2();
                        opc2 = in2.nextInt();
                        switch(opc2)
                        {
                            case 1: 
                                
                                Arbol.MostrarInorden(R);
                                
                                break;
                                
                            case 2:
                                
                                Arbol.MostrarPreorden(R);
                                
                                break;
                                
                            case 3:
                                
                                Arbol.MostrarPostorden(R);
                                
                                break;
                                
                            case 4:
                                
                                Arbol.MostrarHojas(R);
                                
                                break;   
                                
                            case 5:
                                
                                Arbol.MostrarPadres(R);
                                
                                break;  
                                
                                
                             case 6:
                                
                                 System.out.println("DIGITE EL DATO: ");
                                 char Dato = date.nextLine().charAt(0);
                                 int Nivel = Arbol.MostrarNivel(R, 0, Dato); 
                                 
                                 if(Nivel == 0)
                                 {
                                     System.out.println("Dato no encontrado, sos una locota!");
                                 }else
                                 {
                                     System.out.println("Nivel: "+ Nivel);
                                 } 
                                
                                break; 
                                
                             case 7:
                                
                                 System.out.println("DIGITE EL DATO: ");
                                 char DatoH = date.nextLine().charAt(0);
                                 
                                 Arbol.MostrarHermanos(R, DatoH);
                                
                                break; 
                                
                             case 8:
                                
                                 System.out.println("DIGITE EL DATO: ");
                                 char DatoA = date.nextLine().charAt(0);
                                 
                                 Arbol.Ancestros(R, DatoA);
                                
                                break;
                                
                             case 9:
                                 
                                 System.out.println("DIGITE EL DATO: ");
                                 char DatoPr = date.nextLine().charAt(0);
                                 
                                 Arbol.Primos(R, DatoPr);
                                 
                                 break;
                                
                            default:
                                
                                System.out.println("OPCIÓN INVALIDA");
                                
                                break;
                        }
                        
                    }while(opc2 != 11);
                    
                    break;
                    
                    case 2: 
                    
                        System.out.println("PENDIENTE");
                        
                    break;
            }
            
        
        }while(opc1 != 2);
    }
}
