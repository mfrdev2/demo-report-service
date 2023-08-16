package com.example.model.led;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Builder
@Data
public class Token implements Serializable {
    @JsonProperty("token_part_1")
    private String counterNo;
    @JsonProperty("token_part_2")
    private String tokenNo;
    @JsonProperty("part_1_color")
    private String counterColor;
    @JsonProperty("part_1_border_color")
    private String counterBorderColor;
    @JsonProperty("part_1_border_1_shape")
    private String counterBorderShape;
    @JsonProperty("part_2_color")
    private String tokenColor;
}
