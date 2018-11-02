package service;

import java.util.List;

import vo.Login;

public interface ILoginService {
	public Login login(Login login);
	public List<Login> listStudent(Login login);
	public List<Login> listTeacher(Login login);
}
