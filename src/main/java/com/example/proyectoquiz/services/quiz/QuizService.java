package com.example.proyectoquiz.services.quiz;

import org.springframework.data.domain.Page;

import com.example.proyectoquiz.domain.Quiz;
import com.example.proyectoquiz.dto.QuizAdminDTO;
import com.example.proyectoquiz.dto.QuizDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.PropiedadAppException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface QuizService {

    public Page<Quiz> getAllQuizzes(Integer pageNumber);

    public Page<Quiz> getQuizzesByCategoriaId(Long categoriaId, Integer pageNumber);

    public Page<Quiz> getQuizzesBySubcategoriaId(Long subcategoriaId, Integer pageNumber);

    public Page<Quiz> getQuizzesByNombre(String nombre, Integer pageNumber) throws RuntimeException;

    public Quiz getQuizById(Long id) throws RuntimeException;

    public Quiz saveQuiz(QuizDTO quizDTO)
            throws RuntimeException, UserNotFoundException, AuthException, PropiedadAppException;

    public void deleteQuiz(Long id) throws RuntimeException, UserNotFoundException, AuthException;

    public Quiz updateQuiz(Long id, QuizAdminDTO quizDTO)
            throws RuntimeException, UserNotFoundException, AuthException;

    public Page<Quiz> getQuizzesByUsuario(Long creadorId, int pageNumber);

    public Page<Quiz> getQuizzesPendientes(int pageNumber);
}
