package com.example.model.led;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Builder
@Data
public class LEDData implements Serializable {
    private Message message;
    private Token token;
}
