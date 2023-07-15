package com.ites.exercises.controllers;

import com.ites.exercises.entities.Student;
import com.ites.exercises.entities.StudentException;
import com.ites.exercises.entities.StudentRequestDTO;
import com.ites.exercises.entities.StudentResponseDTO;
import com.ites.exercises.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody @Valid StudentRequestDTO studentRequestDTO) {
        Student createdStudent = studentService.addStudent(new Student(studentRequestDTO.getName(), studentRequestDTO.getFirstName()));

        return createdStudent != null
                ? ResponseEntity.status(HttpStatus.CREATED).body(new StudentResponseDTO(createdStudent.getId(), createdStudent.getName(), createdStudent.getFirstName()))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

            /* if (createdStudent != null) {
                StudentResponse response = new StudentResponse(createdStudent.getId(), createdStudent.getName(), createdStudent.getFirstName());
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            } */
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable long id) {
        Optional<Student> studentOptional = studentService.findStudentById(id);
        return studentOptional.isPresent()
                ? ResponseEntity.ok(new StudentResponseDTO(studentOptional.get().getId(), studentOptional.get().getName(), studentOptional.get().getFirstName()))
                : ResponseEntity.notFound().build();
    }

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<String> handleStudentException(StudentException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
