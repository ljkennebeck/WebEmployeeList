import java.util.List;
import java.util.Scanner;
import controller.EmpListHelper;
import model.Employee;

/**  
* Logan Kennebeck - ljkennebeck1  
* CIS171 22149
* Sep 8, 2022  
*/
public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static EmpListHelper elh = new EmpListHelper();
	
	private static void addEmp() {
		System.out.print("Enter a first name: ");
		String fName = in.nextLine();
		System.out.print("Enter a last name: ");
		String lName = in.nextLine();
		Employee toAdd = new Employee(fName, lName);
		elh.insertEmp(toAdd);
	}
	
	private static void deleteEmp() {
		System.out.print("Enter a first name: ");
		String fName = in.nextLine();
		System.out.print("Enter a last name: ");
		String lName = in.nextLine();
		Employee toDelete = new Employee(fName, lName);
		elh.deleteEmp(toDelete);
	}
	
	private static void editEmp() {
		System.out.println("Search by first or last name?");
		System.out.println("1 - Search by first name");
		System.out.println("2 - Search by last name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Employee> foundEmps;
		if(searchBy == 1) {
			System.out.print("Enter a first name: ");
			String fName = in.nextLine();
			foundEmps = elh.searchByFName(fName);
		}else {
			System.out.print("Enter a last name: ");
			String lName = in.nextLine();
			foundEmps = elh.searchByFName(lName);
		}
		
		if(!foundEmps.isEmpty()) {
			System.out.println("Found Employees");
			for(Employee emp : foundEmps) {
				System.out.println(emp.getId() + " - " + emp.getlName() + ", " + emp.getfName());
			}
			System.out.print("Select ID to edit: ");
			int idToEdit = in.nextInt();
			
			Employee toEdit = elh.searchById(idToEdit);
			System.out.println("Retrieved " + toEdit.getfName() + " " + toEdit.getlName());
			System.out.println("1 - update first name");
			System.out.println("2 - update last name");
			int update = in.nextInt();
			in.nextLine();
			
			if(update == 1) {
				System.out.print("New first name: ");
				String newFN = in.nextLine();
				toEdit.setfName(newFN);
			}else if(update == 2) {
				System.out.print("New last name: ");
				String newLN = in.nextLine();
				toEdit.setlName(newLN);
			}
			
			elh.updateEmp(toEdit);
			
		}else {
			System.out.println("No Employees found");
		}
	}
	
	private static void viewEmpList() {
		List<Employee> allEmps = elh.showAllEmps();
		for(Employee singleEmp : allEmps) {
			System.out.println(singleEmp.returnEmpDetails());
		}
	}
	
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("----- Employee List -----");
		while(goAgain) {
			System.out.println("Select an option:");
			System.out.println("1 - Add an employee");
			System.out.println("2 - Edit an employee");
			System.out.println("3 - Delete an employee");
			System.out.println("4 - View list");
			System.out.println("5 - Exit list");
			System.out.print("Your selection: ");
			int selection = in.nextInt();
			in.nextLine();
			
			if(selection == 1) {
				addEmp();
			}else if(selection == 2) {
				editEmp();
			}else if(selection == 3) {
				deleteEmp();
			}else if(selection == 4) {
				viewEmpList();
			}else {
				elh.cleanUp();
				System.out.println("Program successfully exited");
				goAgain = false;
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

}