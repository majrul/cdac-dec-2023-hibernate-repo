package com.cdac.app;

import com.cdac.dao.CustomerDao;

public class DeleteCustomer {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		dao.delete(6);
	}
}
