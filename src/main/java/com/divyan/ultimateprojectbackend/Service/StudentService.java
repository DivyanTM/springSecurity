package com.divyan.ultimateprojectbackend.Service;

import com.divyan.ultimateprojectbackend.Model.Student;
import com.divyan.ultimateprojectbackend.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
