package com.reet.java.file.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.reet.java.file.upload.util.FileStorageUtil.createDirIfDoesNotExist;
import static com.reet.java.file.upload.util.FileStorageUtil.folderPath;

@Controller
@CrossOrigin("http://localhost:8080")
@Slf4j
public class FileUploadController {

  /**
   * Method to upload file
   *
   * @param file - file to be uploaded
   * @return     - response message
   */
  @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
    try {
      createDirIfDoesNotExist();
      byte[] bytes;
      bytes = file.getBytes();
      Files.write(Paths.get(folderPath + file.getOriginalFilename()), bytes);
      log.info("File uploaded successfully");
      return ResponseEntity.status(HttpStatus.OK)
              .body("File uploaded successfully: " + file.getOriginalFilename());
    } catch (Exception exception) {
      log.error("Error occurred while uploading the file : {}", exception.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Exception occurred while uploading file: " + file.getOriginalFilename() + "!");
    }
  }



  /**
   * Method to get the list of files from the file storage folder.
   *
   * @return file names
   */
  @GetMapping("/files")
  public ResponseEntity<String[]> getListFiles() {
    return ResponseEntity.status(HttpStatus.OK)
            .body(new java.io.File(folderPath).list());
  }

}
