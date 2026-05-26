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