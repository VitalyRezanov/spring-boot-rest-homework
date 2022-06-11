package com.netcracker.service;

import com.fasterxml.jackson.core.json.JsonReadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileLoadService<T> {
    public List<T> uploadFile(MultipartFile file) {
        List<T> entities = new ArrayList<>();
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get("/" + file.getOriginalFilename());
        try(BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(Files.write(path, bytes).toFile())))){
            String line = br.readLine();
            String[] subjects = line.split("/");


        } catch (IOException e) {
            e.printStackTrace();
        }
        return entities;
    }
}
