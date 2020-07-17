package com.random.strings.controllers;

import com.random.strings.controllers.dto.RandomDto;
import com.random.strings.services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class RandomControllers {

    @Autowired
    private ProcessService processService;

    @PostMapping("/random")
    public ResponseEntity random(@RequestBody RandomDto randomDto) throws IOException {
        processService.process(randomDto);
        return ResponseEntity.status(200).body("success");
    }

}
