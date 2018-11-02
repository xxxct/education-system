package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ILoginDAO;
import util.SingleConn;
import vo.Course;
import vo.Instructor;
import vo.Login;
import vo.Section;
import vo.Student;
import vo.Login;

public class LoginDAOImpl implements ILoginDAO{

	public List<Login> select(Login login) {
		// TODO Auto-generated method stub
		Connection conn=SingleConn.getConn();
		String sql="SELECT * FROM login WHERE 1=1 ";
		List<Login> result=new ArrayList<Login>();
		List<Object> params=new ArrayList<Object>();
		PreparedStatement pst=null;
		try {
			
			if(login.getID() != null){
				sql+=" and ID=? ";
				params.add(login.getID());
			}
			if(login.getPassword() != null){
				sql+=" and password=? ";
				params.add(login.getPassword());
			}
			if(login.getType() != null){
				sql+=" and type=? ";
				params.add(login.getType());
			}
			pst=conn.prepareStatement(sql);
			for(int i=0;i<params.size();i++){
				Object obj=params.get(i);
				if(obj instanceof String){
					pst.setString(i+1,(String)obj);
				}
				else if(obj instanceof Long){
					pst.setLong(i+1,(Long)obj);
				}
					
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				
				Login s=new Login();
				s.setID(rs.getLong("ID"));
				s.setType(rs.getString("type"));
				s.setPassword(rs.getString("password"));
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

	public List<Login> studentSelect(Login login) {

		List<Login> result=new ArrayList<Login>();
		List<Object> params=new ArrayList<Object>();
		Connection conn= SingleConn.getConn();
		String sql="SELECT l.ID lID,l.password lpassword,l.type ltype,s.ID sID,s.name sname,s.dept_name sdept_name,s.tot_cret stot_cret FROM login l,student s WHERE l.ID=s.ID";
		PreparedStatement pst=null;
		try {
			if(login.getID() != null) {
				sql+=" and l.ID=?";
				params.add(login.getID());
			}
			if(login.getPassword() != null) {
				sql+=" and l.password=?";
				params.add(login.getPassword());
			}
			if(login.getType() != null) {
				sql+=" and l.type=?";
				params.add(login.getType());
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
				Login l =new Login();
				l.setID(rs.getLong("lID"));
				l.setPassword(rs.getString("lpassword"));
				l.setType(rs.getString("ltype"));
				Student student=new Student();
				student.setID(rs.getLong("sID"));
				student.setTot_cret(rs.getLong("stot_cret"));
				student.setDept_name(rs.getString("sdept_name"));
				student.setName(rs.getString("sname"));
				l.setStudent(student);
				result.add(l);
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
	public List<Login> teacherSelect(Login login) {

		List<Login> result=new ArrayList<Login>();
		List<Object> params=new ArrayList<Object>();
		Connection conn= SingleConn.getConn();
		String sql="SELECT l.ID lID,l.password lpassword,l.type ltype,i.ID iID,i.name iname,i.dept_name idept_name,i.salary isalary FROM login l,instructor i WHERE l.ID=i.ID";
		PreparedStatement pst=null;
		try {
			if(login.getID() != null) {
				sql+=" and l.ID=?";
				params.add(login.getID());
			}
			if(login.getPassword() != null) {
				sql+=" and l.password=?";
				params.add(login.getPassword());
			}
			if(login.getType() != null) {
				sql+=" and l.type=?";
				params.add(login.getType());
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
				Login l =new Login();
				l.setID(rs.getLong("lID"));
				l.setPassword(rs.getString("lpassword"));
				l.setType(rs.getString("ltype"));
				Instructor instructor=new Instructor();
				instructor.setID(rs.getLong("iID"));
				instructor.setSalary(rs.getLong("isalary"));
				instructor.setDept_name(rs.getString("idept_name"));
				instructor.setName(rs.getString("iname"));
				l.setInstructor(instructor);
				result.add(l);
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
}
