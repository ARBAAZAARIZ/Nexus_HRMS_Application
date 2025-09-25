package service.payrollService;

import java.sql.SQLException;
import java.util.List;
import dao.payrollDAO.EarningDAO;
import helper.payrollHelper.EarningHelper;
import model.Earning;
import model.EarningType;

public class EarningService {

    EarningDAO dao = new EarningDAO();

    
    public int addEarningType(EarningType et) throws SQLException {
        return dao.insertEarningType(et);
    }

    public List<EarningType> listEarningTypes() throws SQLException {
        return dao.getEarningTypes();
    }

    public boolean updateEarningType(EarningType et) throws SQLException {
        return dao.updateEarningType(et);
    }

    public boolean deleteEarningType(int id) throws SQLException {
        return dao.deleteEarningType(id);
    }

    
    public int addEarning(Earning e) throws SQLException {
        return dao.insertEarning(e);
    }

    public List<EarningHelper> listEarnings() throws SQLException {
        return dao.getAllEarnings();
    }

    public boolean updateEarning(Earning e) throws SQLException {
        return dao.updateEarning(e);
    }
    

    public boolean deleteEarning(int id) throws SQLException {
        return dao.deleteEarning(id);
    }
    
    public List<EarningHelper> fetchEarnings() throws SQLException {
        return dao.getAllEarnings();
    }
    
    public List<EarningHelper> getByDesignation(int designationId) throws SQLException {
    	return dao.getByDesignation(designationId);
    }

	public List<EarningHelper> getEarningsByDepartmentAndDesignation(int departmentId, int designationId) throws SQLException {
		
		return dao.getEarningsByDepartmentAndDesignation(departmentId, designationId);
	}

	
}
