import java.util.Random;

public class ListaCircularDoble {

    private NodoVehiculo primero;
    private NodoVehiculo actual;
    private int cantidad;
    private int siguienteId;

    public ListaCircularDoble() {
        primero = null;
        actual = null;
        cantidad = 0;
        siguienteId = 1;
    }

    public void insertar(String placa, String tipoVehiculo) {
        NodoVehiculo nuevo = new NodoVehiculo(siguienteId, placa, tipoVehiculo);
        siguienteId++;

        if (primero == null) {
            primero = nuevo;
            actual = nuevo;

            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;

        } else {
            NodoVehiculo ultimo = primero.anterior;

            nuevo.siguiente = primero;
            nuevo.anterior = ultimo;

            ultimo.siguiente = nuevo;
            primero.anterior = nuevo;
        }

        cantidad++;
    }

    public void mostrar() {
        if (primero == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        NodoVehiculo auxiliar = primero;

        for (int i = 0; i < cantidad; i++) {

            System.out.println(
                    "ID: " + auxiliar.identificador
                            + " | Placa: " + auxiliar.placa
                            + " | Tipo: " + auxiliar.tipoVehiculo
            );

            auxiliar = auxiliar.siguiente;
        }
    }

    public void consultarActual() {
        if (actual == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        System.out.println("Vehiculo actual:");

        System.out.println(
                "ID: " + actual.identificador
                        + " | Placa: " + actual.placa
                        + " | Tipo: " + actual.tipoVehiculo
        );
    }

    public void siguiente() {
        if (actual == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        actual = actual.siguiente;

        System.out.println("Siguiente vehiculo:");

        System.out.println(
                "ID: " + actual.identificador
                        + " | Placa: " + actual.placa
                        + " | Tipo: " + actual.tipoVehiculo
        );
    }

    public void anterior() {
        if (actual == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        actual = actual.anterior;

        System.out.println("Vehiculo anterior:");

        System.out.println(
                "ID: " + actual.identificador
                        + " | Placa: " + actual.placa
                        + " | Tipo: " + actual.tipoVehiculo
        );
    }

    public NodoVehiculo buscar(int identificador) {

        if (primero == null) {
            return null;
        }

        NodoVehiculo auxiliar = primero;

        for (int i = 0; i < cantidad; i++) {

            if (auxiliar.identificador == identificador) {
                return auxiliar;
            }

            auxiliar = auxiliar.siguiente;
        }

        return null;
    }

    public void eliminar(int identificador) {

        NodoVehiculo nodo = buscar(identificador);

        if (nodo == null) {
            System.out.println("Vehiculo no encontrado.");
            return;
        }

        if (cantidad == 1) {

            primero = null;
            actual = null;
            cantidad = 0;

            System.out.println("Vehiculo eliminado.");
            return;
        }

        nodo.anterior.siguiente = nodo.siguiente;

        nodo.siguiente.anterior = nodo.anterior;

        if (nodo == primero) {
            primero = nodo.siguiente;
        }

        if (nodo == actual) {
            actual = nodo.siguiente;
        }

        cantidad--;

        System.out.println("Vehiculo eliminado.");
    }

    public void recorrer(int vueltas) {

        if (primero == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        if (vueltas <= 0) {
            System.out.println("El numero de vueltas debe ser mayor que 0.");
            return;
        }

        NodoVehiculo auxiliar = primero;

        for (int vuelta = 1; vuelta <= vueltas; vuelta++) {

            System.out.println("\nVuelta " + vuelta + ":");

            for (int i = 0; i < cantidad; i++) {

                System.out.println(
                        "ID: " + auxiliar.identificador
                                + " | Placa: " + auxiliar.placa
                                + " | Tipo: " + auxiliar.tipoVehiculo
                );

                auxiliar = auxiliar.siguiente;
            }

            System.out.println("Se completo la vuelta.");
        }

        actual = auxiliar;
    }

    public void recorridoAzar(int saltos) {

        if (primero == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        if (saltos <= 0) {
            System.out.println("El numero de saltos debe ser mayor que 0.");
            return;
        }

        Random random = new Random();

        System.out.println("\nRecorrido al azar:");

        int realizados = 0;

        while (realizados < saltos) {

            boolean[] usados = new boolean[cantidad];

            int disponibles = cantidad;

            while (disponibles > 0 && realizados < saltos) {

                int posicion;

                do {
                    posicion = random.nextInt(cantidad);
                } while (usados[posicion]);

                usados[posicion] = true;
                disponibles--;

                NodoVehiculo auxiliar = primero;

                for (int j = 0; j < posicion; j++) {
                    auxiliar = auxiliar.siguiente;
                }

                actual = auxiliar;

                realizados++;

                System.out.println(
                        "Salto " + realizados
                                + ": ID: " + actual.identificador
                                + " | Placa: " + actual.placa
                                + " | Tipo: " + actual.tipoVehiculo
                );
            }
        }

        System.out.println("\nSe completaron " + saltos + " saltos.");
    }
}