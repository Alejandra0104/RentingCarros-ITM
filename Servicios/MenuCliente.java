package Servicios;

import Modelos.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCliente {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ClienteServicio servicios = new  ClienteServicio();
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    boolean pedir = true; 
    while (pedir) { 
        System.out.println("Bienvenidos a Gestion de clientes ");
        System.out.println("Que opcion deseas Ingresar ");
        System.out.println("1.Registrar Cliente");
        System.out.println("2.Modificar cliente");
        System.out.println("3.Eliminar cliente");
        System.out.println("4.Buscar cliente ");
        System.out.println("Volver al menu principal");
        
        System.out.println("Ingrese la opcion que deseas realizar");
        int opt = sc.nextInt();
        
        switch (opt) {
            case 1:
                listaCliente = servicios.RegistrarCliente(listaCliente);

                break;
            case 2:
                listaCliente = servicios.Modificar(listaCliente);
                break;
            case 3:
                listaCliente = servicios.Eliminar(listaCliente);
                break;  
            case 4:
                servicios.Consultar(listaCliente);
                break;      

            default:
                System.out.println("Esta opcion no es valida ");
                
        }
        
    }
}
    


    
}
