package Servicios;

import Modelos.Cliente;
import Modelos.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteServicio {
    private static List<Cliente> listaCliente = new ArrayList<>();
    private MenuServicio servicioMenu = new MenuServicio();

    Scanner sc =  new Scanner(System.in);
    private ValidacionServicio validacion = new ValidacionServicio();

    public List<Cliente>RegistrarCliente(){
        boolean pedir = true;
        boolean valido = true;

        //Registrar Cliente        
        while (pedir) { 
            //Se crea un nuevo objeto Cliente     
            Cliente nuevoCliente = new Cliente();

            // Se piden los Datos que se necesitan 
            while (valido) {
                //valido cédula
                valido = false;

                System.out.print("Ingrese la cedula del cliente: ");
                nuevoCliente.setCedula(sc.nextLine());

                // Agrego el while para que valide el Regex
                while (!validacion.ValidarNumeros(nuevoCliente.getCedula())) { 
                    System.out.print("Ingrese nuevamente la cedula: ");
                    nuevoCliente.setCedula(sc.nextLine());
                }

                for (Cliente cliente : listaCliente) {

                    if (cliente.getCedula().equalsIgnoreCase(nuevoCliente.getCedula())) {

                        System.out.println("El cliente ya existe ");

                        System.out.println("Y. Desea Regiastrar otro cliente?");
                        System.out.println("N. Volver al menú principal");
                        String opcion = sc.nextLine();

                        while (!validacion.ValidarDimension(opcion)) 
                        {
                            opcion = sc.nextLine();
                        }
                        if (opcion.equalsIgnoreCase("N")) {

                            return listaCliente;
                        }
                        if (opcion.equalsIgnoreCase("Y")) {
                            
                        }

                        valido = true;

                    }
                    
                }
            }

            System.out.print("Ingrese el Nombre del Cliente ");
            nuevoCliente.setNombre(sc.nextLine());

            while (!validacion.validarTexto(nuevoCliente.getNombre())) { 
                    System.out.print("Ingrese nuevamente el nombre: ");
                    nuevoCliente.setNombre(sc.nextLine());
                }

            System.out.print("Ingrese el Apellido del Cliente ");
            nuevoCliente.setApellido(sc.nextLine());

            while (!validacion.validarTexto(nuevoCliente.getApellido())) { 
                    System.out.print("Ingrese nuevamente el apellido: ");
                    nuevoCliente.setApellido(sc.nextLine());
                }

            //valido que otro clinte no tenga el mismo numero de telefono telefono 
            valido = true ;
            while (valido) {

                valido = false;

                System.out.print("Ingrese el Telefono del Cliente ");
                nuevoCliente.setTelefono(sc.nextLine());

                while (!validacion.ValidarNumeros(nuevoCliente.getTelefono())) { 
                    System.out.print("Ingrese nuevamente el Telefono: ");
                    nuevoCliente.setTelefono(sc.nextLine());
                }
                // Validar que el telefono no sea igual a la cedula
                while (nuevoCliente.getTelefono().equals(nuevoCliente.getCedula())) {
                    System.out.println("El telefono no puede ser igual a la cedula "); 

                    System.out.println("Ingrese nuevamente el numero de telefono ");
                    nuevoCliente.setTelefono(sc.nextLine());
                    
                }

                for (Cliente cliente : listaCliente) {

                    if (cliente.getTelefono().equalsIgnoreCase(nuevoCliente.getTelefono())) {

                        System.out.println("Otro Cliente ya ingreso este numero de telefono ");

                        valido = true;
                    }
                }
            
            }

            System.out.print("Ingrese la direccion de Cliente ");
            nuevoCliente.setDireccion(sc.nextLine());

            while (!validacion.ValidarDireccion(nuevoCliente.getDireccion())) { 
                System.out.print("Ingrese nuevamente la direccion ");
                nuevoCliente.setDireccion(sc.nextLine());

                
            }

            //valido la licencia de conduccion 
            valido = true ;
            while (valido) {
                valido = false;

                System.out.print("Ingrese la licencia de conduccion del cliente: ");
                nuevoCliente.setLicenciaConduccion(sc.nextLine());

                while (!validacion.ValidarNumeros(nuevoCliente.getLicenciaConduccion())) { 
                    System.out.print("Ingrese nuevamente la licencia de conduccion: ");
                    nuevoCliente.setLicenciaConduccion(sc.nextLine());
                }

                 // Validar que el telefono no sea igual a la licencia de conduccion
                while (nuevoCliente.getTelefono().equals(nuevoCliente.getLicenciaConduccion())) {
                    System.out.println("El telefono no puede ser igual a la licencia de conduccion "); 

                    System.out.println("Ingrese nuevamente la licencia de conduccion ");
                    nuevoCliente.setLicenciaConduccion(sc.nextLine());
                    
                }

                for (Cliente cliente : listaCliente) {

                    if (cliente.getLicenciaConduccion().equalsIgnoreCase(nuevoCliente.getLicenciaConduccion())) {

                        System.out.println("Otro cliente ya ingreso esta licencia de conduccion ");

                        valido = true;
                    }
                    //  Validar que la licencia no sea igual a la cedula de otro cliente 
                    if (cliente.getCedula().equalsIgnoreCase(nuevoCliente.getLicenciaConduccion())) {
                        System.out.println("La licencia no puede ser igual a la cedula de otro cliente");

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
    public List<Cliente> Modificar (){

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

            // Guardar los datos originales 
            String cedulaOriginal = c.getCedula();
            String telefonoOriginal = c.getTelefono();
            String licenciaOriginal = c.getLicenciaConduccion();

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

            boolean valido = true;

            while (valido) { 
                valido = false;

                System.out.println("Ingrese la cedula del cliente ");
                String nuevaCedula = sc.nextLine();
                // Validar la cedula 
                while (!validacion.ValidarNumeros(nuevaCedula)) { 

                    System.out.println("Ingrese nuevamente la cedula: ");
                    nuevaCedula = sc.nextLine();
                    
                }

                
                for (Cliente cli : listaCliente) {

                    if (!cli.getCedula().equalsIgnoreCase(cedulaOriginal) 
                        && cli.getCedula().equalsIgnoreCase(nuevaCedula)) {
                        
                        System.out.println("Otro cliente ya ingreso este numero de cedula: ");
                        
                        valido = true;
                    }
                    
                }
                if (!valido) {
                    
                    c.setCedula(nuevaCedula);
                }
                
            }

            // Validar el nombre 
            System.out.println("Ingrese el Nombre del cliente ");
            c.setNombre(sc.nextLine());

            while (!validacion.validarTexto(c.getNombre())) {
                
                System.out.println("Ingrese nuevamente el nombre: ");
                c.setNombre(sc.nextLine());
                
                
            }
            // Validar el apellido
            System.out.println("Ingrese el Apellido del cliente ");
            c.setApellido(sc.nextLine());

            while (!validacion.validarTexto(c.getApellido())) {
                
                System.out.println("Ingrese nuevamente el apellido: ");
                c.setApellido(sc.nextLine());
            }
            // Validar el telefono
            valido = true;

            while (valido) { 

                    valido = false;

                System.out.println("Ingrese el Telefono del cliente ");
                String nuevoTelefono = sc.nextLine();

                while (!validacion.ValidarNumeros(nuevoTelefono)) {
                
                    System.out.println("Ingrese nuevamente el telefono");
                    nuevoTelefono = sc.nextLine();
                
                }
                    while (nuevoTelefono.equalsIgnoreCase(c.getCedula())) { 

                System.out.println("El telefono no puede ser igual a la cedula ");

                System.out.println("Ingrese nuevamente el telefono: ");
                nuevoTelefono = sc.nextLine();

                }
                for (Cliente cli : listaCliente) {

                if (!cli.getTelefono().equalsIgnoreCase(telefonoOriginal)
                        && cli.getTelefono().equalsIgnoreCase(nuevoTelefono)) {

                    System.out.println("Otro cliente ya tiene este telefono");

                    valido = true;
                }
            }
                if (!valido) {
                    c.setTelefono(nuevoTelefono);
                    
                } 
            }
            // Validar la direccion                
            System.out.println("Ingrese la Direccion del cliente ");
            c.setDireccion(sc.nextLine());

            while (!validacion.ValidarDireccion(c.getDireccion())) { 

                System.out.println("Ingrese nuevamente la direccion: ");
                c.setDireccion(sc.nextLine());
                
            }
            // Validar la licencia de conduccion
            valido = true;

            while (valido) {
                valido = false; 
                
                    System.out.println("Ingrese la Licencia de conduccion del cliente ");
                    String nuevaLicencia = sc.nextLine();

                // valido el regex
                while (!validacion.ValidarNumeros(nuevaLicencia)) {
                    
                    System.out.println("Ingrese nuevamente la licencia: ");
                    nuevaLicencia = sc.nextLine();
                    
                }
                // Validar que la licencia no sea igual al telefono
                while (nuevaLicencia.equalsIgnoreCase(c.getTelefono())) {
                    
                    System.out.println("La licencia de conduccion no puede ser igual al telefono");

                    System.out.println("Ingrese nuevamente la liecencia de conduccion: ");
                    nuevaLicencia = sc.nextLine();
                    
                }
                for (Cliente cli : listaCliente) {
                    // Valido que la licencia no este repetida
                    if (!cli.getLicenciaConduccion().equalsIgnoreCase(c.getLicenciaConduccion()) 
                        && cli.getLicenciaConduccion().equalsIgnoreCase(nuevaLicencia)) {
                        
                        System.out.println("Otro cliente ya tiene esta licencia de conduccion");    
                        valido = true;
                    }

                    // Validar que la licencia no sea igual a la cedula de otro cliente
                    if (!cli.getCedula().equalsIgnoreCase(c.getCedula()) 
                        && cli.getCedula().equalsIgnoreCase(nuevaLicencia)) {

                        System.out.println("La licencia no puede ser igual a la cedula de otro cliente");    
                        
                        valido = true;
                        
                    }
                    
                }
                if (!valido) {
                    c.setLicenciaConduccion(nuevaLicencia);
                    
                }

            }

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
    public List<Cliente> Eliminar (){

        System.out.println("********** ELIMINAR CLIENTE ***********");
        System.out.println("Ingresa la cedula del cliente que desea Eliminar:");
        String cedula = sc.nextLine();

            boolean ClienteEncontrado = false;

        for (Cliente cliente : listaCliente) {

        if (cliente.getCedula().equalsIgnoreCase(cedula)) {

                listaCliente.remove(cliente);

                ClienteEncontrado = true;
                System.out.println("Cliente eliminado correctamente");

                break;
                
            }
                
        }
        if (!ClienteEncontrado) {
            System.out.println("El cliente no fue encontrado");
            
        }
        return listaCliente;

    }
    public void Consultar() {
        System.out.println("Por favor Ingrese la cedula para buscar el cliente ");
        String cedula = sc.nextLine();

        boolean encontrado = false;

        for (Cliente cliente : listaCliente) {
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                System.out.println("Cedula: " + cliente.getCedula());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Telefono: " + cliente.getTelefono());
                System.out.println("Direccion: " + cliente.getDireccion());
                System.out.println("Licencia de conduccion: " + cliente.getLicenciaConduccion());
                System.out.println("------------------------------");

                encontrado = true;

            }
            
        }
        if (!encontrado) {
            System.out.println("'\nEl cliente no se encontro.");
            System.out.println("");    
        }
        
    }
    public List<Cliente> VerClientes (){

        System.out.println("Ver todos los Clientes que estan Registrados ");
        // Estoy llenando la listaClientes para Ver que todos los clientes si esten registrados 
        for (Cliente cliente : listaCliente) {
            System.out.println("Cedula: " + cliente.getCedula());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Telefono: " + cliente.getTelefono());
            System.out.println("Direccion: " + cliente.getDireccion());
            System.out.println("Licencia de conduccion: " + cliente.getLicenciaConduccion());
            System.out.println("------------------------------");  
        } 
        return listaCliente;

    }

    // Conseguir y editar lista de clientes (para exportar)
    public List<Cliente> getClientes() {
        return listaCliente;
    }

    public boolean setClientes(List<Cliente> clientes) {
        ClienteServicio.listaCliente = clientes;

        return true;
    }
}
