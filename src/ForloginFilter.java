
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import project_1.dbHelper;
import project_1.pojoOne;

@WebFilter("/ForloginFilter")
public class ForloginFilter implements Filter {

	public ForloginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String upass = request.getParameter("upass");
		String cupass = request.getParameter("cupass");
		// String term = request.getParameter("term");

		dbHelper db = new dbHelper();
		if (upass.equals(cupass)) {

			request.getRequestDispatcher("login.html").include(request, response);

			pojoOne p = new pojoOne(uname, uemail, upass);
			try {
				db.add(p);
				System.out.println("Added Successfullly !!");

			} catch (Exception e) {
				e.printStackTrace();

			}

		} else if (!upass.equals(cupass)) {
			request.getRequestDispatcher("index.html").include(request, response);
			out.print("Enter Password Correctly !");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
