package service;

import model.Employee;
import repo.PayslipRepository;

public class Payslip implements PayslipRepository {
      private Employee employee;
      private double grossIncome;
      private double basicPay;
      private double bonus;
      private double pension;
      private double travelAllowance;
      private double otherAllowance;
      private double houseAllowance;
      private double hardshipAllowance;
      private double insurance_relief;
      private double mortgage_interest;
      private double commission;
      private double loan;
      private double nssf;
      private double nhif;
      private double paye;
      private double housingLevy;
      private double netPay;
      private double taxable_amount;


    public Payslip(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome() {
        this.grossIncome = basicPay + bonus + travelAllowance + otherAllowance + commission;
    }

    public double getHouseAllowance() {
        return houseAllowance;
    }

    public void setHouseAllowance(double rate_hse_allowance) {
        this.houseAllowance = grossIncome * (rate_hse_allowance/100);
    }

    public double getHardshipAllowance() {
        return hardshipAllowance;
    }

    public void setHardshipAllowance(double rate_hd_allowance) {
        this.hardshipAllowance = grossIncome * (rate_hd_allowance/100);
    }

    public double getNhif() {
        return nhif;
    }

    public double getPension() {
        return pension;
    }

    public void setPension(double rate) {
        this.pension = basicPay * (rate/100);
    }

    public void setNhif() {
        if (grossIncome >= 100000) {
            this.nhif = 1700;
        } else if (grossIncome >= 90000) {
            this.nhif = 1600;
        } else if (grossIncome >= 80000) {
            this.nhif = 1500;
        } else if (grossIncome >= 70000) {
            this.nhif = 1400;
        } else if (grossIncome >= 60000) {
            this.nhif = 1300;
        } else if (grossIncome >= 50000) {
            this.nhif = 1200;
        } else if (grossIncome >= 45000) {
            this.nhif = 1100;
        } else if (grossIncome >= 40000) {
            this.nhif = 1000;
        } else if (grossIncome >= 35000) {
            this.nhif = 950;
        } else if (grossIncome >= 30000) {
            this.nhif = 900;
        } else if (grossIncome >= 25000) {
            this.nhif = 850;
        } else if (grossIncome >= 20000) {
            this.nhif = 750;
        } else if (grossIncome >= 15000) {
            this.nhif = 600;
        } else if (grossIncome >= 12000) {
            this.nhif = 500;
        } else if (grossIncome >= 8000) {
            this.nhif = 400;
        } else if (grossIncome >= 6000) {
            this.nhif = 300;
        } else {
            this.nhif = 150; // Default value
        }

    }

    public double getHousingLevy() {
        return housingLevy;
    }

    public void setHousingLevy() {
        this.housingLevy = grossIncome * housing_levy;
    }

    public double getMortgage_interest() {
        return mortgage_interest;
    }

    public void setMortgage_interest(double mortgage_interest) {
        this.mortgage_interest = mortgage_interest;
    }

    public double getNssf() {
        return nssf;
    }

    public void setNssf() {
        if (grossIncome <= 6000) {
            this.nssf = 0;
        } else if (grossIncome > 6000 && grossIncome <= 18000) {
            this.nssf = 0.06 * grossIncome;
        } else {
            this.nssf = 1080;
        }
    }

    public double getInsurance_relief() {
        return insurance_relief;
    }

    public void setInsurance_relief(double amount) {

        double relief = (amount + nhif) * 0.15;
        if (relief >= 5000){
            this.insurance_relief = 5000;
        }else {
            this.insurance_relief = relief;
        }
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTravelAllowance() {
        return travelAllowance;
    }

    public void setTravelAllowance(double travelAllowance) {
        this.travelAllowance = travelAllowance;
    }

    public double getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(double otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    public double getTaxable_amount() {
        return taxable_amount;
    }

    public void setTaxable_amount() {
        this.taxable_amount = grossIncome - travelAllowance - pension - nssf;
    }

    public double getPaye() {
        return paye;
    }

    public void setPaye() {

        double tax_amount = taxable_amount;

        if (tax_amount >=24000){
            this.paye = 24000 * 0.1;
            tax_amount = tax_amount - 24000;
        }

        if (tax_amount < 8330){
            this.paye += tax_amount * 0.25;
        }else {
            this.paye += 8330 * 0.25;
            tax_amount = tax_amount - 8330;
        }

        if (tax_amount !=0){
            this.paye += tax_amount * 0.3;
        }

        this.paye = this.paye - personal_relief - insurance_relief  - mortgage_interest;


    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay() {
        this.netPay = grossIncome - paye - pension  - nssf - housingLevy - loan ;

    }

    @Override
    public void displayPayslip(Payslip payslip){

        System.out.println("");
        System.out.println("PAYSLIP: \n" + payslip.getEmployee());
        System.out.println("");

        System.out.println(   "Basic Pay:               "   + payslip.getBasicPay()
                + "\nHouse Allowance:       "   + payslip.getHouseAllowance()
                + "\nCommission:            "   + payslip.getCommission()
                + "\nHardship Allowance:    "   + payslip.getHardshipAllowance()
                + "\nNon Cash Benefits:     "   + payslip.getTravelAllowance()
                + "\nBonus                  "   + payslip.getBonus()
                + "\nOther Allowances:      "   + payslip.getOtherAllowance()
                + "\n"
                + "\nGROSS INCOME:          "   + payslip.getGrossIncome()
                + "\n"
                + "\nEMPLOYEE DEDUCTIONS"
                + "\nPension:               "   + payslip.getPension()
                + "\nNSSF:                  "   + payslip.getNssf()
                + "\nNHIF:                  "   + payslip.getNhif()
                + "\nHousing Levy:          "   + payslip.getHousingLevy()
                + "\nLoans & Deductions:    "   + payslip.getLoan()
                + "\n"
                + "\nEMPLOYEE RELIEFS"
                + "\nInsurance Relief:       "   + payslip.getInsurance_relief()
                + "\nMortgage Interests:     "   + payslip.getMortgage_interest()
                + "\nNon Cash Benefits:      "   + payslip.getTravelAllowance()
                + "\n"
                + "\nTaxable Amount:         "   + payslip.getTaxable_amount()
                + "\nPAYE:                   "   + payslip.getPaye()
                + "\n"
                + "\nNET PAY:                "   + payslip.getNetPay()


        );

    }



}
