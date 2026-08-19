

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Control in first Servlet");
		
		response.setContentType("text/html");
		
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
		HttpSession session = request.getSession();		
		
		session.setAttribute("name", name);
		
		RequestDispatcher reqDispatch = request.getRequestDispatcher("/SecondServlet");
		
		reqDispatch.forward(request, response);
		
//		reqDispatch.include(request, response);
		
		response.getWriter();
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1> Response from servlet one </h1>");
		System.out.println("Control again in first servlet");
		writer.close();
	}

}
