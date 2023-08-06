package com.example.resource;

import com.example.jasperreport.service.JasperReportService;
import com.example.pojo.*;
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
@RequestMapping("/api/v3/bank")
public class BankReportV2 {

    @GetMapping("report")
    public ResponseEntity<byte[]> getReport() {

        try {
            String filePath = ResourceUtils.getFile("classpath:demov3.jrxml")
                    .getAbsolutePath();


            List<ReportBeanV2> lit = new ArrayList<>();
            List<InfoBeanV2> list = Arrays.asList(
                    new InfoBeanV2("FR",
                            BigDecimal.valueOf(6546465),
                            Arrays.asList(
                                    new InnerTableData("xx"),
                                    new InnerTableData("xx"),
                                    new InnerTableData("xx"),
                                    new InnerTableData("xx")
                            )
                    )

            );

            lit.add(ReportBeanV2.builder()
                    .officeName("Business Automation Ltd")
                    .officeAddress("Mirpur DHOS, Dhaka - 1216")
                    .reportName("Bank Report")
                    .logoUrl("https://ebs.oss.net.bd/home/images/site-logo.png")

                    .nameBnAndAmounts(list)

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
            System.out.println("Exception while creating report:: " + e.getMessage());
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
