package service.dashboard;

import dao.dashboard.EmployeeHomeDao;
import helper.dashboardHelper.EmployeeDashboardMetrics;

public class EmployeeHomeService {

    private EmployeeHomeDao employeeHomeDao = new EmployeeHomeDao();

    public EmployeeDashboardMetrics employeeFetchDashboardMetrics(int userId) {
        return employeeHomeDao.employeeGetDashboardMetrics(userId);
    }
}
