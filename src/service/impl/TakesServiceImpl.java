package service.impl;

import java.util.List;

import dao.ITakesDAO;
import dao.impl.TakesDAOImpl;
import service.ITakesService;
import vo.Takes;

public class TakesServiceImpl implements ITakesService{
	private ITakesDAO takesDAO=new TakesDAOImpl();

	public List<Takes> listCourse(Takes takes) {
		return takesDAO.list(takes);
	}
	public void update(Takes takes) {
		takesDAO.update(takes);
	}

}
