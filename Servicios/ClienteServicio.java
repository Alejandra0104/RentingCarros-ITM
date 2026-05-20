package Servicios;

import Modelos.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteServicio {
    
    Scanner sc =  new Scanner(System.in);
    public ArrayList<Cliente>RegistrarCliente(ArrayList<Cliente> listaCliente){

        boolean pedir = true;
//Registrar Cliente        
        while (pedir) { 
//Se crea un nuevo objeto Cliente     
            Cliente nuevoCliente = new Cliente();
// Se piden los Datos que se necesitan 
            System.out.println("Ingrese el Nombre del Cliente ");
            nuevoCliente.setNombre(sc.next());
            System.out.println("Ingrese la Cedula del Cliente ");
            nuevoCliente.setCedula(sc.next());
            System.out.println("Ingrese el Telefono del Cliente ");
            nuevoCliente.setTelefono(sc.next());
// Guardar ese cliente dentro de la ArrayList 
            listaCliente.add(nuevoCliente);

// Preguntar si desea continuar 
            System.out.println("Desea seguir Ingresando 1) Si , 2) No ");
            System.out.println("*************************************************");
            
            int opt = sc.nextInt();
            if (opt == 2) {

            pedir = false;    
                
            }
            
        }
        return  listaCliente;

    }
    //Modificar
    public ArrayList<Cliente> Modificar (ArrayList<Cliente> listaCliente){

        System.out.println("************ ACTUALIZAR CLIENTE ****************");

//Recorrer la listaClientes 
        for (Cliente c : listaCliente) {
//Validar si la cedula ya existe             
            if (c.getCedula() == Cedula ) {
// Solicitar nuevos datos
                System.out.println("Por favor ingrese Ingrese el nombre a a Modificar ");
                c.setNombre(sc.next());
                System.out.println("Por favor Ingrese el Telefono a Modificar ");
                c.setTelefono(sc.next());
                System.out.println("Cliente Actualizado con exito ");
            }
            
        }
        return listaCliente;
    }
    //Eliminar
    public ArrayList<Cliente> Eliminar (ArrayList<Cliente> listaCliente){

        System.out.println("********** ELIMINAR CLIENTE ***********");

// Se recorre la listas 
        for (int i = 0; i < listaCliente.size(); i++) {
            //Valida si la cedula ya existe 
            if (listaCliente.get(i).getCedula() == Cedula) {

// Elimina el cliente
            listaCliente.remove(i);
            }
            
        }
        return listaCliente;
    }
}
