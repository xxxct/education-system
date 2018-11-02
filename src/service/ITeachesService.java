package service;

import java.util.List;

import vo.Teaches;

public interface ITeachesService {
	public List<Teaches> listCourse(Teaches teaches);
	public List<Teaches> grademanage(Teaches teaches);
}
