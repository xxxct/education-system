package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ITeachesDAO;
import util.SingleConn;
import vo.Teaches;
import vo.Course;
import vo.Section;

public class TeachesDAOImpl implements ITeachesDAO{

	public void add(Teaches teaches) {
		Connection conn= SingleConn.getConn();
		String sql="INSERT INTO teaches(ID,Course_id,sec_id) VALUES(?,?,?)";
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			pst.setLong(1,teaches.getID());
			pst.setLong(2, teaches.getCourse_id());
			pst.setLong(3, teaches.getSec_id());
			pst.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	public void delete(Teaches teaches) {
		Connection conn= SingleConn.getConn();
		String sql="DELETE FROM teaches WHERE sec_id=?;";
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			pst.setLong(1,teaches.getSec_id());
			pst.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	

	public void update(Teaches teaches) {
		Connection conn= SingleConn.getConn();
		String sql="UPDATE teaches SET ID=?,course_id=? WHERE sec_id=?";
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			pst.setLong(1,teaches.getID());
			pst.setLong(2, teaches.getCourse_id());
			pst.setLong(3, teaches.getSec_id());
			pst.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

	public List<Teaches> list(Teaches teaches) {
		List<Teaches> result=new ArrayList<Teaches>();
		List<Object> params=new ArrayList<Object>();
		Connection conn= SingleConn.getConn();
		String sql="SELECT t.ID tID,t.course_id tcourse_id,t.sec_id tsec_id,c.course_id ccourse_id,c.title ctitle,c.dept_name cdept_name,c.credits ccredits,s.sec_id ssec_id,s.course_id scourse_id,s.semester ssemester,s.year syear,s.building sbuilding,s.room_number sroom_number FROM teaches t,course c,section s WHERE t.course_id=c.course_id and t.sec_id=s.sec_id";
		PreparedStatement pst=null;
		try {
			if(teaches.getID() != null) {
				sql+=" and t.ID=?";
				params.add(teaches.getID());
			}
			if(teaches.getCourse_id() != null) {
				sql+=" and t.course_id=?";
				params.add(teaches.getCourse_id());
			}
			if(teaches.getSec_id() != null) {
				sql+=" and t.sec_id=?";
				params.add(teaches.getSec_id());
			}
			pst=conn.prepareStatement(sql);
			for(int i =0;i<params.size();i++) {
				Object obj=params.get(i);
				if(obj instanceof Long) {
					pst.setLong(i+1, (Long)obj);
				}
				else if(obj instanceof String) {
					pst.setString(i+1, (String)obj);
				}
			}
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Teaches t =new Teaches();
				t.setID(rs.getLong("tID"));
				t.setCourse_id(rs.getLong("tcourse_id"));
				t.setSec_id(rs.getLong("tsec_id"));
				Course course=new Course();
				course.setCourse_id(rs.getLong("ccourse_id"));
				course.setTitle(rs.getString("ctitle"));
				course.setDept_name(rs.getString("cdept_name"));
				course.setCredits(rs.getLong("ccredits"));
				t.setCourse(course);
				Section section = new Section();
				section.setSec_id(rs.getLong("ssec_id"));
				section.setCourse_id(rs.getLong("scourse_id"));
				section.setYear(rs.getLong("syear"));
				section.setSemester(rs.getLong("ssemester"));
				section.setBuilding(rs.getString("sbuilding"));
				section.setRoom_number(rs.getString("sroom_number"));
				t.setSection(section);
				result.add(t);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public List<Teaches> select(Teaches teaches) {
		// TODO Auto-generated method stub
		Connection conn=SingleConn.getConn();
		String sql="SELECT * FROM teaches WHERE 1=1 ";
		List<Teaches> result=new ArrayList<Teaches>();
		List<Object> params=new ArrayList<Object>();
		PreparedStatement pst=null;
		try {
			if(teaches.getID() != null){
				sql+=" and id=? ";
				params.add(teaches.getID());
			}
			if(teaches.getCourse_id() != null){
				sql+=" and Course_id=? ";
				params.add(teaches.getCourse_id());
			}
			if(teaches.getSec_id() != null){
				sql+=" and Sec_id=? ";
				params.add(teaches.getSec_id());
			}
			pst=conn.prepareStatement(sql);
			for(int i=0;i<params.size();i++){
				Object obj=params.get(i);
				if(obj instanceof Long){
					pst.setLong(i+1,(Long)obj);
				}
					
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				
				Teaches s=new Teaches();
				s.setID(rs.getLong("id"));
				s.setCourse_id(rs.getLong("Course_Id"));
				s.setSec_id(rs.getLong("Sec_Id"));
				result.add(s); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
}
//	public List<Teaches> select(Teaches teaches) {
//		List<Teaches> result=new ArrayList<Teaches>();
//		List<Object> params=new ArrayList<Object>();
//		Connection conn= SingleConn.getConn();
//		String sql="SELECT * FROM teaches WHERE 1=1";
//		PreparedStatement pst=null;
//		try {
//			if(teaches.getID() != null) {
//				sql+=" and ID=?";
//				params.add(teaches.getID());
//			}
//			if(teaches.getCourse_id() != null) {
//				sql+=" and course_id=?";
//				params.add(teaches.getCourse_id());
//			}
//			if(teaches.getSec_id() != null) {
//				sql+=" and sec_id=?";
//				params.add(teaches.getSec_id());
//			}
//			pst=conn.prepareStatement(sql);
//			for(int i =0;i<params.size();i++) {
//				Object obj=params.get(i);
//				if(obj instanceof Long) {
//					pst.setLong(i+1, (Long)obj);
//				}
//				else if(obj instanceof String) {
//					pst.setString(i+1, (String)obj);
//				}
//			}
//			ResultSet rs = pst.executeQuery();
//			while(rs.next()) {
//				Teaches s =new Teaches();
//				s.setID(rs.getLong("ID"));
//				s.setCourse_id(rs.getLong("course_id"));
//				s.setSec_id(rs.getLong("sec_id"));
//				result.add(s);
//			}
//		} 
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		finally {
//			if(pst!=null) {
//				try {
//					pst.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
}
