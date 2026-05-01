package com.example.proyectoquiz.services.subcategoria;

import java.util.List;

import com.example.proyectoquiz.domain.Subcategoria;
import com.example.proyectoquiz.dto.SubcategoriaAdminDTO;
import com.example.proyectoquiz.dto.SubcategoriaDTO;
import com.example.proyectoquiz.exceptions.AuthException;
import com.example.proyectoquiz.exceptions.UserNotFoundException;

public interface SubcategoriaService {

    public List<Subcategoria> getAllSubcategorias();

    public List<Subcategoria> getAllSubcategoriasEditar();

    public Subcategoria getSubcategoriaById(Long id) throws RuntimeException;

    public Subcategoria saveSubcategoria(SubcategoriaDTO subcategoriaDTO) throws RuntimeException;

    public Subcategoria updateSubcategoria(Long id, SubcategoriaAdminDTO subcategoriaDTO)
            throws RuntimeException, UserNotFoundException, AuthException;

    public void deleteSubcategoria(Long id) throws RuntimeException, UserNotFoundException, AuthException;
}
