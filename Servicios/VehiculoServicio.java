package Servicios;

import Modelos.CamionetaSUV;
import Modelos.CarroSedan;
import Modelos.ContratoRenting;
import Modelos.Vehiculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VehiculoServicio {
    private static List<Vehiculo> listaVehiculos = new ArrayList<>();

    public ValidacionServicio validaciones = new ValidacionServicio();
    public ContratoServicio servicioContrato = new ContratoServicio();
    public MenuServicio menu = new MenuServicio();

    private final Scanner teclado = new Scanner(System.in);

    // Booleanos de apoyo
    boolean continuar = true;
    boolean valido = false;

    public VehiculoServicio() {
    }

    // Solicitadores
    public String solicitarPlaca() {
        // Placa
        String placa = "";

        while (!valido) {
            System.out.print("Ingrese la placa: ");
            placa = (teclado.nextLine()).toUpperCase();

            valido = validaciones.validarPlaca(placa);
        }

        resetVariables();

        return placa;
    }
    public String solicitarMarca() {
        // Marca
        String marca = "";

        while(!valido) {
            System.out.print("Ingrese la marca: ");
            marca = teclado.nextLine();

            valido = validaciones.validarTexto(marca);
        }

        resetVariables();

        return marca;
    }
    public int solicitarModelo() {
        // Modelo
        int modelo = 0;
        int añoActual = LocalDate.now().getYear();

        while (!valido) {
            try {
                System.out.print("Ingrese el modelo: ");
                modelo = Integer.parseInt(teclado.nextLine());

                // Validando que el año sea valido
                if (modelo >= 1800 && modelo <= añoActual) {
                    valido = true;
                } else {
                    System.out.println(
                            "Debe ser mayor o igual a el año 1800 y menor o igual al año actual (" + añoActual + ")");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero");
            }
        }

        resetVariables();

        return modelo;
    }
    public float solicitarPrecio() {
        float precioDiario = 0;

        while (!valido) {
            try {
                System.out.print("Ingrese el precio diario: ");
                precioDiario = Float.parseFloat(teclado.nextLine());

                // Validando que el numero sea valido
                if (precioDiario > 0) {
                    valido = true;
                } else {
                    System.out.println("Debe ser mayor a cero");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero");
            }
        }

        resetVariables();

        return precioDiario;
    }
    public float solicitarCapacidadMaletero() {
        float capacidadMaletero = 0;

        while (!valido) {
            try {
                System.out.print("Ingrese la capacidad del maletero en litros: ");
                capacidadMaletero = Float.parseFloat(teclado.nextLine());

                // Validando que el numero sea valido
                if (capacidadMaletero > 0) {
                    valido = true;
                } else {
                    System.out.println("Debe ser mayor a cero");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero");
            }
        }

        resetVariables();

        return capacidadMaletero;
    }
    public String solicitarTipoCombustible() {
        System.out.println("Ingrese el tipo de combustible");
        System.out.println("1. Gasolina");
        System.out.println("2. Diesel");
        System.out.println("3. Electrico");

        String tipoCombustible = "";

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente
        // escoja una opcion válida
        while (!valido) {
            try {
                System.out.print("Ingrese la opcion: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1 -> {
                        tipoCombustible = "Gasolina";
                        valido = true;
                    }
                    case 2 -> {
                        tipoCombustible = "Diesel";
                        valido = true;
                    }
                    case 3 -> {
                        tipoCombustible = "Electrico";
                        valido = true;
                    }
                    default -> {
                        System.out.println("Por favor ingrese una opcion valida");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero por favor");
            }
        }

        resetVariables();

        return tipoCombustible;
    }
    public String solicitarTraccion() {
        System.out.println("Ingrese la traccion del vehiculo");
        System.out.println("1. 4x2");
        System.out.println("2. 4x4");

        String traccion = "";

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente
        // escoja una opcion válida
        while (!valido) {
            try {
                System.out.print("Ingrese la opcion: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        traccion = "4x2";
                        valido = true;
                        break;
                    case 2:
                        traccion = "4x4";
                        valido = true;
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }

        resetVariables();

        return traccion;
    }
    public String solicitarTransmision() {
        System.out.println("Ingrese la transmision del vehiculo");
        System.out.println("1. Automatica");
        System.out.println("2. Manual");

        String transmision = "";

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente
        // escoja una opcion válida
        while (!valido) {
            try {
                System.out.print("Ingrese la opcion: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        transmision = "Automática";
                        valido = true;
                        break;
                    case 2:
                        transmision = "Manual";
                        valido = true;
                        break;
                    default:
                        System.out.println("Por favor ingrese una valida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }

        resetVariables();

        return transmision;
    }
    public int solicitarTipo() {
        System.out.println("¿Qué tipo de vehiculo es?");
        System.out.println("1. Camioneta SUV");
        System.out.println("2. Carro Sedan");
        System.out.println("3. Tradicional");

        int tipoVehiculo = 0;

        while (!valido) {
            try {
                System.out.print("Ingrese la opcion: ");
                tipoVehiculo = Integer.parseInt(teclado.nextLine());

                // Validando que sea una opcion valida
                if (tipoVehiculo > 0 && tipoVehiculo <= 3) {
                    valido = true;
                } else {
                    System.err.println("Por favor ingrese una opcion valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero.");
            }
        }

        resetVariables();

        return tipoVehiculo;
    }

    // Utiles
    public boolean mostrarInfoAdicional(Vehiculo vehiculo) {
        // Verificando qué vehiculo es para realizar casting y obtener datos adicionales
        if (vehiculo instanceof CamionetaSUV) {
            // Si es una camioneta suv
            CamionetaSUV camioneta = (CamionetaSUV) vehiculo; // Casteo de entidad

            System.out.println("Traccion: " + camioneta.getTraccion());
            System.out.println("Capacidad Maletero: " + camioneta.getCapacidadMaletero() + " litros");
            System.out.println("Tipo: Camioneta SUV");
        } else if (vehiculo instanceof CarroSedan) {
            // Si es un carro sedan
            CarroSedan carro = (CarroSedan) vehiculo;

            System.out.println("Tipo Combustible: " + carro.getTipoCombustible());
            System.out.println("Transmision: " + carro.getTransmision());
            System.out.println("Tipo: Carro Sedan");
        } else {
            System.out.println("Tipo: Vehiculo Tradicional");
        }

        return true;
    }

    public boolean resetVariables() {
        continuar = true;
        valido = false;

        return true;
    }

    // Validaciones Lógicas
    public Vehiculo vehiculoExiste(String placa) {
        for (Vehiculo vehiculo : listaVehiculos) {
            // Busca el vehiculo que coincide con la placa dada
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }

        return null; // Si no encuentra nada, retorna null
    }

    // Funciones CRUD
    public boolean mostrar() {
        // Validando que hayan registros
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay ningun registro aún");

            return false;
        }

        // Imprimiendo vehiculo por vehiculo
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println("---VEHICULO " + vehiculo.getPlaca() + "---");
            System.out.println(vehiculo.toString());

            // Casteo e impresión de datos según tipo de vehiculo
            mostrarInfoAdicional(vehiculo);
        }

        return true;
    }

    public boolean consultar() {
        // Validando que hayan registros
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay ningun registro aún");

            return false;
        }

        do {
            resetVariables();

            // Solicitar placa
            String placa = solicitarPlaca();

            // Verificar que existe
            Vehiculo vehiculoEncontrado = vehiculoExiste(placa);

            if (vehiculoEncontrado == null) {
                System.out.println("ERROR: Vehiculo no encontrado");

                return false;
            }

            // Imprimiendo resultado
            System.out.println("---VEHICULO " + vehiculoEncontrado.getPlaca() + "---");
            System.out.println(vehiculoEncontrado.toString());
            mostrarInfoAdicional(vehiculoEncontrado);

            // Preguntar si desea seguir buscando
            continuar = menu.preguntarContinuar() == 1;
        } while (continuar);

        return true;
    }

    public boolean agregar() {
        do {
            resetVariables();

            // CONTROLADOR - Validaciones de Datos y creación de objeto
            System.out.println("------AGREGANDO VEHICULO------");

            Vehiculo nuevoVehiculo = new Vehiculo();

            // Solicitando datos

            String placa = solicitarPlaca();
            String marca = solicitarMarca();
            int modelo = solicitarModelo();
            float precioDiario = solicitarPrecio();

            // Tipo de vehiculo
            int tipoVehiculo = solicitarTipo();
            String tipo = "";

            switch (tipoVehiculo) {
                case 1: // Camioneta SUV
                    // Traccion
                    String traccion = solicitarTraccion();

                    // Capacidad
                    float capacidadMaletero = solicitarCapacidadMaletero();

                    // Creación de vehiculo
                    nuevoVehiculo = new CamionetaSUV(placa, marca, modelo, precioDiario, traccion, capacidadMaletero);
                    tipo = "CamionetaSUV";

                    break;
                case 2: // Carro Sedan
                    // Tipo de combustible
                    String tipoCombustible = solicitarTipoCombustible();

                    // Transmision
                    String transmision = solicitarTransmision();

                    // Creacion de vehiculo
                    nuevoVehiculo = new CarroSedan(placa, marca, modelo, precioDiario, tipoCombustible,
                            transmision);
                    tipo = "CarroSedan";

                    break;
                case 3: // Tradicional
                    nuevoVehiculo = new Vehiculo(placa, marca, modelo, precioDiario);

                    tipo = "Tradicional";

                    break;
                default:
                    break;
            }

            // SERVICIO - Validaciones Lógicas e Implementación a Lista

            // Verificar si ya existe
            Vehiculo vehiculoEncontrado = vehiculoExiste(nuevoVehiculo.getPlaca());

            if (vehiculoEncontrado != null) {
                System.out.println("ERROR: Ya se encuentra un vehículo registrado con esa placa.");

                return false;
            }

            // Casteando segun tipo de vehiculo
            if (tipo.equalsIgnoreCase("CamionetaSUV")) {
                CamionetaSUV nuevaCamioneta = (CamionetaSUV) nuevoVehiculo;

                // Añadiendo a lista
                listaVehiculos.add(nuevaCamioneta);
            } else if (tipo.equalsIgnoreCase("CarroSedan")) {
                CarroSedan nuevoCarro = (CarroSedan) nuevoVehiculo;

                // Añadiendo a lista
                listaVehiculos.add(nuevoCarro);
            } else {
                // Añadiendo a lista sin casteo en caso de que sea tradicional
                listaVehiculos.add(nuevoVehiculo);
            }

            // Imprimir Resultado
            System.out.println("---VEHICULO AGREGADO CON EXITO---");

            // Preguntar si quiere seguir agregando
            continuar = menu.preguntarContinuar() == 1; // Si la opción es 1, devuelve true. Si no es 1, devuelve false

        } while (continuar);

        return true;
    }

    public boolean actualizar() {
        do {
            // Recibir opción de menú
            int opcion = menu.actualizarVehiculo();

            // Verificar si el usuario desea salir
            if (opcion == 8) {
                System.out.println("Regresando...");
                return true;
            }

            // Preguntar placa
            String placa = solicitarPlaca();

            // Encontrar vehiculo
            Vehiculo vehiculo = vehiculoExiste(placa);

            // Verificar que exista
            if (vehiculo == null) {
                System.out.println("No hay ningun vehículo registrado con esa placa.");

                return false;
            }

            // Verificar casteo
            if ((opcion == 4 || opcion == 5) && !((vehiculo) instanceof CamionetaSUV)) { // Si la opcion elegida es la 4 o
                                                                                        // la 5, y el casteo no funciona,
                                                                                        // devuelve falso
                System.out.println("Ese vehículo no es una camioneta suv.");

                return false;
            } else if ((opcion == 6 || opcion == 7) && !((vehiculo) instanceof CarroSedan)) {
                System.out.println("Ese vehículo no es un carro sedan");

                return false;
            }

            // Switch
            switch (opcion) {
                case 1 -> { // Marca
                    String marca = solicitarMarca();

                    vehiculo.setMarca(marca);
                }
                case 2 -> { // Modelo
                    int modelo = solicitarModelo();

                    vehiculo.setModelo(modelo);
                }
                case 3 -> { // Precio Diario
                    float precioDiario = solicitarPrecio();

                    vehiculo.setPrecioDiario(precioDiario);
                }
                case 4 -> { // Tracción (Camioneta SUV)
                    CamionetaSUV camioneta = (CamionetaSUV) vehiculo; // Casteo
                    String traccion = solicitarTraccion();

                    camioneta.setTraccion(traccion);
                }
                case 5 -> { // Capacidad de Maletero (Camioneta SUV)
                    CamionetaSUV camioneta = (CamionetaSUV) vehiculo; // Casteo
                    float capacidadMaletero = solicitarCapacidadMaletero();

                    camioneta.setCapacidadMaletero(capacidadMaletero);
                }
                case 6 -> { // Tipo de Combustible (Carro Sedan)
                    CarroSedan carro = (CarroSedan) vehiculo;
                    String tipoCombustible = solicitarTipoCombustible();

                    carro.setTipoCombustible(tipoCombustible);
                }
                case 7 -> { // Transmisión (Carro Sedan)
                    CarroSedan carro = (CarroSedan) vehiculo;
                    String transmision = solicitarTransmision();

                    carro.setTransmision(transmision);
                }
            }

            // Imprimir resultado
            System.out.println("---VEHICULO ACTUALIZADO CON EXITO---");

            // Preguntar si quiere seguir agregando
            continuar = menu.preguntarContinuar() == 1; // Si la opción es 1, devuelve true. Si no es 1, devuelve false    
        } while(continuar); 

        // Retornar respuesta
        return true;
    }

    public boolean actualizarEstado(String placa, String estado) {
        // Buscar vehiculo
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculo.setEstado(estado);

                return true;
            }
        }

        return false;
    }

    public boolean eliminar() {
        // Solicitar placa
        String placa = solicitarPlaca();

        // Verificar que existe
        Vehiculo vehiculoEncontrado = vehiculoExiste(placa);

        if (vehiculoEncontrado == null) {
            System.out.println("ERROR: Vehiculo no encontrado.");

            return false;
        }
 
        // Eliminar vehiculo
        listaVehiculos.remove(vehiculoEncontrado);

        // Eliminar contratos con ese vehiculo
        LinkedList<ContratoRenting> contratos = servicioContrato.getContratos(); // Conseguir lista de contratos

        // Eliminar contratos con ese vehiculo
        contratos.removeIf(contrato -> contrato.getPlacaVehiculo().equals(placa));

        // Actualizar lista de contratos en servicio Contrato
        servicioContrato.setContratos(contratos);

        // Retornar respuesta
        System.out.println("Vehiculo eliminado con exito.");

        return true;
    }

    // Conseguir y editar lista de vehiculos (para exportar)
    public List<Vehiculo> getVehiculos() {
        return listaVehiculos;
    }

    public boolean setVehiculos(List<Vehiculo> vehiculos) {
        VehiculoServicio.listaVehiculos = vehiculos;

        return true;
    }
}