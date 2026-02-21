package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.QuizDTO;
import com.example.proyectoquiz.services.quiz.QuizService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllQuizzes() {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getAllQuizzes());
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<?> getQuizzesByCategory(@PathVariable Long categoriaId) {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizzesByCategoriaId(categoriaId));
    }

    @GetMapping("/{subcategoriaId}")
    public ResponseEntity<?> getQuizzesBySubcategory(@PathVariable Long subcategoriaId) {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizzesBySubcategoriaId(subcategoriaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuizById(@PathVariable Long id) throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> saveQuiz(@RequestBody QuizDTO quizDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.saveQuiz(quizDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Long id) throws RuntimeException {
        quizService.deleteQuiz(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
