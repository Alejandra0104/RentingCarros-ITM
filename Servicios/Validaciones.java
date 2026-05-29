package Servicios;

import java.time.LocalDate;
import java.util.Scanner;

public class Validaciones 
{
    Scanner sc = new Scanner(System.in);

    //este metodo solo valida la dimension de lo ingresado, no precisa mente las letras 
    /*public boolean ValidarRango(String opt) {
        while (opt.length() > 1) {
            System.out.println("Solo puede agregar Y or N");
            return false;

        }
        return true;

    }*/
    
     public boolean ValidarDimension(String opt) {

        if (!opt.equalsIgnoreCase("Y") &&
            !opt.equalsIgnoreCase("N")) {

            System.out.println("Solo puede ingresar Y o N");

            return false;
        }

        return true;
    }

    public boolean validarIdcontrato(String idContrato)
    {
        String idContratoregex = "CTR\\d{3}";

        if (idContrato.matches(idContratoregex)) {
            return true;
        }

        System.out.println("el id del contrato no es valido. debe seguir el formato CRT000");
        return false;
    }
    public String validarFecha(String mensaje) {

        try {

            System.out.print(mensaje);
            String fecha = sc.nextLine();

            // Intenta convertir la fecha
            LocalDate.parse(fecha);

            return fecha;

        } catch (Exception e) {

            System.out.println("Fecha inválida. Use formato AAAA-MM-DD");

            return validarFecha(mensaje);
        }
    }
    
    public String validarFechaFin(String fechaInicio) {

        try {

            System.out.print("Ingrese la fecha de fin (AAAA-MM-DD): ");
            String fechaFin = sc.nextLine();

            LocalDate inicio = LocalDate.parse(fechaInicio);
            LocalDate fin = LocalDate.parse(fechaFin);

            if (fin.isBefore(inicio)) {

                System.out.println("La fecha fin no puede ser menor que la fecha inicio");

                return validarFechaFin(fechaInicio);
            }

            return fechaFin;

        } catch (Exception e) {

            System.out.println("Fecha inválida. Use formato AAAA-MM-DD");

            return validarFechaFin(fechaInicio);
        }
    }

    public float validarValorTotal() {

        try {

            System.out.print("Ingrese el valor total: ");

            float valor = Float.parseFloat(sc.nextLine());

            if (valor <= 0) {

                System.out.println("El valor debe ser mayor a 0");

                return validarValorTotal();
            }

            return valor;

        } catch (Exception e) {

            System.out.println("Debe ingresar un número válido");

            return validarValorTotal();
        }
    }
}