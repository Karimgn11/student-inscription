package com.ites.exercises.repositories;

import com.ites.exercises.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    <S extends Student> S saveAndFlush(S entity);
    @Override
    <S extends Student> List<S> saveAllAndFlush(Iterable<S> entities);
    @Override
    Optional<Student> findById(Long aLong);
    @Override
    List<Student> findAllById(Iterable<Long> longs);
    @Override
    void deleteById(Long aLong);
}


