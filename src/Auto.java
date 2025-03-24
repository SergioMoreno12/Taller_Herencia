// Subclase Auto
public class Auto extends Vehiculo{
    private int numeroPuertas;

    public Auto(String marca, String modelo, int ano, double precioPorDia, int numeroPuertas) {
        super(marca, modelo, ano, precioPorDia);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return "Auto{" +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", precioPorDia=" + precioPorDia +
                ", estado=" + estado +
                "numeroPuertas='" + numeroPuertas + '\'' +
                '}';
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo de vehiculo: Auto");
        System.out.println("-----------------------------");
        super.mostrarInfo();
        System.out.println("Numero de puertas: " + numeroPuertas);
    }
}
