package parcial_desarrollo_software.model;

public class Docente {
    private String nombre;
    private String identificacion;
    private int valorHora;
    private int horasTrabajadas;
    private int totalNomina;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getTotalNomina() {
        return totalNomina;
    }

    public void setTotalNomina(int totalNomina) {
        this.totalNomina = totalNomina;
    }
}
