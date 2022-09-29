package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Employee;

/**  
* Logan Kennebeck - ljkennebeck1  
* CIS171 22149
* Sep 8, 2022  
*/
public class EmpListHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebEmployeeList");
	
	public void insertEmp(Employee emp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteEmp(Employee emp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select emp from Employee emp where emp.fName = :selectedFN and emp.lName = :selectedLN", Employee.class);
		typedQuery.setParameter("selectedFN", emp.getfName());
		typedQuery.setParameter("selectedLN", emp.getlName());
		typedQuery.setMaxResults(1);
		Employee result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Employee> showAllEmps(){
		EntityManager em = emfactory.createEntityManager();
		List<Employee> allEmps = em.createQuery("SELECT i FROM Employee i").getResultList();
		return allEmps;
	}
	
	public List<Employee> searchByFName(String fName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("Select emp from Employee emp where emp.fName = :selectedFN",Employee.class);
		typedQuery.setParameter("selectedFN", fName);
		List<Employee> foundFN = typedQuery.getResultList();
		return foundFN;
	}
	
	public List<Employee> searchByLName(String lName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Employee> typedQuery = em.createQuery("select emp from Employee emp where emp.lName = :selectedLN", Employee.class);
		typedQuery.setParameter("selectedLN", lName);
		List<Employee> foundLN = typedQuery.getResultList();
		return foundLN;
	}
	
	public Employee searchById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Employee found = em.find(Employee.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateEmp(Employee toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
