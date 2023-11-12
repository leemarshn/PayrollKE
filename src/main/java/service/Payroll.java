package service;

import model.Employee;

import java.util.Scanner;

public class Payroll {






    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //EMPLOYEE DETAILS
        System.out.print("Enter National ID: ");
        int nationalID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter First Name: ");
        String first_name = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String last_name = scanner.nextLine();

        System.out.print("Enter Middle Name: ");
        String middle_name = scanner.nextLine();


        // BEGINNING OF PAYSLIP DETAILS

        System.out.print("Enter Basic Pay: ");
        double basicPay = scanner.nextDouble();

        System.out.print("Enter Commission: ");
        double commission = scanner.nextDouble();

        System.out.print("Enter Pension: % of Basic Pay: ");
        double rate_pension = scanner.nextDouble();

        System.out.print("Enter House Allowance: % of Basic Pay: ");
        double rate_hse_allowance = scanner.nextDouble();

        System.out.print("Enter Hardship Allowance: % of Basic Pay: ");
        double rate_hd_allowance = scanner.nextDouble();

        System.out.print("Enter Insurance Premium: ");
        double premium = scanner.nextDouble();

        System.out.print("Enter Mortgage Interests Amount: ");
        double mortgage = scanner.nextDouble();

        System.out.print("Enter Bonus Amount: ");
        double bonus = scanner.nextDouble();

        System.out.print("Enter Travel Allowance / Non Cash Benefits: ");
        double travelAllowance= scanner.nextDouble();

        System.out.print("Enter Any Deductions e.g Loans etc: ");
        double deductions = scanner.nextDouble();

        System.out.print("Enter any Other Allowances: ");
        double otherAllowance = scanner.nextDouble();


        Payslip payslip = new Payslip(new Employee(nationalID, first_name, middle_name, last_name));


        //Contribute to gross income
        payslip.setBasicPay(basicPay);
        payslip.setBonus(bonus);
        payslip.setTravelAllowance(travelAllowance);
        payslip.setOtherAllowance(otherAllowance);
        payslip.setCommission(commission);
        payslip.setHouseAllowance(rate_hse_allowance);
        payslip.setHardshipAllowance(rate_hd_allowance);

        payslip.setGrossIncome();

        //deductions on gross income
        payslip.setHousingLevy();
        payslip.setLoan(deductions);
        payslip.setNhif();
        payslip.setNssf();

        //allowable tax -> get taxable amount
        payslip.setPension(rate_pension);
        payslip.setMortgage_interest(mortgage);
        payslip.setInsurance_relief(premium);
        payslip.setTaxable_amount();


        payslip.setPaye();
        payslip.setNetPay();


        payslip.displayPayslip(payslip);











    }
}
