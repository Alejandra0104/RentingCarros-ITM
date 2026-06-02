package Servicios;
import java.io.FileWriter;
import java.io.IOException;

import Modelos.ContratoRenting;

public class ExportarContratos {
    //exportar contratos en archivo txt
   public void exportarContratos() {

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

}
