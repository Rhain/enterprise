package com.rhain.enterprise.service.impl;

import com.rhain.enterprise.exception.FileNotFoundException;
import com.rhain.enterprise.exception.FileStorageException;
import com.rhain.enterprise.exception.ResourceNotFoundException;
import com.rhain.enterprise.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private static final DateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Override
    public String storeFile(MultipartFile file) {
        Date date = new Date();
        String day = sdf.format(date);
        Path location = Paths.get(uploadDir).toAbsolutePath().normalize();
        location = location.resolve(day).normalize();
        if(Files.notExists(location)){
            try {
                Files.createDirectories(location);
            } catch (IOException e) {
                throw new FileStorageException("Could not create the directory where the uploaded files will be stored ", e);
            }
        }
        String originalFilename = file.getOriginalFilename();
        Integer index = originalFilename.lastIndexOf(".");
        String ext = originalFilename.substring(index, originalFilename.length());

        String fileName = date.getTime() + ext;
        if(fileName.contains("..")){
            throw new FileStorageException("Sorry! Filename contains invalid path sequence");
        }
        Path targetLocation = location.resolve(fileName);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }
        return day + File.separator + fileName;
    }

    @Override
    public Resource loadFileAsResource(String filename) {
        try {
            Path location = Paths.get(uploadDir).toAbsolutePath().normalize();
            Path filePath = location.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()){
                return resource;
            }else {
                throw new FileNotFoundException("File Not Found:" + filename);
            }
        }catch (MalformedURLException e) {
            throw new FileNotFoundException("File Not Found:" + filename, e);
        }

    }
}
