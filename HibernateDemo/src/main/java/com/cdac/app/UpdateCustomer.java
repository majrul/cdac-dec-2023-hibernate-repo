package com.cdac.app;

import java.time.LocalDate;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class UpdateCustomer {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.fetch(4);
		customer.setDateOfBirth(LocalDate.of(1999, 12, 25));
		dao.update(customer);
	}
}
