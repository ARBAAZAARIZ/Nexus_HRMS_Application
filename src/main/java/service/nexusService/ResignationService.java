package service.nexusService;

import java.util.List;
import dao.nexusDao.ResignationDAO;
import model.Resignation;

public class ResignationService {
    private ResignationDAO dao = new ResignationDAO();

    public void save(Resignation r) {
        dao.save(r);
    }

    public List<Resignation> fetchAll() {
        return dao.fetchAll();
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public void update(Resignation r) {
        dao.update(r);
    }

    public Resignation findById(int id) {
        return dao.findById(id);
    }
}
