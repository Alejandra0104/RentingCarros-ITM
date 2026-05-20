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
