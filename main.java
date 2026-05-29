import Servicios.ContratoServicio;
import Modelos.ContratoRenting;
import java.util.LinkedList;

public class main {
    public static void main(String[] args) {
        Menu servicioMenu = new Menu();

        // Inicializacion de Controladores
        VehiculoControlador controladorVehiculo = new VehiculoControlador();

        /*// Inicializacion de Servicios
        VehiculoServicio servicioVehiculo = new VehiculoServicio();*/
        ContratoServicio servicioContrato = new ContratoServicio();
        LinkedList<ContratoRenting> contratos = new LinkedList<>();

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
                    
                    while(continuar){
                        int opcionContrato = servicioMenu.contratos();
                        switch (opcionContrato) {
                            case 1:// Registrar contrato
                                contratos = servicioContrato.RegistrarContrato(contratos);
                                break;
                            case 2:
                                //ModificarContrato
                                servicioContrato.modificarContrato(contratos);
                                break;
                            case 3:
                                //Consultar contrato
                                servicioContrato.Consultar(contratos);
                                break;
                            case 4:
                                //Eliminar contrato
                                contratos = servicioContrato.finalizarContrato(contratos);
                                break;
                            case 5:
                                //Mostrar todos los contratos  
                                servicioContrato.imprimirInforme(contratos);
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
                default:
                    System.out.println("Por favor elige una opcion correcta.");
            }
        }
    }
}