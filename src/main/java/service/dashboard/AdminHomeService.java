package service.dashboard;

import java.util.Map;

import dao.dashboard.AdminHomeDao;
import helper.dashboardHelper.AdminDashboardMetrics;

public class AdminHomeService {
    private AdminHomeDao adminHomeDao = new AdminHomeDao();

    public AdminDashboardMetrics fetchAdminDashboardMetrics() {
        return adminHomeDao.getAdminDashboardMetrics();
    }
    
    public Map<String, Integer> fetchEmployeeCountByDepartment() {
        return adminHomeDao.getEmployeeCountByDepartment();
    }

}
