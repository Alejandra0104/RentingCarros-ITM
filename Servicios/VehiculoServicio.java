package Servicios;

import Modelos.CamionetaSUV;
import Modelos.CarroSedan;
import Modelos.Vehiculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiculoServicio {
    private final static List<Vehiculo> listaVehiculos = new ArrayList<>();

    public ValidacionServicio validaciones = new ValidacionServicio();
    public MenuServicio menu = new MenuServicio();

    private final Scanner teclado = new Scanner(System.in);

    // Booleanos de apoyo
    boolean continuar = true;
    boolean valido = false;

    public VehiculoServicio() {
    }

    // Preguntadores
    public String preguntarTipoCombustible() {
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
    public String preguntarTraccion() {
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
    public String preguntarTransmision() {
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
    public int preguntarTipo() {
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
    public void mostrarInfoAdicional(Vehiculo vehiculo) {
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
    }
    public void resetVariables() {
        continuar = true;
        valido = false;
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
        // Imprimiendo vehiculo por vehiculo
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println("---VEHICULO " + vehiculo.getPlaca() + "---");
            System.out.println(vehiculo.toString());

            // Casteo e impresión de datos según tipo de vehiculo
            mostrarInfoAdicional(vehiculo);
        }

        return true;
    }

    public boolean consultar(String placa) {
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

        return true;
    }

    public boolean agregar() {
        do {
            resetVariables();

            // CONTROLADOR - Validaciones de Datos y creación de objeto
            System.out.println("------AGREGANDO VEHICULO------");

            Vehiculo nuevoVehiculo = new Vehiculo();

            // Solicitando datos

            // Placa
            String placa = "";

            while (!valido) {
                System.out.print("Ingrese la placa: ");
                placa = (teclado.nextLine()).toUpperCase();

                if (validaciones.validarPlaca(placa)) {
                    valido = true;
                }
            }

            resetVariables();

            // Marca
            String marca = "";

            while (!valido) {
                System.out.print("Ingrese la marca: ");
                marca = teclado.nextLine();

                if (validaciones.validarTexto(marca)) {
                    valido = true;
                }
            }

            resetVariables();

            // Modelo
            int modelo = 0;

            while (!valido) {
                try {
                    System.out.print("Ingrese el modelo: ");
                    modelo = Integer.parseInt(teclado.nextLine());

                    int añoActual = LocalDate.now().getYear();

                    // Validando que el numero sea valido
                    if (modelo >= 1800 && modelo <= añoActual) {
                        valido = true;
                    } else {
                        System.out.println(
                                "Debe ser mayor o igual a el año 1800 y menor al año actual (" + añoActual + ")");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debes ingresar un numero");
                }
            }

            resetVariables();

            // Precio Diario
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

            // Tipo de vehiculo
            int tipoVehiculo = preguntarTipo();
            String tipo = "";

            switch (tipoVehiculo) {
                case 1: // Camioneta SUV
                    // Traccion
                    String traccion = preguntarTraccion();

                    // Capacidad
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

                    // Creación de vehiculo
                    nuevoVehiculo = new CamionetaSUV(placa, marca, modelo, precioDiario, traccion, capacidadMaletero);
                    tipo = "CamionetaSUV";

                    break;
                case 2: // Carro Sedan
                    // Tipo de combustible
                    String tipoCombustible = preguntarTipoCombustible();

                    // Transmision
                    String transmision = preguntarTransmision();

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

    public boolean actualizar(Vehiculo vehiculoActualizado) {
        // Verificar que existe
        Vehiculo vehiculoEncontrado = vehiculoExiste(vehiculoActualizado.getPlaca());

        if (vehiculoEncontrado == null) {
            System.out.println("ERROR: Vehiculo no encontrado.");

            return false;
        }

        // Actualizando vehiculo
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca() == vehiculoActualizado.getPlaca()) {
                vehiculo.setMarca(vehiculoActualizado.getMarca());
                vehiculo.setModelo(vehiculoActualizado.getModelo());
                vehiculo.setPrecioDiario(vehiculoActualizado.getPrecioDiario());
                vehiculo.setEstado(vehiculoActualizado.getEstado());

                // Casteando y actualizando según tipo de vehículo
                if (vehiculoActualizado instanceof CamionetaSUV) {
                    CamionetaSUV camioneta = (CamionetaSUV) vehiculo;
                    CamionetaSUV camionetaActualizada = (CamionetaSUV) vehiculoActualizado;

                    camioneta.setTraccion(camionetaActualizada.getTraccion());
                    camioneta.setCapacidadMaletero(camionetaActualizada.getCapacidadMaletero());
                } else if (vehiculoActualizado instanceof CarroSedan) {
                    CarroSedan carro = (CarroSedan) vehiculo;
                    CarroSedan carroActualizado = (CarroSedan) vehiculoActualizado;

                    carro.setTipoCombustible(carroActualizado.getTipoCombustible());
                    carro.setTransmision(carroActualizado.getTransmision());
                }
            }
        }

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

    public boolean eliminar(String placa) {
        // Verificar que existe
        Vehiculo vehiculoEncontrado = vehiculoExiste(placa);

        if (vehiculoEncontrado == null) {
            System.out.println("ERROR: Vehiculo no encontrado.");

            return false;
        }

        // Eliminar vehiculo
        listaVehiculos.remove(vehiculoEncontrado);

        // Retornar respuesta
        return true;
    }
}