package Servicios;

import Modelos.ContratoRenting;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Scanner;

public class ContratoServicio
{
    static LinkedList<ContratoRenting> contratos = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    ValidacionServicio validacion = new ValidacionServicio();

    //si esta vble cambia, es porque encontro el nuevoContrato en modificar, consultar y eliminar
    boolean contratoEncontrado = false;

    public LinkedList<ContratoRenting> RegistrarContrato() 
    {
        boolean pedir = true, valido = true;
        String opcion = "";    
        while (pedir) {
            ContratoRenting nuevoContrato = new ContratoRenting ();
            
             //valido que no exista idcontrato
             //valido formato del idcontrato
            while (valido) {
                valido = false;

                System.out.print("Por favor Ingrese el id del contrato: ");
                nuevoContrato.setIdContrato(sc.nextLine().toUpperCase());

                // Validar formato
                if (!validacion.validarIdcontrato(nuevoContrato.getIdContrato())) {

                    valido = true;

                    continue;
                }

                // Validar repetidos
                //contrato es una varible temporal para comparar lo que hay en el objeto nuevo y lo que ya esta guardado en la lista 
                for (ContratoRenting contrato : contratos) {

                    if (contrato.getIdContrato().equals(nuevoContrato.getIdContrato())) {

                        System.out.println("El ID ya existe, ingrese otro");

                        valido = true;
                    }
                }
            }

            valido = true;
            while (valido) {
                //valido cédula
                valido = false;
 
                System.out.print("Ingrese la cedula del cliente: ");
                nuevoContrato.setCedulaCliente(sc.nextLine());
 
                // Agrego el while para que valide el Regex
                while (!validacion.ValidarNumeros(nuevoContrato.getCedulaCliente())) {
                    System.out.println("Ingrese nuevamente la cedula: ");
                    nuevoContrato.setCedulaCliente(sc.nextLine());
                }
 
                for (ContratoRenting contrato : contratos) {
 
                    if (contrato.getCedulaCliente().equalsIgnoreCase(nuevoContrato.getCedulaCliente())) {
 
                        System.out.println("El cliente ya tiene un vehículo alquilado");
 
                        System.out.println("Y. Desea Regiastrar otro cliente?");
                        System.out.println("N. Volver al menú principal");
                        opcion = sc.nextLine();
 
                        while (!validacion.ValidarDimension(opcion))
                        {
                            opcion = sc.nextLine();
                        }
                        if (opcion.equalsIgnoreCase("N")) {
 
                            return contratos;
                        }
 
                        valido = true;
 
                    }
                   
                }
            }

            //valido vehiculo no esté alquilado
            valido = true;
            while (valido) {

                valido = false;

                System.out.print("Ingrese la placa del vehículo: ");
                nuevoContrato.setPlacaVehiculo(sc.nextLine().toUpperCase());

                if(!validacion.validarPlaca(nuevoContrato.getPlacaVehiculo()))
                {
                    valido = true;
                    continue;
                }
                
                for (ContratoRenting contrato : contratos) {

                    if (contrato.getPlacaVehiculo().equals(nuevoContrato.getPlacaVehiculo())) {

                        System.out.println("El vehículo ya está alquilado");

                        valido = true;
                    }
                }
            }
            valido = true;
           
            String inicio = validacion.validarFecha("Ingrese la fecha de inicio (AAAA-MM-DD): ");
            nuevoContrato.setFechaInicio(inicio);

            String fin = validacion.validarFechaFin(inicio);
            nuevoContrato.setFechaFin(fin);
            
            //convierte las variables String a localdate para luego poder calcular lo dias entre ellas 
            LocalDate fechaInicio = LocalDate.parse(inicio);
            LocalDate fechaFin = LocalDate.parse(fin);

            //calcula cuantos dias hay entre las dos fechas ingresadas 
            long totalDias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
            nuevoContrato.setTotalDias( (int) totalDias);
            
            // se ingresa y se valida el valor total del contrato 
            nuevoContrato.setValorTotal(validacion.validarValorTotal());

            //Se agrega el objeto a la lista
            contratos.add(nuevoContrato);
            System.out.println("Contrato registrado...");
            new ExportarContratos().exportarContratos();
            
            System.out.print("Desea seguir registrando contratos Y/N: ");
            opcion = sc.nextLine();
            while (!validacion.ValidarDimension(opcion)) {
                opcion = sc.nextLine();
            }
            if (opcion.equalsIgnoreCase("N")) {
                pedir = false;
            }
        }
        return contratos;
    }
    //metodo ActualizarContrato con switch case para elegir que dato modificar del contrato
    public LinkedList<ContratoRenting> modificarContrato() {

        MenuServicio menu = new MenuServicio();
        contratoEncontrado = false;

        String idContrato;

        do {

            System.out.print("Ingrese el id del contrato que desea modificar: ");
            idContrato = sc.nextLine().toUpperCase();

        } while (!validacion.validarIdcontrato(idContrato));

        for (ContratoRenting contrato : contratos) {

            if (contrato.getIdContrato().equals(idContrato)) {

                contratoEncontrado = true;
                
                // Muestro la información actual del contrato antes de modificar
                System.out.println("Información actual del contrato...");
                System.out.println("Cédula del cliente: " + contrato.getCedulaCliente());
                System.out.println("Placa del vehículo: " + contrato.getPlacaVehiculo());
                System.out.println("Fecha de inicio: " + contrato.getFechaInicio());
                System.out.println("Fecha de fin: " + contrato.getFechaFin());
                System.out.println("Total de días: " + contrato.getTotalDias());
                System.out.println("Valor total: " + contrato.getValorTotal());

                System.out.println("------------------------------");

                int opcion = menu.actualizarContrato();

                switch (opcion) {

                    case 1:

                        String nuevaFechaInicio = validacion.validarFecha("Ingrese la nueva fecha de inicio (AAAA-MM-DD): ");

                        contrato.setFechaInicio(nuevaFechaInicio);

                        // Validar nuevamente la fecha fin
                        String fechaFin = validacion.validarFechaFin(nuevaFechaInicio);

                        contrato.setFechaFin(fechaFin);

                        validacion.recalcularDias(contrato);

                        System.out.println("Fecha de inicio actualizada.");
                        new ExportarContratos().exportarContratos();

                        break;

                    case 2:

                        String nuevaFechaFin = validacion.validarFechaFin(contrato.getFechaInicio());

                        contrato.setFechaFin(nuevaFechaFin);

                        validacion.recalcularDias(contrato);

                        System.out.println("Fecha de fin actualizada.");
                        new ExportarContratos().exportarContratos();

                        break;

                    case 3:

                        contrato.setValorTotal(validacion.validarValorTotal());

                        System.out.println("Valor total actualizado.");
                        new ExportarContratos().exportarContratos();

                        break;
                    case 4:
                        // Validar fecha inicio
                        String inicio = validacion.validarFecha("Ingrese la fecha de inicio (AAAA-MM-DD): ");
                        contrato.setFechaInicio(inicio);

                        // Validar fecha fin
                        String fin = validacion.validarFechaFin(inicio);
                        contrato.setFechaFin(fin);

                        // Calcular días
                        LocalDate fechaInicio = LocalDate.parse(inicio);
                        LocalDate fechaF = LocalDate.parse(fin);

                        long totalDias = ChronoUnit.DAYS.between(fechaInicio, fechaF);
                        contrato.setTotalDias((int) totalDias);

                        // Validar valor
                        contrato.setValorTotal(validacion.validarValorTotal());
                        System.out.println("información actualizada.");
                        new ExportarContratos().exportarContratos();

                        break;

                    case 5:

                        System.out.println("Modificación cancelada.");
                        break;
                }
            }
        }

        if (!contratoEncontrado) {

            System.out.println("Contrato no encontrado...");
        }

        return contratos;
    }

    public void Consultar() {

        contratoEncontrado = false;
        String idContrato;

        // Validar formato del ID
        do {

            System.out.print("Por favor Ingrese el id del Contrato a buscar: ");
            idContrato = sc.nextLine();

        } while (!validacion.validarIdcontrato(idContrato));

        // Buscar contrato
        for (ContratoRenting nuevoContrato : contratos) {
            if (nuevoContrato.getIdContrato().equals(idContrato)) {
                contratoEncontrado = true;

                System.out.println("Cédula del cliente: " + nuevoContrato.getCedulaCliente());
                System.out.println("Placa del vehículo: " + nuevoContrato.getPlacaVehiculo());
                System.out.println("Fecha de inicio: " + nuevoContrato.getFechaInicio());
                System.out.println("Fecha de fin: " + nuevoContrato.getFechaFin());
                System.out.println("Total de días: " + nuevoContrato.getTotalDias());
                System.out.println("Valor total: " + nuevoContrato.getValorTotal());
                System.out.println("Estado: " + nuevoContrato.getEstado());

                System.out.println("------------------------------");
            }
        }
        if (!contratoEncontrado) {
            System.out.println("Contrato no encontrado...");
        }
    }
    
    public LinkedList<ContratoRenting> finalizarContrato() {

        String idContrato;
        do{
            System.out.print("Por favor Ingrese el id del Contrato a finalizar: ");
            idContrato = sc.nextLine().toUpperCase();
        }while (!validacion.validarIdcontrato(idContrato));
        
        contratoEncontrado = false;

        for (ContratoRenting contrato : contratos) {

            if (contrato.getIdContrato().equals(idContrato)) {

                // Cambia la fecha fin al día actual
                contrato.setFechaFin(LocalDate.now().toString());

                contratoEncontrado = true;

                System.out.println("Contrato finalizado correctamente...");
                new ExportarContratos().exportarContratos();
            }
        }

        if (!contratoEncontrado) {

            System.out.println("Contrato no encontrado...");
        }

        return contratos;
    }
    
    public void imprimirInforme() {

        float totalIngresos = 0;

        System.out.println("\n---- CONTRATOS ACTIVOS ----");

        for (ContratoRenting contrato : contratos) {

            if (contrato.getEstado().equals("ACTIVO")) {

                imprimir(contrato);

                totalIngresos += contrato.getValorTotal();
            }
        }

        System.out.println("\n---- CONTRATOS FINALIZADOS ----");
 
        for (ContratoRenting contrato : contratos) {

            if (contrato.getEstado().equals("FINALIZADO")) {

                imprimir(contrato);

                totalIngresos += contrato.getValorTotal();
            }
        }

        System.out.println("\n---- INGRESOS TOTALES ----");
        System.out.println("Total generado por renting: $" + totalIngresos);
    }
    
    public void imprimir(ContratoRenting nuevoContrato) {
        System.out.println("-------------------------- --");
        System.out.println("Id del nuevoContrato: " + nuevoContrato.getIdContrato());
        System.out.println("Cédula del cliente: " + nuevoContrato.getCedulaCliente());
        System.out.println("Placa del vehículo: " + nuevoContrato.getPlacaVehiculo());
        System.out.println("Fecha de inicio: " + nuevoContrato.getFechaInicio());
        System.out.println("Fecha de fin: " + nuevoContrato.getFechaFin());
        System.out.println("Total de días: " + nuevoContrato.getTotalDias());
        System.out.println("Valor total: " + nuevoContrato.getValorTotal());
        System.out.println("Estado: " + nuevoContrato.getEstado());
        System.out.println("------------------------------");
    }

    // Conseguir y editar lista de contratos (para exportar)
    public static LinkedList<ContratoRenting> getContratos() {
        return contratos;
    }

    public boolean setContratos(LinkedList<ContratoRenting> contratos) {
        ContratoServicio.contratos = contratos;

        return true;
    }
}
