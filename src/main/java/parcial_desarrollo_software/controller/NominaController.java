package parcial_desarrollo_software.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import parcial_desarrollo_software.model.Docente;
import parcial_desarrollo_software.service.NominaService;

@Controller
public class NominaController {

    private NominaService nominaService;

    public NominaController(NominaService nominaService) {
        this.nominaService = nominaService;
    }

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("docente", new Docente());
        return "index";
    }

    @PostMapping("/calcular")
    public String calcularNomina(@Valid @ModelAttribute("docente") Docente docente,
                                 BindingResult result,
                                 Model model) {

        if(result.hasErrors()) {
            return "index";
        }
        try {
            Integer total = nominaService.calcularNomina(docente.getValorHora(), docente.getHorasTrabajadas());
            docente.setTotalNomina(total);
            model.addAttribute("docente", docente);
            return "resultado";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }
}
