package com.divyan.ultimateprojectbackend.Repository;

import com.divyan.ultimateprojectbackend.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
