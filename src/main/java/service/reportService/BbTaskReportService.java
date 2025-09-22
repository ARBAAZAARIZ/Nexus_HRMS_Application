package service.reportService;

import dao.reportDao.BbTaskReportDAO;
import helper.reportHelper.BbTaskReportHelper;
import helper.reportHelper.BbTaskSummaryHelper;
import util.BbPaginationHelper;

public class BbTaskReportService {
    private BbTaskReportDAO dao = new BbTaskReportDAO();

    public BbTaskSummaryHelper getTaskSummary(String filter) throws Exception {
        return dao.getTaskSummary(filter);
    }
    
    public BbPaginationHelper<BbTaskReportHelper> fetchPaginatedTasks(int page, int recordsPerPage, String filter) throws Exception {
        return dao.getPaginatedTasks(page, recordsPerPage, filter);
    }
}
