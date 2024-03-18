package com.assignment.controller;

import com.assignment.response.ResponseMessage;
import com.assignment.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CsvRestController {

    @Autowired
    private CsvService service;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){

        if(service.hasCsvFormat(file)) {
            service.processAndSaveData(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseMessage("Upload file success: "+file.getOriginalFilename()));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseMessage("Please upload csv file"));
    }

}
