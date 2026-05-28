import Servicios.VehiculoServicio;

public class main {
    public static void main(String[] args) {
        Menu servicioMenu = new Menu();

        // Inicializacion de Servicios
        VehiculoServicio servicioVehiculo = new VehiculoServicio();

        // Mostrar menú general de forma infinita hasta que el usuario desee salir
        while(true) {
            int opcionGeneral = servicioMenu.general();

            boolean continuar = true;

            switch(opcionGeneral) {
                case 1: // Seccion Clientes
                    break;
                case 2: // Seccion Vehiculos
                    while(continuar) {
                        // Mostrar menu de clientes de forma infinita hasta que el usuario desee retroceder
                        int opcionVehiculo = servicioMenu.vehiculos();

                        switch (opcionVehiculo) {
                            case 1: // Agregar
                                servicioVehiculo.agregar();
                                break;
                            case 2: // Actualizar
                                // falta terminar.
                                break;
                            case 3: // Consultar
                                //servicioVehiculo.consultar();
                                break;
                            case 4: // Eliminar
                                //servicioVehiculo.eliminar();
                                break;
                            case 5: // Obtener todos
                                //servicioVehiculo.mostrar();
                                break;
                            case 6: // Devolverme al menu principal
                                System.out.println("Devolviendo...");
                                continuar = false;

                                break;
                            default:
                                System.out.println("Por favor elige una opcion correcta.");
                                break;
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
                default:
                    System.out.println("Por favor elige una opcion correcta.");
            }
        }
    }
}