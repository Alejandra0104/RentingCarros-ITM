package Servicios;

import Modelos.ContratoRenting;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Scanner;

public class Contrato 
{ 
    Scanner sc = new Scanner(System.in);
        public LinkedList<ContratoRenting> RegistrarContrato(LinkedList<ContratoRenting> contratos) 
        {
            Validaciones v = new Validaciones();
            boolean pedir = true, valido = true;
            String opt = "";
            while (pedir) {
                ContratoRenting o = new ContratoRenting ();
                //valido que no exista idcontrato
                while (valido) {

                    valido = false;

                    System.out.print("Por favor Ingrese el id del contrato: ");
                    o.setIdContrato(sc.nextLine());

                    //c es una varible temporal para comparar lo que hay en el objeto nuevo y lo que ya esta guardado en la lista 
                    for (ContratoRenting c : contratos) {

                        if (c.getIdContrato().equals(o.getIdContrato())) {

                            System.out.println("El ID ya existe, ingrese otro");

                            valido = true;
                        }
                    }
                }
                //valido cédula
                valido = true ;
                while (valido) {

                    valido = false;

                    System.out.print("Ingrese la cedula del cliente: ");
                    o.setCedulaCliente(sc.nextLine());

                    for (ContratoRenting c : contratos) {

                        if (c.getCedulaCliente().equals(o.getCedulaCliente())) {

                            System.out.println("El cliente ya tiene un vehículo alquilado");

                            valido = true;
                        }
                    }
                }
                //valido vehiculo no esté alquilado
                valido = true;
                while (valido) {

                    valido = false;

                    System.out.print("Ingrese la placa del vehículo: ");
                    o.setPlacaVehiculo(sc.nextLine());

                    for (ContratoRenting c : contratos) {

                        if (c.getPlacaVehiculo().equals(o.getPlacaVehiculo())) {

                            System.out.println("El vehículo ya está alquilado");

                            valido = true;
                        }
                    }
                }
                valido = true;
                System.out.print("Ingrese la fecha de inicio (AAAA-MM-DD): ");
                String inicio = sc.nextLine();
                o.setFechaInicio(inicio);
                System.out.print("Ingrese la fecha de fin (AAAA-MM-DD): ");
                String fin = sc.nextLine();
                o.setFechaFin(fin);
                
                //convierte las variables String a localdate para luego poder calcular lo dias entre ellas 
                LocalDate fechaInicio = LocalDate.parse(inicio);
                LocalDate fechaFin = LocalDate.parse(fin);

                //calcula cuantos dias hay entre las dos fechas ingresadas 
                long totalDias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
                o.setTotalDias( (int) totalDias);

                System.out.print("Ingrese el valor total: ");
                o.setValorTotal(sc.nextFloat());
                
                contratos.add(o);
                System.out.println("Contrato registrado...");
                
                sc.nextLine();
                System.out.print("Desea seguir registrando contratos Y/N: ");
                opt = sc.nextLine();
                while (!v.ValidarDimension(opt)) {
                    opt = sc.nextLine();
                }
                if (opt.equalsIgnoreCase("N")) {
                    pedir = false;
                }
            }
            return contratos;
        }
    
    public LinkedList<ContratoRenting> modificarContrato(LinkedList<ContratoRenting> contratos) 
    {
        System.out.print("Ingrese el id del contrato que desea modificar: ");
        String idContrato = sc.nextLine();
        System.out.println("");
        for (ContratoRenting o : contratos) {
            if (o.getIdContrato().equals(idContrato)) {
                System.out.println("Información actual del contrato...");
                System.out.println("Cédula del cliente: " + o.getCedulaCliente());
                System.out.println("Placa del vehículo: " + o.getPlacaVehiculo());
                System.out.println("Fecha de inicio: " + o.getFechaInicio());
                System.out.println("Fecha de fin: " + o.getFechaFin());
                System.out.println("Total de días: " + o.getTotalDias());
                System.out.println("Valor total: " + o.getValorTotal());
                System.out.println("------------------------------");
                System.out.println("A continuacion debes ingresar la nueva información...");
                System.out.print("Ingrese la nueva fecha de inicio (AAAA-MM-DD):");
                String inicio = sc.nextLine();
                o.setFechaInicio(inicio);
                System.out.print("Ingrese la nueva fecha de fin (AAAA-MM-DD): ");
                String fin = sc.nextLine();
                o.setFechaFin(fin);

                LocalDate fechaInicio = LocalDate.parse(inicio);
                LocalDate fechaFin = LocalDate.parse(fin);

                long totalDias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
                o.setTotalDias( (int) totalDias);

                System.out.print("Ingrese el valor total: ");
                o.setValorTotal(sc.nextFloat());

                System.out.println("Contrato modificado correctamente");

            }else 
                System.out.println("Contrato no encontrado");
        }
        return contratos;
    }
    
    public LinkedList<ContratoRenting> finalizarContrato(LinkedList<ContratoRenting> contratos) {

        System.out.print("Por favor Ingrese el id del contrato a eliminar: ");
        String idContrato = sc.nextLine();
        //elimina si el id ingresado es igual al guardado
        contratos.removeIf(x -> x.getIdContrato().equals(idContrato));
        System.out.println("El contrato se eliminó correctamente...");
        return contratos;
    }
    
    public void Consultar(LinkedList<ContratoRenting> contratos) {
        System.out.print("Por favor Ingrese el id del contrato a buscar: ");
        String idContrato = sc.nextLine();
        for (ContratoRenting o : contratos) {
            if (o.getIdContrato().equals(idContrato)) {
                System.out.println("Cédula del cliente: " + o.getCedulaCliente());
                System.out.println("Placa del vehículo: " + o.getPlacaVehiculo());
                System.out.println("Fecha de inicio: " + o.getFechaInicio());
                System.out.println("Fecha de fin: " + o.getFechaFin());
                System.out.println("Total de días: " + o.getTotalDias());
                System.out.println("Valor total: " + o.getValorTotal());
                System.out.println("------------------------------");
            }
        }
    }
}
