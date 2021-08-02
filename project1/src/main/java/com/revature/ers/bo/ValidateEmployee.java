package com.revature.ers.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.ers.db.DBUtil;
import com.revature.ers.model.Employee;

public class ValidateEmployee {
	public boolean checkEmployee(Employee e) throws Exception {
		boolean result=false;
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from ers_employeetable where id=? and (password=? and type=?)");
		pst.setInt(1,e.getEmployeeId());
		pst.setString(2,e.getPassword());
		pst.setString(3,e.getType());
		ResultSet rst=pst.executeQuery();
		if(rst.next())
			result=true;
		return result;
	}
}
