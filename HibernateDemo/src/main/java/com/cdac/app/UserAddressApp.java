package com.cdac.app;

import java.util.List;

import com.cdac.dao.UserAddressDao;
import com.cdac.entity.Address;
import com.cdac.entity.User;

public class UserAddressApp {

	public static void main(String[] args) {
		UserAddressDao dao = new UserAddressDao();
		
		//---------- scenario 1 -----------------//
		//first store user, then store address, finally link the user with the address

		//adding a user
		/*User user = new User();
		user.setName("Puja");
		user.setEmail("puja@gmail.com");
		user.setMobileNumber(9988776655L);
		dao.add(user);*/
		
		//adding an address
		/*Address addr = new Address();
		addr.setPincode(40002);
		addr.setCity("Mumbai");
		addr.setState("Maharashtra");
		dao.add(addr);*/
		
		//link user and address
		/*User user = dao.fetchUserById(15);
		Address addr = dao.fetchAddressById(16);
		user.setAddress(addr);
		dao.update(user);*/

	
		//---------- scenario 2 -----------------//
		//store user and address in one go in the db
		
		/*User user = new User();
		user.setName("Kuldeep");
		user.setEmail("kuldeep@outlook.com");
		user.setMobileNumber(988776654L);
		
		Address addr = new Address();
		addr.setPincode(420002);
		addr.setCity("Nashik");
		addr.setState("Maharashtra");
		
		user.setAddress(addr);
		
		dao.add(user);*/	
		
		//---------- scenario 3 -----------------//
		//---------- fetch the data -------------//
		/*User user = dao.fetchUserByEmail("harshal@gmail.com");
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getMobileNumber());*/
		
		//List<User> users = dao.fetchUsersByDomain("gmail");
		/*List<User> users = dao.fetchUsersByCity("Nashik");
		for(User user : users) {
			System.out.println("----------------");
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getMobileNumber());
			Address addr = user.getAddress();
			System.out.println(addr.getPincode());
			System.out.println(addr.getCity());
			System.out.println(addr.getState());
		}*/
		
		List<Object[]> users = dao.fetchUsersByCityV2("Mumbai");
		for(Object[] user : users) {
			System.out.println("-------------");
			System.out.println(user[0]);
			System.out.println(user[1]);
		}
	}
}
