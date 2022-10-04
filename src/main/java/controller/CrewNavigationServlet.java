package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CrewDetails;

/**
 * Servlet implementation class TeamNavigationServlet
 */
@WebServlet("/crewNavigationServlet")
public class CrewNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CrewDetailsHelper dao = new CrewDetailsHelper();
		String act = request.getParameter("doThisToCrew");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllCrewsServlet").forward(request, response);
		}else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CrewDetails crewToDelete = dao.searchForCrewDetailsById(tempId);
				dao.deleteCrew(crewToDelete);
			}catch(NumberFormatException e) {
				System.out.println("Click a button first");
			}finally {
				getServletContext().getRequestDispatcher("/viewAllCrewsServlet").forward(request, response);
			}
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CrewDetails crewToEdit = dao.searchForCrewDetailsById(tempId);
				request.setAttribute("crewToEdit", crewToEdit);
				
				request.setAttribute("month", crewToEdit.getLastModified().getMonthValue());
				request.setAttribute("day", crewToEdit.getLastModified().getDayOfMonth());
				request.setAttribute("year", crewToEdit.getLastModified().getYear());
				
				EmpListHelper daoForEmployees = new EmpListHelper();
				
				request.setAttribute("allEmployees", daoForEmployees.showAllEmps());
				
				if(daoForEmployees.showAllEmps().isEmpty()) {
					request.setAttribute("allEmployees", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-crew.jsp").forward(request, response);
				
			}catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllCrewsServlet").forward(request, response);
			}
		}else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/addEmployeesToCrewServlet").forward(request, response);
		}
	}

}
