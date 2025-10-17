package parcial_desarrollo_software.model;

import jakarta.validation.constraints.*;

public class Docente {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Pattern(
            regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ]+(\\s[A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$",
            message = "El nombre solo puede contener letras y espacios, y no puede comenzar con un espacio."
    )
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres.")
    private String nombre;

    @Min(value = 10000, message = "La identificación debe tener al menos 5 dígitos.")
    @Max(value = 9999999999L, message = "La identificación no puede superar 10 dígitos.")
    private Long identificacion;

    @NotNull(message = "El valor por hora es obligatorio.")
    @Min(value = 10000, message = "Valor mínimo 10.000")
    @Max(value = 80000, message = "Valor máximo 80.000")
    private Integer valorHora;

    @NotNull(message = "Las horas trabajadas son obligatorias.")
    @Min(value = 1, message = "Mínimo 1 hora")
    @Max(value = 76, message = "Máximo 76 horas")
    private Integer horasTrabajadas;

    private int totalNomina;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getValorHora() {
        return valorHora;
    }

    public void setValorHora(Integer valorHora) {
        this.valorHora = valorHora;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Integer getTotalNomina() {
        return totalNomina;
    }

    public void setTotalNomina(Integer totalNomina) {
        this.totalNomina = totalNomina;
    }
}
