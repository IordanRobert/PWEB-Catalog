package ro.unitbv.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ro.unitbv.catalog.entity.Nota;
import ro.unitbv.catalog.entity.Student;
import ro.unitbv.catalog.service.NotaService;
import ro.unitbv.catalog.service.StudentService;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class idControler {
    private final StudentService studentService;
    private final NotaService notaService;

    @GetMapping(value = "/studenti/{id}")
    public Student fetchStudentById(@PathVariable("id") Long id) {
        return studentService.fetchStudentById(id);
    }

    @GetMapping(value = "/note/{id}")
    public String fetchNotaById(@PathVariable("id") Long studentId, Model model) {
        Iterable<Nota> note = notaService.fetchNoteById(studentId);
        String numeStudent = "", prenumeStudent = "";
        double media = 0;
        int i=0;
        for (Nota n : note) {
            media += n.getNota();
            i++;
            numeStudent=studentService.fetchStudentById(n.getStudentId()).getNumeStudent() ;
            prenumeStudent=studentService.fetchStudentById(n.getStudentId()).getPrenumeStudent() ;
        }
        media /= i;

        model.addAttribute("note", note);
        model.addAttribute("student", numeStudent + " " + prenumeStudent);
        model.addAttribute("mediaText", "Media = ");
        model.addAttribute("media", media);

        return "tabelNote";
    }
}
