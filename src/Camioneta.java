// Subclase Camioneta
public class Camioneta extends Vehiculo{
    private double capacidadCarga;

    public Camioneta(String marca, String modelo, int ano, double precioPorDia, double capacidadCarga) {
        super(marca, modelo, ano, precioPorDia);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return "Camioneta{" +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", precioPorDia=" + precioPorDia +
                ", estado=" + estado +
                "capacidadCarga=" + capacidadCarga +
                '}';
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo de vehiculo: Camioneta");
        System.out.println("-----------------------------");
        super.mostrarInfo();
        System.out.println("Capacidad de carga: " + capacidadCarga);
    }
}
