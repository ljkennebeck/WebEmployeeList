package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class CrewDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String department;
	private LocalDate lastModified;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Manager manager;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Employee> listOfEmployees;
	
	public CrewDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CrewDetails(int id, String department, LocalDate lastModified, Manager manager,
			List<Employee> listOfEmployees) {
		super();
		this.id = id;
		this.department = department;
		this.lastModified = lastModified;
		this.manager = manager;
		this.listOfEmployees = listOfEmployees;
	}

	public CrewDetails(String department, LocalDate lastModified, Manager manager, List<Employee> listOfEmployees) {
		super();
		this.department = department;
		this.lastModified = lastModified;
		this.manager = manager;
		this.listOfEmployees = listOfEmployees;
	}

	public CrewDetails(String department, LocalDate lastModified, Manager manager) {
		super();
		this.department = department;
		this.lastModified = lastModified;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDate lastModified) {
		this.lastModified = lastModified;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", department=" + department + ", lastModified=" + lastModified + ", manager="
				+ manager + ", listOfEmployees=" + listOfEmployees + "]";
	}
	
	

}
