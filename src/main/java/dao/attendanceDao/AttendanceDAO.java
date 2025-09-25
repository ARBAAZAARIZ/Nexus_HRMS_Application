package dao.attendanceDao;

import util.DatabaseConnection;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Attendance;

public class AttendanceDAO {

    private static final LocalTime OFFICE_START_TIME = LocalTime.of(9, 0);
    private static final LocalTime HALF_DAY_THRESHOLD = LocalTime.of(13, 0); 
    public String handlePunch(int userId) throws SQLException {
        String nextAction = "Punch In";
        try (Connection conn = DatabaseConnection.getConnection()) {
            LocalDate today = LocalDate.now();

            String sq = "SELECT * FROM attendance WHERE user_id = ? AND date = ?";
            try (PreparedStatement ps = conn.prepareStatement(sq)) {
                ps.setInt(1, userId);
                ps.setDate(2, Date.valueOf(today));

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                       
                        LocalTime now = LocalTime.now();
                        double lateHour = 0.0;
                        String status = "present";

                        if (now.isAfter(OFFICE_START_TIME)) {
                            lateHour = Duration.between(OFFICE_START_TIME, now).toMinutes() / 60.0;
                        }

                        if (now.isAfter(HALF_DAY_THRESHOLD)) {
                            status = "half-day";
                        }

                        String sq1 = "INSERT INTO attendance(user_id, date, check_in, status, late_hour) VALUES(?, ?, ?, ?, ?)";
                        try (PreparedStatement ps1 = conn.prepareStatement(sq1)) {
                            ps1.setInt(1, userId);
                            ps1.setDate(2, Date.valueOf(today));
                            ps1.setTime(3, Time.valueOf(now));
                            ps1.setString(4, status);
                            ps1.setDouble(5, lateHour);
                            ps1.executeUpdate();
                        }

                        nextAction = "Lunch Out";

                    } else {
                        int attendanceID = rs.getInt("attendance_id");
                        Time checkIn = rs.getTime("check_in");
                        Time lunchOut = rs.getTime("lunch_out");
                        Time lunchIn = rs.getTime("lunch_in");
                        Time checkOut = rs.getTime("check_out");

                        if (lunchOut == null) {
                            String sq2 = "UPDATE attendance SET lunch_out=? WHERE attendance_id=?";
                            try (PreparedStatement ps2 = conn.prepareStatement(sq2)) {
                                ps2.setTime(1, Time.valueOf(LocalTime.now()));
                                ps2.setInt(2, attendanceID);
                                ps2.executeUpdate();
                            }
                            nextAction = "Lunch In";

                        } else if (lunchIn == null) {
                            String sq3 = "UPDATE attendance SET lunch_in=? WHERE attendance_id=?";
                            try (PreparedStatement ps3 = conn.prepareStatement(sq3)) {
                                ps3.setTime(1, Time.valueOf(LocalTime.now()));
                                ps3.setInt(2, attendanceID);
                                ps3.executeUpdate();
                            }
                            nextAction = "Punch Out";

                        } else if (checkOut == null) {
                            LocalTime now = LocalTime.now();

                            long totalMinutes = Duration.between(checkIn.toLocalTime(), now).toMinutes();
                            long totalBreak = Duration.between(lunchOut.toLocalTime(), lunchIn.toLocalTime()).toMinutes();
                            long workingMinutes = totalMinutes - totalBreak;

                            String sq4 = "UPDATE attendance SET check_out=?, working_hours=?, break_hour=? WHERE attendance_id=?";
                            try (PreparedStatement ps4 = conn.prepareStatement(sq4)) {
                                ps4.setTime(1, Time.valueOf(now));
                                ps4.setDouble(2, workingMinutes / 60.0);
                                ps4.setDouble(3, totalBreak / 60.0);
                                ps4.setInt(4, attendanceID);
                                ps4.executeUpdate();
                            }
                            nextAction = "Done";
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nextAction;
    }




 
    
    public Attendance getTodayAttendance(int userId ) throws SQLException {
    	
    	LocalDate today = LocalDate.now();
        String sql = "SELECT * FROM attendance WHERE user_id=? AND date=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(today));
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Attendance attend = new Attendance();
                    attend.setCheck_in(rs.getTime("check_in"));
                    attend.setLunch_out(rs.getTime("lunch_out"));
                    attend.setLunch_in(rs.getTime("lunch_in"));
                    attend.setCheck_out(rs.getTime("check_out"));
                    attend.setDate(rs.getDate("date"));
                   
                    attend.setProduction_hours(rs.getDouble("working_hours"));
                    attend.setLate_hour(rs.getDouble("break_hour"));
                    attend.setUser_id(rs.getInt("user_id"));
                    System.out.println(attend.getCheck_in());
                    System.out.println(attend.getWorking_hours());
                    System.out.println(attend.getProduction_hours());
                    return attend;
                }
            }
        }
        return null; 
    	
    }
    
    
    public double getTodayWorkingHours(int userId) throws SQLException {
        LocalDate today = LocalDate.now();
        String sql = "SELECT working_hours FROM attendance WHERE user_id=? AND date=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(today));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("working_hours"); 
                }
            }
        }
        return 0.0; 
    }
    
    
    public double getWeeklyWorkingHours(int userId) throws SQLException {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = today.with(DayOfWeek.SUNDAY);

        String sql = "SELECT SUM(working_hours) as total_hours FROM attendance WHERE user_id=? AND date BETWEEN ? AND ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(startOfWeek));
            ps.setDate(3, Date.valueOf(endOfWeek));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("total_hours"); 
                }
            }
        }
        return 0.0;
    }
    
    public double getTodayBreakHours(int userId) throws SQLException {
        LocalDate today = LocalDate.now();
        String sql = "SELECT break_hour FROM attendance WHERE user_id=? AND date=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(today));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("break_hour"); 
                }
            }
        }
        return 0.0;
    }

    public double getMonthlyWorkingHours(int userId) throws SQLException {
        YearMonth currentMonth = YearMonth.now();
        LocalDate startOfMonth = currentMonth.atDay(1);
        LocalDate endOfMonth = currentMonth.atEndOfMonth();

        String sql = "SELECT SUM(working_hours) as total_hours FROM attendance WHERE user_id=? AND date BETWEEN ? AND ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(startOfMonth));
            ps.setDate(3, Date.valueOf(endOfMonth));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("total_hours");
                }
            }
        }
        return 0.0;
    }
    
    
    public int getAllPresent() {
        String sql = "SELECT COUNT(*) AS total_present FROM attendance WHERE status = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "Present");  
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total_present");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; 
    }
    
    
    public int getAllAbsent() {
        String sql = "SELECT COUNT(*) AS total_absent FROM attendance WHERE status = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "Absent");
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total_absent");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    public int getTotalEmployees() {
        String sql = "SELECT COUNT(*) AS total_employees FROM users WHERE status = 'ACTIVE'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt("total_employees");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List<Attendance> getTodaysAttendance(int userId) throws SQLException {
        List<Attendance> attendanceList = new ArrayList<>();
        LocalDate today = LocalDate.now();

        String sql = "SELECT * FROM attendance WHERE user_id=? AND date=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(today));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Attendance att = new Attendance();
                    att.setUser_id(rs.getInt("user_id"));
                    att.setCheck_in(rs.getTime("check_in"));
                    att.setLunch_out(rs.getTime("lunch_out"));
                    att.setLunch_in(rs.getTime("lunch_in"));
                    att.setCheck_out(rs.getTime("check_out"));
                    att.setWorking_hours(rs.getDouble("working_hours"));
                    att.setBreak_hours(rs.getDouble("break_hour"));
                    attendanceList.add(att);
                }
            }
        }
        return attendanceList;
    }

}
