import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ListaCircularDoble lista = new ListaCircularDoble();
        int opcion;

        do {
            System.out.println("\n--- ROTACION DE VEHICULOS ---");
            System.out.println("1. Insertar vehiculo");
            System.out.println("2. Mostrar vehiculos");
            System.out.println("3. Consultar vehiculo actual");
            System.out.println("4. Siguiente vehiculo");
            System.out.println("5. Anterior vehiculo");
            System.out.println("6. Recorrer N veces");
            System.out.println("7. Recorrido al azar N saltos");
            System.out.println("8. Eliminar vehiculo");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    
                    System.out.print("Placa: ");
                    String placa = entrada.next();

                    System.out.print("Tipo de vehiculo: ");
                    String tipo = entrada.next();

                    if (tipo.matches("\\d+")) {
                        System.out.println("El tipo de vehiculo debe ser texto.");
                        break;
                    }

                    lista.insertar(placa, tipo);
                    System.out.println("Vehiculo insertado.");
                    break;

                case 2:
                    lista.mostrar();
                    break;

                case 3:
                    lista.consultarActual();
                    break;

                case 4:
                    lista.siguiente();
                    break;

                case 5:
                    lista.anterior();
                    break;

                case 6:
                    System.out.print("Numero de vueltas: ");
                    int vueltas = entrada.nextInt();
                    lista.recorrer(vueltas);
                    break;

                case 7:
                    System.out.print("Numero de saltos: ");
                    int saltos = entrada.nextInt();
                    lista.recorridoAzar(saltos);
                    break;

                case 8:
                    System.out.print("Identificador del vehiculo a eliminar: ");
                    int idEliminar = entrada.nextInt();
                    lista.eliminar(idEliminar);
                    break;

                case 9:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 9);

        entrada.close();
    }
}