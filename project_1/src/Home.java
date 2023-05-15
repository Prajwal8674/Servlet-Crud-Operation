

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project_1.dbHelper;
import project_1.pojoOne;


@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js'></script>");
		out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
		
		
		
		
		dbHelper db = new dbHelper(); 
		
		try {
			ArrayList<pojoOne> p = db.getAllUser(); 
			
			
			
			out.print("<table class='table'>");
			out.print("<thead>");
//			out.print("<tr>");
//			out.print("<th>U ID</th>");
			out.print("<th>UserName</th>");
			out.print("<th>Password</th>");
			out.print("<th>Email</th>");
			out.print("<th>Action</th>");
			out.print("</tr>");
			out.print("</thead>");
			out.print("<tbody>");

			
			for(pojoOne p1 :p)
			{
				out.print("<tr>");
//						out.print("<td>"+p1.getUid()+"</td>");
						out.print("<td>"+p1.getUname()+"</td>");
						out.print("<td>"+p1.getUpass()+"</td>");
						out.print("<td>"+p1.getUemail()+"</td>");
		                out.print("</tr>");
			
			}
							
			out.print("</tbody>");
			out.print("</table>");
		}
			catch(Exception e){
				e.printStackTrace();
			}
			
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
