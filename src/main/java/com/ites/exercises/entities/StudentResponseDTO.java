package com.ites.exercises.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StudentResponseDTO {
    private long id;
    private String name;
    private String firstName;
    public static StudentResponseDTO fromEntity(Student student) {
        return new StudentResponseDTO(student.getId(), student.getName(), student.getFirstName());
    }
}
