package controller.payrollController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.payrollDAO.DesignationDAO;
import helper.employeeHelper.DesignationHelper;
import helper.payrollHelper.DeductionHelper;
import helper.payrollHelper.EarningHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Earning;
import model.EarningType;
import model.Deduction;
import model.DeductionType;
import model.Departments;
import model.Designations;
import service.payrollService.EarningService;
import service.employeeService.DepartmentService;
import service.employeeService.DesignationService;
import service.payrollService.DeductionService;

@WebServlet("/salaryConfig")
public class salaryConfig extends HttpServlet {
    private static final long serialVersionUID = 1L;

    EarningService earningService = new EarningService();
    DeductionService deductionService = new DeductionService();
    
    DepartmentService departmentService=new DepartmentService();
    DesignationService designationService=new DesignationService();
    
    DesignationDAO dao=new DesignationDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            List<EarningHelper> earnings = earningService.fetchEarnings();
            List<DeductionHelper> deductions = deductionService.fetchDeductions();
            List<EarningType> earningTypes = earningService.listEarningTypes();
            List<DeductionType> deductionTypes = deductionService.listDeductionTypes();
            
            List<Departments> departments=departmentService.getAllDepartments();
            List<DesignationHelper>designations=designationService.getAllDesignations();

           

            request.setAttribute("earnings", earnings);
            request.setAttribute("deductions", deductions);
            request.setAttribute("earningTypes", earningTypes);
            request.setAttribute("deductionTypes", deductionTypes);

            request.setAttribute("departments", departments);
            request.setAttribute("designations", designations);

            request.getRequestDispatcher("WEB-INF/views/payroll/salaryConfig.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");

            
            if ("addEarning".equals(action)) {
                Earning e = new Earning();
                e.setEarningTypeId(Integer.parseInt(request.getParameter("earningTypeId")));
               int per=(int) Double.parseDouble(request.getParameter("earningPercentage"));
                e.setEarningPercentage(per);
               int deptId= Integer.parseInt(request.getParameter("departmentId"));
                e.setDepartmentId(deptId);
                e.setDesignationId(Integer.parseInt(request.getParameter("designationId")));
                departmentService.getDepartmentById(deptId);
                
                request.setAttribute("deptId", deptId);
                earningService.addEarning(e);

            } else if ("updateEarning".equals(action)) {
                Earning e = new Earning();
                e.setEarningId(Integer.parseInt(request.getParameter("id"))); // unified name
                e.setEarningTypeId(Integer.parseInt(request.getParameter("earningTypeId")));
                int per=(int) Double.parseDouble(request.getParameter("earningPercentage"));
                e.setEarningPercentage(per);
                e.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
                e.setDesignationId(Integer.parseInt(request.getParameter("designationId")));
                earningService.updateEarning(e);

            } else if ("deleteEarning".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                earningService.deleteEarning(id);

            
            } else if ("addDeduction".equals(action)) {
                Deduction d = new Deduction();
                d.setDeductionTypeId(Integer.parseInt(request.getParameter("deductionTypeId")));
                int per=(int) Double.parseDouble(request.getParameter("deductionPercentage"));
                d.setDeductionPercentage(per);
                d.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
                d.setDesignationId(Integer.parseInt(request.getParameter("designationId")));
                deductionService.addDeduction(d);

            } else if ("updateDeduction".equals(action)) {
                Deduction d = new Deduction();
                d.setDeductionId(Integer.parseInt(request.getParameter("id"))); // unified name
                d.setDeductionTypeId(Integer.parseInt(request.getParameter("deductionTypeId")));
                int per=(int) Double.parseDouble(request.getParameter("deductionPercentage"));
                d.setDeductionPercentage(per);
                d.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
                d.setDesignationId(Integer.parseInt(request.getParameter("designationId")));
                deductionService.updateDeduction(d);

            } else if ("deleteDeduction".equals(action)) {
                int id = Integer.parseInt(request.getParameter("deductionId"));
                deductionService.deleteDeduction(id);

           
            } else if ("addEarningType".equals(action)) {
                EarningType et = new EarningType();
                et.setEarningTypeName(request.getParameter("earningTypeName"));
                earningService.addEarningType(et);

            } else if ("updateEarningType".equals(action)) {
                EarningType et = new EarningType();
                et.setEarningTypeId(Integer.parseInt(request.getParameter("id")));
                et.setEarningTypeName(request.getParameter("earningTypeName"));
                earningService.updateEarningType(et);

            } else if ("deleteEarningType".equals(action)) {
                int id = Integer.parseInt(request.getParameter("earningId"));
                earningService.deleteEarningType(id);

            
            } else if ("addDeductionType".equals(action)) {
                DeductionType dt = new DeductionType();
                dt.setDeductionTypeName(request.getParameter("deductionTypeName"));
                deductionService.addDeductionType(dt);

            } else if ("updateDeductionType".equals(action)) {
                DeductionType dt = new DeductionType();
                dt.setDeductionTypeId(Integer.parseInt(request.getParameter("id")));
                dt.setDeductionTypeName(request.getParameter("deductionTypeName"));
                deductionService.updateDeductionType(dt);

            } else if ("deleteDeductionType".equals(action)) {
                int id = Integer.parseInt(request.getParameter("deductionId"));
                deductionService.deleteDeductionType(id);
            } else if("getByDepartment".equals(action)) {
                String deptIdStr = request.getParameter("deptId");
                int deptId = Integer.parseInt(deptIdStr);

                List<DesignationHelper> designations = dao.getAllDesignations();

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < designations.size(); i++) {
                    DesignationHelper des = designations.get(i);
                    json.append("{")
                        .append("\"designationId\":").append(des.getDesignationId()).append(",")
                        .append("\"designationName\":\"").append(des.getDesignationName()).append("\"")
                        .append("}");
                    if (i < designations.size() - 1) json.append(",");
                }
                json.append("]");
                response.getWriter().write(json.toString());
                return; 
            }

            response.sendRedirect("salaryConfig");

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

}
