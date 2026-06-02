package Servicios;
import java.io.FileWriter;
import java.io.IOException;

import Modelos.ContratoRenting;

public class ExportarContratos {
    //exportar contratos en archivo txt
   public void exportarContratos() {

        StringBuilder txtBuilder = new StringBuilder();
        txtBuilder.append("ID Contrato, Cedula Cliente, Placa Vehiculo, Fecha Inicio, Fecha Fin, Total Dias, Valor Total\n");

        for (ContratoRenting contrato : ContratoServicio.getContratos()) {

            txtBuilder.append(contrato.getIdContrato()).append(", ");
            txtBuilder.append(contrato.getCedulaCliente()).append(", ");
            txtBuilder.append(contrato.getPlacaVehiculo()).append(", ");
            txtBuilder.append(contrato.getFechaInicio()).append(", ");
            txtBuilder.append(contrato.getFechaFin()).append(", ");
            txtBuilder.append(contrato.getTotalDias()).append(", ");
            txtBuilder.append(contrato.getValorTotal()).append(",");
            txtBuilder.append(contrato.getEstado()).append("\n");
        }

        try (FileWriter fileWriter = new FileWriter("exports/contratos.txt")) {
            fileWriter.write(txtBuilder.toString());
            System.out.println("Contratos exportados exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }

}
