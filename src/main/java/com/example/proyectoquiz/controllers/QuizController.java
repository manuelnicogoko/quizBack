package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.QuizAdminDTO;
import com.example.proyectoquiz.dto.QuizDTO;
import com.example.proyectoquiz.services.quiz.QuizService;
import com.example.proyectoquiz.services.websocket.WebSocketService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    private final WebSocketService webSocketService;

    @GetMapping("/all/{pageNumber}")
    @Operation(summary = "Listar todos los quizzes", description = "Devuelve todos los quizzes activos visibles para el usuario")
    public ResponseEntity<?> getAllQuizzes(@PathVariable Integer pageNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(quizService.getAllQuizzes(pageNumber));
    }

    @GetMapping("/categoria/{categoriaId}/{pageNumber}")
    public ResponseEntity<?> getQuizzesByCategory(@PathVariable Long categoriaId, @PathVariable Integer pageNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizzesByCategoriaId(categoriaId, pageNumber));
    }

    @GetMapping("/subcategoria/{subcategoriaId}/{pageNumber}")
    public ResponseEntity<?> getQuizzesBySubcategory(@PathVariable Long subcategoriaId,
            @PathVariable Integer pageNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(quizService.getQuizzesBySubcategoriaId(subcategoriaId, pageNumber));
    }

    @GetMapping("/nombre/{nombre}/{pageNumber}")
    public ResponseEntity<?> getQuizzesByName(@PathVariable String nombre, @PathVariable Integer pageNumber)
            throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizzesByNombre(nombre, pageNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuizById(@PathVariable Long id) throws RuntimeException {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> saveQuiz(@RequestBody QuizDTO quizDTO) {
        webSocketService.notificacionNuevoQuiz();
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.saveQuiz(quizDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuiz(@PathVariable Long id, @RequestBody QuizAdminDTO quizDTO, @Headers Long userId)
            throws RuntimeException {

        webSocketService.notificacionQuizPendienteAprobacion(userId);
        return ResponseEntity.status(HttpStatus.OK).body(quizService.updateQuiz(id, quizDTO));
    }

    @PutMapping("/{id}/portada")
    public ResponseEntity<?> updateQuizPortada(@PathVariable Long id, @RequestBody String nuevaPortada) {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.updateQuizPortada(id, nuevaPortada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Long id) throws RuntimeException {
        quizService.deleteQuiz(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/usuario/{creadorId}/{pageNumber}")
    public ResponseEntity<?> getQuizzesPendientesUsuario(@PathVariable Long creadorId,
            @PathVariable Integer pageNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(quizService.getQuizzesByUsuario(creadorId, pageNumber));
    }

    @GetMapping("/pendientes/{pageNumber}")
    public ResponseEntity<?> getQuizzesPendientes(@PathVariable Integer pageNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(quizService.getQuizzesPendientes(pageNumber));
    }
}
