import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int decision=0,a;

        String placa="";
        Parqueadero pr = new Parqueadero();

        do {
            // Menu
            System.out.println("");
            System.out.println("Bienvenido a parqueadero");
            System.out.println("Ingrese la opción que desee (Ingrese un numero)");
            System.out.println("1. Ingresar un auto");
            System.out.println("2. Hacer salir a un auto");
            System.out.println("3. Ingresos del parqueadero");
            System.out.println("4. cantidad de puestos disponibles");
            System.out.println("5. Avanzar el reloj del parqueadero");
            System.out.println("6. Cambiar la tarifa del parqueadero");
            System.out.println("7. Salir del sistema");
            System.out.print("Ingrese el numero de opcion: ");
            decision = Integer.parseInt(br.readLine());
            System.out.println("");
            System.out.println("");

            //decision
            switch (decision){
                case 1:{
                    System.out.println("Ingrese la placa del auto");
                    placa=br.readLine();
                    a=pr.entrarCarro(placa);
                    switch (a) {
                        case -2: {
                            System.out.println("Parqueadero cerrado");
                            System.out.println("");
                            break;
                        }
                        case -4: {
                            System.out.println("Ya esta este auto en el parqueadero");
                            System.out.println("");
                            break;
                        }
                        case -1: {
                            System.out.println("No hay puesto en el parqueadero");
                            System.out.println("");
                            break;
                        }
                        default:{
                            System.out.println("El auto se ha ingresado correctamente");
                            System.out.println("");

                        }
                    }
                    break;
                }
                case 2:{
                    System.out.println("Ingrese la placa del auto que quiere sacar");
                    placa= br.readLine();
                    a=pr.sacarCarro(placa);
                    switch (a) {
                        case -2: {
                            System.out.println("Parqueadero cerrado");
                            System.out.println("");
                            break;
                        }
                        case -3: {
                            System.out.println("El auto no existe en el parqueadero");
                            System.out.println("");
                            break;
                        }
                        default:{
                            System.out.println("El auto ha salido correctamente");
                            System.out.println("");
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.print("Los ingresos del parqueadero son: $"+pr.darMontoCaja());
                    System.out.println("");
                    break;
                }
                case 4:{
                    System.out.println("La cantidad de puestos disponibles son: "+pr.calcularPuestosLibres());
                    System.out.println("");
                    break;
                }
                case 5:{
                    a=pr.darHoraActual();
                    pr.avanzarHora();
                    int b=pr.darHoraActual();
                    System.out.println("Ha avanzado la hora de "+a+":00 a "+b+":00");
                    System.out.println("");
                    break;
                }
                case 6:{
                    System.out.println("Ingrese la cantidad de tarifa");

                    a=Integer.parseInt(br.readLine());
                    pr.cambiarTarifa(a);
                    break;
                }
                case 7:{
                    System.out.println("");
                    System.out.println("Gracias!");
                    break;
                }
                default:{
                    System.out.println("Valor no valido");

                }


            }

        }while (decision!=7);
    }
}