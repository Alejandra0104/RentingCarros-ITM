import java.util.Scanner;

import Modelos.CamionetaSUV;
import Modelos.CarroSedan;
import Modelos.Vehiculo;
import Servicios.ValidacionServicio;
import Servicios.VehiculoServicio;

public class VehiculoControlador {
    private VehiculoServicio servicioVehiculo = new VehiculoServicio();
    private ValidacionServicio validaciones = new ValidacionServicio();

    


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
            

            // Llamando servicio
            boolean respuesta = servicioVehiculo.agregar(nuevoVehiculo, tipo);

            

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