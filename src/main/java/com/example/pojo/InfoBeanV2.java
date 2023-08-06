package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InfoBeanV2 implements Serializable {
    private String nameBn;
    private BigDecimal creditAmount;
    private List<InnerTableData> innerTableData;
}
