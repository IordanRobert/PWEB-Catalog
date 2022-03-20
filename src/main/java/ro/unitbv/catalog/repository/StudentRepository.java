package ro.unitbv.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.unitbv.catalog.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
