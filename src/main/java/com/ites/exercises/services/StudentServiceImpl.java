package com.ites.exercises.services;

import com.ites.exercises.entities.Student;
import com.ites.exercises.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return  studentRepository.saveAndFlush(student);
    }

    @Override
    public Optional<Student> findStudentById(Long id) {

        return studentRepository.findById(id);
    }
}
