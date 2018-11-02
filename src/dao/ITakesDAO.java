package dao;

import java.util.List;

import vo.Takes;

public interface ITakesDAO {
	public void add(Takes takes);
	public void delete(Takes takes);
	public List<Takes> select(Takes takes);
	public List<Takes> list(Takes takes);
	public void update(Takes takes);
}
