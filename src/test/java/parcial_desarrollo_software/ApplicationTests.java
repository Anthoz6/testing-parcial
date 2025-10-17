package parcial_desarrollo_software;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import parcial_desarrollo_software.service.NominaService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

	private final NominaService nominaService = new NominaService();

	@Test
	void contextLoads() {
	}

	// Pruebas unitarias para el servicio de nómina
	@Test
	void testCalculoCorrecto() {
		int total = nominaService.calcularNomina(20000, 40);
		assertEquals(800000, total);
	}

	@Test
	void testValorHoraInvalidoInfeiror() {
		Exception e = assertThrows(IllegalArgumentException.class, () ->
				nominaService.calcularNomina(9000, 20));
		assertTrue(e.getMessage().contains("valor por hora"));
	}

	@Test
	void testValorHoraInvalidoSuperior() {
		Exception e = assertThrows(IllegalArgumentException.class, () ->
				nominaService.calcularNomina(85000, 20));
		assertTrue(e.getMessage().contains("valor por hora"));
	}

	@Test
	void testHorasExcedidas() {
		Exception e = assertThrows(IllegalArgumentException.class, () ->
				nominaService.calcularNomina(20000, 90));
		assertTrue(e.getMessage().contains("76 horas"));
	}

	// Pruebas de frontera (borde)
	@Test
	void testBordeInferiorValorHora() {
		int total = nominaService.calcularNomina(10000, 10);
		assertEquals(100000, total);
	}

	@Test
	void testBordeSuperiorValorHora() {
		int total = nominaService.calcularNomina(80000, 10);
		assertEquals(800000, total);
	}

	@Test
	void testBordeHorasMaximas() {
		int total = nominaService.calcularNomina(20000, 76);
		assertEquals(1520000, total);
	}
}
