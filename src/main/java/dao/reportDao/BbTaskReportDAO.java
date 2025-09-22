package dao.reportDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import helper.reportHelper.BbTaskReportHelper;
import helper.reportHelper.BbTaskSummaryHelper;

import util.BbPaginationHelper;
import util.DatabaseConnection;

public class BbTaskReportDAO {

   
    public BbTaskSummaryHelper getTaskSummary(String filter) throws Exception {
        int total = 0, completed = 0, onhold = 0, overdue = 0;

        String baseCondition = " WHERE 1=1 ";
        if ("daily".equalsIgnoreCase(filter)) {
            baseCondition += " AND DATE(deadline) = CURDATE() ";
        } else if ("weekly".equalsIgnoreCase(filter)) {
            baseCondition += " AND YEARWEEK(deadline) = YEARWEEK(NOW()) ";
        } else if ("monthly".equalsIgnoreCase(filter)) {
            baseCondition += " AND MONTH(deadline) = MONTH(NOW()) AND YEAR(deadline) = YEAR(NOW()) ";
        }

        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement()) {

           
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM task" + baseCondition);
            if (rs.next()) total = rs.getInt(1);

            
            rs = st.executeQuery("SELECT COUNT(*) FROM task WHERE status='completed'" + (baseCondition.replace("WHERE 1=1", " AND 1=1")));
            if (rs.next()) completed = rs.getInt(1);

            
            rs = st.executeQuery("SELECT COUNT(*) FROM task WHERE status='onhold'" + (baseCondition.replace("WHERE 1=1", " AND 1=1")));
            if (rs.next()) onhold = rs.getInt(1);

         
            rs = st.executeQuery("SELECT COUNT(*) FROM task WHERE deadline < CURDATE() AND status!='completed'" + (baseCondition.replace("WHERE 1=1", " AND 1=1")));
            if (rs.next()) overdue = rs.getInt(1);
        }

        return new BbTaskSummaryHelper(total, completed, onhold, overdue);
    }

    public BbPaginationHelper<BbTaskReportHelper> getPaginatedTasks(int page, int recordsPerPage, String filter) throws Exception {
        List<BbTaskReportHelper> list = new ArrayList<>();
        int start = (page - 1) * recordsPerPage;

        String baseQuery =
                "SELECT t.task_id, t.title, p.project_name, " +
                "DATE_FORMAT(t.deadline, '%Y-%m-%d') as deadline, " +
                "t.priority, t.status " +
                "FROM task t JOIN projects p ON t.project_id = p.project_id " +
                "WHERE 1=1 ";

        if ("daily".equalsIgnoreCase(filter)) {
            baseQuery += " AND DATE(t.deadline) = CURDATE() ";
        } else if ("weekly".equalsIgnoreCase(filter)) {
            baseQuery += " AND YEARWEEK(t.deadline) = YEARWEEK(NOW()) ";
        } else if ("monthly".equalsIgnoreCase(filter)) {
            baseQuery += " AND MONTH(t.deadline) = MONTH(NOW()) AND YEAR(t.deadline) = YEAR(NOW()) ";
        }

        baseQuery += " ORDER BY t.task_id DESC LIMIT ?, ?";

        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(baseQuery);
            ps.setInt(1, start);
            ps.setInt(2, recordsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BbTaskReportHelper(
                        rs.getInt("task_id"),
                        rs.getString("title"),
                        rs.getString("project_name"),
                        rs.getString("deadline"),
                        rs.getString("priority"),
                        rs.getString("status")
                ));
            }

            String countQuery = "SELECT COUNT(*) FROM task t WHERE 1=1 ";
            if ("daily".equalsIgnoreCase(filter)) {
                countQuery += " AND DATE(t.deadline) = CURDATE() ";
            } else if ("weekly".equalsIgnoreCase(filter)) {
                countQuery += " AND YEARWEEK(t.deadline) = YEARWEEK(NOW()) ";
            } else if ("monthly".equalsIgnoreCase(filter)) {
                countQuery += " AND MONTH(t.deadline) = MONTH(NOW()) AND YEAR(t.deadline) = YEAR(NOW()) ";
            }

            int totalRecords = 0;
            try (Statement st = con.createStatement();
                 ResultSet rs2 = st.executeQuery(countQuery)) {
                if (rs2.next()) totalRecords = rs2.getInt(1);
            }

            return new BbPaginationHelper<>(list, totalRecords, recordsPerPage, page);
        }
    }
}
