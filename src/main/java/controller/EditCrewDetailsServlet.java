package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CrewDetails;
import model.Employee;
import model.Manager;

/**
 * Servlet implementation class EditCrewDetailsServlet
 */
@WebServlet("/editCrewDetailsServlet")
public class EditCrewDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCrewDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CrewDetailsHelper dao = new CrewDetailsHelper();
		EmpListHelper elh = new EmpListHelper();
		ManagerHelper mh = new ManagerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		CrewDetails crewToUpdate = dao.searchForCrewDetailsById(tempId);
		
		String newDepartmentName = request.getParameter("departmentName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String managerName = request.getParameter("managerName");
		Manager newManager = mh.findManager(managerName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedEmployees = request.getParameterValues("allEmployeesToAdd");
			List<Employee> selectedEmployeesInCrew = new ArrayList<Employee>();
			
			for(int i = 0; i < selectedEmployees.length; i++) {
				System.out.println(selectedEmployees[i]);
				Employee e = elh.searchById(Integer.parseInt(selectedEmployees[i]));
				selectedEmployeesInCrew.add(e);
			}
			crewToUpdate.setListOfEmployees(selectedEmployeesInCrew);
		}catch(NullPointerException e) {
			List<Employee> selectedEmployeesInCrew = new ArrayList<Employee>();
			crewToUpdate.setListOfEmployees(selectedEmployeesInCrew);
		}
		
		crewToUpdate.setDepartment(newDepartmentName);
		crewToUpdate.setLastModified(ld);
		crewToUpdate.setManager(newManager);
		
		dao.updateCrew(crewToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllCrewsServlet").forward(request, response);
	}

}
