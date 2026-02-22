package com.example.proyectoquiz.services.files;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    public String store(String nombre, MultipartFile file, Path destino) throws IOException;

    public void delete(String filename) throws RuntimeException;

    public Resource loadAsResource(String filename);

    public Path getRootLocation();
}