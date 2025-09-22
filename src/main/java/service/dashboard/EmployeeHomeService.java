package service.dashboard;

import java.util.List;

import dao.dashboard.EmployeeHomeDao;
import helper.dashboardHelper.EmployeeDashboardMetrics;
import helper.dashboardHelper.TrainingInfo;

public class EmployeeHomeService {

    private EmployeeHomeDao employeeHomeDao = new EmployeeHomeDao();

    public EmployeeDashboardMetrics employeeFetchDashboardMetrics(int userId) {
        return employeeHomeDao.employeeGetDashboardMetrics(userId);
    }
    
    public List<TrainingInfo> employeeGetTrainingProgress(int userId) {
        return employeeHomeDao.employeeGetTrainingProgress(userId);
    }
    
}
