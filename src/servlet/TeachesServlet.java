package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ILoginService;
import service.ITeachesService;
import service.impl.LoginServiceImpl;
import service.impl.TeachesServiceImpl;
import vo.Login;
import vo.Teaches;

public class TeachesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ITeachesService teachesService=new TeachesServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Login login=(Login)request.getSession().getAttribute("USER");
		String method=request.getParameter("type");
		if(method.equals("listcourse")){ 
			Teaches teaches =new Teaches();
			teaches.setID(login.getID());
			List<Teaches> studentList=teachesService.listCourse(teaches);
			String str="";
			if(studentList != null && studentList.size()>0){
				for(int i = 0 ;i<studentList.size();i++){
					str += "<tr>";
					str += "<td>"+studentList.get(i).getCourse().getTitle()+"</td>";
					str += "<td>"+studentList.get(i).getSection().getBuilding()+"</td>";
					str += "<td>"+studentList.get(i).getSection().getRoom_number()+"</td>";
					str += "<td>"+studentList.get(i).getSection().getYear()+"</td>";
					str += "<td>"+studentList.get(i).getSection().getSemester()+"</td>";
					str += "<td>"+studentList.get(i).getCourse().getCredits()+"</td>";
					str += "</tr>";
				}
			}
			request.setAttribute("courseList", str);
			request.getRequestDispatcher("Tmain.jsp").forward(request, response);
		}
		if(method.equals("grademanage")){ 
			Teaches teaches =new Teaches();
			teaches.setID(login.getID());
			List<Teaches> studentList=teachesService.grademanage(teaches);
			Login l=new Login();
			String str="";
			if(studentList != null && studentList.size()>0){
				for(int i = 0 ;i<studentList.size();i++){
					l.setID(studentList.get(i).getTakes().getID());
					ILoginService loginService=new LoginServiceImpl();
					List<Login> sl=loginService.listStudent(l);
					str += "<tr>";
					str += "<td>"+studentList.get(i).getCourse().getTitle()+"</td>";
					str += "<td>"+studentList.get(i).getSection().getYear()+"</td>";
					str += "<td>"+studentList.get(i).getSection().getSemester()+"</td>";
					str += "<td>"+studentList.get(i).getTakes().getID()+"</td>";
//					System.out.println("sql:"+i+studentList.get(i).getTakes().getID());
					str += "<td>"+sl.get(0).getStudent().getName()+"</td>";
//					System.out.println("a"+studentList.get(i).getTakes().getID());	
					str += "<td><input type=\"text\" name=\"grade"+i+"\" value=\""+studentList.get(i).getTakes().getGrade()+"\"></td>";
					str += "</tr>";
					request.setAttribute("ID"+i, studentList.get(i).getTakes().getID());
					request.setAttribute("sec_id"+i, studentList.get(i).getSec_id());
				}
				request.setAttribute("stuSize",new Long(studentList.size()));
			}

			request.setAttribute("studentList", str);
			request.getRequestDispatcher("Tmain.jsp").forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
}
