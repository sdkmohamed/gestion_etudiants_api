package com.example.gestion_etudiants.service;

import com.example.gestion_etudiants.dto.StudentDTO;
import com.example.gestion_etudiants.entity.Course;
import com.example.gestion_etudiants.entity.Student;
import com.example.gestion_etudiants.repositor.CourseRepository;
import com.example.gestion_etudiants.repositor.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // 🔥 Ajout de cette annotation

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional // 🔥 Ajout pour éviter Lazy Initialization Exception
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional // 🔥 Hibernate a besoin d'une session active pour éviter Lazy Loading error
    public Student updateStudent(Long id, StudentDTO studentDTO) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstname(studentDTO.getFirstname());
                    student.setSurname(studentDTO.getSurname());
                    student.setAddress(studentDTO.getAddress());
                    student.setAcademicYearRegistered(studentDTO.isAcademicYearRegistered());
                    student.setAcademicYearId(studentDTO.getAcademicYearId());
                    student.setPw(studentDTO.getPw());
                    student.setDw(studentDTO.getDw());

                    // Mise à jour des cours
                    List<Course> courses = courseRepository.findAllById(studentDTO.getCoursesId());
                    student.setCourses(courses);

                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
