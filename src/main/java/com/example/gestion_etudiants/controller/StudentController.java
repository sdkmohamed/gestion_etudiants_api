package com.example.gestion_etudiants.controller;

import com.example.gestion_etudiants.entity.Student;
import com.example.gestion_etudiants.repositor.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173") // ✅ Autorise les requêtes du frontend
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // ➤ Ajouter un étudiant
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        student.setId(null); // S'assurer que l'ID est bien null pour que la BDD le génère
        return studentRepository.save(student);
    }

    // ➤ Récupérer tous les étudiants
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ➤ Récupérer un étudiant par son ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // ➤ Mettre à jour un étudiant
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstname(studentDetails.getFirstname());
            student.setAge(studentDetails.getAge());
            student.setEmail(studentDetails.getEmail());
            student.setAddress(studentDetails.getAddress());
            student.setPhoneNumber(studentDetails.getPhoneNumber());
            return studentRepository.save(student);
        }
        return null;
    }

    // ➤ Supprimer un étudiant
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Étudiant supprimé avec succès.";
        } else {
            return "Étudiant introuvable.";
        }
    }
}
