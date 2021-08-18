package common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

	//check to see what instance does
		private static DatabaseUtil _instance;
		private Connection conn = null;
		
		//nobody else can create this instance 
		private DatabaseUtil() {
			try {
				
				//need to add the file way to do this and add it to the git ignore
				conn = DriverManager.getConnection("jdbc:postgresql://database-1.cpf6k3ueavgf.us-east-2.rds.amazonaws.com:5432/payback", "postgres", "postgres");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		//gets one instance always
		public static DatabaseUtil getInstance() {
			if(_instance == null) {
				_instance = new DatabaseUtil();
			}
			
			return _instance;
		}
		//gets the connction object
		public Connection getConnection() {
			return this.conn;
		}

		
}
