<<<<<<< HEAD
package Servicios;
public class Validaciones 
{
    //este metodo solo valida la dimension de lo ingresado, no precisa mente las letras 
    public boolean ValidarDimension(String opt) {
        while (opt.length() > 1) {
            System.out.println("Solo puede agregar Y or N");
            return false;

        }
        return true;

    }
    //este metodo si valida las letras literalmente
    /* public boolean ValidarDimension(String opt) {

        if (!opt.equalsIgnoreCase("Y") &&
            !opt.equalsIgnoreCase("N")) {

            System.out.println("Solo puede ingresar Y o N");

            return false;
        }

        return true;
    }*/
}
=======
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

    /*public boolean validarTexto(String texto) {
        // Se valida que: no contenga numeros, simbolos y que su longitud sea coherente
    }

    public boolean validarEntero(int numero) {

    }

    public boolean validarDecimal(float numero) {

    }*/
}
>>>>>>> origin/dev
