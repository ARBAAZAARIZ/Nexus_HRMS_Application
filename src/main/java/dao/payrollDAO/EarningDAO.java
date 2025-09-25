package dao.payrollDAO;

import java.sql.*;
import java.util.*;

import helper.payrollHelper.EarningHelper;
import model.Earning;
import model.EarningType;
import util.DatabaseConnection;

public class EarningDAO {

    Connection conn = DatabaseConnection.getConnection();

   
    public int insertEarningType(EarningType earningType) throws SQLException {
        String sql = "INSERT INTO earning_type (earning_type_name) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, earningType.getEarningTypeName());
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                int id = rs.getInt(1);
                earningType.setEarningTypeId(id);
                return id;
            }
        }
        return 0;
    }

    public List<EarningType> getEarningTypes() throws SQLException {
        List<EarningType> list = new ArrayList<>();
        String sql = "SELECT * FROM earning_type";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            EarningType et = new EarningType();
            et.setEarningTypeId(rs.getInt("earning_type_id"));
            et.setEarningTypeName(rs.getString("earning_type_name"));
            list.add(et);
        }
        return list;
    }
    
    

    public boolean updateEarningType(EarningType earningType) throws SQLException {
        String sql = "UPDATE earning_type SET earning_type_name=? WHERE earning_type_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, earningType.getEarningTypeName());
        ps.setInt(2, earningType.getEarningTypeId());
        return ps.executeUpdate() > 0;
    }

    public boolean deleteEarningType(int id) throws SQLException {
        String sql = "DELETE FROM earning_type WHERE earning_type_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
    
    

    
    public List<EarningHelper> getAllEarnings() throws SQLException {
        List<EarningHelper> list = new ArrayList<>();

        String sql = "SELECT e.earning_id, e.earning_percentage, " +
                     "d.department_id, d.department_name, " +
                     "ds.designation_id, ds.designation_name, " +
                     "et.earning_type_id, et.earning_type_name " +
                     "FROM earning e " +
                     "JOIN departments d ON e.department_id = d.department_id " +
                     "JOIN designation ds ON e.designation_id = ds.designation_id " +
                     "JOIN earning_type et ON e.earning_type_id = et.earning_type_id";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                EarningHelper earning = new EarningHelper();
                earning.setEarningId(rs.getInt("earning_id"));
                earning.setEarningPercentage(rs.getInt("earning_percentage"));

                earning.setDepartmentId(rs.getInt("department_id"));
                earning.setDepartmentName(rs.getString("department_name"));

                earning.setDesignationId(rs.getInt("designation_id"));
                earning.setDesignationName(rs.getString("designation_name"));

                earning.setEarningTypeId(rs.getInt("earning_type_id"));
                earning.setEarningTypeName(rs.getString("earning_type_name"));

                list.add(earning);
            }
        }
        return list;
    }
    
    
    
    
    public int insertEarning(Earning earning) throws SQLException {
        String sql = "INSERT INTO earning (earning_percentage, department_id, designation_id, earning_type_id) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, earning.getEarningPercentage());
        ps.setInt(2, earning.getDepartmentId());
        ps.setInt(3, earning.getDesignationId());
        ps.setInt(4, earning.getEarningTypeId());
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                int id = rs.getInt(1);
                earning.setEarningId(id);
                return id;
            }
        }
        return 0;
    }



    public boolean updateEarning(Earning earning) throws SQLException {
        String sql = "UPDATE earning SET earning_percentage=?, department_id=?, designation_id=?, earning_type_id=? WHERE earning_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, earning.getEarningPercentage());
        ps.setInt(2, earning.getDepartmentId());
        ps.setInt(3, earning.getDesignationId());
        ps.setInt(4, earning.getEarningTypeId());
        ps.setInt(5, earning.getEarningId());
        return ps.executeUpdate() > 0;
    }

    public boolean deleteEarning(int id) throws SQLException {
        String sql = "DELETE FROM earning WHERE earning_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
    
    
    public List<EarningHelper> getByDesignation(int designationId) throws SQLException {
        List<EarningHelper> earnings = new ArrayList<>();
        String sql = "SELECT * FROM earning WHERE designation_id = ?";
        try {
             PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, designationId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EarningHelper e = new EarningHelper();
                e.setEarningId(rs.getInt("earning_id"));
                e.setEarningTypeName(rs.getString("earning_type_name"));
                e.setEarningPercentage(rs.getDouble("earning_percentage"));
                e.setDesignationId(rs.getInt("designation_id"));
                e.setDesignationName(rs.getString("designation_name"));
                earnings.add(e);
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return earnings;
    }
    
    
    
    public List<EarningHelper> getEarningsByDepartmentAndDesignation(int departmentId, int designationId) throws SQLException {
        List<EarningHelper> list = new ArrayList<>();
        String sql = "SELECT e.earning_id, e.earning_type_id, et.earning_type_name, e.earning_percentage, dep.department_id, dep.department_name, des.designation_id, des.designation_name FROM earning e JOIN earning_type et ON e.earning_type_id = et.earning_type_id JOIN departments dep ON e.department_id = dep.department_id JOIN designation des ON e.designation_id = des.designation_id WHERE e.department_id = ? AND e.designation_id = ?";


        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            ps.setInt(2, designationId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EarningHelper eh = new EarningHelper();
                    eh.setEarningId(rs.getInt("earning_id"));
                    eh.setEarningTypeId(rs.getInt("earning_type_id"));
                    eh.setEarningTypeName(rs.getString("earning_type_name"));
                    eh.setEarningPercentage(rs.getDouble("earning_percentage"));
                    eh.setDepartmentId(rs.getInt("department_id"));
                    eh.setDepartmentName(rs.getString("department_name"));
                    eh.setDesignationId(rs.getInt("designation_id"));
                    eh.setDesignationName(rs.getString("designation_name"));

                    list.add(eh);
                }
            }
        }
        return list;
    }
    
    
    public List<EarningHelper> getEarningsByEmployee(int userId, int salaryId) throws SQLException {
        List<EarningHelper> list = new ArrayList<>();
        String sql = "SELECT ee.earning_id earning_id, et.earning_type_name, ee.earning_amt " +
                     "FROM employee_earning ee " +
                     "JOIN earning e ON ee.earning_id = e.earning_id " +
                     "JOIN earning_type et ON e.earning_type_id = et.earning_type_id " +
                     "WHERE ee.user_id = ? AND ee.salary_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, salaryId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EarningHelper helper = new EarningHelper();
                    helper.setEarningId(rs.getInt("earning_id"));
                    helper.setEarningTypeName(rs.getString("earning_type_name"));
                    helper.setCalculatedAmount(rs.getDouble("earning_amt")); // ✅ directly from DB
                    list.add(helper);
                }
            }
        }
        return list;
    }



   

}
