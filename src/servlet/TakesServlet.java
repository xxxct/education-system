package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.ITakesService;
import service.impl.TakesServiceImpl;
import vo.Login;
import vo.Takes;

public class TakesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ITakesService takesService=new TakesServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Login login=(Login)request.getSession().getAttribute("USER");
		String method=request.getParameter("type");
		if(method.equals("listcourse")){ 
			Takes takes =new Takes();
			takes.setID(login.getID());
			List<Takes> courseList=takesService.listCourse(takes);
			String str="";
			if(courseList != null && courseList.size()>0){
				for(int i = 0 ;i<courseList.size();i++){
					str += "<tr>";
					str += "<td>"+courseList.get(i).getCourse().getTitle()+"</td>";
					str += "<td>"+courseList.get(i).getSection().getT_name()+"</td>";
					str += "<td>"+courseList.get(i).getSection().getBuilding()+"</td>";
					str += "<td>"+courseList.get(i).getSection().getRoom_number()+"</td>";
					str += "<td>"+courseList.get(i).getSection().getYear()+"</td>";
					str += "<td>"+courseList.get(i).getSection().getSemester()+"</td>";
					str += "<td>"+courseList.get(i).getCourse().getCredits()+"</td>";
					str += "</tr>";
				}
			}
			request.setAttribute("courseList", str);
			request.getRequestDispatcher("Smain.jsp").forward(request, response);
		}
		if(method.equals("grademanage")){ 
			Takes takes =new Takes();
			takes.setID(login.getID());
			List<Takes> courseList=takesService.listCourse(takes);
			String str="";
			if(courseList != null && courseList.size()>0){
				for(int i = 0 ;i<courseList.size();i++){
					str += "<tr>";
					str += "<td>"+courseList.get(i).getCourse().getTitle()+"</td>";
					str += "<td>"+courseList.get(i).getSection().getYear()+"</td>";
					str += "<td>"+courseList.get(i).getSection().getSemester()+"</td>";
					str += "<td>"+courseList.get(i).getCourse().getCredits()+"</td>";
					str += "<td>"+courseList.get(i).getGrade()+"</td>";
					str += "</tr>";
				}
			}
			request.setAttribute("gradeList", str);
			request.getRequestDispatcher("Smain.jsp").forward(request, response);
		}
		if(method.equals("gradeUpdate")){ 
			Takes takes =new Takes();
			Long size=new Long(request.getParameter("stuSize"));
			System.out.println("size:"+size);
			for(int i = 0 ;i<size;i++){
				takes.setID(new Long(request.getParameter("ID"+i)));
				takes.setSec_id(new Long(request.getParameter("sec_id"+i)));
				takes.setGrade(new Long(request.getParameter("grade"+i)));
				takesService.update(takes);				
			}
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher("TeachesServlet?type=grademanage").forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
}
