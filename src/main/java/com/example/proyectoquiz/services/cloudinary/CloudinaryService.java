package com.example.proyectoquiz.services.cloudinary;

import java.io.IOException;

public interface CloudinaryService {

    public String upload(byte[] bytes, String folder, String filename, String format) throws IOException;
}
