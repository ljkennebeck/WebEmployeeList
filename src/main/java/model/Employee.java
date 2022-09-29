package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
/**  
* Logan Kennebeck - ljkennebeck1  
* CIS171 22149
* Sep 8, 2022  
*/


public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="FNAME")
	private String fName;
	@Column(name="LNAME")
	private String lName;
	
	public Employee() {
		super();
	}
	
	public Employee(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String returnEmpDetails() {
		return "Employee: " + this.lName + ", " + this.fName;
	}

}
