package service.nexusService;

import java.util.List;
import dao.nexusDao.JTerminationDAO;
import model.JTermination;

public class JTerminationService {

    private JTerminationDAO dao = new JTerminationDAO();

    public List<JTermination> fetchAll() {
        return dao.fetchAll();
    }

    public void save(JTermination t) {
        dao.save(t);
    }

    public void update(JTermination t) {
        dao.update(t);
    }

    public void delete(int termination_id) {
        dao.delete(termination_id);
    }

    public JTermination fetchById(int termination_id) {
        return dao.fetchById(termination_id);
    }
}
