package services.DocumentsService;

import java.util.List;
import dao.documentsDao.*;
import model.documents.*;

public class DpAdminDocumentsService {

    private DpAdminDocumentsDao dao = new DpAdminDocumentsDao();

    public void addDocuments(Documents doc) {
        dao.addDocuments(doc);
    }
    
    public List<Documents> fetchAdminDoc() {
   	 return dao.fetechDocName();
   }
    public void addUploadDocuments(Uploads upload) {
        dao.addUploadDocuments(upload);
    }
    
    public int dgetUserIdByEmail(String email) {
        return dao.dgetUserIdByEmail(email);
    }

    public int dfetchDocumentId(String documentName) {
        return dao.fetchDocumentId(documentName);
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
    
    public UploadDetails getUploadDetailsByUploadId(int uploadId) {
     
       return  dao.getDocumentByDocumentId(uploadId);
       
    }
    
    public List<String> dfetchAllEmployeeEmails() {
        return dao.dgetAllEmployeeEmails();
    }

	public void deleteDoc(int documentId) {
		dao.deleteDocName(documentId);
		
	}
}
