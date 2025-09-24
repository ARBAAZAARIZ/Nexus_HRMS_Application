package dao.nexusDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Users;
import util.DatabaseConnection;

public class UserDAO {
			    public void saveUser(Users u) {
			        try {
			           Connection conn=DatabaseConnection.getConnection();
			            String q = "insert into Users (user_id,firstName, lastName, email, hashPassword, "
			            		+ "contactNumber, roleId, departmentId, designationId, "
			            		+ "dateOfJoining, dateOfBirth, address, profilePicture, "
			            		+ "reportingManager, aboutEmployee, "
			            		+ "createdAt, createdBy, modifiedAt, modifiedBy, status) values "
			            		 + "('"+u.getUserId()+"',"
			                    + "('"+u.getFirstName()+"',"
			 					+ "'"+u.getLastName()+"',"
			 					+ "'"+u.getEmail()+"',"
								+ "'"+u.getHashPassword()+"',"
								+ "'"+u.getContactNumber()+"',"
								+ "'"+u.getRoleId()+"',"
								+ "'"+u.getDepartmentId()+"',"
							    + "'"+u.getDesignationId()+"',"
							    + "'"+u.getDateOfJoining()+"',"
							    + "'"+u.getDateOfBirth()+"',"
							    + "'"+u.getAddress()+"',"
							    + "'"+u.getProfilePicture()+"',"
							    + "'"+u.getReportingManager()+"',"
							    + "'"+u.getAboutEmployee()+"',"
							    + "'"+u.getCreatedAt()+"',"
							    + "'"+u.getCreatedBy()+"',"
							    + "'"+u.getModifiedAt()+"',"
							    + "'"+u.getModifiedBy()+"',"
							    + "'"+u.getStatus()+"')";
			            PreparedStatement ps = conn.prepareStatement(q);
			            ps.executeUpdate();
			        } 
			        catch (Exception e) {
			            System.out.println(e);
			        }
			    }

			    public List<Users> fetchUser() {
			        List<Users> userlist = new ArrayList<Users>();
			        try {
			            Connection conn = DatabaseConnection.getConnection();
			            String q = "SELECT * FROM Users where status='active'";
			            PreparedStatement ps = conn.prepareStatement(q);
			            ResultSet rs = ps.executeQuery();
			            while (rs.next()) {
			            	userlist.add(new Users(
			                    rs.getInt("user_id"),
			                    rs.getString("first_name"),
			                    rs.getString("last_name")
			                ));
			            }
			        } 
			        catch (Exception e) {
			            System.out.println(e);
			        }
			        return userlist;
			    }
			      public void deleteuser(int id) {
			        try {
			            Connection conn = DatabaseConnection.getConnection();
			            String q = "DELETE FROM Users WHERE user_id=?";
			            PreparedStatement ps = conn.prepareStatement(q);
			            ps.executeUpdate();
			        } 
			        catch (Exception e) {
			            System.out.println(e);
			        }
			    }
			   
			    public Users findById(int id) {
			        Users u = null;
			        try {
			            Connection conn = DatabaseConnection.getConnection();
			            String q = "SELECT * FROM Users WHERE user_id=?";
			            PreparedStatement ps = conn.prepareStatement(q);
			            ResultSet rs = ps.executeQuery();
			            if (rs.next()) {
			                u = new Users(
			                		rs.getInt("userId"),
			                        rs.getString("firstName"),
			                        rs.getString("lastName"),
			                        rs.getString("email"),
			                        rs.getString("hashPassword"),
			                        rs.getString("contactNumber"),
			                        rs.getInt("roleId"),
			                        rs.getInt("departmentId"),
			                        rs.getInt("designationId"),
			                        rs.getDate("dateOfJoining"),
			                        rs.getDate("dateOfBirth"),
			                        rs.getString("address"),
			                        rs.getString("profilePicture"),
			                        rs.getInt("reportingManager"),
			                        rs.getString("aboutEmployee"),
			                        rs.getDate("createdAt"),
			                        rs.getString("createdBy"),
			                        rs.getDate("modifiedAt"),
			                        rs.getString("modifiedBy"),
			                        rs.getString("status")
			                );
			            }
			        } 
			        catch (Exception e) {
			            System.out.println(e);
			        }
			        return u;
			    }
			    
			    public void updateUsers(Users user) {
			        try {
			            Connection conn = DatabaseConnection.getConnection();
			            String q = "UPDATE users SET firstName=?, lastName=?, email=?, hashPassword=?, contactNumber=?, roleId=?, departmentId=?, designationId=?, dateOfJoining=?, dateOfBirth=?, address=?, profilePicture=?, reportingManager=?, aboutEmployee=?, modifiedAt=?, modifiedBy=?,"
			            		+ " status=? WHERE userId=?;";
			            PreparedStatement ps = conn.prepareStatement(q);
			            ps.executeUpdate();
			        } catch (Exception e) {
			            System.out.println(e);
			        }
			    }

			  
			    
}
