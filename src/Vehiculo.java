// Clase base Vehiculo
public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double precioPorDia;
    protected boolean estado;
    private Cliente cliente;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int ano, double precioPorDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.precioPorDia = precioPorDia;
        this.estado = true;
        this.cliente = null;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public boolean isEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", precioPorDia=" + precioPorDia +
                ", estado=" + estado +
                '}';
    }

    public void mostrarInfo(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + ano);
        System.out.println("Precio por dia: " + precioPorDia);
        System.out.println("Estado: " + estado);
    }

    public void alquilar() {
        this.estado = false;
    }

    public void devolver() {
        this.estado = true;
        this.cliente = null;
    }

    public double calcularCosto(int dias) {
        double total = dias * precioPorDia;
        if (dias > 7) {
            total *= 0.9;
        }
        return total;
    }

}
