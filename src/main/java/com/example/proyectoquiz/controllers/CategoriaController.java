package com.example.proyectoquiz.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoquiz.dto.CategoriaAdminDTO;
import com.example.proyectoquiz.dto.CategoriaDTO;
import com.example.proyectoquiz.services.categoria.CategoriaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/all")
    public ResponseEntity<?> getCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoria(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getCategoriaById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> postCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.saveCategoria(categoriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCategoria(@PathVariable Long id, @RequestBody CategoriaAdminDTO categoriaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.updateCategoria(id, categoriaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
