public class NodoVehiculo {

    int identificador;
    String placa;
    String tipoVehiculo;

    NodoVehiculo siguiente;
    NodoVehiculo anterior;

    public NodoVehiculo(int identificador, String placa, String tipoVehiculo) {
        this.identificador = identificador;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.siguiente = null;
        this.anterior = null;
    }
}