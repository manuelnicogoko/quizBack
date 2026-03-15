package com.example.proyectoquiz.controllers;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.proyectoquiz.services.files.FileStorageService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FilesController {

    private final FileStorageService fileStorageService;

    @PostMapping("/categoria/{categoriaId}/{filename:.+}")
    public ResponseEntity<?> postLogoCategoriaLogo(@PathVariable Long categoriaId, @PathVariable String filename,
            @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("categoriaLogo/" + categoriaId + "/");
        return ResponseEntity.status(HttpStatus.CREATED).body(fileStorageService.store(filename, file, destino));
    }

    @PostMapping("/subcategoria/{subcategoriaId}/{filename:.+}")
    public ResponseEntity<?> postLogoSubategoriaLogo(@PathVariable Long subcategoriaId, @PathVariable String filename,
            @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("subcategoriaLogo/" + subcategoriaId + "/");
        return ResponseEntity.status(HttpStatus.CREATED).body(fileStorageService.store(filename, file, destino));
    }

    @PostMapping("/imagen/{quizId}/{preguntaPos}/{filename:.+}")
    public ResponseEntity<?> postPreguntaImagen(@PathVariable Long quizId, @PathVariable Integer preguntaPos,
            @PathVariable String filename, @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("imagenPreg/" + quizId + "/" + preguntaPos + "/");
        return ResponseEntity.status(HttpStatus.CREATED).body(fileStorageService.store(filename, file, destino));
    }

    @PostMapping("/avatar/{userId}/{filename:.+}")
    public ResponseEntity<?> postAvatar(@PathVariable Long userId, @PathVariable String filename,
            @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("userAvatar/" + userId + "/");
        return ResponseEntity.status(HttpStatus.CREATED).body(fileStorageService.store(filename, file, destino));
    }

    @PostMapping("/portada/{quizId}/{filename:.+}")
    public ResponseEntity<?> postPortada(@PathVariable Long quizId, @PathVariable String filename,
            @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("quizPortada/" + quizId + "/");
        return ResponseEntity.status(HttpStatus.CREATED).body(fileStorageService.store(filename, file, destino));
    }

    @GetMapping("/categoria/{categoriaId}/{filename:.+}")
    public ResponseEntity<?> getLogoCategoriaLogo(@PathVariable Long categoriaId, @PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource("categoriaLogo/" + categoriaId + "/" + filename);
        return ResponseEntity.ok().body(file);
    }

    @GetMapping("/subcategoria/{subcategoriaId}/{filename:.+}")
    public ResponseEntity<?> getSubcategoriaLogo(@PathVariable Long subcategoriaId, @PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource("subcategoriaLogo/" + subcategoriaId + "/" + filename);
        return ResponseEntity.ok().body(file);
    }

    @GetMapping("/imagen/{quizID}/{preguntaPos}/{filename:.+}")
    public ResponseEntity<?> getPreguntaImagen(@PathVariable Long quizID, @PathVariable Integer preguntaPos,
            @PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource("imagenPreg/" + quizID + "/" + preguntaPos + "/" + filename);
        return ResponseEntity.ok().body(file);
    }

    @GetMapping("/avatar/{userID}/{filename:.+}")
    public ResponseEntity<?> getAvatar(@PathVariable Long userID, @PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource("userAvatar/" + userID + "/" + filename);
        return ResponseEntity.ok().body(file);
    }

    @GetMapping("/portada/{quizID}/{filename:.+}")
    public ResponseEntity<?> getPortada(@PathVariable Long quizID, @PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource("quizPortada/" + quizID + "/" + filename);
        return ResponseEntity.ok().body(file);
    }

}
