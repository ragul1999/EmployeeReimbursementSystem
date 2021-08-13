package com.revature.ers.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ManagerViewReimbursementDaoImplTest {

	@Test
	public void testGetPendingReimbursement() {
		ManagerViewReimbursementDaoImpl impl=new ManagerViewReimbursementDaoImpl();
		List<PendingReimbursementEntity> list=impl.getPendingReimbursement();
		assertNotNull(list);
	}

	@Test
	public void testGetRejectedReimbursement() {
		ManagerViewReimbursementDaoImpl impl=new ManagerViewReimbursementDaoImpl();
		List<RejectedReimbursementEntity> list=impl.getRejectedReimbursement();
		assertNotNull(list);
	}

	@Test
	public void testGetResolvedReimbursement() {
		ManagerViewReimbursementDaoImpl impl=new ManagerViewReimbursementDaoImpl();
		List<ResolvedReimbursementEntity> list=impl.getResolvedReimbursement();
		assertNotNull(list);
	}

	@Test
	public void testGetAllEmployees() {
		ManagerViewReimbursementDaoImpl impl=new ManagerViewReimbursementDaoImpl();
		List<EmployeeEntity> list=impl.getAllEmployees();
		assertNotNull(list);
	}

}
