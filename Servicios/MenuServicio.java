package Servicios;

import java.util.Scanner;

public class MenuServicio {
    private Scanner teclado = new Scanner(System.in);

    public MenuServicio() {
    }

    public int general() {
        while (true) {
            try {
                System.out.println("------BIENVENIDO A RENTING CARROS------");
                System.out.println("1. Seccion de Clientes");
                System.out.println("2. Seccion de Vehiculos");
                System.out.println("3. Seccion de Contratos");
                System.out.println("4. Exportar informacion");
                System.out.println("5. Salir");

                System.out.print("Ingrese la opcion que desea realizar: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                // Validar opcion
                if (opcion > 0 && opcion < 6) {
                    return opcion;
                }

                System.out.println("Ingresa una opcion valida.");
            } catch (NumberFormatException error) {
                System.out.println("Escriba por favor un numero.");
            }
        }
    }

    // Sub menus
    public int clientes() {
        while (true) {
            try {
                System.out.println("------SECCION DE CLIENTES------");
                System.out.println("1. Agregar Cliente");
                System.out.println("2. Actualizar Cliente");
                System.out.println("3. Consultar Cliente");
                System.out.println("4. Eliminar Cliente");
                System.out.println("5. Ver todos los clientes");
                System.out.println("6. Regresar al menu principal");

                System.out.print("Ingrese la opcion que desea realizar: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                // Validar opcion
                if (opcion > 0 && opcion < 7) {
                    return opcion;
                }

                System.out.println("Ingresa una opcion valida.");
            } catch (NumberFormatException error) {
                System.out.print("Escriba por favor un numero.");
            }
        }
    }

    public int vehiculos() {
        while (true) {
            try {
                System.out.println("------SECCION DE VEHICULOS------");
                System.out.println("1. Agregar Vehiculo");
                System.out.println("2. Actualizar Vehiculo");
                System.out.println("3. Consultar Vehiculo");
                System.out.println("4. Eliminar Vehiculo");
                System.out.println("5. Ver todos los Vehiculos");
                System.out.println("6. Regresar al menu principal");

                System.out.print("Ingrese la opcion que desea realizar: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                // Validar opcion
                if (opcion > 0 && opcion < 7) {
                    return opcion;
                }

                System.out.println("Ingresa una opcion valida.");
            } catch (NumberFormatException error) {
                System.out.print("Escriba por favor un numero.");
            }
        }
    }

    public int contratos() {
        while (true) {
            try {
                System.out.println("------SECCION DE CONTRATOS------");
                System.out.println("1. Agregar Contrato");
                System.out.println("2. Actualizar Contrato");
                System.out.println("3. Consultar Contrato");
                System.out.println("4. Eliminar Contrato");
                System.out.println("5. Ver todos los contratos");
                System.out.println("6. Regresar al menu principal");

                System.out.print("Ingrese la opcion que desea realizar: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                // Validar opcion
                if (opcion > 0 && opcion < 7) {
                    return opcion;
                }

                System.out.println("Ingresa una opcion valida.");
            } catch (NumberFormatException error) {
                System.out.print("Escriba por favor un numero.");

                return 0;
            }
        }
    }

    // Menus de Actualizacion
    public int actualizarCliente() {
        while (true) {
            try {
                System.out.println("------ACTUALIZAR CLIENTE------");
                System.out.println("1. Nombre");
                System.out.println("2. Apellido");
                System.out.println("3. Telefono");
                System.out.println("4. Dirección");
                System.out.println("5. Licencia de Conducción");
                System.out.println("6. Cancelar");

                System.out.print("Ingrese la opción que desea actualizar: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                // Validar opcion
                if (opcion > 0 && opcion < 7) {
                    return opcion;
                }

                System.out.println("Ingresa una opcion valida.");
            } catch (NumberFormatException e) {
                System.out.println("Escriba por favor un numero");
            }
        }
    }

    public int actualizarVehiculo() {
        while (true) {
            try {
                System.out.println("------ACTUALIZAR VEHICULO------");
                System.out.println("1. Marca");
                System.out.println("2. Modelo");
                System.out.println("3. Precio Diario");
                System.out.println("4. Traccion (Camioneta SUV)");
                System.out.println("5. Capacidad de Maletero (Camioneta SUV)");
                System.out.println("6. Tipo de Combustible (Carro Sedan)");
                System.out.println("7. Transmision (Carro Sedan)");
                System.out.println("8. Cancelar");

                System.out.print("Ingrese la opción que desea actualizar: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                // Validar opcion
                if (opcion > 0 && opcion < 9) {
                    return opcion;
                }

                System.out.println("Ingresa una opcion valida.");
            } catch (NumberFormatException e) {
                System.out.println("Escriba por favor un numero");
            }
        }
    }

    public int actualizarContrato() {
        while (true) {
            try {
                System.out.println("------ACTUALIZAR CONTRATO------");
                System.out.println("1. Cedula de Cliente");
                System.out.println("2. Placa de Vehiculo");
                System.out.println("3. Fecha de Inicio");
                System.out.println("4. Fecha de Fin");
                System.out.println("5. Cancelar");

                System.out.print("Ingrese la opción que desea actualizar: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                // Validar opcion
                if (opcion > 0 && opcion < 6) {
                    return opcion;
                }

                System.out.println("Ingresa una opcion valida.");
            } catch (NumberFormatException e) {
                System.out.println("Escriba por favor un numero");
            }
        }
    }

    // Menús utiles
    public int preguntarContinuar() {
        while (true) {
            try {
                System.out.println("Desea continuar?");
                System.out.println("1. Si");
                System.out.println("2. No");

                System.out.print("Digite el número de la opcion que desea: ");
                int opcion = Integer.parseInt(teclado.nextLine());

                // Verificando que la opción es valida
                if (opcion > 0 || opcion < 3) {
                    return opcion;
                }

                System.out.println("Debes ingresar una opción valida.");
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un número.");
            }
        }
    }
}