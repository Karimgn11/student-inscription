package com.ites.exercises.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;



@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode @ToString

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String firstName;
    private Date DateOfBirth;


    public Student(String name, String firstName) {
    }
}
