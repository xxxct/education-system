package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ITakesDAO;
import util.SingleConn;
import vo.Course;
import vo.Section;
import vo.Takes;


public class TakesDAOImpl implements ITakesDAO {
	/*public static void main(String args[]){
		Takes t = new Takes();
		long i = Long.parseLong("301");
		t.setID(i);
	
		t.setSec_id(i);
		ITakesDAO q = new TakesDAOImpl();
		List<Takes> L =  q.list(t);
		List<Takes> L =  q.select(t);
		if(L!=null && L.size()>0){
			
			for(Takes c : L){
				System.out.println(c.getGrade());
				System.out.println(c.getS().getBuilding());
				System.out.println(c.getC().getDept_name());
				System.out.println(c.getGrade());
				System.out.println(c.getSemester());
				System.out.println(c.getYear());
				
			}
		}
		else System.out.print("aaa");
	
		
	}*/
	 
	public void add(Takes takes) {
		Connection conn=SingleConn.getConn();
		String sql="insert into takes(ID,course_id,sec_id,grade) values(?,?,?,?)";
		PreparedStatement pst=null;
		try{
			pst=conn.prepareStatement(sql);
			pst.setLong(1,takes.getID());
			pst.setLong(2,takes.getCourse_id());
			pst.setLong(3,takes.getSec_id());
			pst.setLong(6,takes.getGrade());
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pst!=null)
				try{
					pst.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			
			
		}
		
	}

	 
	public void delete(Takes takes) {
		// TODO Auto-generated method stub
		Connection conn=SingleConn.getConn();
		String sql="delete from takes where ID = ?";
		PreparedStatement pst=null;
		try{
			pst=conn.prepareStatement(sql);
			pst.setLong(1,takes.getID());
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pst!=null)
				try{
					pst.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			
			
		}
		
	}
		
	

	
	public void update(Takes takes) {
		// TODO Auto-generated method stub
		Connection conn=SingleConn.getConn();
		String sql="update takes set grade=? where ID=? and sec_id=?";
		PreparedStatement pst=null;
		try{
			pst=conn.prepareStatement(sql);
			pst.setLong(1,takes.getGrade());
			pst.setLong(2,takes.getID());
			pst.setLong(3,takes.getSec_id());
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pst!=null)
				try{
					pst.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			
			
		}
		
	}
	

	
	public List<Takes> select(Takes takes) {
		// TODO Auto-generated method stub
		List<Takes> result = new ArrayList<Takes>();
		List<Object> params=new ArrayList<Object>();
		Connection conn=SingleConn.getConn();
		String sql="select * from takes where 1=1 ";
		PreparedStatement pst=null;
		if(takes.getID()!=null){
			sql+="and ID=? ";
			params.add(takes.getID());
		}
		if(takes.getCourse_id()!=null){
			sql+="and course_id=? ";
			params.add(takes.getCourse_id());
		}
		if(takes.getSec_id()!=null){
			sql+="and Sec_id=? ";
			params.add(takes.getSec_id());
		}
		if(takes.getGrade()!=null){
			sql+="and grade ";	
			params.add(takes.getGrade());
		}

		
		try{
			pst=conn.prepareStatement(sql);
			for(int i=0;i<params.size();i++){
				Object obj=params.get(i);
				if(obj instanceof String){
					pst.setString(i+1,(String) obj);
				}
				else if(obj instanceof Long){
					pst.setLong(i+1,(Long) obj);
				}
				else if(obj instanceof Double){
					pst.setDouble(i+1,(Double)obj);
				}
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Takes c=new Takes();
				c.setCourse_id(rs.getLong("course_id"));
				c.setID(rs.getLong("ID"));
				c.setSec_id(rs.getLong("sec_id"));
				c.setGrade(rs.getLong("grade"));
				result.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pst!=null)
				try{
					pst.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			
			
		}
		
	
		return result;
	}
	
	
	public List<Takes> list(Takes takes) {
		// TODO Auto-generated method stub
		List<Takes> result = new ArrayList<Takes>();
		List<Object> params=new ArrayList<Object>();
		Connection conn=SingleConn.getConn();
		String sql="SELECT t.grade tgrade,t.ID tID,t.course_id tcourse_id,t.sec_id tsec_id,c.course_id ccourse_id,c.title ctitle,c.dept_name cdept_name,c.credits ccredits,s.sec_id ssec_id,s.course_id scourse_id,s.semester ssemester,s.year syear,s.building sbuilding,s.room_number sroom_number,s.t_name st_name FROM takes t,course c,section s WHERE t.course_id=c.course_id and t.sec_id=s.sec_id ";
		PreparedStatement pst=null;
		if(takes.getID()!=null){
			sql+="and t.id=? ";
			params.add(takes.getID());
		}
		if(takes.getCourse_id()!=null){
			sql+="and t.course_id=? ";
			params.add(takes.getCourse_id());
		}
		if(takes.getSec_id()!=null){
			sql+="and t.ID=? ";
			params.add(takes.getSec_id());
		}
		if(takes.getGrade()!=null){
			sql+="and t.grade=? ";	
			params.add(takes.getGrade());
		}
		try{
			pst=conn.prepareStatement(sql);
			for(int i=0;i<params.size();i++){
				Object obj=params.get(i);
				if(obj instanceof String){
					pst.setString(i+1,(String) obj);
				}
				else if(obj instanceof Long){
					pst.setLong(i+1,(Long) obj);
				}
				else if(obj instanceof Double){
					pst.setDouble(i+1,(Double)obj);
				}
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Takes t=new Takes();
				t.setCourse_id(rs.getLong("tcourse_id"));
				t.setID(rs.getLong("tID"));
				t.setSec_id(rs.getLong("tsec_id"));
				t.setGrade(rs.getLong("tgrade"));
				Course c = new Course();
				c.setCourse_id(rs.getLong("ccourse_id"));
				c.setTitle(rs.getString("ctitle"));
				c.setDept_name(rs.getString("cdept_name"));
				c.setCredits(rs.getLong("ccredits"));
				Section s = new Section();
				s.setSec_id(rs.getLong("ssec_id"));
				s.setCourse_id(rs.getLong("scourse_id"));
				s.setSemester(rs.getLong("ssemester"));
				s.setYear(rs.getLong("syear"));
				s.setBuilding(rs.getString("sbuilding"));
				s.setRoom_number(rs.getString("sroom_number"));
				s.setT_name(rs.getString("st_name"));
				t.setSection(s);
				t.setCourse(c);
				result.add(t);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pst!=null)
				try{
					pst.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			
			
		}
		
	
		return result;
	}


	
	

}