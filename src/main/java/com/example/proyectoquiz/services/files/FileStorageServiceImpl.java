package com.example.proyectoquiz.services.files;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

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

        int width = 512;
        int height = 512;
        String destStr = destino.toString().toLowerCase();
        String format = "jpg";
        if (destStr.contains("portada") || destStr.contains("avatar")) {
            width = 512;
            height = 512;
            format = "jpg";
        } else if (destStr.contains("imagenpreg") || destStr.contains("pregunta")) {
            width = 1920;
            height = 1080;
            format = "jpg";
        } else if (destStr.contains("categorialogo") || destStr.contains("subcategorialogo")) {
            width = 128;
            height = 128;
            format = "png";
        }

        // Elimina la extensión si ya existe
        String baseName = nombre;
        int dotIndex = nombre.lastIndexOf('.');
        if (dotIndex > 0) {
            baseName = nombre.substring(0, dotIndex);
        }
        String storedFilename = baseName + "." + format;
        Path fullPath = rootLocation.resolve(destino).normalize();
        if (!Files.exists(fullPath)) {
            Files.createDirectories(fullPath);
        }

        try (InputStream inputStream = file.getInputStream()) {
            BufferedImage originalImage = ImageIO.read(inputStream);
            if (originalImage == null) {
                throw new RuntimeException("El archivo subido no es una imagen válida o está corrupto");
            }
            Thumbnails.Builder<BufferedImage> builder = Thumbnails.of(originalImage)
                    .size(width, height)
                    .outputFormat(format);

            if ("jpg".equals(format)) {
                builder.outputQuality(0.7);
            }

            BufferedImage resizedImage = builder.asBufferedImage();
            Path targetFile = fullPath.resolve(storedFilename);
            ImageIO.write(resizedImage, format, targetFile.toFile());
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
