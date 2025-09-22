package dao.reportDao;

import helper.reportHelper.BbAttendanceReportHelper;
import helper.reportHelper.BbAttendanceSummaryHelper;

import java.sql.*;
import java.util.*;

public class BbAttendanceReportDAO {

    private Connection conn;

    public BbAttendanceReportDAO(Connection conn) {
        this.conn = conn;
    }

  
    public BbAttendanceSummaryHelper getAttendanceSummary() throws Exception {
        BbAttendanceSummaryHelper summary = new BbAttendanceSummaryHelper(0, 0, 0, 0);

        
        String empSql = "SELECT COUNT(*) FROM users WHERE status='ACTIVE'";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(empSql)) {
            if (rs.next()) summary.setTotalEmployees(rs.getInt(1));
        }

      
        String leaveSql = "SELECT COUNT(*) FROM attendance WHERE status='absent'";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(leaveSql)) {
            if (rs.next()) summary.setTotalLeaves(rs.getInt(1));
        }

      
        String holidaySql = "SELECT COUNT(*) FROM attendance WHERE status='holiday'";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(holidaySql)) {
            if (rs.next()) summary.setTotalHolidays(rs.getInt(1));
        }

        
        String halfdaySql = "SELECT COUNT(*) FROM attendance WHERE status='halfday' OR late_hour >= 4";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(halfdaySql)) {
            if (rs.next()) summary.setTotalHalfdays(rs.getInt(1));
        }

        return summary;
    }

    
    public List<BbAttendanceReportHelper> getAttendanceReport() throws Exception {
        List<BbAttendanceReportHelper> list = new ArrayList<>();

        String sql = "SELECT a.attendance_id, a.date, a.check_in, a.check_out, " +
                     "a.lunch_in, a.lunch_out, a.status, a.working_hours, " +
                     "a.production_hours, a.break_hour, u.first_name, u.last_name, u.profile_picture " +
                     "FROM attendance a " +
                     "JOIN users u ON a.user_id = u.user_id " +
                     "ORDER BY a.date DESC";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String empName = rs.getString("first_name") + " " + rs.getString("last_name");

                BbAttendanceReportHelper h = new BbAttendanceReportHelper(
                        rs.getInt("attendance_id"),
                        empName,
                        rs.getString("profile_picture"),
                        rs.getDate("date"),
                        rs.getString("check_in"),
                        rs.getString("check_out"),
                        rs.getString("lunch_in"),
                        rs.getString("lunch_out"),
                        rs.getString("status"),
                        rs.getInt("working_hours"),
                        rs.getInt("production_hours"),
                        rs.getInt("break_hour")
                );

                list.add(h);
            }
        }
        return list;
    }

    
    public Map<String, Map<String, Integer>> getAttendanceGraphData(java.sql.Date fromDate, java.sql.Date toDate) throws Exception {
       
        Map<String, Map<String, Integer>> graphData = new LinkedHashMap<>();

        String sql = "SELECT DATE(a.date) as day, a.status, COUNT(*) as cnt " +
                     "FROM attendance a " +
                     "WHERE a.date BETWEEN ? AND ? " +
                     "GROUP BY DATE(a.date), a.status " +
                     "ORDER BY DATE(a.date)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, fromDate);
            ps.setDate(2, toDate);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String day = rs.getString("day");
                    String status = rs.getString("status");
                    int count = rs.getInt("cnt");

                    graphData.putIfAbsent(day, new HashMap<>());
                    graphData.get(day).put(status, count);
                }
            }
        }

        return graphData;
    }
}
