package com.example.resource;

import com.example.model.led.LEDRequestBody;
import com.example.model.led.Token;
import com.example.service.LEDService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/opd")
@AllArgsConstructor
public class LEDResource {

    private LEDService service;

    @PostMapping("queue-display")
    private ResponseEntity<?> getLEDDisplayData(@RequestBody LEDRequestBody body) {
        return new ResponseEntity<>(service.getLEDData(body), HttpStatus.OK);
    }
}
