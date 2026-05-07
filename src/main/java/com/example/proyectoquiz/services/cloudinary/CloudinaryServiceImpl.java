package com.example.proyectoquiz.services.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(
            @Value("${cloudinary.cloud_name}") String cloudName,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    public String upload(byte[] bytes, String folder, String filename, String format) throws IOException {
        Map<String, Object> uploadResult = cloudinary.uploader().upload(
                bytes,
                ObjectUtils.asMap(
                        "folder", folder,
                        "public_id", filename,
                        "overwrite", true,
                        "resource_type", "image",
                        "format", format));
        return (String) uploadResult.get("secure_url");
    }
}
