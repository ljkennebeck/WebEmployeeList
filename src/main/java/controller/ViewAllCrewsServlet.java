package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CrewDetails;

/**
 * Servlet implementation class ViewAllTeamsServlet
 */
@WebServlet("/viewAllCrewsServlet")
public class ViewAllCrewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCrewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CrewDetailsHelper edh = new CrewDetailsHelper();
		List<CrewDetails> abc = edh.getEmployees();
		request.setAttribute("allEmployees", abc);
		
		if(abc.isEmpty()) {
			request.setAttribute("allEmployees", " ");
		}
		
		getServletContext().getRequestDispatcher("/crew-list-by-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
