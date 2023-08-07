package com.example.resource;

import com.example.model.PettyCashBean;
import com.example.model.PettyCashReport;
import com.example.pojo.Student;
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

import java.util.*;

@RestController
@RequestMapping("/api/v3/a2i")
public class PettyCashReportService {

    @GetMapping("petty-cash")
    public ResponseEntity<byte[]> getReportPettyCash() {

        try {
            String filePath = ResourceUtils.getFile("classpath:report/petty_cash.jrxml")
                    .getAbsolutePath();


            List<PettyCashReport> list = getPettyCashReports();


            JRBeanCollectionDataSource dataSource =
                    new JRBeanCollectionDataSource(list);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", "FRabbi");
            //	parameters.put("tableData", dataSource);

            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print =
                    JasperFillManager.
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

    @GetMapping("non-petty-cash")
    public ResponseEntity<byte[]> getReportWithoutPettyCash() {

        try {
            String filePath = ResourceUtils.getFile("classpath:report/non_petty_cash.jrxml")
                    .getAbsolutePath();


            List<PettyCashReport> list = getPettyCashReports();


            JRBeanCollectionDataSource dataSource =
                    new JRBeanCollectionDataSource(list);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", "FRabbi");
            //	parameters.put("tableData", dataSource);

            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print =
                    JasperFillManager.
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

    private static List<PettyCashReport> getPettyCashReports() {
        return Arrays.asList(
                new PettyCashReport(
                        Arrays.asList(
                                PettyCashBean.builder()
                                        .voucherNo("#VS1")
                                        .date("08-02-2023")
                                        .pcPayment("25000")
                                        .pcReceipt("546431")
                                        .nameOfPayee("FRabbi")
                                        .teamName("BT")
                                        .modeOfPayment("Mood")
                                        .modeOfPaymentRef("Cash")
                                        .bankPayment("326546")
                                        .bankReceipt("4154")
                                        .financialCode("1245")
                                        .description("Hi I am  description about this raw")
                                        .build(),
                                PettyCashBean.builder()
                                        .voucherNo("#VS1")
                                        .date("08-02-2023")
                                        .pcPayment("25000")
                                        .pcReceipt("546431")
                                        .nameOfPayee("FRabbi")
                                        .teamName("BT")
                                        .modeOfPayment("Mood")
                                        .modeOfPaymentRef("Cash")
                                        .bankPayment("326546")
                                        .bankReceipt("4154")
                                        .financialCode("1245")
                                        .description("Hi I am  description about this raw")
                                        .build(),
                                PettyCashBean.builder()
                                        .voucherNo("#VS1")
                                        .date("08-02-2023")
                                        .pcPayment("25000")
                                        .pcReceipt("546431")
                                        .nameOfPayee("FRabbi")
                                        .teamName("BT")
                                        .modeOfPayment("Mood")
                                        .modeOfPaymentRef("Cash")
                                        .bankPayment("326546")
                                        .bankReceipt("4154")
                                        .financialCode("1245")
                                        .description("Hi I am  description about this raw")
                                        .build(),
                                PettyCashBean.builder()
                                        .voucherNo("#VS1")
                                        .date("08-02-2023")
                                        .pcPayment("25000")
                                        .pcReceipt("546431")
                                        .nameOfPayee("FRabbi")
                                        .teamName("BT")
                                        .modeOfPayment("Mood")
                                        .modeOfPaymentRef("Cash")
                                        .bankPayment("326546")
                                        .bankReceipt("4154")
                                        .financialCode("1245")
                                        .description("Hi I am  description about this raw")
                                        .build()
                        )
                )
        );
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
