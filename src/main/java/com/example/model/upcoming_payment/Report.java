package com.example.model.upcoming_payment;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Builder
@Data
public class Report implements Serializable {
    private List<UpcomingPaymentBean> upcomingPaymentTableData;
}
