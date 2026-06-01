package Servicios;

import java.util.Scanner;

public class ValidacionServicio {
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
}