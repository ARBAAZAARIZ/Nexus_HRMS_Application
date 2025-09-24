package dao.nexusDao;

import java.sql.*;
import java.util.*;
import model.Resignation;
import util.DatabaseConnection;

public class ResignationDAO {
    public void save(Resignation r) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String q = "insert into resignation (resignation_id, department_id, notice_date, resign_date, reason, status, user_id) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, r.getResignation_id());
            ps.setInt(2, r.getDepartment_id());
            ps.setDate(3, r.getNotice_date());
            ps.setDate(4, r.getResign_date());
            ps.setString(5, r.getReason());
            ps.setString(6, r.getStatus());
            ps.setInt(7, r.getUser_id());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error save: " + e);
        }
    }

    public List<Resignation> fetchAll() {
        List<Resignation> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String q = "select r.resignation_id, r.department_id, r.notice_date, r.resign_date, r.reason, r.status, r.user_id, u.first_name, u.last_name, d.department_name from resignation r join users u on r.user_id=u.user_id join departments d on r.department_id=d.department_id where u.status='active'";
            PreparedStatement ps = conn.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Resignation r = new Resignation();
                r.setResignation_id(rs.getInt("resignation_id"));
                r.setDepartment_id(rs.getInt("department_id"));
                r.setNotice_date(rs.getDate("notice_date"));
                r.setResign_date(rs.getDate("resign_date"));
                r.setReason(rs.getString("reason"));
                r.setStatus(rs.getString("status"));
                r.setUser_id(rs.getInt("user_id"));
                r.setFirst_name(rs.getString("first_name"));
                r.setLast_name(rs.getString("last_name"));
                r.setDepartment(rs.getString("department_name"));
                list.add(r);
            }
        } catch (Exception e) {
            System.out.println("Error fetchAll: " + e);
        }
        return list;
    }

    public void delete(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String q = "delete from resignation where resignation_id=?";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error delete: " + e);
        }
    }

    public void update(Resignation r) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String q = "update resignation set department_id=?, notice_date=?, resign_date=?, reason=?, status=?, user_id=? where resignation_id=?";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, r.getDepartment_id());
            ps.setDate(2, r.getNotice_date());
            ps.setDate(3, r.getResign_date());
            ps.setString(4, r.getReason());
            ps.setString(5, r.getStatus());
            ps.setInt(6, r.getUser_id());
            ps.setInt(7, r.getResignation_id());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error update: " + e);
        }
    }

    public Resignation findById(int id) {
        Resignation r = null;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String q = "select * from resignation where resignation_id=?";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r = new Resignation();
                r.setResignation_id(rs.getInt("resignation_id"));
                r.setDepartment_id(rs.getInt("department_id"));
                r.setNotice_date(rs.getDate("notice_date"));
                r.setResign_date(rs.getDate("resign_date"));
                r.setReason(rs.getString("reason"));
                r.setStatus(rs.getString("status"));
                r.setUser_id(rs.getInt("user_id"));
            }
        } catch (Exception e) {
            System.out.println("Error findById: " + e);
        }
        return r;
    }
}
