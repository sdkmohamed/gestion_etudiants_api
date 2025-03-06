package com.example.gestion_etudiants.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le prénom ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le prénom doit contenir entre 2 et 50 caractères")
    private String firstname;

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    private String surname;

    @NotBlank(message = "L'adresse ne peut pas être vide")
    private String address;  // ✅ Correction orthographique

    @NotNull(message = "La date de naissance est requise")
    @Past(message = "La date de naissance doit être dans le passé")
    private LocalDate dateOfBirth; // ✅ Ajout d'un champ "date de naissance"

    private boolean academicYearRegistered;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> coursesId;  // ✅ Amélioration avec FetchType.EAGER

    private Long academicYearId; // Année académique de l'étudiant

    private int pw; // Groupe TP
    private int dw; // Groupe TD

    // ✅ Getters et Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public boolean isAcademicYearRegistered() { return academicYearRegistered; }
    public void setAcademicYearRegistered(boolean academicYearRegistered) { this.academicYearRegistered = academicYearRegistered; }

    public List<Long> getCoursesId() { return coursesId; }
    public void setCoursesId(List<Long> coursesId) { this.coursesId = coursesId; }

    public Long getAcademicYearId() { return academicYearId; }
    public void setAcademicYearId(Long academicYearId) { this.academicYearId = academicYearId; }

    public int getPw() { return pw; }
    public void setPw(int pw) { this.pw = pw; }

    public int getDw() { return dw; }
    public void setDw(int dw) { this.dw = dw; }
}
