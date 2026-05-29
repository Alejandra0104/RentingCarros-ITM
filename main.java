import Servicios.MenuServicio;
import Servicios.VehiculoServicio;

public class main {
    public static void main(String[] args) {
        MenuServicio servicioMenu = new MenuServicio();

        // Inicializacion de Servicios
        VehiculoServicio servicioVehiculo = new VehiculoServicio();

        // Mostrar menú general de forma infinita hasta que el usuario desee salir
        while (true) {
            int opcionGeneral = servicioMenu.general();

            boolean continuar = true;

            switch (opcionGeneral) {
                case 1: // Seccion Clientes
                    break;
                case 2: // Seccion Vehiculos
                    while (continuar) {
                        // Mostrar menu de clientes de forma infinita hasta que el usuario desee
                        int opcionVehiculo = servicioMenu.vehiculos();

                        switch (opcionVehiculo) {
                            case 1 -> {
                                servicioVehiculo.agregar();
                            }
                            case 2 -> {
                                servicioVehiculo.actualizar();
                            } // Actualizar
                            case 3 -> {
                                servicioVehiculo.consultar();
                            } // Consultar
                            case 4 -> {
                                /* servicioVehiculo.eliminar(); */ } // Eliminar
                            case 5 -> {
                                servicioVehiculo.mostrar();
                            } // Obtener todos
                            case 6 -> {
                                // Devolverme al menu principal
                                System.out.println("Devolviendo...");
                                continuar = false;
                            }
                        }
                    }

                    break;
                case 3: // Seccion Contratos
                    break;
                case 4: // Imprimir datos
                    break;
                case 5: // Salir del sistema
                    System.out.println("Saliendo...");

                    System.exit(0);
                    break;
            }
        }
    }
}