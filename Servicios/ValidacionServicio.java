package Servicios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import Modelos.ContratoRenting;

public class ValidacionServicio {
    private Scanner teclado = new Scanner(System.in);

    public ValidacionServicio() {
    }

    public boolean validarPlaca(String placa) {
        /*
         * ^ -> Inicio del string
         * [A-Z]{3} -> Exactamente 3 letras
         * - -> Debe haber un guión
         * \d{3} -> Exactamente 3 números
         * $ -> Fin del string
         */
        String placaRegex = "^[A-Z]{3}-\\d{3}$";

        if (placa.matches(placaRegex)) {
            return true;
        }

        System.out.println("La placa es inválida. Debe seguir el formato AAA-000");
        return false;
    }

    public boolean validarTexto(String texto) {
        String textoRegex = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{3,30}$";

        if (texto.matches(textoRegex)) {
            return true;
        }

        System.err.println(
                "Debe ser mayor a 3 caracteres y menor a 30 carácteres. No puede contener numeros ni simbolos especiales");
        return false;
    }

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor Ingrese un digito Numérico");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public boolean ValidarDimension(String opt) {

        if (!opt.equalsIgnoreCase("Y") &&
            !opt.equalsIgnoreCase("N")) {

            System.out.println("Solo puede ingresar Y o N");

            return false;
        }

        return true;
    }

    public boolean ValidarDireccion(String direccion){
        String direccionRegex = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ#\\-., ]{10,100}$";

        if (direccion.matches(direccionRegex)) {

            return true;

        } 
        System.out.println("Direccion invalida");
        return false;
    }

    public boolean ValidarNumeros(String Numeros){

        String numerosRegex = "^[0-9]{6,10}$";

        if (Numeros.matches(numerosRegex)) {
            
            return true;
            
        }
        System.out.println("Debe ingresar de 6 a 10 numeros, reintente...");
        return false;
    }

    public boolean validarIdcontrato(String idContrato)
    {
        String idContratoregex = "CTR\\d{3}";

        if (idContrato.matches(idContratoregex)) {
            return true;
        }

        System.out.println("El id del contrato no es válido. Debe seguir el formato CTR000"); 
        return false;
    }
    //valido que la fecha de inicio sea posterior a la fecha actual
    public String validarFecha(String mensaje) {

        try {

            System.out.print( mensaje);
            String fechaInicio = teclado.nextLine();

            LocalDate fechaActual = LocalDate.now();
            LocalDate inicio = LocalDate.parse(fechaInicio);

            if (inicio.isBefore(fechaActual)) {

                System.out.println("La fecha de inicio no puede ser menor que la fecha actual");

                return validarFecha(mensaje);
            }

            return fechaInicio;

        } catch (Exception e) {

            System.out.println("Fecha inválida. Use formato AAAA-MM-DD");

            return validarFecha(mensaje);
        }
    }
    
    // Valida que la fecha de fin sea posterior a la fecha de inicio
    public String validarFechaFin(String fechaInicio) {

        try {

            System.out.print("Ingrese la fecha de fin (AAAA-MM-DD): ");
            String fechaFin = teclado.nextLine();

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

    public void recalcularDias(ContratoRenting contrato) {

        LocalDate fechaInicio = LocalDate.parse(contrato.getFechaInicio());

        LocalDate fechaFin = LocalDate.parse(contrato.getFechaFin());

        long totalDias =
                ChronoUnit.DAYS.between(fechaInicio, fechaFin);

        contrato.setTotalDias((int) totalDias);
    }
    public float validarValorTotal() {

        try {

            System.out.print("Ingrese el valor total: ");

            float valor = Float.parseFloat(teclado.nextLine());

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