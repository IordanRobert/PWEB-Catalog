package ro.unitbv.catalog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unitbv.catalog.entity.Nota;
import ro.unitbv.catalog.repository.NoteRepository;

@Service
@RequiredArgsConstructor
public class NotaService {
    @Autowired
    private final NoteRepository noteRepository;

    public Iterable<Nota> fetchNoteById(Long studentId) {
        return noteRepository.findAllByStudentId(studentId);
    }

    public Iterable<Nota> fetchAll() {
        return noteRepository.findAll();
    }

    public void addNota(Nota nota) {
        noteRepository.save(nota);
    }

    public void deleteNota(Long id) {
        noteRepository.deleteById(id);
    }

    public void updateNota(Nota nota) {
        noteRepository.save(nota);
    }
}
