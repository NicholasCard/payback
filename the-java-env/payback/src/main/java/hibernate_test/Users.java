package hibernate_test;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;




@Entity(name="users")
public class Users {

	//creates a generated value for the id in the object
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name="id_generator", sequenceName = "users_id_seq", allocationSize = 1)
	//used if column name is not the same name as the variable name
	private int id;
	
	@Column
	private String f_name;
	
	@Column
	private String l_name;
	
	@OneToMany(mappedBy = "users", cascade=CascadeType.ALL)
	private Set<Request> requests;
	//part of mapping for hibernate. this is saying that one user has many requests
	
	//need getters and setters for each of these
	
	
	public Users() {
		super();
	}

	public Users(String f_name, String l_name) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
	}

	public Users(int id, String f_name, String l_name) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}
	
	
	
}
