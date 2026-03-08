package com.example.proyectoquiz.services.files;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.proyectoquiz.exceptions.FileNotFoundException;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private final Path rootLocation = Paths.get("uploadFiles");

    public String store(String nombre, MultipartFile file, Path destino) throws RuntimeException, IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("archivo enviado vacío");
        }

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        if (originalFilename.contains("..")) {
            throw new RuntimeException("nombre de archivo incorrecto");
        }

        String extension = StringUtils.getFilenameExtension(originalFilename);
        String storedFilename = nombre + "." + extension;

        Path fullPath = rootLocation.resolve(destino).normalize();

        if (!Files.exists(fullPath)) {
            Files.createDirectories(fullPath);
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, fullPath.resolve(storedFilename),
                    StandardCopyOption.REPLACE_EXISTING);
            return storedFilename;
        } catch (IOException ioe) {
            throw new RuntimeException("Error al almacenar el archivo: " + ioe.getMessage());
        }
    }

    public void delete(String filename) throws RuntimeException {
        try {
            Path file = rootLocation.resolve(filename);
            if (!Files.exists(file))
                throw new RuntimeException("No existe el fichero");
            Files.delete(file);
        } catch (IOException ioe) {
            throw new RuntimeException("Error en borrado");
        }
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException(file.toString());
            }
        } catch (Exception e) {
            throw new FileNotFoundException(filename);
        }
    }

    // Getter
    public Path getRootLocation() {
        return rootLocation;
    }

}
