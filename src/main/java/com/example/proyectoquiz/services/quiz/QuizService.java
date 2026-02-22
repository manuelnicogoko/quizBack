package com.example.proyectoquiz.services.quiz;

import java.util.List;

import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.dto.QuizDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface QuizService {

    public List<Quiz> getAllQuizzes();

    public List<Quiz> getQuizzesByCategoriaId(Long categoriaId);

    public List<Quiz> getQuizzesBySubcategoriaId(Long subcategoriaId);

    public List<Quiz> getQuizzesByNombre(String nombre) throws RuntimeException;

    public Quiz getQuizById(Long id) throws RuntimeException;

    public Quiz saveQuiz(QuizDTO quizDTO) throws RuntimeException, UserNotFoundException, AuthException;

    public void deleteQuiz(Long id) throws RuntimeException, UserNotFoundException, AuthException;

    public Quiz updateQuiz(Long id, QuizDTO quizDTO) throws RuntimeException, UserNotFoundException, AuthException;
}
