import Servicios.ClienteServicio;
import Servicios.ContratoServicio;
import Servicios.MenuServicio;
import Servicios.VehiculoServicio;

public class main {
    public static void main(String[] args) {
        MenuServicio servicioMenu = new MenuServicio();

        // Inicializacion de Servicios
        VehiculoServicio servicioVehiculo = new VehiculoServicio();
        ClienteServicio servicioCliente = new ClienteServicio();
        ContratoServicio servicioContrato = new ContratoServicio();

        // Mostrar menú general de forma infinita hasta que el usuario desee salir
        while (true) {
            int opcionGeneral = servicioMenu.general();

            boolean continuar = true;

            switch (opcionGeneral) {
                case 1: // Seccion Clientes
                    while (continuar) {
                        int opcionClientes = servicioMenu.clientes();

                        switch(opcionClientes) {
                            case 1: // Registrar
                                servicioCliente.RegistrarCliente();
                                break;
                            case 2: // Modificar
                                servicioCliente.Modificar();
                                break;   
                            case 3: // Consultar
                                servicioCliente.Consultar(); 
                                break;  
                            case 4: // Eliminar
                                servicioCliente.Eliminar();
                                break;  
                            case 5:// Ver todos los Clientes
                                servicioCliente.VerClientes();
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
                    while (continuar) {
                        // Mostrar menu de clientes de forma infinita hasta que el usuario desee
                        int opcionVehiculo = servicioMenu.vehiculos();

                        switch (opcionVehiculo) {
                            case 1 -> {
                                servicioVehiculo.agregar();
                            }
                            case 2 -> {
                                servicioVehiculo.actualizar();
                            }
                            case 3 -> {
                                servicioVehiculo.consultar();
                            }
                            case 4 -> {
                                //servicioVehiculo.eliminar();
                            }
                            case 5 -> {
                                servicioVehiculo.mostrar();
                            }
                            case 6 -> {
                                // Devolverme al menu principal
                                System.out.println("Devolviendo...");
                                continuar = false;
                            }
                        }
                        
                    }
                    break;
                case 3: // Seccion Contratos
                    while(continuar){
                        int opcionContrato = servicioMenu.contratos();
                        switch (opcionContrato) {
                            case 1:// Registrar contrato
                                servicioContrato.RegistrarContrato();
                                break;
                            case 2:
                                //ModificarContrato
                                servicioContrato.modificarContrato();
                                break;
                            case 3:
                                //Consultar contrato
                                servicioContrato.Consultar();
                                break;
                            case 4:
                                //Eliminar contrato
                                servicioContrato.finalizarContrato();
                                break;
                            case 5:
                                //Mostrar todos los contratos  
                                servicioContrato.imprimirInforme();
                                break;
                            case 6:// Devolverme al menu principal
                                System.out.println("Devolviendo...");
                                continuar = false;
                                break;
                            default:
                                System.out.println("Opción no valida, reintente...");
                                break;
                        }
                    }
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

