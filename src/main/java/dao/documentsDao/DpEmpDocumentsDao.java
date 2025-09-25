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


public class DpEmpDocumentsDao {

    public void addDocuments(Documents doc) {
        String q = "insert into master_emp(document_name) values(?)";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setString(1, doc.getDocumentName());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  List<Documents> fetechDocName(){
  	  List<Documents> li=new ArrayList();
  	  String q="Select * from master_emp";
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
    
    public void addUploadDocuments(Uploads upload) {
        String q = "insert into upload_emp(upload_name, upload_file, document_id, user_id) values(?,?,?,?)";
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

    public int fetchDocumentId(String documentName) {
        int id = 0;
        String q = "select document_id from master_emp where document_name=?";
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

    public List<UploadDetails> uploadedDetails(String email) {
        String q = "SELECT u.upload_id, u.upload_name, u.upload_file, u.document_id, u.user_id, "
                 + "d.document_name, us.first_name, us.last_name, us.email "
                 + "FROM upload_emp u "
                 + "JOIN master_emp d ON u.document_id = d.document_id "
                 + "JOIN users us ON u.user_id = us.user_id "
                 + "WHERE us.email = ?";

        List<UploadDetails> li = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(q)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UploadDetails obj = new UploadDetails();
                    obj.setUploadId(rs.getInt("upload_id"));
                    obj.setUploadName(rs.getString("upload_name"));
                    obj.setUploadFile(rs.getString("upload_file"));
                    obj.setDocumentId(rs.getInt("document_id"));
                    obj.setUserId(rs.getInt("user_id"));
                    obj.setDocumentName(rs.getString("document_name"));                   
                    String firstname = rs.getString("first_name");
                    String lastname = rs.getString("last_name");
                    obj.setUsername(firstname + " " + lastname);
                    obj.setEmail(rs.getString("email"));

                    li.add(obj);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return li;
    }
    
    
    public List<UploadDetails> uploadedDetails() {
        String q = "SELECT u.upload_id, u.upload_name, u.upload_file, u.document_id, u.user_id, "
                 + "d.document_name, us.first_name, us.last_name, us.email "
                 + "FROM upload_emp u "
                 + "JOIN master_emp d ON u.document_id = d.document_id "
                 + "JOIN users us ON u.user_id = us.user_id ";
          

        List<UploadDetails> li = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(q)) {

      
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UploadDetails obj = new UploadDetails();
                    obj.setUploadId(rs.getInt("upload_id"));
                    obj.setUploadName(rs.getString("upload_name"));
                    obj.setUploadFile(rs.getString("upload_file"));
                    obj.setDocumentId(rs.getInt("document_id"));
                    obj.setUserId(rs.getInt("user_id"));
                    obj.setDocumentName(rs.getString("document_name"));                   
                    String firstname = rs.getString("first_name");
                    String lastname = rs.getString("last_name");
                    obj.setUsername(firstname + " " + lastname);
                    obj.setEmail(rs.getString("email"));

                    li.add(obj);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return li;
    } 
    
    
    
    


    public void updateDocument(int documentId, String documentName) {
        String q = "update master_emp set document_name=? where document_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setString(1, documentName);
            cs.setInt(2, documentId);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void deleteDocName(int id) {
        String q = "delete from master_emp where document_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUploaded(int uploadId) {
        String q = "delete from upload_emp where upload_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setInt(1, uploadId);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getMissingDocumentsForUser(int userId) {
        List<String> missingDocs = new ArrayList<>();
        String q = "SELECT m.document_name "
                 + "FROM master_emp m "
                 + "LEFT JOIN upload_emp u ON m.document_id = u.document_id AND u.user_id = ? "
                 + "WHERE u.upload_id IS NULL";

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement cs = conn.prepareCall(q)) {
            cs.setInt(1, userId);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) missingDocs.add(rs.getString("document_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return missingDocs;
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
                     "FROM upload_emp u " +
                     "JOIN master_emp d ON u.document_id = d.document_id " +
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
