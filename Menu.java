import java.util.Scanner;

public class Menu {
    private Scanner teclado = new Scanner(System.in);

    public Menu() {}

    public int general() {
        try {
            System.out.println("------BIENVENIDO A RENTING CARROS------");
            System.out.println("1. Seccion de Clientes");
            System.out.println("2. Seccion de Vehiculos");
            System.out.println("3. Seccion de Contratos");
            System.out.println("4. Exportar informacion");
            System.out.println("5. Salir");
                
            System.out.println("Ingrese la opcion que desea realizar: ");
            int opcion = Integer.parseInt(teclado.nextLine());

            return opcion;
        } catch(NumberFormatException error) {
            System.out.println("Escriba por favor un numero.");

            return 0;
        }
    }

    public int clientes() {
        try {
            System.out.println("------SECCION DE CLIENTES------");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Consultar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Ver todos los clientes");
            System.out.println("6. Regresar al menu principal");
                
            System.out.println("Ingrese la opcion que desea realizar: ");
            int opcion = Integer.parseInt(teclado.nextLine());

            return opcion;
        } catch(NumberFormatException error) {
            System.out.println("Escriba por favor un numero.");

            return 0;
        }
    }

    public int vehiculos() {
        try {
            System.out.println("------SECCION DE VEHICULOS------");
            System.out.println("1. Agregar Vehiculo");
            System.out.println("2. Actualizar Vehiculo");
            System.out.println("3. Consultar Vehiculo");
            System.out.println("4. Eliminar Vehiculo");
            System.out.println("5. Ver todos los Vehiculos");
            System.out.println("6. Regresar al menu principal");
                
            System.out.println("Ingrese la opcion que desea realizar: ");
            int opcion = Integer.parseInt(teclado.nextLine());

            return opcion;
        } catch(NumberFormatException error) {
            System.out.println("Escriba por favor un numero.");

            return 0;
        }
    }

    public int contratos() {
        try {
            System.out.println("------SECCION DE CONTRATOS------");
            System.out.println("1. Agregar Contrato");
            System.out.println("2. Actualizar Contrato");
            System.out.println("3. Consultar Contrato");
            System.out.println("4. Eliminar Contrato");
            System.out.println("5. Ver todos los contratos");
            System.out.println("6. Regresar al menu principal");
                
            System.out.println("Ingrese la opcion que desea realizar: ");
            int opcion = Integer.parseInt(teclado.nextLine());

            return opcion;
        } catch(NumberFormatException error) {
            System.out.println("Escriba por favor un numero.");

            return 0;
        }
    }
}