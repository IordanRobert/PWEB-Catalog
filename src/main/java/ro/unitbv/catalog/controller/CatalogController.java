package ro.unitbv.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.unitbv.catalog.entity.Nota;
import ro.unitbv.catalog.entity.Student;
import ro.unitbv.catalog.service.NotaService;
import ro.unitbv.catalog.service.StudentService;

@Controller
@RequiredArgsConstructor
public class CatalogController {

    @Autowired
    StudentService studentService;
    @Autowired
    NotaService notaService;

    @GetMapping(value = "")
    public String showDefault(Model mdoel) {
        return "redirect:/studenti";
    }

    @GetMapping(value = "/studenti")
    public String showTabelStudenti(Model model) {
        Iterable<Student> studenti = studentService.fetchAll();

        model.addAttribute("studenti", studenti);

        return "tabelStudenti";
    }

    @GetMapping(value = "/note")
    public String showTabelNote(Model model) {
        Iterable<Nota> note = notaService.fetchAll();

        model.addAttribute("note", note);
        model.addAttribute("student", "Catalog");
        model.addAttribute("mediaText", "@ 2021-2022");

        return "tabelNote";
    }

    @PostMapping(value = "/addNota")
    public String addNota(@ModelAttribute("nota") Nota nota, BindingResult result, Model model) {
        if (result.hasErrors()) return "error";

        notaService.addNota(nota);
        return "redirect:/note";
    }

    @GetMapping(value = "/deleteNota/{id}")
    public String deleteNota(@PathVariable("id") Long id, Model model) {

        notaService.deleteNota(id);
        return "redirect:/note";
    }

    @PostMapping(value = "/updateNota")
    public String updateNota(@ModelAttribute("nota") Nota nota, BindingResult result, Model model) {
        if (result.hasErrors()) return "error";

        notaService.updateNota(nota);
        return "redirect:/note";
    }

    @PostMapping(value = "/addStudent")
    public String addNota(@ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) return "error";

        studentService.addStudent(student);
        return "redirect:/studenti";
    }

}
