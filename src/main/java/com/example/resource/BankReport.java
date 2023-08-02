package com.example.resource;

import com.example.jasperreport.service.JasperReportService;
import com.example.pojo.InfoBean;
import com.example.pojo.ReportBean;
import com.example.pojo.Student;
import com.example.pojo.Subject;
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

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/v2/bank")
public class BankReport {

    @GetMapping("report")
    public ResponseEntity<byte[]> getReport() {

        try {
            String filePath = ResourceUtils.getFile("classpath:demov2.jrxml")
                    .getAbsolutePath();



            List<ReportBean> lit = new ArrayList<>();

            lit.add(ReportBean.builder()
                    .reportName("Bank Report")
                    .logoUrl(null)
                    .nameBnAndAmounts(Arrays.asList(InfoBean.builder()
                            .nameBn("FRabbi")
                            .creditAmount(BigDecimal.valueOf(5464))
                            .debitAmount(BigDecimal.valueOf(465456))
                            .build(),
                            InfoBean.builder()
                            .creditAmount(BigDecimal.valueOf(5454))
                            .nameBn("FRabbi")
                            .debitAmount(BigDecimal.valueOf(64564))
                            .build()))
                    .build());



            JRBeanCollectionDataSource chartDataSource =
                    new JRBeanCollectionDataSource(lit);

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("service", new JasperReportService());
            //	parameters.put("tableData", dataSource);

            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print =
                    JasperFillManager.
                            fillReport(report, parameters, chartDataSource);

            byte[] byteArray = JasperExportManager.exportReportToPdf(print);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "bank.pdf");

            return new ResponseEntity<byte[]>(byteArray, headers, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Exception while creating report:: "+e.getMessage());
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public static JasperReport getSubReport() {

        JasperReport report;
        try {
            String filePath = ResourceUtils.getFile("classpath:FirstReport.jrxml").getAbsolutePath();
            report = JasperCompileManager.compileReport(filePath);
            return report;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JRBeanCollectionDataSource getSubDataSource() {
        Student student1 = new Student(1L, "Raj", "Joshi", "Happy Street",
                "Delhi");

        Student student2 = new Student(2L, "Peter", "Smith", "Any Street",
                "Mumbai");

        List<Student> list = new ArrayList<Student>();
        list.add(student1);
        list.add(student2);

        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(list);

        return dataSource;
    }

    public static Map<String, Object> getSubParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("studentName", "FRabbi");

        return parameters;
    }

}
