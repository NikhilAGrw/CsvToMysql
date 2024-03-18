package com.assignment.service;

import org.springframework.web.multipart.MultipartFile;

public interface CsvService {
    boolean hasCsvFormat(MultipartFile file);

    void processAndSaveData(MultipartFile file);

}
