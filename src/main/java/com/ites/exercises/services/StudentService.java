package com.ites.exercises.services;

import com.ites.exercises.entities.Student;

import java.util.Optional;

public interface StudentService  {
  Student  addStudent(Student student);
  Optional<Student> findStudentById(Long id);
}
