import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.CrewDetailsHelper;
import controller.ManagerHelper;
import model.Employee;
import model.CrewDetails;
import model.Manager;

/**  
* Logan Kennebeck - ljkennebeck1  
* CIS171 22149
* Oct 1, 2022  
*/
public class EmployeeDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager tom = new Manager("Tom");
		
		CrewDetailsHelper edh = new CrewDetailsHelper();
		
		Employee dave = new Employee("Dave", "Johnson");
		Employee phil = new Employee("Phil", "Norwalk");
		
		List<Employee> tomsEmployees = new ArrayList<Employee>();
		tomsEmployees.add(dave);
		tomsEmployees.add(phil);
		
		CrewDetails tomsList = new CrewDetails("Accounting", LocalDate.now(), tom);
		tomsList.setListOfEmployees(tomsEmployees);
		
		edh.insertNewEmployeeDetails(tomsList);
		
		List<CrewDetails> allEmployees = edh.getEmployees();
		for(CrewDetails e : allEmployees) {
			System.out.println(e.toString());
		}
	}

}
