package com.example.service;

import com.example.model.led.LEDData;
import com.example.model.led.LEDRequestBody;
import com.example.model.led.Message;
import com.example.model.led.Token;
import org.springframework.stereotype.Service;

@Service
public class LEDService {
    public LEDData getLEDData(LEDRequestBody body) {
        System.out.println(body);
        return LEDData.builder()
                .message(Message.builder()
                        .message("Welcome to Business Automation Ltd.")
                        .messageColor("GREEN")
                        .borderColor("NONE")
                        .borderShape("NONE")
                        .build())
                .token(Token.builder()
                        .counterNo("01")
                        .counterColor("RED")
                        .counterBorderColor("GREEN")
                        .counterBorderShape("SQUARE")
                        .tokenNo("FR01")
                        .tokenColor("GREEN")
                        .build())
                .build();
    }
}
