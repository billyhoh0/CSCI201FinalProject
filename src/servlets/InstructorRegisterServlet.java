package servlets;

import classes.UserManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InstructorRegisterServlet
 */
@WebServlet("/InstructorRegisterServlet")
public class InstructorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get username and password from form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String confirmpw = request.getParameter("confirmpw");

		if(confirmpw.trim().equals(password.trim())){
			if(UserManager.register(username,password,first_name,last_name,2)){
				session.setAttribute("username",username);
				session.setAttribute("password",password);
				session.setAttribute("first_name",first_name);
				RequestDispatcher rd = request.getRequestDispatcher("/Student.jsp");
				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/StudentRegister.jsp");
				rd.forward(request, response);
			}
		}
	}
}
