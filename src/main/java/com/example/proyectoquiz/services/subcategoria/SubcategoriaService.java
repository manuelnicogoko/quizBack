package com.example.proyectoquiz.services.subcategoria;

import java.util.List;

import com.example.proyectoquiz.domain.Subcategoria;
import com.example.proyectoquiz.dto.SubcategoriaDTO;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface SubcategoriaService {

    public List<Subcategoria> getAllSubcategorias();

    public Subcategoria getSubcategoriaById(Long id) throws RuntimeException;

    public Subcategoria saveSubcategoria(SubcategoriaDTO subcategoriaDTO) throws RuntimeException;

    public Subcategoria updateSubcategoria(Long id, SubcategoriaDTO subcategoriaDTO)
            throws RuntimeException, UserNotFoundException;

    public void deleteSubcategoria(Long id) throws RuntimeException, UserNotFoundException;
}
