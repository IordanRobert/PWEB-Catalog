package ro.unitbv.catalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.unitbv.catalog.entity.Nota;

@Repository
public interface NoteRepository extends CrudRepository<Nota, Long> {
    Iterable<Nota> findAllByStudentId(Long studentId);
}
