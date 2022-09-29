package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/editEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpListHelper dao = new EmpListHelper();
		
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Employee empToUpdate = dao.searchById(tempId);
		empToUpdate.setfName(fName);
		empToUpdate.setlName(lName);
		
		dao.updateEmp(empToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllEmployeesServlet").forward(request, response);
	}

}
