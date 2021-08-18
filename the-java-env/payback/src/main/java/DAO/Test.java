package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.util.DatabaseUtil;

public class Test {

	public List<String> showUsers() {
		List<String> ca = new ArrayList<String>();
		
		
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT f_name FROM payback.users;");
			
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
			//this can be a method but for right now i have to chill
				ca.add(rs.getString(1));
				
		}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ca;
	}
}
