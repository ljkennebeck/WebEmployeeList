package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {
	
	@Id
	@GeneratedValue
	private int id;
	private String managerName;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String managerName) {
		super();
		this.id = id;
		this.managerName = managerName;
	}

	public Manager(String managerName) {
		super();
		this.managerName = managerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", managerName=" + managerName + "]";
	}
	
	

}
