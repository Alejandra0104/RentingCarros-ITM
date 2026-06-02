package Servicios;

import Modelos.ContratoRenting;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class importarContratos {

    public void importarContratos() {

        try (BufferedReader br = new BufferedReader(new FileReader("exports/contratos.txt"))) {

            String linea;

            // Saltar encabezado
            br.readLine();

           while ((linea = br.readLine()) != null) {

            if (linea.startsWith("ID Contrato:")) {

                ContratoRenting contrato = new ContratoRenting();

                contrato.setIdContrato(
                    linea.replace("ID Contrato:", "").trim());

                contrato.setCedulaCliente(
                    br.readLine().replace("Cedula Cliente:", "").trim());

                contrato.setPlacaVehiculo(
                    br.readLine().replace("Placa Vehiculo:", "").trim());

                contrato.setFechaInicio(
                    br.readLine().replace("Fecha Inicio:", "").trim());

                contrato.setFechaFin(
                    br.readLine().replace("Fecha Fin:", "").trim());

                contrato.setTotalDias(
                    Integer.parseInt(
                        br.readLine().replace("Total Dias:", "").trim()));

                contrato.setValorTotal(
                    Float.parseFloat(
                        br.readLine().replace("Valor Total:", "").trim()));

                contrato.setEstado(
                    br.readLine().replace("Estado:", "").trim());

                br.readLine(); // línea de guiones

                ContratoServicio.getContratos().add(contrato);
            }
        }

            System.out.println("Contratos cargados correctamente.");

        } catch (IOException e) {

            System.out.println(
                "No existe archivo de contratos. Se iniciará una lista vacía.");
        }
    }
}
