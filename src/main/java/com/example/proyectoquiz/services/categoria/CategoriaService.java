package com.example.proyectoquiz.services.categoria;

import java.util.List;

import com.example.proyectoquiz.domain.Categoria;
import com.example.proyectoquiz.dto.CategoriaDTO;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface CategoriaService {

    public List<Categoria> getAllCategorias();

    public Categoria getCategoriaById(Long id) throws RuntimeException;

    public Categoria saveCategoria(CategoriaDTO categoriaDTO) throws RuntimeException, UserNotFoundException;

    public Categoria updateCategoria(Long id, CategoriaDTO categoriaDTO)
            throws RuntimeException, UserNotFoundException;

    public void deleteCategoria(Long id) throws RuntimeException, UserNotFoundException;
}
