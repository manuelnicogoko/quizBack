// package com.example.proyectoquiz.config;

// import com.example.proyectoquiz.services.cloudinary.CloudinaryService;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import java.io.File;
// import java.nio.file.Files;
// import java.nio.file.Path;

// @Component
// public class StartupUploader implements CommandLineRunner {

// private final CloudinaryService cloudinaryService;

// @Value("${uploadFiles.path:uploadFiles}")
// private String uploadFilesPath;

// public StartupUploader(CloudinaryService cloudinaryService) {
// this.cloudinaryService = cloudinaryService;
// }

// @Override
// public void run(String... args) throws Exception {
// File rootFolder = new File(uploadFilesPath);
// if (!rootFolder.exists() || !rootFolder.isDirectory())
// return;

// uploadRecursively(rootFolder, rootFolder.toPath());
// }

// private void uploadRecursively(File current, Path rootPath) throws Exception
// {
// for (File file : current.listFiles()) {
// if (file.isDirectory()) {
// uploadRecursively(file, rootPath);
// } else if (file.isFile()) {
// String filename = file.getName();
// String baseName = filename.contains(".") ? filename.substring(0,
// filename.lastIndexOf('.')) : filename;
// String format = filename.substring(filename.lastIndexOf('.') + 1);
// String relativeFolder =
// rootPath.relativize(file.getParentFile().toPath()).toString().replace("\\",
// "/");
// String url = cloudinaryService.upload(
// Files.readAllBytes(file.toPath()),
// relativeFolder,
// baseName,
// format);
// System.out.println("Subido: " + url);
// }
// }
// }
// }