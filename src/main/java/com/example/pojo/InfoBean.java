package com.example.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Builder
@Data
public class InfoBean implements Serializable {
    private String nameBn;
    private BigDecimal creditAmount;
    private BigDecimal debitAmount;
}
