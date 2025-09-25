package service.nexusService;

import dao.nexusDao.*;
import model.JDesignation;

import java.util.List;

public class JDesignationService {
    private JDesignationDAO dao = new JDesignationDAO();

    public List<JDesignation> fetchDesignations() {
        return dao.fetchAll();
    }
}
