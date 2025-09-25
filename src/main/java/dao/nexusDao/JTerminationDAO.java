package dao.nexusDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.JTermination;
import util.DatabaseConnection;

public class JTerminationDAO {

    public List<JTermination> fetchAll() {
        List<JTermination> list = new ArrayList<>();
        String sql = "select t.*, u.first_name, u.last_name from termination t join users u on t.user_id=u.user_id order by t.termination_id desc";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                JTermination t = new JTermination();
                t.setTermination_id(rs.getInt("termination_id"));
                t.setTermination_type(rs.getString("termination_type"));
                t.setNotice_date(rs.getDate("notice_date"));
                t.setResign_date(rs.getDate("resign_date"));
                t.setReason(rs.getString("reason"));
                t.setStatus(rs.getString("status"));
                t.setUser_id(rs.getInt("user_id"));
                t.setUser_name(rs.getString("first_name")+" "+rs.getString("last_name"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save(JTermination t) {
        String sqlTerm = "insert into termination (termination_type, notice_date, resign_date, reason, status, user_id) values (?,?,?,?,?,?)";
        String sqlUser = "update users set status='INACTIVE' where user_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement psTerm = con.prepareStatement(sqlTerm);
             PreparedStatement psUser = con.prepareStatement(sqlUser)) {
            psTerm.setString(1, t.getTermination_type());
            psTerm.setDate(2, t.getNotice_date());
            psTerm.setDate(3, t.getResign_date());
            psTerm.setString(4, t.getReason());
            psTerm.setString(5, t.getStatus());
            psTerm.setInt(6, t.getUser_id());
            psTerm.executeUpdate();
            psUser.setInt(1, t.getUser_id());
            psUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(JTermination t) {
        String sql = "update termination set termination_type=?, notice_date=?, resign_date=?, reason=?, status=?, user_id=? where termination_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getTermination_type());
            ps.setDate(2, t.getNotice_date());
            ps.setDate(3, t.getResign_date());
            ps.setString(4, t.getReason());
            ps.setString(5, t.getStatus());
            ps.setInt(6, t.getUser_id());
            ps.setInt(7, t.getTermination_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int termination_id) {
        String sqlGetUser = "select user_id from termination where termination_id=?";
        String sqlDel = "delete from termination where termination_id=?";
        String sqlUser = "update users set status='ACTIVE' where user_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement psGetUser = con.prepareStatement(sqlGetUser);
             PreparedStatement psDel = con.prepareStatement(sqlDel);
             PreparedStatement psUser = con.prepareStatement(sqlUser)) {

            int userId = 0;
            psGetUser.setInt(1, termination_id);
            try (ResultSet rs = psGetUser.executeQuery()) {
                if (rs.next()) {
                    userId = rs.getInt("user_id");
                }
            }

            psDel.setInt(1, termination_id);
            psDel.executeUpdate();

            if (userId != 0) {
                psUser.setInt(1, userId);
                psUser.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public JTermination fetchById(int termination_id) {
        JTermination t = null;
        String sql = "select t.*, u.first_name, u.last_name from termination t join users u on t.user_id=u.user_id where termination_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, termination_id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    t = new JTermination();
                    t.setTermination_id(rs.getInt("termination_id"));
                    t.setTermination_type(rs.getString("termination_type"));
                    t.setNotice_date(rs.getDate("notice_date"));
                    t.setResign_date(rs.getDate("resign_date"));
                    t.setReason(rs.getString("reason"));
                    t.setStatus(rs.getString("status"));
                    t.setUser_id(rs.getInt("user_id"));
                    t.setUser_name(rs.getString("first_name")+" "+rs.getString("last_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
}
