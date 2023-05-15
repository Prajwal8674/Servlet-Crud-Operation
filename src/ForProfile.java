

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project_1.dbHelper;



@WebServlet("/ForProfile")
public class ForProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter  out  = response.getWriter();
		
        String checkeMail = request.getParameter("email");
        String checkepass = request.getParameter("password");
        
        dbHelper db = new dbHelper();
        try {
			if(db.checkForLogin(checkeMail, checkepass)){
//		        request.getRequestDispatcher("profile.html").include(request, response);
				response.sendRedirect("Home");

				System.out.println("ahyeahhh");
				
			}
			else{
		        request.getRequestDispatcher("login.html").include(request, response);	
		        out.print("Username Or Password Didn't Match!");
				System.out.println("naah buddy");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
   
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
