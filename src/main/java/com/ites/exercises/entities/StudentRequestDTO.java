package com.ites.exercises.entities;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StudentRequestDTO {
    @NotBlank(message = "Le nom de l'étudiant est requis")
    private String name;

    @NotBlank(message = "Le prénom de l'étudiant est requis")
    private String firstName;
    public Student toEntity() {
        Student student = new Student();
        student.setName(name);
        student.setFirstName(firstName);
        return student;
    }
}
