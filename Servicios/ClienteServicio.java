package Servicios;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteServicio {
    
    Scanner sc =  new Scanner(System.in);
    public ArrayList<Cliente>RegistrarCliente(ArrayList<Cliente> l){

        boolean pedir = true;
        while (pedir) { 
            Cliente c = new Cliente();

            System.out.println("Ingrese el Nombre del Cliente ");
            c.setNombre(sc.next());
            System.out.println("Ingrese la Cedula del Cliente ");
            c.setCedula(sc.nextInt());
            System.out.println("Ingrese el Telefono del Cliente ");
            c.setTelefono(sc.nextInt());

            l.add(c);

            System.out.println("Desea seguir Ingresando 1) Si , 2) No ");
            System.out.println("*************************************************");
            
            int opt = sc.nextInt();
            if (opt == 2) {

            pedir = false;    
                
            }
            
        }
        return  l;

    }
    public ArrayList<Cliente> Modificar (ArrayList<Cliente> l){

        for (Cliente c : l) {
            if (c.getCedula() == Cedula ) {

                System.out.println("Por favor ingrese Ingrese el nombre a a Modificar ");
                c.setNombre(sc.next());
                System.out.println("Por favor Ingrese el Telefono a Modificar ");
                c.setTelefono(sc.next());
            }
            
        }
        return l;
    }
    public ArrayList<Cliente> Eliminar (ArrayList<Cliente> l){

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getCedula() == cedula) {

            l.remove(i);
            }
            
        }
        return l;
    }
}
