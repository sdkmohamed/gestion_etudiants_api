package com.example.gestion_etudiants.service;

import com.example.gestion_etudiants.entity.Student;
import com.example.gestion_etudiants.repositor.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstname(updatedStudent.getFirstname());
                    student.setSurname(updatedStudent.getSurname());
                    student.setAdress(updatedStudent.getAdress());
                    student.setAcademicYearRegistered(updatedStudent.isAcademicYearRegistered());
                    student.setCoursesId(updatedStudent.getCoursesId());
                    student.setAcademicYearId(updatedStudent.getAcademicYearId());
                    student.setPw(updatedStudent.getPw());
                    student.setDw(updatedStudent.getDw());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> importStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }
}
