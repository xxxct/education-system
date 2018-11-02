package dao;

import java.util.List;

import vo.Teaches;

public interface ITeachesDAO {
	public void add(Teaches teaches);
	public void delete(Teaches teaches) ;
	public void update(Teaches teaches) ;
	public List<Teaches> list(Teaches teaches) ;
	public List<Teaches> select(Teaches teaches);
}
