package com.example.proyectoquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoquiz.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
