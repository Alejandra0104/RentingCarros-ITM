package Servicios;
import java.util.Scanner;

public class Validaciones {
    public Validaciones() {}

    public boolean validarPlaca(String placa) {
        /*
        * ^ -> Inicio del string
        * [A-Z]{3} -> Exactamente 3 letras
        * - -> Debe haber un guión
        * \d{3} -> Exactamente 3 números
        * $ -> Fin del string
        * */
        String placaRegex = "^[A-Z]{3}-\\d{3}$";

        if(placa.matches(placaRegex)) {
            return true;
        }

        System.out.println("La placa es inválida. Debe seguir el formato AAA-000");
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

    /*public boolean validarTexto(String texto) {
        // Se valida que: no contenga numeros, simbolos y que su longitud sea coherente
    }

    public boolean validarEntero(int numero) {

    }

    public boolean validarDecimal(float numero) {

    }*/
    public boolean ValidarNumeros(String Numeros){

        String numerosRegex = "^[0-9]{6,10}$";

        if (Numeros.matches(numerosRegex)) {
            
            return true;
            
        }
        System.out.println("Debe ingresar de 6 a 10 numeros, reintente...");
        return false;
        
        
    }
      

    public boolean ValidarTexto(String Texto){

        String textoRegex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{2,50}$";

        if (Texto.matches(textoRegex)) {

             return true;


        }
        System.out.println("Debe ingresar 2 a 50 caracteres de texto, reintente...");
        return false;
    }
    public boolean ValidarDireccion(String direccion){

        String direccionRegex = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ#\\-., ]{10,100}$";

        if (direccion.matches(direccionRegex)) {

            return true;

        } 
        System.out.println("Direccion invalida");
        return false;
    }
    
}