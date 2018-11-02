package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import service.ILoginService;
import service.impl.LoginServiceImpl;
import vo.Login;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILoginService loginService=new LoginServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String method=request.getParameter("label");
		if(method.equals("login")) {
			Long ID=new Long(request.getParameter("ID"));
			String password=request.getParameter("password");
			String type=request.getParameter("type");
			Login login=new Login();
			login.setID(ID);
			login.setPassword(password);
			login.setType(type);
			Login result=loginService.login(login);
			if(result!=null){
				request.getSession().setAttribute("USER", result);
				if(type.equals("S"))
					request.getRequestDispatcher("Smain.jsp").forward(request, response);
				if(type.equals("T"))
					request.getRequestDispatcher("Tmain.jsp").forward(request, response);
			}else {
			
				request.setAttribute("error", "E");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}	
		}
		if(method.equals("listStudent")) {
			Login login =(Login)request.getSession().getAttribute("USER");
			List<Login> studentList=loginService.listStudent(login);
			String str="";
			if(studentList != null && studentList.size()>0){
				for(int i = 0 ;i<studentList.size();i++){
					str += "<tr>";
					str += "<td>"+studentList.get(i).getID()+"</td>";
					str += "<td>"+studentList.get(i).getStudent().getName()+"</td>";
					str += "<td>"+studentList.get(i).getStudent().getDept_name()+"</td>";
					str += "</tr>";
				}
			}
			request.setAttribute("studentList", str);
			request.getRequestDispatcher("Smain.jsp").forward(request, response);
		}
		if(method.equals("listTeacher")) {
			Login login =(Login)request.getSession().getAttribute("USER");
			List<Login> teacherList=loginService.listTeacher(login);
			String str="";
			if(teacherList != null && teacherList.size()>0){
				for(int i = 0 ;i<teacherList.size();i++){
					str += "<tr>";
					str += "<td>"+teacherList.get(i).getID()+"</td>";
					str += "<td>"+teacherList.get(i).getInstructor().getName()+"</td>";
					str += "<td>"+teacherList.get(i).getInstructor().getDept_name()+"</td>";
					str += "<td>"+teacherList.get(i).getInstructor().getSalary()+"</td>";
					str += "</tr>";
				}
			}
			request.setAttribute("teacherList", str);
			request.getRequestDispatcher("Tmain.jsp").forward(request, response);
		}
		if(method.equals("logout")) {
			
				request.getSession().invalidate();
				request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
}
