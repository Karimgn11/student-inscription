package com.ites.exercises;

import com.ites.exercises.entities.Student;
import com.ites.exercises.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExercisesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExercisesApplication.class, args);
    }

    @Bean
    public CommandLineRunner studentInitializer(StudentService studentService) {
        return args -> {
            Student student = new Student();
            student.setName("Diallo");
            student.setFirstName("Abdoul Karim");
            studentService.addStudent(student);

            System.out.println("Étudiant : " + student.toString() + " enregistré avec succès");
        };
    }
}
