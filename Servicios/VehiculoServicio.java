package Servicios;

import java.util.List;
import java.util.ArrayList;

import Modelos.CamionetaSUV;
import Modelos.CarroSedan;
import Modelos.Vehiculo;

public class VehiculoServicio {
    // Lista puede ir aquí
    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    public VehiculoServicio() { }

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
    public boolean agregar(Vehiculo nuevoVehiculo, String tipoVehiculo) {
        // Verificar si ya existe
        Vehiculo vehiculoEncontrado = vehiculoExiste(nuevoVehiculo.getPlaca());

        if(vehiculoEncontrado != null) {
            System.out.println("ERROR: Ya se encuentra un vehículo registrado con esa placa.");

            return false;
        }

        // Casteando segun tipo de vehiculo
        if(tipoVehiculo == "CamionetaSUV") {
            CamionetaSUV nuevaCamioneta = (CamionetaSUV) nuevoVehiculo;

            // Añadiendo a lista
            listaVehiculos.add(nuevaCamioneta);
        } else if(tipoVehiculo == "CarroSedan") {
            CarroSedan nuevoCarro = (CarroSedan) nuevoVehiculo;

            // Añadiendo a lista
            listaVehiculos.add(nuevoCarro);
        } else {
            listaVehiculos.add(nuevoVehiculo);
        }

        // Retornar respuesta
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