public class Cliente {
    private String nombre;
    private String cedula;
    private String numeroLicencia;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, String numeroLicencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numeroLicencia = numeroLicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", numeroLicencia='" + numeroLicencia + '\'' +
                '}';
    }

}
