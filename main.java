
import Modelos.Cliente;
import Servicios.ClienteServicio;
import java.util.ArrayList;
import java.util.Scanner;


public class main {

   public static void main(String[] args) {

      
    Cliente c = new Cliente();

    ArrayList<Cliente> listaClientes = new ArrayList<>();

    Scanner sc = new Scanner(System.in); 

    int opt;

    while (true) {
        System.out.println("************ GESTION DE CLIENTES *********"); 
        System.out.println("Registrar Cliente ");
        System.out.println("Modificar Cliente ");
        System.out.println("Eliminar Cliente ");
        System.out.println("Salir ");

        opt = sc.nextInt();
        
    }
    switch (opt) {
        case 1:
            
            
            break;
        case 2:
                System.out.println("");
            
            break;    
        default:
            throw new AssertionError();
    }
   }

}