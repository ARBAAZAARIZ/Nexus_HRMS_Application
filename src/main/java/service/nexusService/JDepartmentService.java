package service.nexusService;

import java.util.List;
import dao.nexusDao.JDepartmentDAO;
import model.JDepartmentModel;

public class JDepartmentService {
    private JDepartmentDAO dao = new JDepartmentDAO();

    public List<JDepartmentModel> fetchDepartments() {
        return dao.fetchAll();
    }
}
