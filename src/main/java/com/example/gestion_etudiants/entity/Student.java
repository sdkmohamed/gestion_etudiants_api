package com.example.gestion_etudiants.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnore // Évite le problème de Lazy Loading en JSON
    private List<Course> courses;

    public Student() {}

    public Student(String firstname, String surname, int age, String email, String address, String phoneNumber,
                   boolean academicYearRegistered, Long academicYearId, int pw, int dw, List<Course> courses) {
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.academicYearRegistered = academicYearRegistered;
        this.academicYearId = academicYearId;
        this.pw = pw;
        this.dw = dw;
        this.courses = courses;
    }

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
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}
