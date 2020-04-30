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
        System.out.println("[2] NARIO");
        System.out.println("[3] SALIR");
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
        System.out.println("[4] SALIR");
    }
    
    public static void main(String[] args) {
        
        MainBinario Arbol = new MainBinario(null);
        Scanner sc = new Scanner(System.in);
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
                                
                            default:
                                
                                System.out.println("OPCIÓN INVALIDA");
                                
                                break;
                        }
                        
                    }while(opc2 != 4);
                    
                    break;
                    
                    case 2: 
                    
                        System.out.println("PENDIENTE");
                        
                    break;
            }
            
        
        }while(opc1 != 3);
    }
}
