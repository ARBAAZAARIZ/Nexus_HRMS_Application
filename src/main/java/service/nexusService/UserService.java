package service.nexusService;

import java.util.List;

import dao.nexusDao.UserDAO;
import model.Users;


public class UserService {


	UserDAO dao=new UserDAO();
	
	public void saveUsers(Users u)
	{
		dao.saveUser(u);
	}
	
	public List<Users> fetchUsers()
	{
		return dao.fetchUser();
	}
	public void delUsers(int id)
	{
		dao.deleteuser(id);;
	}
	
	public Users findById(int id)
	{
		return dao.findById(id);
	}
	
	public void UpdateUsers(Users user)
	{
		dao.updateUsers(user);
	}


}
