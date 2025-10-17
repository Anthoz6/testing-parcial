package parcial_desarrollo_software.service;

import org.springframework.stereotype.Service;

@Service
public class NominaService {

    public double calcularNomina(double valorHora, int horas) {
        if (valorHora < 10000 || valorHora > 80000) {
            throw new IllegalArgumentException("El valor por hora debe estar entre 10,000 y 80,000 pesos.");
        }
        if (horas < 0 || horas > 76) {
            throw new IllegalArgumentException("El número de horas no puede superar las 76 horas mensuales.");
        }
        return valorHora * horas;
    }
}
