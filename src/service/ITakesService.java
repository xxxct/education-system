package service;

import java.util.List;

import vo.Takes;

public interface ITakesService {
	public List<Takes> listCourse(Takes takes);
	public void update(Takes takes);
}
