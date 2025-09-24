package dao.documentsDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.documents.*;
import util.DatabaseConnection;
import model.documents.Documents;

public class DpAdminDocumentsDao {

    public void addDocuments(Documents doc) {
        String q = "insert into master_admin(document_name) values(?)";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setString(1, doc.getDocumentName());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUploadDocuments(Uploads upload) {
        String q = "insert into upload_admin(upload_name, upload_file, document_id, user_id) values(?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setString(1, upload.getUploadName());
            cs.setString(2, upload.getUploadFile());
            cs.setInt(3, upload.getDocumentId());
            cs.setInt(4, upload.getUserId());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteDocName(int id) {
        String q = "delete from master_admin where document_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
  public  List<Documents> fetechDocName(){
	  List<Documents> li=new ArrayList();
	  String q="Select * from master_admin";
	  try (Connection conn = DatabaseConnection.getConnection();
	             CallableStatement cs = conn.prepareCall(q);
	             ResultSet rs = cs.executeQuery()) {

	            while (rs.next()) {
	        Documents doc=new Documents();
	        doc.setId(rs.getInt("document_id"));
	        doc.setDocumentName(rs.getString("document_name"));
	       	        li.add(doc);
	       
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	  return li;
  }

    public int fetchDocumentId(String documentName) {
        int id = 0;
        String q = "select document_id from master_admin where document_name=?";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setString(1, documentName);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) id = rs.getInt("document_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<UploadDetails> uploadedDetails() {
        String q = "select u.upload_id, u.upload_name, u.upload_file, u.document_id, u.user_id, "
                 + "d.document_name, us.first_name, us.last_name, us.email "
                 + "from upload_admin u "
                 + "join master_admin d on u.document_id=d.document_id "
                 + "join users us on u.user_id=us.user_id";

        List<UploadDetails> li = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                UploadDetails obj = new UploadDetails();
                obj.setUploadId(rs.getInt("upload_id"));
                obj.setUploadName(rs.getString("upload_name"));
                obj.setUploadFile(rs.getString("upload_file"));
                obj.setDocumentId(rs.getInt("document_id"));
                obj.setUserId(rs.getInt("user_id"));
                obj.setDocumentName(rs.getString("document_name"));
              String firstname1= rs.getString("first_name");
              String lastname1=  rs.getString("last_name");
              String username=firstname1+""+lastname1;
             obj.setUsername(username);
                obj.setEmail(rs.getString("email"));
                li.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public void updateDocument(int documentId, String documentName) {
        String q = "update master_admin set document_name=? where document_id=?";
        try (Connection conn =DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setString(1, documentName);
            cs.setInt(2, documentId);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUploaded(int uploadId) {
        String q = "delete from upload_admin where upload_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setInt(1, uploadId);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<String> dgetAllEmployeeEmails() {
        List<String> emails = new ArrayList<>();
        String sql = "SELECT email FROM users WHERE role_id=3";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                emails.add(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return emails; 
    }
    
    
    
    public int dgetUserIdByEmail(String email) {
        int userId = -1;
        String sql = "SELECT user_id FROM users WHERE email = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, email);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("user_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId;
    }



        public UploadDetails getDocumentByDocumentId(int uploadId) {
            UploadDetails details = null;
            String sql = "SELECT u.upload_id, u.upload_name, u.upload_file, u.document_id, u.user_id, " +
                         "d.document_name, us.first_name, us.last_name, us.email " +
                         "FROM upload_admin u " +
                         "JOIN master_admin d ON u.document_id = d.document_id " +
                         "JOIN users us ON u.user_id = us.user_id " +
                         "WHERE u.upload_id = ?";

            try (  Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, uploadId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    details = new UploadDetails();
                    details.setUploadId(rs.getInt("upload_id"));
                    details.setUploadName(rs.getString("upload_name"));
                    details.setUploadFile(rs.getString("upload_file"));
                    details.setDocumentId(rs.getInt("document_id"));
                    details.setUserId(rs.getInt("user_id"));
                    details.setDocumentName(rs.getString("document_name"));
                    details.setUsername(rs.getString("first_name") + " " + rs.getString("last_name"));
                    details.setEmail(rs.getString("email"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return details;
        }
    

    
}
