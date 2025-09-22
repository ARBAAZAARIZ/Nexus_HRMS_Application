package service.reportService;

import java.util.List;
import java.util.Map;

import dao.reportDao.BbProjectReportDAO;
import helper.reportHelper.BbProjectReportHelper;
import helper.reportHelper.BbProjectSummaryHelper;
import util.BbPaginationHelper;

public class BbProjectReportService {

    private final BbProjectReportDAO projectDao;

    public BbProjectReportService() {
        this.projectDao = new BbProjectReportDAO();
    }

    public BbProjectSummaryHelper getProjectSummary() {
        Map<String, Integer> counts = projectDao.getProjectCounts();

        return new BbProjectSummaryHelper(
            counts.getOrDefault("total", 0),
            counts.getOrDefault("completed", 0),
            counts.getOrDefault("onhold", 0),
            counts.getOrDefault("overdue", 0)
        );
    }

    public BbPaginationHelper<BbProjectReportHelper> getProjectList(int page, int pageSize) {
        return projectDao.getProjects(page, pageSize);
    }

    public List<BbProjectReportHelper> getAllProjects() {
        return projectDao.getAllProjects();
    }
}
