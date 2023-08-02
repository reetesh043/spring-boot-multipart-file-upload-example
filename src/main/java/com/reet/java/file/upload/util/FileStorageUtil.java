package com.reet.java.file.upload.util;

import lombok.NoArgsConstructor;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@NoArgsConstructor
public class FileStorageUtil {

    public static final String folderPath = "files-storage//";
    public static final Path filePath = Paths.get(folderPath);

    public static void createDirIfDoesNotExist() {
        //create directory to save the files
        File directory = new File(folderPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}