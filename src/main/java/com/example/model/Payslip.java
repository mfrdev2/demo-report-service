//package com.example.model;
//
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//
//@SqlResultSetMapping(
//        name = "PhasePaymentMapping",
//        classes = @ConstructorResult(
//                targetClass = PhasePayment.class,
//                columns = {
//                        @ColumnResult(name = "total", type = Integer.class),
//                        @ColumnResult(name = "paidTotal", type = Integer.class)
//                }
//        )
//)
//@NamedNativeQuery(
//        name = "Payslip.findPhasePaymentData",
//        query = "SELECT COUNT(*) AS total, SUM(CASE WHEN payment_status = 'paid' THEN 1 ELSE 0 END) + 1 AS paidTotal " +
//                "FROM ci_payslips " +
//                "WHERE contract_id = :contractId",
//        resultSetMapping = "PhasePaymentMapping"
//)
//@Data
//@Entity
//@Table(name = "ci_payslips")
//@EqualsAndHashCode(callSuper = true)
//public class Payslip  {
//    @Id
//    @Column(name = "payslip_id")
//    private Integer payslipId; //PRIMARY KEY
//    @Column(name = "payslip_key")
//    private String payslipKey;
//    @Column(name = "company_id")
//    private Integer companyId;
//    @Column(name = "contract_id")
//    private Integer contractId;
//    @Column(name = "contract_amount", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double contractAmount;
//    @Column(name = "payment_status")
//    private String paymentStatus;
//    @Column(name = "paid_amount", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double paidAmount;
//    @Column(name = "staff_id")
//    private Integer staffId;
//    @Column(name = "salary_month")
//    private String salaryMonth;
//    @Column(name = "wages_type")
//    private Integer wagesType;
//    @Column(name = "payslip_type")
//    private String payslipType;
//    @Column(name = "basic_salary", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double basicSalary;
//    @Column(name = "daily_wages", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double dailyWages;
//    @Column(name = "hours_worked", columnDefinition = "varchar(255) default '0'")
//    private String hoursWorked;
//    @Column(name = "total_allowances", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double totalAllowances;
//    @Column(name = "total_commissions", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double totalCommissions;
//    @Column(name = "total_statutory_deductions", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double totalStatutoryDeductions;
//    @Column(name = "total_other_payments", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double totalOtherPayments;
//    @Column(name = "net_salary", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double netSalary;
//    @Column(name = "payment_method")
//    private Integer paymentMethod;
//    @Column(name = "pay_comments", columnDefinition = "TEXT")
//    private String payComments;
//    @Column(name = "is_payment")
//    private Integer isPayment;
//    @Column(name = "year_to_date")
//    private String yearToDate;
//    @Column(name = "is_advance_salary_deduct")
//    private Integer isAdvanceSalaryDeduct;
//    @Column(name = "advance_salary_amount", columnDefinition = "Decimal(65,2)")
//    private Double advanceSalaryAmount;
//    @Column(name = "is_loan_deduct")
//    private Integer isLoanDeduct;
//    @Column(name = "loan_amount", columnDefinition = "Decimal(65,2)")
//    private Double loanAmount;
//    @Column(name = "status")
//    private Integer status;
//    @Column(name = "created_at")
//    private String createdAt;
//    @Column(name = "vat", columnDefinition = "Decimal(65,2) default '0.00'")
//    private Double vat;
//    @Column(name = "tax", columnDefinition = "varchar(65) default '0.00'")
//    private String tax;
//    @Column(name = "payment_date")
//    private String paymentDate;
//}
