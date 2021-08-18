package hibernate_test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="requests")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name="id_generator", sequenceName = "requests_id_seq", allocationSize = 1)
	private int id;
	
	@Column
	private double amt;
	
	@Column
	private String status;
	
	//hibernate mapping 
	
	//states that one user belongs to multiple addresses
	
	
	//essentially creates a join to user_id and users
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	
	//this is what you use in the xml file for the name part of the many-to-one
	private Users users;
	
	
	
	public Request() {
		super();
	}
	
	public Request(String status, int amt) {
		super();
		this.setStatus(status);
		this.setAmt(amt);
	}
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	

	

	

	
	
	
}
