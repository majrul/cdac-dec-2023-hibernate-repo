package com.cdac.app;

import java.util.List;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class FetchMultipleCustomers {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		//List<Customer> list = dao.fetchAll();
		List<Customer> list = dao.fetchByCity("New Jersey");
		/*list.forEach(customer -> {
			System.out.println("-----------------");
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getDateOfBirth());
			System.out.println(customer.getCity());
		});*/
		for(Customer customer : list) {
			System.out.println("-----------------");
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getDateOfBirth());
			System.out.println(customer.getCity());			
		}
	}
}
