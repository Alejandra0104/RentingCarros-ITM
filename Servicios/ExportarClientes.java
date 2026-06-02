package Servicios;

import Modelos.Cliente;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportarClientes {
    ClienteServicio servicioCliente = new ClienteServicio();

    public boolean Cliente(){

        List<Cliente> cliente = servicioCliente.getListaClientes();

        //Exportar CVS
        StringBuilder csvBuilder = new StringBuilder();
         csvBuilder.append("Cedula,Nombre,Apellido,Telefono,Direccion,LicenciaConduccion\n");

         for (Cliente clientes : cliente) {

            csvBuilder.append(clientes.getCedula()).append(",");
            csvBuilder.append(clientes.getNombre()).append(",");
            csvBuilder.append(clientes.getApellido()).append(",");
            csvBuilder.append(clientes.getTelefono()).append(",");
            csvBuilder.append(clientes.getDireccion()).append(",");
            csvBuilder.append(clientes.getLicenciaConduccion()).append(",");

         }
         // Guardar CVS en archivo 
         try(FileWriter fileWriter = new FileWriter("exports/clientes.cvs")) {
             fileWriter.write(csvBuilder.toString());
             System.out.println("Clientes exportados exitosamente a clientes.cvs");
         } catch (IOException e) {
            System.out.println("Error al exportar clientes: " + e.getMessage());
         }
         return true;
    }
    
}
