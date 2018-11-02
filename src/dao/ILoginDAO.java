package dao;

import java.util.List;

import vo.Login;

public interface ILoginDAO {
	public List<Login> select(Login login);
	public List<Login> studentSelect(Login login);
	public List<Login> teacherSelect(Login login);	
}
