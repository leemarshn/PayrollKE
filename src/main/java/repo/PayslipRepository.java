package repo;

import service.Payslip;

public interface PayslipRepository {


    double housing_levy = 0.015;
    double personal_relief = 2400;


    void displayPayslip(Payslip payslip);
}
