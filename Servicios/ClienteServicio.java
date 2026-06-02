package Servicios;

import Modelos.Cliente;
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

                System.out.println("Ingrese la cedula del cliente: ");
                nuevoCliente.setCedula(sc.nextLine());

                // Agrego el while para que valide el Regex
                while (!validacion.ValidarNumeros(nuevoCliente.getCedula())) { 
                    System.out.println("Ingrese nuevamente la cedula: ");
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
                    // Validar que la cedula no sea igual al telefono de otro cliente 
                    if (cliente.getTelefono().equalsIgnoreCase(nuevoCliente.getCedula())) {

                        System.out.println("La cedula no puede ser igual al telefono de otro cliente ");
                        valido = true;
                    }   
                    // Validar que la cedula no sea igual a lalicencia de otro cliente 
                    if (cliente.getLicenciaConduccion().equalsIgnoreCase(nuevoCliente.getCedula())) {

                        System.out.println("La cedula no puede ser igual a la licencia de otro cliente ");
                        valido = true;
                        
                    }
                    
                }
            }

            System.out.println("Ingrese el Nombre del Cliente ");
            nuevoCliente.setNombre(sc.nextLine());

            while (!validacion.validarTexto(nuevoCliente.getNombre())) { 
                    System.out.println("Ingrese nuevamente el nombre: ");
                    nuevoCliente.setNombre(sc.nextLine());
                }

            System.out.println("Ingrese el Apellido del Cliente ");
            nuevoCliente.setApellido(sc.nextLine());

            while (!validacion.validarTexto(nuevoCliente.getApellido())) { 
                    System.out.println("Ingrese nuevamente el apellido: ");
                    nuevoCliente.setApellido(sc.nextLine());
                }

            //valido que otro clinte no tenga el mismo numero de telefono 
            valido = true ;
            while (valido) {

                valido = false;

                System.out.println("Ingrese el Telefono del Cliente ");
                nuevoCliente.setTelefono(sc.nextLine());

                while (!validacion.ValidarNumeros(nuevoCliente.getTelefono())) { 
                    System.out.println("Ingrese nuevamente el Telefono: ");
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
                    // Valido que el telefono no sea igual a la cedula de otro cliente 
                    if (cliente.getCedula().equalsIgnoreCase(nuevoCliente.getTelefono())) {
                        
                        System.out.println("El telefono no puede ser igual a la cedula de otro cliente");
                        valido = true;
                    }
                    // Valido que el telefono no sea igual a la licencia de otro cliente 
                    if (cliente.getLicenciaConduccion().equalsIgnoreCase(nuevoCliente.getTelefono())) {
                        
                        System.out.println("El telefono no puede ser igual ala licencia de otro cliente");
                        valido = true;
                    }
                }
            
            }

            System.out.println("Ingrese la direccion de Cliente ");
            nuevoCliente.setDireccion(sc.nextLine());

            while (!validacion.ValidarDireccion(nuevoCliente.getDireccion())) { 
                System.out.println("La direccion debe ser de 10 o mas caracteres ingrese nuevamente la direccion ");
                nuevoCliente.setDireccion(sc.nextLine());

                
            }

            //valido la licencia de conduccion 
            valido = true ;
            while (valido) {
                valido = false;

                System.out.println("Ingrese la licencia de conduccion del cliente: ");
                nuevoCliente.setLicenciaConduccion(sc.nextLine());

                while (!validacion.ValidarNumeros(nuevoCliente.getLicenciaConduccion())) { 
                    System.out.println("Ingrese nuevamente la licencia de conduccion: ");
                    nuevoCliente.setLicenciaConduccion(sc.nextLine());
                }

                 // Validar que el telefono no sea igual a la licencia de conduccion
                while (nuevoCliente.getTelefono().equals(nuevoCliente.getLicenciaConduccion())) {
                    System.out.println("El telefono no puede ser igual a la licencia de conduccion "); 

                    System.out.println("Ingrese nuevamente la licencia de conduccion ");
                    nuevoCliente.setLicenciaConduccion(sc.nextLine());
                    
                }

                for (Cliente cliente : listaCliente) {
                    // Valida que no sea igual a la licencia de otro cliente
                    if (cliente.getLicenciaConduccion().equalsIgnoreCase(nuevoCliente.getLicenciaConduccion())) {

                        System.out.println("Otro cliente ya ingreso esta licencia de conduccion ");

                        valido = true;
                    }
                    //  Validar que la licencia no sea igual a la cedula de otro cliente 
                    if (cliente.getCedula().equalsIgnoreCase(nuevoCliente.getLicenciaConduccion())) {
                        System.out.println("La licencia no puede ser igual a la cedula de otro cliente");

                        valido = true;
                    }
                    // Vaalidar que la licencia no sea igual al telefono de otro cliente 
                    if (cliente.getTelefono().equalsIgnoreCase(nuevoCliente.getLicenciaConduccion())) {
                        System.out.println("La licencia no puede ser igual al telefono de otro cliente");
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

            if (c.getCedula().equalsIgnoreCase(cedula)) {

               ClienteEncontrado = true;

                String cedulaOriginal = c.getCedula();
                String telefonoOriginal = c.getTelefono();
                String licenciaOriginal = c.getLicenciaConduccion();

                System.out.println("Informacion actual del Cliente...");
                System.out.println("Cedula del cliente: " + c.getCedula());
                System.out.println("Nombre del cliente: " + c.getNombre());
                System.out.println("Apellido del cliente: " + c.getApellido());
                System.out.println("Telefono del cliente: " + c.getTelefono());
                System.out.println("Direccion del cliente: " + c.getDireccion());
                System.out.println("Licencia de conduccion del cliente: " + c.getLicenciaConduccion());
                System.out.println("******************************");

                System.out.println("\n¿Que desea modificar?");
                System.out.println("1. Cedula");
                System.out.println("2. Nombre");
                System.out.println("3. Apellido");
                System.out.println("4. Telefono");
                System.out.println("5. Direccion");
                System.out.println("6. Licencia de conduccion");
                System.out.println("7. Todo");

                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1 -> c.setCedula(modificarCedula(c, cedulaOriginal));

                    case 2 -> c.setNombre(modificarNombre());

                    case 3 -> c.setApellido(modificarApellido());

                    case 4 -> c.setTelefono(modificarTelefono(c, telefonoOriginal));

                    case 5 -> c.setDireccion(modificarDireccion());

                    case 6 -> c.setLicenciaConduccion(modificarLicencia(c, licenciaOriginal));

                    case 7 -> {
                        c.setCedula(modificarCedula(c, cedulaOriginal));
                        c.setNombre(modificarNombre());
                        c.setApellido(modificarApellido());
                        c.setTelefono(modificarTelefono(c, telefonoOriginal));
                        c.setDireccion(modificarDireccion());
                        c.setLicenciaConduccion(modificarLicencia(c, licenciaOriginal));
                    }

                    default -> System.out.println("Opcion invalida");
                }

                System.out.println("\nInformacion del cliente modificada correctamente");
                System.out.println("");

                break;
            }
        }

            if (!ClienteEncontrado) {

                System.out.println("El cliente no fue encontrado");
            }

            return listaCliente;
    }
    // Modificar cedula
    public String modificarCedula(Cliente c, String cedulaOriginal){

        boolean valido = true;
        String nuevaCedula = "";

        while (valido) {

            valido = false;

            System.out.println("Ingrese la cedula del cliente ");
            nuevaCedula = sc.nextLine();

            while (!validacion.ValidarNumeros(nuevaCedula)) {

                System.out.println("La cedula debe contener solo numeros");
                System.out.println("Ingrese nuevamente la cedula: ");
                nuevaCedula = sc.nextLine();
            }
            // Cedula no puede ser igual al telefono del mismo cliente 
            while (nuevaCedula.equalsIgnoreCase(c.getTelefono())) {
                
                System.out.println("La cedula no puede ser igual al telefono del mismo cliente");

                System.out.println("Ingrese nuevamente la cedula: ");
                nuevaCedula = sc.nextLine();
            }

            for (Cliente cli : listaCliente) {
                // Validar que la cedula no este repetida 
                if (!cli.getCedula().equalsIgnoreCase(cedulaOriginal)
                        && cli.getCedula().equalsIgnoreCase(nuevaCedula)) {

                    System.out.println("Otro cliente ya ingreso este numero de cedula");
                    valido = true;
                }
                // Que cedula no sea igual al telefono de otro cliente
                if (!cli.getTelefono().equalsIgnoreCase(c.getCedula())
                    && cli.getTelefono().equalsIgnoreCase(nuevaCedula)) {

                    System.out.println("La cedula no puede ser igual al telfono de otro cliente");
                       
                    valido = true;
                }   
                // Validar que no sea Igual a la licencia de otro cliente
                if (!cli.getLicenciaConduccion().equalsIgnoreCase(c.getLicenciaConduccion())
                    && cli.getLicenciaConduccion().equalsIgnoreCase(nuevaCedula)) {
                    
                    System.out.println("La cedula no puede ser igual a la licencia de otro cliente");
                    valido = true;    
                }
            }
        }

        return nuevaCedula;
    }

    // Modificar nombre
    public String modificarNombre(){

        System.out.println("Ingrese el nombre del cliente ");
        String nombre = sc.nextLine();

        while (!validacion.validarTexto(nombre)) {

            System.out.println("El nombre solo puede contener letras");
            System.out.println("Ingrese nuevamente el nombre ");
            nombre = sc.nextLine();
            
        }
        return nombre;
    }
    // Modificar Apellido
    public String modificarApellido(){

        System.out.println("Ingrese el apellido del cliente ");
        String apellido = sc.nextLine();

        while (!validacion.validarTexto(apellido)) {

            System.out.println("El apellido solo puede contener letras ");
            System.out.println("Ingrese nuevamente el apellido: ");
            apellido = sc.nextLine(); 
            
        }
        return apellido;
    }
    // Modificar telefono
    public String modificarTelefono(Cliente c, String telefonoOriginal){

         boolean valido = true;
         String nuevoTelefono = "";

        while (valido) {

            valido = false;

            System.out.println("Ingrese el Telefono del cliente ");
            nuevoTelefono = sc.nextLine();

            while (!validacion.ValidarNumeros(nuevoTelefono)) {

                System.out.println("El telefono solo puede contener de 6 a 10 numeros");
                System.out.println("Ingrese nuevamente el telefono: ");
                nuevoTelefono = sc.nextLine();
            }

            

            while (nuevoTelefono.equalsIgnoreCase(c.getCedula())) {

                System.out.println("El telefono no puede ser igual a la cedula");

                System.out.println("Ingrese nuevamente el telefono:");
                nuevoTelefono = sc.nextLine();
            }

            for (Cliente cli : listaCliente) {

                if (!cli.getTelefono().equalsIgnoreCase(telefonoOriginal)
                        && cli.getTelefono().equalsIgnoreCase(nuevoTelefono)) {

                    System.out.println("Otro cliente ya tiene este telefono");
                    valido = true;
                }
                // validar que no sea igual a la cedula de otro cliente 
                if (!cli.getCedula().equalsIgnoreCase(c.getCedula())
                     && cli.getCedula().equalsIgnoreCase(nuevoTelefono)) {

                    System.out.println("El telefono no puede ser igual a la cedula de otro cliente ");    
                    valido = true;
                }
                // validar que no sea igual a la licencia de otro cliente
                if (!cli.getLicenciaConduccion().equalsIgnoreCase(c.getLicenciaConduccion())
                    && cli.getLicenciaConduccion().equalsIgnoreCase(nuevoTelefono)) {
                    
                    System.out.println("El telefono no puede ser igual a la licencia de otro cliente ");    
                    valido = true;
                }
            }
        }

        return nuevoTelefono;

    }

    // Modificar Direccion 
    public String modificarDireccion(){


        System.out.println("Ingrese la direccion del cliente ");
        String direccion = sc.nextLine();

        while (!validacion.ValidarDireccion(direccion)|| direccion.matches("\\d+")) {
            
            System.out.println("Direccin invalida deben ser mas de 3 caracteres y menos de 100");
            System.out.println("Ingrese nuevamente la direccion: ");
            direccion = sc.nextLine();
            
        }
        return direccion;
    }
    // Modificar licencia de conduccion
    public String modificarLicencia(Cliente c, String licenciaOriginal){

         boolean valido = true;
        String nuevaLicencia = "";

        while (valido) {

            valido = false;

            System.out.println("Ingrese la Licencia de conduccion del cliente ");
            nuevaLicencia = sc.nextLine();

            while (!validacion.ValidarNumeros(nuevaLicencia)) {

                System.out.println("La licencia solo puede contener numeros");
                System.out.println("Ingrese nuevamente la licencia:");
                nuevaLicencia = sc.nextLine();
            }

            while (nuevaLicencia.equalsIgnoreCase(c.getTelefono())) {

                System.out.println("La licencia no puede ser igual al telefono");

                System.out.println("Ingrese nuevamente la licencia: ");
                nuevaLicencia = sc.nextLine();
            }

            for (Cliente cli : listaCliente) {

                // Validar que no este repetida
                if (!cli.getLicenciaConduccion().equalsIgnoreCase(licenciaOriginal)
                        && cli.getLicenciaConduccion().equalsIgnoreCase(nuevaLicencia)) {

                    System.out.println("Otro cliente ya tiene esta licencia");
                    valido = true;
                }
                // Validar que no sea igual a la cedula de otro cliente 
                if (!cli.getCedula().equalsIgnoreCase(c.getCedula())
                        && cli.getCedula().equalsIgnoreCase(nuevaLicencia)) {

                    System.out.println("La licencia no puede ser igual a la cedula de otro cliente");
                    valido = true;
                }
                // Validar que no sea igual al telefono de otro cliente
                if (!cli.getTelefono().equalsIgnoreCase(c.getTelefono())
                    && cli.getTelefono().equalsIgnoreCase(nuevaLicencia)) {
                    
                    System.out.println("La licencia no puede ser igual al telefono de otro cliente");    
                    valido = true;
                }
                
            }
        }

        return nuevaLicencia;

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

        System.out.println("***************** Ver todos los Clientes que estan Registrados ***************** ");
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

    
}
