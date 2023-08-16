package com.example.model.led;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class LEDRequestBody implements Serializable {
    @JsonProperty("device_ip")
    private String deviceId;
}
