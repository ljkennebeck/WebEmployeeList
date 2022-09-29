package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpListHelper dao = new EmpListHelper();
		String act = request.getParameter("doThisToEmployee");
		
		String path = "/viewAllEmployeesServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Employee empToDelete = dao.searchById(tempId);
				dao.deleteEmp(empToDelete);
				
			}catch(NumberFormatException e) {
				System.out.println("Select an Employee");
			}
			
		}else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Employee empToEdit = dao.searchById(tempId);
				request.setAttribute("empToEdit", empToEdit);
				path = "/edit-employee.jsp";
				
			}catch(NumberFormatException e) {
				System.out.println("Select an Employee");
			}
			
		}else if(act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
