package service.impl;

import java.util.List;


import dao.ILoginDAO;
import dao.impl.LoginDAOImpl;
import service.ILoginService;
import vo.Login;

public class LoginServiceImpl implements ILoginService{

	private ILoginDAO loginDAO = new LoginDAOImpl();
	public Login login(Login login) {
		List<Login> list =loginDAO.select(login);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	public List<Login> listStudent(Login login) {
		return loginDAO.studentSelect(login);
	}
	public List<Login> listTeacher(Login login) {
		return loginDAO.teacherSelect(login);
	}
}
