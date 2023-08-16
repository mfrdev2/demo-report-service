package com.example.model.led;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Builder
@Data
public class Message implements Serializable {
    private String message;
    @JsonProperty("message_color")
    private String messageColor;
    @JsonProperty("border_color")
    private String borderColor;
    @JsonProperty("border_shape")
    private String borderShape;
}
