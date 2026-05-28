package Servicios;

import Modelos.CamionetaSUV;
import Modelos.CarroSedan;
import Modelos.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiculoServicio {
    private static List<Vehiculo> listaVehiculos = new ArrayList<>();

    public Validaciones validaciones = new Validaciones();

    private Scanner teclado = new Scanner(System.in);

    // Booleanos de apoyo
    boolean continuar = true;
    boolean valido = false;

    public VehiculoServicio() { }

    // Preguntadores
    public String preguntarTipoCombustible() {
        System.out.println("Ingrese el tipo de combustible");
        System.out.println("1. Gasolina");
        System.out.println("2. Diesel");
        System.out.println("3. Electrico");

        String tipoCombustible = "";

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente escoja una opcion válida
        while(!valido) {
            try {
                System.out.print("Ingrese la opcion: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                switch(opcion) {
                    case 1:
                        tipoCombustible = "Gasolina";
                        valido = true;
                    case 2:
                        tipoCombustible = "Diesel";
                        valido = true;
                    case 3:
                        tipoCombustible = "Electrico";
                        valido = true;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
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

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente escoja una opcion válida
        while(!valido) {
            try {
                System.out.print("Ingrese la opcion: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                switch(opcion) {
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

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente escoja una opcion válida
        while(!valido) {
            try {
                System.out.print("Ingrese la opcion: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                switch(opcion) {
                    case 1:
                        transmision = "Automatica";
                        valido = true;
                    case 2:
                        transmision = "Manual";
                        valido = true;
                    default:
                        System.out.println("Por favor ingrese una valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }

        resetVariables();

        return transmision;
    }

    // Utiles
    public void mostrarInfoAdicional(Vehiculo vehiculo) {
        // Verificando qué vehiculo es para realizar casting y obtener datos adicionales
        if(vehiculo instanceof CamionetaSUV) {
            // Si es una camioneta suv
            CamionetaSUV camioneta = (CamionetaSUV) vehiculo; // Casteo de entidad

            System.out.println("Traccion: " + camioneta.getTraccion());
            System.out.println("Capacidad Maletero: " + camioneta.getCapacidadMaletero() + " litros");
            System.out.println("Tipo: Camioneta SUV");
        } else if(vehiculo instanceof CarroSedan) {
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
        for(Vehiculo vehiculo : listaVehiculos) {
            // Busca el vehiculo que coincide con la placa dada
            if(vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }

        return null; // Si no encuentra nada, retorna null
    }

    // Funciones CRUD
    public boolean mostrar() {
        // Imprimiendo vehiculo por vehiculo
        for(Vehiculo vehiculo : listaVehiculos) {
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

        if(vehiculoEncontrado == null) {
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
        resetVariables();

        // CONTROLADOR
        System.out.println("------AGREGANDO VEHICULO------");

        Vehiculo nuevoVehiculo = new Vehiculo();

        // Solicitando datos
        String placa = "";

        while(!valido) {
            System.out.print("Ingrese la placa: ");
            placa = teclado.nextLine();

            if(validaciones.validarPlaca(placa)) {
                valido = true;
            }
        }

        resetVariables();

        String marca = "";

        while(!valido) {
            System.out.print("Ingrese la marca: ");
            marca = teclado.nextLine();
            
            if(validaciones.validarTexto(marca)) {
                valido = true;
            }
        }

        resetVariables();

        int modelo = 0;

        while(!valido) {
            try {
                System.out.print("Ingrese el modelo: ");
                modelo = Integer.parseInt(teclado.nextLine());

                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero");
            }   
        }

        resetVariables();

        float precioDiario = 0;

        while(!valido) {
            try {
                System.out.print("Ingrese el precio diario: ");
                precioDiario = Float.parseFloat(teclado.nextLine());
                
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero");
            }
        }

        resetVariables();

        System.out.println("¿Qué tipo de vehiculo es?");
        System.out.println("1. Camioneta SUV");
        System.out.println("2. Carro Sedan");
        System.out.println("3. Tradicional");

        int tipoVehiculo = 0;
        String tipo = "";

        while(!valido) {
            try {
                System.out.print("Ingrese la opcion: ");
                tipoVehiculo = Integer.parseInt(teclado.nextLine());
  
                if(tipoVehiculo > 0 && tipoVehiculo <= 3) {
                    valido = true;
                } else {
                    System.err.println("Esa opcion no existe.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero");
            }
        }

        resetVariables();

        switch(tipoVehiculo) {
            case 1: // Camioneta SUV
                String traccion = preguntarTraccion();
                float capacidadMaletero = 0;

                while(!valido) {
                    try {
                        System.out.print("Ingrese la capacidad del maletero en litros: ");
                        capacidadMaletero = Float.parseFloat(teclado.nextLine());
                        
                        valido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Debes ingresar un numero");
                    }
                }

                resetVariables();

                nuevoVehiculo = new CamionetaSUV(placa, marca, modelo, precioDiario, "Disponible", traccion, capacidadMaletero);
                tipo = "CamionetaSUV";

                break;
            case 2: // Carro Sedan
                String tipoCombustible = preguntarTipoCombustible();
                String transmision = preguntarTransmision();

                nuevoVehiculo = new CarroSedan(placa, marca, modelo, precioDiario, "Disponible", tipoCombustible, transmision);
                tipo = "CarroSedan";

                break;
            case 3: // Tradicional
                nuevoVehiculo = new Vehiculo(placa, marca, modelo, precioDiario, "Disponible"); // Valor 'disponible' quemado
                tipo = "Tradicional";

                break;
            default:
                break;
        }

        // SERVICIO

        // Verificar si ya existe
        Vehiculo vehiculoEncontrado = vehiculoExiste(nuevoVehiculo.getPlaca());

        if(vehiculoEncontrado != null) {
            System.out.println("ERROR: Ya se encuentra un vehículo registrado con esa placa.");
            
            return false;
        }

        // Casteando segun tipo de vehiculo
        if(tipo.equalsIgnoreCase("CamionetaSUV")) {
            CamionetaSUV nuevaCamioneta = (CamionetaSUV) nuevoVehiculo;

            // Añadiendo a lista
            listaVehiculos.add(nuevaCamioneta);
        } else if(tipo.equalsIgnoreCase("CarroSedan")) {
            CarroSedan nuevoCarro = (CarroSedan) nuevoVehiculo;

            // Añadiendo a lista
            listaVehiculos.add(nuevoCarro);
        } else {
            listaVehiculos.add(nuevoVehiculo);
        }

        // Imprimir Resultado
        System.out.println("---VEHICULO AGREGADO CON EXITO---");

        // Preguntar si quiere seguir agregando
        continuar = true;

        return true;
    }

    public boolean actualizar(Vehiculo vehiculoActualizado) {
        // Verificar que existe
        Vehiculo vehiculoEncontrado = vehiculoExiste(vehiculoActualizado.getPlaca());

        if(vehiculoEncontrado == null) {
            System.out.println("ERROR: Vehiculo no encontrado.");

            return false;
        }

        // Actualizando vehiculo
        for(Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo.getPlaca() == vehiculoActualizado.getPlaca()) {
                vehiculo.setMarca(vehiculoActualizado.getMarca());
                vehiculo.setModelo(vehiculoActualizado.getModelo());
                vehiculo.setPrecioDiario(vehiculoActualizado.getPrecioDiario());
                vehiculo.setEstado(vehiculoActualizado.getEstado());

                // Casteando y actualizando según tipo de vehículo
                if(vehiculoActualizado instanceof CamionetaSUV) {
                    CamionetaSUV camioneta = (CamionetaSUV) vehiculo;
                    CamionetaSUV camionetaActualizada = (CamionetaSUV) vehiculoActualizado;

                    camioneta.setTraccion(camionetaActualizada.getTraccion());
                    camioneta.setCapacidadMaletero(camionetaActualizada.getCapacidadMaletero());
                } else if(vehiculoActualizado instanceof CarroSedan) {
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
        for(Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculo.setEstado(estado);

                return true;
            }
        }

        return false;
    }
    
    public boolean eliminar(String placa) {
        // Verificar que existe
        Vehiculo vehiculoEncontrado = vehiculoExiste(placa);

        if(vehiculoEncontrado == null) {
            System.out.println("ERROR: Vehiculo no encontrado.");

            return false;
        }

        // Eliminar vehiculo
        listaVehiculos.remove(vehiculoEncontrado);

        // Retornar respuesta
        return true;
    }
}