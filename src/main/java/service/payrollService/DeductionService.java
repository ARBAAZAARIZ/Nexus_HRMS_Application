package service.payrollService;

import java.sql.SQLException;
import java.util.List;
import dao.payrollDAO.DeductionDAO;
import helper.payrollHelper.DeductionHelper;
import helper.payrollHelper.EarningHelper;
import model.Deduction;
import model.DeductionType;

public class DeductionService {

    DeductionDAO dao = new DeductionDAO();

 
    public int addDeductionType(DeductionType dt) throws SQLException {
        return dao.insertDeductionType(dt);
    }

    public List<DeductionType> listDeductionTypes() throws SQLException {
        return dao.getDeductionTypes();
    }

    public boolean updateDeductionType(DeductionType dt) throws SQLException {
        return dao.updateDeductionType(dt);
    }

    public boolean deleteDeductionType(int id) throws SQLException {
        return dao.deleteDeductionType(id);
    }

   
    public int addDeduction(Deduction d) throws SQLException {
        return dao.insertDeduction(d);
    }

    public List<Deduction> listDeductions() throws SQLException {
        return dao.getDeductions();
    }

    public boolean updateDeduction(Deduction d) throws SQLException {
        return dao.updateDeduction(d);
    }

    public boolean deleteDeduction(int id) throws SQLException {
        return dao.deleteDeduction(id);
    }
    
    public List<DeductionHelper> fetchDeductions() throws SQLException {
        return dao.getAllDeductions();
    }
    
    public List<DeductionHelper> getByDesignation(int designationId) throws SQLException {
    	return dao.getByDesignation(designationId);
    }

	public List<DeductionHelper> getDeductionsByDepartmentAndDesignation(int departmentId, int designationId) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getDeductionsByDepartmentAndDesignation(departmentId, designationId);
	}
    
}
