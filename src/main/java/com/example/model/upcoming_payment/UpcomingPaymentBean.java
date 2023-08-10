package com.example.model.upcoming_payment;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Builder
@Data
public class UpcomingPaymentBean implements Serializable {
        private String packageName;
        private String sourceOfFund;
        private String vendorName;
        private String team;
        private String invoiceSubmissionDate;
        private String tillPending;
        private String dueBefore;
        private String firstMonth;
        private String secondMonth;
        private String thirdMonth;
        private String fourthMonth;
        private String fifthMonth;
        private String sixMonth;
        private String anAmountToBePaid;
        private String contractAdministrator;
}
