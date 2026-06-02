package Servicios;

import Modelos.CamionetaSUV;
import Modelos.CarroSedan;
import Modelos.ContratoRenting;
import Modelos.Vehiculo;

import java.util.LinkedList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;

public class ExportarServicio {
    VehiculoServicio servicioVehiculo = new VehiculoServicio();
    ContratoServicio servicioContrato = new ContratoServicio();
    ClienteServicio servicioCliente = new ClienteServicio();

    public void contratos() {

        StringBuilder txtBuilder = new StringBuilder();
        txtBuilder.append( "IdContrato,CedulaCliente,PlacaVehiculo,FechaInicio,FechaFin,TotalDias,ValorTotal,Estado\n"
);

        for (ContratoRenting contrato : ContratoServicio.getContratos()) {

            txtBuilder.append("ID Contrato: " + contrato.getIdContrato()).append(", ");
            txtBuilder.append("Cedula Cliente: " + contrato.getCedulaCliente()).append(", ");
            txtBuilder.append("Placa Vehiculo: " + contrato.getPlacaVehiculo()).append(", ");
            txtBuilder.append("Fecha Inicio: " + contrato.getFechaInicio()).append(", ");
            txtBuilder.append("Fecha Fin: " + contrato.getFechaFin()).append(", ");
            txtBuilder.append("Total Dias: " + contrato.getTotalDias()).append(", ");
            txtBuilder.append("Valor Total: " + contrato.getValorTotal()).append(", ");
            txtBuilder.append("Estado: " + contrato.getEstado()).append("\n");
            txtBuilder.append("--------------------------------------------------\n");
        }

        try (FileWriter fileWriter = new FileWriter("exports/contratos.txt")) {
            fileWriter.write(txtBuilder.toString());
            System.out.println("Contratos exportados exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }

    public boolean vehiculos() {
        // Conseguir lista de vehiculos
        List<Vehiculo> vehiculos = servicioVehiculo.getVehiculos();

        // Exportar a CSV
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("Placa,Marca,Modelo,Precio Diario,Estado,Traccion,Capacidad Maletero,Tipo de Combustible,Transmision\n");

        for (Vehiculo vehiculo : vehiculos) {
            csvBuilder.append(vehiculo.getPlaca()).append(",");
            csvBuilder.append(vehiculo.getMarca()).append(",");
            csvBuilder.append(vehiculo.getModelo()).append(",");
            csvBuilder.append(vehiculo.getPrecioDiario()).append(",");
            csvBuilder.append(vehiculo.getEstado()).append(",");

            // Si es camioneta o carro
            if((vehiculo instanceof CamionetaSUV)) {
                CamionetaSUV camioneta = (CamionetaSUV) vehiculo;

                csvBuilder.append(camioneta.getTraccion()).append(",");
                csvBuilder.append(camioneta.getCapacidadMaletero()).append(',');
                csvBuilder.append("---").append(','); // No aplica para camioneta
                csvBuilder.append("---").append('\n'); // No aplica para camioneta
            } else if(vehiculo instanceof CarroSedan) {
                CarroSedan carro = (CarroSedan) vehiculo;

                csvBuilder.append("---").append(','); // No aplica para carro
                csvBuilder.append("---").append(','); // No aplica para carro
                csvBuilder.append(carro.getTipoCombustible()).append(',');
                csvBuilder.append(carro.getTransmision()).append('\n');
            } else {
                csvBuilder.append("---").append(','); // No aplica para camioneta suv
                csvBuilder.append("---").append(','); // No aplica para camioneta suv
                csvBuilder.append("---").append(','); // No aplica para carro
                csvBuilder.append("---").append('\n'); // No aplica para carro
            }
        }

        // Guardar CSV en archivo
        try (FileWriter fileWriter = new FileWriter("exports/vehiculos.csv")) {
            fileWriter.write(csvBuilder.toString());
            System.out.println("Vehiculos exportados exitosamente a vehiculos.csv");
        } catch (IOException e) {
            System.out.println("Error al exportar vehiculos: " + e.getMessage());
        }

        return true;
    }
}