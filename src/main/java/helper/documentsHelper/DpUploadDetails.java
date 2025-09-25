package helper.documentsHelper;

import model.documents.*;

public class DpUploadDetails {
	public static String uploadDetailsToString(UploadDetails details) {
        if(details == null)
        	{
        	return "UploadDetails is null";
        	}

        return "UploadDetails [uploadId=" + details.getUploadId() 
                + ", uploadName=" + details.getUploadName() 
                + ", uploadFile=" + details.getUploadFile() 
                + ", documentId=" + details.getDocumentId() 
                + ", userId=" + details.getUserId() 
                + ", documentName=" + details.getDocumentName() 
                + ", userFirstName=" + details.getUsername() 
               
                + ", email=" + details.getEmail() + "]";
        
        
        //to invoke
//        List<UploadDetails> list = DpEmployeeDocumentsService.uploadedDetails();
//        for (UploadDetails ud : list) {
//            System.out.println(DpUploadDetails.uploadDetailsToString(ud));
//        }

    }
}
