package client;

import java.util.List;

import manager.TestManager;

public class ConsoleApp {

	private static TestManager tm = new TestManager();
	
	public static void main(String[] args) {
		
			System.out.println(showUsers());
		
			
		}
	
	private static List<String> showUsers() {
		
		List<String> users = tm.showUsers(); 
		return users;
	}
}
