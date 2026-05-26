
import Modelos.Cliente;
import Servicios.ClienteServicio;
import java.util.ArrayList;
import java.util.Scanner;



public class main {
    public static void main(String[] args) {
        Menu servicioMenu = new Menu();
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        ClienteServicio servicios = new ClienteServicio();
        

        // Inicializacion de Controladores
        VehiculoControlador controladorVehiculo = new VehiculoControlador();

        /*// Inicializacion de Servicios
        VehiculoServicio servicioVehiculo = new VehiculoServicio();*/

        // Mostrar menú general de forma infinita hasta que el usuario desee salir
        while(true) {
            int opcionGeneral = servicioMenu.general();

            boolean continuar = true;
            

            switch(opcionGeneral) {
                case 1: // Seccion Clientes
                    while (continuar) {
                        int opcionClientes = servicioMenu.clientes();

                        switch(opcionClientes) {
                            case 1: // Registrar
                                servicios.RegistrarCliente();
                                break;
                            case 2: // Modificar
                                servicios.Modificar();
                                break;   
                            case 3: // Consultar
                               servicios.Consultar(); 
                                break;  
                            case 4: // Eliminar
                              servicios.Eliminar();
                                break;  
                            case 5:// Ver todos los Clientes
                              servicios.VerClientes();
                                break;    
                            case 6: // Dvolverme al menu principal
                                System.out.println("Devolviendo...");
                                continuar = false;
                                break;   
                            default:
                                System.out.println("Por favor elige una opcion correcta.");
                                break;          
                        }
                        
                    }
                    break;
                case 2: // Seccion Vehiculos
                    while(continuar) {
                        // Mostrar menu de clientes de forma infinita hasta que el usuario desee retroceder
                        int opcionCliente = servicioMenu.clientes();

                        switch (opcionCliente) {
                            case 1: // Agregar
                                controladorVehiculo.agregar();
                                break;
                            case 2: // Actualizar
                                // falta terminar.
                                break;
                            case 3: // Consultar
                                controladorVehiculo.consultar();
                                break;
                            case 4: // Eliminar
                                controladorVehiculo.eliminar();
                                break;
                            case 5: // Obtener todos
                                controladorVehiculo.mostrar();
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

