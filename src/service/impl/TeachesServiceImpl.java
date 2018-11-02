package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.ITakesDAO;
import dao.ITeachesDAO;
import dao.impl.TakesDAOImpl;
import dao.impl.TeachesDAOImpl;
import service.ITeachesService;
import vo.Takes;
import vo.Teaches;

public class TeachesServiceImpl implements ITeachesService{
	private ITeachesDAO teachesDAO=new TeachesDAOImpl();
	public List<Teaches> listCourse(Teaches teaches) {
		return teachesDAO.list(teaches);
	}
	public List<Teaches> grademanage(Teaches teaches) {
		// TODO Auto-generated method stub
		ITeachesDAO teachesDAO=new TeachesDAOImpl();
		ITakesDAO takesDAO=new TakesDAOImpl();
		List<Teaches> tlist=teachesDAO.list(teaches);
		List<Takes> slist=new ArrayList<Takes>();
		int a=0;
		List<Teaches> stulist=new ArrayList<Teaches>();
		if(tlist!=null&&tlist.size()>0){


			for(int i=0;i<tlist.size();i++){
				Takes takes=new Takes();
				Teaches teaches1=tlist.get(i);
				takes.setSec_id(tlist.get(i).getSec_id());
				slist=takesDAO.select(takes);
				for(int j=0;j<slist.size();j++){
					Teaches teaches2=new Teaches();
					teaches2.setTeaches(teaches1);
					teaches2.setTakes(slist.get(j));//把根据sec_id查到的所有takes放入Teaches对象
					stulist.add(teaches2);					
				}
			}
		}	
		return stulist;
	}

	
}
