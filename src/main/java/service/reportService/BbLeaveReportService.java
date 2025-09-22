package service.reportService;

import java.sql.Connection;
import java.util.List;

import dao.reportDao.BbLeaveReportDAO;
import helper.reportHelper.BbLeaveReportHelper;
import util.BbPaginationHelper;

public class BbLeaveReportService {
    private BbLeaveReportDAO dao;

    public BbLeaveReportService(Connection conn) {
        this.dao = new BbLeaveReportDAO(conn);
    }

    
    public int getTotalLeaves(int year) throws Exception { 
        return dao.getTotalLeaves(year); 
    }
    public int getApprovedLeaves(int year) throws Exception { 
        return dao.getApprovedLeaves(year); 
    }
    public int getPendingLeaves(int year) throws Exception { 
        return dao.getPendingLeaves(year); 
    }
    public int getRejectedLeaves(int year) throws Exception { 
        return dao.getRejectedLeaves(year); 
    }

   
    public List<String> getDeptNames() throws Exception {
        return dao.getDeptNames();
    }
    public List<Integer> getDeptCounts() throws Exception {
        return dao.getDeptCounts();
    }

    
    public List<Integer> getMonthlyTrends(int year) throws Exception {
        return dao.getMonthlyTrends(year);
    }

    
    public BbPaginationHelper<BbLeaveReportHelper> getLeaveList(int page, int pageSize) throws Exception {
        return dao.getLeaveList(page, pageSize);
    }
}
