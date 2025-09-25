package dao.payrollDAO;

import java.sql.*;
import java.util.*;

import helper.payrollHelper.DeductionHelper;
import model.Deduction;
import model.DeductionType;
import util.DatabaseConnection;

public class DeductionDAO {

	Connection conn = DatabaseConnection.getConnection();

	
	public int insertDeductionType(DeductionType deductionType) throws SQLException {
		String sql = "INSERT INTO deduction_type (deduction_type_name) VALUES (?)";
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, deductionType.getDeductionTypeName());
		ps.executeUpdate();

		try (ResultSet rs = ps.getGeneratedKeys()) {
			if (rs.next()) {
				int id = rs.getInt(1);
				deductionType.setDeductionTypeId(id);
				return id;
			}
		}
		return 0;
	}

	public List<DeductionType> getDeductionTypes() throws SQLException {
		List<DeductionType> list = new ArrayList<>();
		String sql = "SELECT * FROM deduction_type";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			DeductionType dt = new DeductionType();
			dt.setDeductionTypeId(rs.getInt("deduction_type_id"));
			dt.setDeductionTypeName(rs.getString("deduction_type_name"));
			list.add(dt);
		}
		return list;
	}

	public boolean updateDeductionType(DeductionType deductionType) throws SQLException {
		String sql = "UPDATE deduction_type SET deduction_type_name=? WHERE deduction_type_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, deductionType.getDeductionTypeName());
		ps.setInt(2, deductionType.getDeductionTypeId());
		return ps.executeUpdate() > 0;
	}

	public boolean deleteDeductionType(int id) throws SQLException {
		String sql = "DELETE FROM deduction_type WHERE deduction_type_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate() > 0;
	}

	

	public List<DeductionHelper> getAllDeductions() throws SQLException {
		List<DeductionHelper> list = new ArrayList<>();

		String sql = "SELECT de.deduction_id, de.deduction_percentage, " + "d.department_id, d.department_name, "
				+ "ds.designation_id, ds.designation_name, " + "dt.deduction_type_id, dt.deduction_type_name "
				+ "FROM deduction de " + "JOIN departments d ON de.department_id = d.department_id "
				+ "JOIN designation ds ON de.designation_id = ds.designation_id "
				+ "JOIN deduction_type dt ON de.deduction_type_id = dt.deduction_type_id";

		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				DeductionHelper deduction = new DeductionHelper();
				deduction.setDeductionId(rs.getInt("deduction_id"));
				deduction.setDeductionPercentage(rs.getInt("deduction_percentage"));

				deduction.setDepartmentId(rs.getInt("department_id"));
				deduction.setDepartmentName(rs.getString("department_name"));

				deduction.setDesignationId(rs.getInt("designation_id"));
				deduction.setDesignationName(rs.getString("designation_name"));

				deduction.setDeductionTypeId(rs.getInt("deduction_type_id"));
				deduction.setDeductionTypeName(rs.getString("deduction_type_name"));

				list.add(deduction);
			}
		}
		return list;
	}

	public int insertDeduction(Deduction deduction) throws SQLException {
		String sql = "INSERT INTO deduction (deduction_percentage, department_id, designation_id, deduction_type_id) VALUES (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, deduction.getDeductionPercentage());
		ps.setInt(2, deduction.getDepartmentId());
		ps.setInt(3, deduction.getDesignationId());
		ps.setInt(4, deduction.getDeductionTypeId());
		ps.executeUpdate();

		try (ResultSet rs = ps.getGeneratedKeys()) {
			if (rs.next()) {
				int id = rs.getInt(1);
				deduction.setDeductionId(id);
				return id;
			}
		}
		return 0;
	}

	public List<Deduction> getDeductions() throws SQLException {
		List<Deduction> list = new ArrayList<>();
		String sql = "SELECT * FROM deduction";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Deduction d = new Deduction();
			d.setDeductionId(rs.getInt("deduction_id"));
			d.setDeductionPercentage(rs.getInt("deduction_percentage"));
			d.setDepartmentId(rs.getInt("department_id"));
			d.setDesignationId(rs.getInt("designation_id"));
			d.setDeductionTypeId(rs.getInt("deduction_type_id"));
			list.add(d);
		}
		return list;
	}

	public boolean updateDeduction(Deduction deduction) throws SQLException {
		String sql = "UPDATE deduction SET deduction_percentage=?, department_id=?, designation_id=?, deduction_type_id=? WHERE deduction_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, deduction.getDeductionPercentage());
		ps.setInt(2, deduction.getDepartmentId());
		ps.setInt(3, deduction.getDesignationId());
		ps.setInt(4, deduction.getDeductionTypeId());
		ps.setInt(5, deduction.getDeductionId());
		return ps.executeUpdate() > 0;
	}

	public boolean deleteDeduction(int id) throws SQLException {
		String sql = "DELETE FROM deduction WHERE deduction_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate() > 0;
	}

	public List<DeductionHelper> getByDesignation(int designationId) throws SQLException {
		List<DeductionHelper> deductions = new ArrayList<>();
		String sql = "SELECT * FROM deduction WHERE designation_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, designationId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DeductionHelper d = new DeductionHelper();
				d.setDeductionId(rs.getInt("deduction_id"));
				d.setDeductionTypeName(rs.getString("deduction_type_name"));
				d.setDeductionPercentage(rs.getInt("deduction_percentage"));
				d.setDesignationId(rs.getInt("designation_id"));
				d.setDesignationName(rs.getString("designation_name"));
				d.setDepartmentId(rs.getInt("department_id"));
				d.setDepartmentName(rs.getString("department_name"));
				deductions.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deductions;
	}

	public List<DeductionHelper> getDeductionsByDepartmentAndDesignation(int departmentId, int designationId) throws SQLException {
        List<DeductionHelper> list = new ArrayList<>();
        String sql = "SELECT d.deduction_id, d.deduction_type_id, dt.deduction_type_name, d.deduction_percentage, dep.department_id, dep.department_name, des.designation_id, des.designation_name FROM deduction d JOIN deduction_type dt ON d.deduction_type_id = dt.deduction_type_id JOIN departments dep ON d.department_id = dep.department_id JOIN designation des ON d.designation_id = des.designation_id WHERE d.department_id = ? AND d.designation_id = ?";
     

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            ps.setInt(2, designationId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DeductionHelper dh = new DeductionHelper();
                    dh.setDeductionId(rs.getInt("deduction_id"));
                    dh.setDeductionTypeId(rs.getInt("deduction_type_id"));
                    dh.setDeductionTypeName(rs.getString("deduction_type_name"));
                    dh.setDeductionPercentage(rs.getInt("deduction_percentage"));
                    dh.setDepartmentId(rs.getInt("department_id"));
                    dh.setDepartmentName(rs.getString("department_name"));
                    dh.setDesignationId(rs.getInt("designation_id"));
                    dh.setDesignationName(rs.getString("designation_name"));

                    list.add(dh);
                }
            }
        }
        return list;
    }
	
	
	public List<DeductionHelper> getDeductionsByEmployee(int userId, int salaryId) throws SQLException {
	    List<DeductionHelper> list = new ArrayList<>();
	    String sql = "SELECT ed.deduction_id, dt.deduction_type_name, ed.deduction_amt " +
	                 "FROM employee_deduction ed " +
	                 "JOIN deduction d ON ed.deduction_id = d.deduction_id " +
	                 "JOIN deduction_type dt ON d.deduction_type_id = dt.deduction_type_id " +
	                 "WHERE ed.user_id = ? AND ed.salary_id = ?";

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, userId);
	        ps.setInt(2, salaryId);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                DeductionHelper dh = new DeductionHelper();
	                dh.setDeductionId(rs.getInt("deduction_id"));
	                dh.setDeductionTypeName(rs.getString("deduction_type_name"));
	                dh.setCalculatedAmount(rs.getDouble("deduction_amt")); // ✅ directly from DB
	                list.add(dh);
	            }
	        }
	    }
	    return list;
	}


}
