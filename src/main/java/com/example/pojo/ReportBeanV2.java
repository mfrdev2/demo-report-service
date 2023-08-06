package com.example.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class ReportBeanV2 implements Serializable {
    private List<InfoBeanV2> nameBnAndAmounts;
    private String officeName;
    private String officeAddress;
    private String reportName;
    private String logoUrl;
}
