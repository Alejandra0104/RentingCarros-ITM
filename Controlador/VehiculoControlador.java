import java.util.Scanner;

import Modelos.CamionetaSUV;
import Modelos.CarroSedan;
import Modelos.Vehiculo;
import Servicios.VehiculoServicio;

public class VehiculoControlador {
    private VehiculoServicio servicioVehiculo = new VehiculoServicio();
    private Validaciones validaciones = new Validaciones();

    private Scanner teclado = new Scanner(System.in);

    // Utiles
    public String preguntarTipoCombustible() {
        System.out.println("Ingrese el tipo de combustible");
        System.out.println("1. Gasolina");
        System.out.println("2. Diesel");
        System.out.println("3. Electrico");

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente escoja una opcion válida
        while(true) {
            System.out.print("Ingrese la opcion: ");
            int opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion) {
                case 1:
                    return "Gasolina";
                case 2:
                    return "Diesel";
                case 3:
                    return "Electrico";
                default:
                    System.out.println("Por favor ingrese una opcion valida");
            }
        }
    }

    public String preguntarTraccion() {
        System.out.println("Ingrese la traccion del vehiculo");
        System.out.println("1. 4x2");
        System.out.println("2. 4x4");

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente escoja una opcion válida
        while(true) {
            System.out.print("Ingrese la opcion: ");
            int opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion) {
                case 1:
                    return "4x2";
                case 2:
                    return "4x4";
                default:
                    System.out.println("Por favor ingrese una opcion valida");
            }
        }
    }

    public String preguntarTransmision() {
        System.out.println("Ingrese la transmision del vehiculo");
        System.out.println("1. Automatica");
        System.out.println("2. Manual");

        // El sistema debe devolver SI o SI un string. Se pregunta hasta que el cliente escoja una opcion válida
        while(true) {
            System.out.print("Ingrese la opcion: ");
            int opcion = Integer.parseInt(teclado.nextLine());

            switch(opcion) {
                case 1:
                    return "Automatica";
                case 2:
                    return "Manual";
                default:
                    System.out.println("Por favor ingrese una opcion valida");
            }
        }
    }

    // CRUD
    public boolean mostrar() {
        System.out.println("------MOSTRANDO VEHICULOS REGISTRADOS------");

        // Llamando servicio
        servicioVehiculo.mostrar();

        return true;
    }

    public boolean consultar() {
        System.out.println("------CONSULTANDO VEHICULO------");

        // Solicitando placa
        System.out.print("Ingresa la placa que deseas buscar: ");
        String placa = teclado.nextLine();

        // Validando que sea válida
        boolean placaValida = validaciones.validarPlaca(placa);

        if(!placaValida) { return false; }

        // Llamando servicio
        boolean respuesta = servicioVehiculo.consultar(placa);

        // Imprimiendo resultado
        return respuesta;
    }

    public boolean agregar() {
        try {
            System.out.println("------AGREGANDO VEHICULO------");

            Vehiculo nuevoVehiculo;

            // Solicitando datos
            System.out.print("Ingrese la placa: ");
            String placa = teclado.nextLine();
            if(!(validaciones.validarPlaca(placa))) { return false; }

            System.out.print("Ingrese la marca: ");
            String marca = teclado.nextLine();
            // VALIDACION FALTANTE DE TEXTO

            System.out.print("Ingrese el modelo: ");
            int modelo = Integer.parseInt(teclado.nextLine());
            // VALIDACION FALTANTE DE NUMERO

            System.out.print("Ingrese el precio diario: ");
            float precioDiario = Float.parseFloat(teclado.nextLine());
            // VALIDACION FALTANTE DE NUMERO

            System.out.println("¿Qué tipo de vehiculo es?");
            System.out.println("1. Camioneta SUV");
            System.out.println("2. Carro Sedan");
            System.out.println("3. Tradicional");

            int tipoVehiculo = Integer.parseInt(teclado.nextLine());
            String tipo;

            switch(tipoVehiculo) {
                case 1: // Camioneta SUV
                    String traccion = preguntarTraccion();

                    System.out.print("Ingrese la capacidad del maletero en litros: ");
                    float capacidadMaletero = Float.parseFloat(teclado.nextLine());
                    // VALIDACION FALTANTE DE NUMERO

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
                    System.out.println("Debes ingresar una opción valida.");

                    return false;
            }

            // Llamando servicio
            boolean respuesta = servicioVehiculo.agregar(nuevoVehiculo, tipo);

            // Imprimiendo resultado
            if(respuesta) {
                System.out.println("---VEHICULO AGREGADO CON EXITO---");

                return true;
            }

            return false;
        } catch (NumberFormatException error) {
            System.out.println("ERROR: Debes ingresar un numero valido.");

            return false;
        }
    }
    public boolean actualizar() {
        System.out.println("------ACTUALIZANDO VEHICULO------");

        // Solicitando y validando datos

        // Llamando servicio
        boolean respuesta = servicioVehiculo.actualizar(null);

        // Imprimiendo resultado
        if(respuesta) {
            System.out.println("---VEHICULO ACTUALIZADO CON EXITO---");

            return true;
        }

        return false;
    }
    public boolean eliminar() {
        System.out.println("------ELIMINANDO VEHICULO------");

        // Solicitando y validando datos
        System.out.print("Ingrese la placa: ");
        String placa = teclado.nextLine();
        if(!(validaciones.validarPlaca(placa))) { return false; }

        // Llamando servicio
        boolean respuesta = servicioVehiculo.eliminar(placa);

        // Imprimiendo resultado
        if(respuesta) {
            System.out.println("---VEHICULO ELIMINADO CON EXITO---");

            return true;
        }

        return false;
    }
}