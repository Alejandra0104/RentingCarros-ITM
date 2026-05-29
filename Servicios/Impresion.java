package Servicios;

import java.util.Scanner;

public class Impresion
{   Scanner sc = new Scanner(System.in);
    public void menuImpresion ()
    {   
        ContratoServicio servicioContrato = new ContratoServicio();
        int opcion = 0;

        while(opcion != 5){
            System.out.println("---- Menu de impresion ----");
            System.out.println("1. Ver todos los clientes ");
            System.out.println("2. Ver todos los vehivulos ");
            System.out.println("3. Ver todos los contratos ");
            System.out.println("4. Ver todos los registros ");
            System.out.println("5. Salir");
            System.out.println("ingrese la opcion que desea realizar...  ");

            try{
                opcion = Integer.parseInt(sc.nextLine());

                 switch (opcion) {

                    case 1://impresion de clientes 
                        
                        break;

                    case 2://impresion de vehiculos 
                        
                        break;

                    case 3://impresion de contratos
                        servicioContrato.imprimirInforme();
                        break;

                    case 4:
                        
                        break;

                    case 5:
                        System.out.println("Regresando al menú principal...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch(NumberFormatException error) {
                System.out.println("Escriba por favor un numero.");

                
            }
        }    
    }

}