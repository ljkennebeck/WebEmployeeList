import java.util.List;

import controller.ManagerHelper;
import model.Manager;

/**  
* Logan Kennebeck - ljkennebeck1  
* CIS171 22149
* Oct 1, 2022  
*/
public class ManagerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Manager Kim = new Manager("Kim");
		Manager Bethany = new Manager("Bethany");
		
		ManagerHelper mh = new ManagerHelper();
		
		mh.insertManager(Kim);
		mh.insertManager(Bethany);
		
		List<Manager> allManagers = mh.showAllManagers();
		for(Manager m : allManagers) {
			System.out.println(m.toString());
		}

	}

}
