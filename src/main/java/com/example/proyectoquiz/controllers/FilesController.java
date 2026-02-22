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

    @PostMapping("/categoria/{filename:.+}")
    public ResponseEntity<?> postLogoCategoriaLogo(@PathVariable String filename,
            @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("categoriaLogo/");
        return ResponseEntity.status(HttpStatus.CREATED).body(fileStorageService.store(filename, file, destino));
    }

    @PostMapping("/subcategoria/{filename:.+}")
    public ResponseEntity<?> postLogoSubategoriaLogo(@PathVariable String filename,
            @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("subcategoriaLogo/");
        return ResponseEntity.status(HttpStatus.CREATED).body(fileStorageService.store(filename, file, destino));
    }

    @PostMapping("/imagen/{quizId}/{preguntaPos}/{filename:.+}")
    public ResponseEntity<?> postPreguntaImagen(@PathVariable Long quizId, @PathVariable Integer preguntaPos,
            @PathVariable String filename, @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("imagenPreg/" + quizId + "/" + preguntaPos + "/");
        return ResponseEntity.status(HttpStatus.CREATED).body(fileStorageService.store(filename, file, destino));
    }

    @PostMapping("/avatar/{userId}/{filename:.+}")
    public String postAvatar(@PathVariable Long userId, @PathVariable String filename,
            @RequestParam("file") MultipartFile file) throws IOException {
        Path destino = Path.of("userAvatar/" + userId + "/");
        return fileStorageService.store(filename, file, destino);
    }

    @GetMapping("/categoria/{filename:.+}")
    public ResponseEntity<?> getLogoCategoriaLogo(@PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource("categoriaLogo/" + filename);
        return ResponseEntity.ok().body(file);
    }

    @GetMapping("/subcategoria/{filename:.+}")
    public ResponseEntity<?> getSubcategoriaLogo(@PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource("subcategoriaLogo/" + filename);
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

}
