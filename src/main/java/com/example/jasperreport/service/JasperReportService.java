package com.example.jasperreport.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class JasperReportService implements Serializable {
  public static String getFormattedAmount(BigDecimal bigDecimal){
      return "152644.000";
  }

  public static Integer toBnStr(Object page){
      return 12;
  }

  public static Date getReportGenerationDate(){
      return new Date();
  }

}
