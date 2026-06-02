package Servicios;

import Modelos.Vehiculo;
import Modelos.ContratoRenting;
import Modelos.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class ImportarServicio {
    private static ClienteServicio clienteServicio = new ClienteServicio();
    private static VehiculoServicio vehiculoServicio = new VehiculoServicio();
    public static ContratoServicio contratoServicio = new ContratoServicio();

    public boolean vehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("imports/vehiculos.csv"))) {
            String linea;

            while((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                vehiculos.add(new Vehiculo(datos[0], datos[1], Integer.parseInt(datos[2]), Float.parseFloat(datos[3])));
            } 
        } catch(IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
                return false;
        }

        // Actualizando variable estática
        vehiculoServicio.setVehiculos(vehiculos);

        return true;
    }

    public boolean contratos() {
        LinkedList<ContratoRenting> contratos = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("imports/contratos.csv"))) {
            String linea;

            while((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                contratos.add(new ContratoRenting(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5]), Float.parseFloat(datos[6]), datos[7]));
            } 
        } catch(IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
                return false;
        }

        // Actualizando variable estática
        contratoServicio.setContratos(contratos);

        return true;
    }

    public boolean clientes() {
        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("imports/clientes.csv"))) {
            String linea;

            while((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                clientes.add(new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]));
            } 
        } catch(IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
                return false;
        }

        // Actualizando variable estática
        clienteServicio.setClientes(clientes);

        return true;
    }
}
