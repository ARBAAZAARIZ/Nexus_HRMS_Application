package services.DocumentsService;

import java.util.List;
import dao.documentsDao.*;
import model.documents.*;

public class DpEmployeeDocumentsService {

    private DpEmpDocumentsDao dao = new DpEmpDocumentsDao();

    public void addDocuments(Documents doc) {
        dao.addDocuments(doc);
    }

    public void addUploadDocuments(Uploads upload) {
        dao.addUploadDocuments(upload);
    }

    public List<Documents> fetchEmpDoc() {
      	 return dao.fetechDocName();
      }
//    
//    public List<Documents> fetchEmpDetails() {
//    	 return dao.fetechDocName();
//    }
    
    public int dgetUserIdByEmail(String email) {
        return dao.dgetUserIdByEmail(email);
    }


    public int dfetchDocumentId(String documentName) {
        return dao.fetchDocumentId(documentName);
    }
    public int fetchDocumentId(String documentName) {
        return dao.fetchDocumentId(documentName);
    }

    public List<UploadDetails> uploadedDetails(String email) {
        return dao.uploadedDetails(email);
    }

    public List<UploadDetails> uploadedDetails() {
        return dao.uploadedDetails();
    }
    
    public void updateDocument(int documentId, String documentName) {
        dao.updateDocument(documentId, documentName);
    }

    public void deleteUploaded(int uploadId) {
        dao.deleteUploaded(uploadId);
    }
    
    public void deleteDoc(int id) {
        dao.deleteDocName(id);
    }

    public List<String> getMissingDocumentsForUser(int userId) {
        return dao.getMissingDocumentsForUser(userId);
    }
    
    public UploadDetails getUploadDetailsByUploadId(int uploadId) {
        
        return  dao.getDocumentByDocumentId(uploadId);
        
     } 
    
}
