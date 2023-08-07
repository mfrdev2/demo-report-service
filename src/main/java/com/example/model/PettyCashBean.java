package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PettyCashBean implements Serializable {
    private String voucherNo;
    private String date;
    private String pcReceipt;
    private String pcPayment;
    private String nameOfPayee;
    private String teamName;
    private String description;
    private String modeOfPayment;
    private String modeOfPaymentRef;
    private String bankReceipt;
    private String bankPayment;
    private String financialCode;
}
