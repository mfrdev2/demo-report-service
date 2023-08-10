package com.example.resource;

import com.example.model.upcoming_payment.Report;
import com.example.model.upcoming_payment.UpcomingPaymentBean;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/a2i")
public class UpcomingPaymentReport {

    @GetMapping("upcoming-report")
    public ResponseEntity<byte[]> getUpcomingPaymentReport() {

        try {
            String filePath = ResourceUtils.getFile("classpath:report/upcoming_payment.jrxml")
                    .getAbsolutePath();


            List<UpcomingPaymentBean> upcomingPaymentBeanList = Arrays.asList(UpcomingPaymentBean.builder()
                            .packageName("Package")
                    .build());



            JRBeanCollectionDataSource dataSource =
                    new JRBeanCollectionDataSource(Arrays.asList(Report.builder()
                                    .upcomingPaymentTableData(upcomingPaymentBeanList)
                            .build()));

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("headerTitle", "This is a title");
            parameters.put("firstMonthName", "Jan");
            parameters.put("secondMonthName", "Feb");
            parameters.put("thirdMonthName", "March");
            parameters.put("fourthMonthName", "April");
            parameters.put("fifthMonthName", "May");
            parameters.put("sixthMonthName", "June");
            //	parameters.put("tableData", dataSource);

            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print = JasperFillManager.
                            fillReport(report, parameters, dataSource);



            byte[] byteArray = JasperExportManager.exportReportToPdf(print);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "petty-cash-report.pdf");
            return new ResponseEntity<byte[]>(byteArray, headers, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Exception while creating report:: " + e.getMessage());
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
