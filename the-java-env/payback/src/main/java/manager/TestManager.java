package manager;

import java.util.List;

import DAO.Test;


public class TestManager {

	
	private Test test = new Test();

	public List<String> showUsers() {
		
		return test.showUsers();
	}
	
}
