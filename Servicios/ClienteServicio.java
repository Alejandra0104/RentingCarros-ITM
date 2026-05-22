package Servicios;

import Modelos.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteServicio {
    
    Scanner sc =  new Scanner(System.in);
    public ArrayList<Cliente>RegistrarCliente(ArrayList<Cliente> listaCliente){

        boolean pedir = true, valido = true ;
       //Registrar Cliente        
        while (pedir) { 
            //Se crea un nuevo objeto Cliente     
            Cliente nuevoCliente = new Cliente();
            // Se piden los Datos que se necesitan 

            //valido cédula
            while (valido) {

                valido = false;

                System.out.print("Ingrese la cedula del cliente: ");
                nuevoCliente.setCedula(sc.nextLine());

                for (Cliente c : listaCliente) {

                    if (c.getCedula().equalsIgnoreCase(nuevoCliente.getCedula())) {

                        System.out.println("El cliente ya existe ");

                        valido = true;
                    }
                }
            }
            System.out.println("Ingrese el Nombre del Cliente ");
            nuevoCliente.setNombre(sc.nextLine());
            System.out.println("Ingrese el Apellido del Cliente ");
            nuevoCliente.setApellido(sc.nextLine());

            //valido el telefono del cliente
            valido = true ;
            while (valido) {

                valido = false;

                System.out.println("Ingrese el Telefono del Cliente ");
                nuevoCliente.setTelefono(sc.nextLine());

                for (Cliente c : listaCliente) {

                    if (c.getTelefono().equalsIgnoreCase(nuevoCliente.getTelefono())) {

                        System.out.println("Otro Cliente ya ingreso este numero de telefono ");

                        valido = true;
                    }
                }
            }
            System.out.println("Ingrese la direccion de Cliente ");
            nuevoCliente.setDireccion(sc.nextLine());

           //valido la licencia de conduccion 
            valido = true ;
            while (valido) {

                valido = false;

                System.out.print("Ingrese la licencia de conduccion del cliente: ");
                nuevoCliente.setLicenciaConduccion(sc.nextLine());

                for (Cliente c : listaCliente) {

                    if (c.getLicenciaConduccion().equalsIgnoreCase(nuevoCliente.getLicenciaConduccion())) {

                        System.out.println("Otro cliente ya ingreso esta licencia de conduccion ");

                        valido = true;
                    }
                }
            }
            valido = true;
           
            // Guardar ese cliente dentro de la ArrayList 
            listaCliente.add(nuevoCliente);
             System.out.println("Cliente registrado ");

            // Preguntar si desea continuar 
            System.out.println("Desea seguir Registrando Cliente: 1) Si , 2) No ");
            System.out.println("*************************************************");
            
            int opt = sc.nextInt();
            sc.nextLine();
            if (opt == 2) {

            pedir = false;    
                
            }
            
        }

        return  listaCliente;

    }
    //Modificar
    public ArrayList<Cliente> Modificar (ArrayList<Cliente> listaCliente){

        System.out.println("************ ACTUALIZAR CLIENTE ****************");


        System.out.println("Ingrese la Cedula del cliente que desea modificar: ");
        String cedula = sc.nextLine();

        System.out.println("");

        /*Se crea la bandera para que al momento de ingresar la cedula, si no lo encuentra dentro de la lista, el nunca entra al IF del for */
        boolean ClienteEncontrado = false;

        //Recorrer la listaClientes 
        for (Cliente c : listaCliente) {
            //Validar si la cedula ya existe             
            if (c.getCedula().equalsIgnoreCase(cedula) ) {
                /*Se cambia a true para que demuestre que si existe el cliente */
                ClienteEncontrado = true;
                // Solicitar nuevos datos
                System.out.println("Informacion actual del Cliente...");
                System.out.println("Cedula del cliente: " + c.getCedula());
                System.out.println("Nombre del cliente: " + c.getNombre() );
                System.out.println("Apellido del cliente: " + c.getApellido());
                System.out.println("Telefono del cliente: " + c.getTelefono());
                System.out.println("Direccion del cliente: " + c.getDireccion());
                System.out.println("Licencia de conduccion del cliente: " + c.getLicenciaConduccion());
                System.out.println("******************************");


                System.out.println("A continuacion se debe ingresar la nueva informacion... ");

                //Se deben ingresear los nuevos datos del cliente 


                System.out.println("Ingrese la Cedula del cliente ");
                c.setCedula(sc.nextLine());
                System.out.println("Ingrese el Nombre del cliente ");
                c.setNombre(sc.nextLine());
                System.out.println("Ingrese el Apellido del cliente ");
                c.setApellido(sc.nextLine());
                System.out.println("Ingrese el Telefono del cliente ");
                c.setTelefono(sc.nextLine());
                System.out.println("Ingrese la Direccion del cliente ");
                c.setDireccion(sc.nextLine());
                System.out.println("Ingrese la Licencia de conduccion del cliente ");
                c.setLicenciaConduccion(sc.nextLine());

                System.out.println("\nInformacion del cliente modificada correctamente ");
                System.out.println("");
            } 
        }
        /*Si el cliente no fue encontrado la bandera o boolean queda en False */
        if (!ClienteEncontrado) {
            
            System.out.println("El cliente no fue encontrado ");
            
        }
        return listaCliente;
    }

    //Eliminar
    public ArrayList<Cliente> Eliminar (ArrayList<Cliente> listaCliente){

        System.out.println("********** ELIMINAR CLIENTE ***********");
        System.out.println("Cual cliente desea Eliminar");
        String cedula = sc.nextLine();
        // Se recorre la listas 
        listaCliente.removeIf(x -> x.getCedula().equals(cedula));
        System.out.println("La Cedula se eliminó correctamente...");
        return listaCliente;
    }
    public void Consultar(ArrayList<Cliente> listaCliente) {
        System.out.println("Por favor Ingrese la cedula a buscar");
        String cedula = sc.nextLine();
        for (Cliente c : listaCliente) {
            if (c.getCedula().equals(cedula)) {
                System.out.println("Cedula: " + c.getCedula());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                System.out.println("Telefono: " + c.getTelefono());
                System.out.println("Direccion: " + c.getDireccion());
                System.out.println("Licencia de conduccion" + c.getLicenciaConduccion());
                System.out.println("------------------------------");
            }else
                System.out.println("'\nEl cliente no se encontro");
        }
    }
}
