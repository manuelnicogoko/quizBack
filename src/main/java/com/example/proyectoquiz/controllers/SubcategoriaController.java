package com.example.proyectoquiz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.SubcategoriaDTO;
import com.example.proyectoquiz.services.subcategoria.SubcategoriaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subcategoria")
public class SubcategoriaController {

    private final SubcategoriaService subcategoriaService;

    @GetMapping("/all")
    public ResponseEntity<?> getSubcategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(subcategoriaService.getAllSubcategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubcategoria(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(subcategoriaService.getSubcategoriaById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> postSubcategoria(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subcategoriaService.saveSubcategoria(subcategoriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putSubcategoria(@PathVariable Long id, @RequestBody SubcategoriaDTO subcategoriaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(subcategoriaService.updateSubcategoria(id, subcategoriaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubcategoria(@PathVariable Long id) {
        subcategoriaService.deleteSubcategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
