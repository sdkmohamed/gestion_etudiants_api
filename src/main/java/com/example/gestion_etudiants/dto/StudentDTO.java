package com.example.gestion_etudiants.dto;

import com.example.gestion_etudiants.entity.Course;
import com.example.gestion_etudiants.entity.Student;
import java.util.List;

public class StudentDTO {
    private Long id;
    private String firstname;
    private String surname;
    private int age;
    private String email;
    private String address;
    private String phoneNumber;
    private boolean academicYearRegistered;
    private Long academicYearId;
    private int pw;
    private int dw;
    private List<Long> coursesId; // On renvoie juste les IDs des cours, pas l'objet complet

    // 🔥 Constructeur par défaut (important pour JSON)
    public StudentDTO() {}

    // 🔥 Constructeur basé sur l'entité Student
    public StudentDTO(Student student) {
        this.id = student.getId();
        this.firstname = student.getFirstname();
        this.surname = student.getSurname();
        this.age = student.getAge();
        this.email = student.getEmail();
        this.address = student.getAddress();
        this.phoneNumber = student.getPhoneNumber();
        this.academicYearRegistered = student.isAcademicYearRegistered();
        this.academicYearId = student.getAcademicYearId();
        this.pw = student.getPw();
        this.dw = student.getDw();

        // 🔥 Transformation de la liste de Course en liste d'IDs (évite le problème de Lazy Loading)
        this.coursesId = student.getCourses().stream()
                .map(Course::getId) // 🔥 On récupère juste les IDs des cours
                .toList();
    }

    // 🔥 Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isAcademicYearRegistered() { return academicYearRegistered; }
    public void setAcademicYearRegistered(boolean academicYearRegistered) { this.academicYearRegistered = academicYearRegistered; }

    public Long getAcademicYearId() { return academicYearId; }
    public void setAcademicYearId(Long academicYearId) { this.academicYearId = academicYearId; }

    public int getPw() { return pw; }
    public void setPw(int pw) { this.pw = pw; }

    public int getDw() { return dw; }
    public void setDw(int dw) { this.dw = dw; }

    public List<Long> getCoursesId() { return coursesId; }
    public void setCoursesId(List<Long> coursesId) { this.coursesId = coursesId; }
}
