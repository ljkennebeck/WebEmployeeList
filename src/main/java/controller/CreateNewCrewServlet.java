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

import model.Employee;
import model.CrewDetails;
import model.Manager;

/**
 * Servlet implementation class CreateNewCrewServlet
 */
@WebServlet("/createNewCrewServlet")
public class CreateNewCrewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewCrewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpListHelper elh = new EmpListHelper();
		String crewDepartment = request.getParameter("crewDepartment");
		System.out.println("Manager Name:" + crewDepartment);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String managerName = request.getParameter("managerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException e) {
			ld = LocalDate.now();
		}
		
		String[] selectedEmployees = request.getParameterValues("allEmployeesToAdd");
		List<Employee> selectedEmployeesInCrew = new ArrayList<Employee>();
		
		if(selectedEmployees != null && selectedEmployees.length > 0) {
			for(int i = 0; i < selectedEmployees.length; i++) {
				System.out.println(selectedEmployees[i]);
				Employee e = elh.searchById(Integer.parseInt(selectedEmployees[i]));
				selectedEmployeesInCrew.add(e);
			}
		}
		Manager manager = new Manager(managerName);
		CrewDetails ed = new CrewDetails(crewDepartment, ld, manager, selectedEmployeesInCrew);
		//ed.setListOfEmployees(selectedEmployeesInCrew);
		CrewDetailsHelper edh = new CrewDetailsHelper();
		edh.insertNewEmployeeDetails(ed);
		
		System.out.println("Success");
		System.out.println(ed.toString());
		
		getServletContext().getRequestDispatcher("/viewAllCrewsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
