package controller.payrollController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import service.employeeService.EmployeeService;
import service.employeeService.UserService;
import service.payrollService.DeductionService;
import service.payrollService.EarningService;
import helper.employeeHelper.UserDetails;
import helper.payrollHelper.DeductionHelper;
import helper.payrollHelper.EarningHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddEmployeeSalary")
public class AddEmployeeSalary extends HttpServlet {
    private static final long serialVersionUID = 1L;

    EmployeeService employeeService = new EmployeeService();
    EarningService earningService = new EarningService();
    DeductionService deductionService = new DeductionService();
    private UserService userService =new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    	List<UserDetails> employeeList = userService.getAllUserDetails();
        request.setAttribute("employeeList", employeeList);

        
        List<EarningHelper> earnings = new ArrayList<>();
        List<DeductionHelper> deductions = new ArrayList<>();

        
        String employeeIdParam = request.getParameter("employeeId");
        String totalSalaryParam = request.getParameter("totalSalary");

        if (employeeIdParam != null && !employeeIdParam.isEmpty()) {
            try {
                int employeeId = Integer.parseInt(employeeIdParam);
                Users emp = employeeService.getEmployeeById(employeeId);

                
                double totalSalary = 0.0;
                if (totalSalaryParam != null && !totalSalaryParam.isEmpty()) {
                    totalSalary = Double.parseDouble(totalSalaryParam);
                }

                
                earnings = earningService.getEarningsByDepartmentAndDesignation(emp.getDepartmentId(), emp.getDesignationId());
                deductions = deductionService.getDeductionsByDepartmentAndDesignation(emp.getDepartmentId(), emp.getDesignationId());

                double totalEarnings = 0.0;
                double totalDeductions = 0.0;

                if(totalSalary > 0) {
                    for (EarningHelper er : earnings) {
                        double amt = (totalSalary * er.getEarningPercentage()) / 100.0;
                        er.setCalculatedAmount(amt);
                        totalEarnings += amt;
                    }

                    for (DeductionHelper dr : deductions) {
                        double amt = (totalSalary * dr.getDeductionPercentage()) / 100.0;
                        dr.setCalculatedAmount(amt);
                        totalDeductions += amt;
                    }
                }

                double netSalary = totalSalary + totalEarnings - totalDeductions;
                
                
              

        
                request.setAttribute("employee", emp);
                request.setAttribute("totalSalary", totalSalary);
                request.setAttribute("netSalary", netSalary);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("earnings", earnings);
        request.setAttribute("deductions", deductions);

        request.getRequestDispatcher("WEB-INF/views/payroll/addEmployeeSalary.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    	List<UserDetails> employeeList = userService.getAllUserDetails();
        request.setAttribute("employeeList", employeeList);

       
        List<EarningHelper> earnings = new ArrayList<>();
        List<DeductionHelper> deductions = new ArrayList<>();

        try {
        	String employeeIdParam = request.getParameter("employeeId");
            if (employeeIdParam != null && !employeeIdParam.isEmpty()) {
                int employeeId = Integer.parseInt(employeeIdParam);
                Users emp = employeeService.getEmployeeById(employeeId);
            double totalSalary = 0.0;
            String totalSalaryParam = request.getParameter("totalSalary");
            if (totalSalaryParam != null && !totalSalaryParam.isEmpty()) {
                totalSalary = Double.parseDouble(totalSalaryParam);
            }

            
            earnings = earningService.getEarningsByDepartmentAndDesignation(
                    emp.getDepartmentId(), emp.getDesignationId());

            deductions = deductionService.getDeductionsByDepartmentAndDesignation(
                    emp.getDepartmentId(), emp.getDesignationId());

            double totalEarnings = 0.0;
            double totalDeductions = 0.0;

            if(totalSalary > 0) {
                for (EarningHelper er : earnings) {
                    double amt = (totalSalary * er.getEarningPercentage()) / 100.0;
                    er.setCalculatedAmount(amt);
                    totalEarnings += amt;
                }

                for (DeductionHelper dr : deductions) {
                    double amt = (totalSalary * dr.getDeductionPercentage()) / 100.0;
                    dr.setCalculatedAmount(amt);
                    totalDeductions += amt;
                }
            }

            double netSalary = totalSalary + totalEarnings - totalDeductions;
            
            int salaryId = employeeService.saveSalary(emp.getUserId(), totalSalary, netSalary);

            for (EarningHelper er : earnings) {
                employeeService.saveEmployeeEarning(emp.getUserId(), salaryId, er.getEarningId(), er.getCalculatedAmount());
            }

            for (DeductionHelper dr : deductions) {
                employeeService.saveEmployeeDeduction(emp.getUserId(), salaryId, dr.getDeductionId(), dr.getCalculatedAmount());
            }

          
            request.setAttribute("employee", emp);
            request.setAttribute("totalSalary", totalSalary);
            request.setAttribute("netSalary", netSalary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("earnings", earnings);
        request.setAttribute("deductions", deductions);

        request.getRequestDispatcher("WEB-INF/views/payroll/generatePayslip.jsp").forward(request, response);
    }
        
}
