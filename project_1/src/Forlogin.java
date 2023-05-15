
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project_1.dbHelper;
import project_1.pojoOne;

@WebServlet("/Forlogin")
public class Forlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	    String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String upass = request.getParameter("upass");
		String cupass = request.getParameter("cupass");
		 String term = request.getParameter("term");
		uname.trim();
		uemail.trim(); 
		upass.trim();
		cupass.trim();
	    term.trim();
		dbHelper db = new dbHelper();
		  pojoOne p = new pojoOne(uname, uemail, upass);

	

			try {
				if (!db.checkUser(uemail)) {
					
					  if (upass.equals(cupass)) {
						  
//						  if(term.equals("on")){
						  
						    db.add(p); 
					        System.out.println("Added Successfullly !!");
					        out.print("Registeration successful !! please login");
					        request.getRequestDispatcher("login.html").include(request, response);	
//						  }
//						  else if(!term.equals("on")){
//							  
//						  }
					  } 
					  else if (!upass.equals(cupass))

						{
							request.getRequestDispatcher("index.html").include(request, response);
							out.print("Enter Both Passwords Same !");
						}
						        

				}
				else if (db.checkUser(uemail)){
	            	out.print("YOUR EMAIL IS ALREADY EXIST PLEASE LOGIN !!");
			        request.getRequestDispatcher("login.html").include(request, response);			        
			     }				
			    
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}