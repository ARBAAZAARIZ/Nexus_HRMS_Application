package dao.reportDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.reportHelper.BbProjectReportHelper;
import helper.reportHelper.BbProjectReportHelper.MemberDTO;
import util.BbPaginationHelper;
import util.DatabaseConnection;

public class BbProjectReportDAO {

    public Map<String, Integer> getProjectCounts() {
        Map<String, Integer> counts = new HashMap<>();
        String total = "SELECT COUNT(*) FROM projects";
        String completed = "SELECT COUNT(*) FROM projects WHERE status='COMPLETED'";
        String overdue = "SELECT COUNT(*) FROM projects WHERE end_date < CURDATE() AND status!='COMPLETED'";
        String onhold = "SELECT COUNT(*) FROM projects WHERE status='ONHOLD'";

        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement()) {

            counts.put("total", getCount(st, total));
            counts.put("completed", getCount(st, completed));
            counts.put("overdue", getCount(st, overdue));
            counts.put("onhold", getCount(st, onhold));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return counts;
    }

    private int getCount(Statement st, String sql) throws Exception {
        try (ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) return rs.getInt(1);
        }
        return 0;
    }

  
    public BbPaginationHelper<BbProjectReportHelper> getProjects(int page, int pageSize) {
        List<BbProjectReportHelper> list = new ArrayList<>();
        int totalRecords = 0;

        String countSql = "SELECT COUNT(*) FROM projects";
        String sql = "SELECT project_id, project_name, manager_name, end_date, priority, status " +
                     "FROM projects ORDER BY project_id DESC LIMIT ? OFFSET ?";

        try (Connection con = DatabaseConnection.getConnection()) {

            try (Statement st = con.createStatement();
                 ResultSet rsCount = st.executeQuery(countSql)) {
                if (rsCount.next()) totalRecords = rsCount.getInt(1);
            }

           
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, pageSize);
                ps.setInt(2, (page - 1) * pageSize);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int projectId = rs.getInt("project_id");
                        String projectName = rs.getString("project_name");
                        String leader = rs.getString("manager_name"); // alias for leader
                        String deadline = rs.getString("end_date");
                        String priority = rs.getString("priority");
                        String status = rs.getString("status");

                       
                        List<MemberDTO> members = getProjectMembers(con, projectId);

                        list.add(new BbProjectReportHelper(
                                projectId, projectName, leader, deadline, priority, status, members
                        ));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new BbPaginationHelper<>(list, totalRecords, page, pageSize);
    }

    
    public List<BbProjectReportHelper> getAllProjects() {
        List<BbProjectReportHelper> list = new ArrayList<>();
        String sql = "SELECT project_id, project_name, manager_name, end_date, priority, status FROM projects";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int projectId = rs.getInt("project_id");
                String projectName = rs.getString("project_name");
                String leader = rs.getString("manager_name");
                String deadline = rs.getString("end_date");
                String priority = rs.getString("priority");
                String status = rs.getString("status");

            
                List<MemberDTO> members = getProjectMembers(con, projectId);

                list.add(new BbProjectReportHelper(
                        projectId, projectName, leader, deadline, priority, status, members
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    private List<MemberDTO> getProjectMembers(Connection con, int projectId) {
        List<MemberDTO> members = new ArrayList<>();
        String sql = "SELECT u.first_name, u.last_name, u.profile_picture " +
                     "FROM project_user pu " + 
                     "JOIN users u ON u.user_id = pu.user_id " +
                     "WHERE pu.project_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("first_name") + " " + rs.getString("last_name");
                    String photo = rs.getString("profile_picture");
                    members.add(new MemberDTO(name, photo));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return members;
    }
}
