package com.lti.ui;

import java.util.Scanner;


import com.lti.model.Users;

import com.lti.service.UserService;

public class MainFinal {

private static UserService service = null;
	
	static{
		service = new UserService();
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String uname = sc.next();
		System.out.println("Enter Password");
		String pass = sc.next();
		if(service.checkLogin(uname,pass))
		{
			String ans;
			int no;
			String username,password,firstname,lastname,mobilenumber; 
			Users user1 = null;
			do {
				
				System.out.println("1.Add User ");
				System.out.println("2.Read User By username ");
				System.out.println("3.Modify User");
				System.out.println("4.Delete User");
				
				System.out.println("Pls enter your choice: ");
				
				no = sc.nextInt();
				switch (no) {
				case 1:	System.out.println("Enter username: ");
				        username = sc.next();
				        System.out.println("Enter password: ");
				        password = sc.next();
				        System.out.println("Enter FirstName: ");
				        firstname = sc.next();
				        System.out.println("Enter LastName");
				        lastname = sc.next();
				        System.out.println("Enter Mobile Number:");
				        mobilenumber = sc.next();
				        user1 = new Users(username, password, firstname, lastname, mobilenumber);
				        boolean result = service.addUser(user1);
						if(result)
							System.out.println("User added successfully in dB");
						break;
						
				case 2: System.out.println("Enter the username: ");
				 		username = sc.next();
				        user1 = service.findUserByUsername(username);
				        System.out.println(user1);
						break;
						
				case 3: System.out.println("Enter the username of user you want to modify: ");
						username = sc.next();
				        user1 = service.findUserByUsername(username);
				        System.out.println(user1);
				        System.out.println("Modify Password:");
				        password = sc.next();
				        System.out.println("Modify FirstName: ");
				        firstname = sc.next();
				        System.out.println("Modify LastName: ");
				        lastname = sc.next();
				        System.out.println("Modify MobileNumber: ");
				        mobilenumber = sc.next();
				        user1 = new Users(username, password, firstname, lastname, mobilenumber);
				        Users user2 = service.modifyUser(user1);
				        System.out.println(user2);
						break;
						
				case 4: System.out.println("Enter the username you wanna delete");
				        username = sc.next();
				        boolean result1 = service.removeUser(username);
						if(result1)
							System.out.println("User removed successfully from dB");
						break;
						
			    default: System.out.println("Wrong choice entered");
			     		break;
				        
				}
				System.out.println("Do you want to continue yes/no");
				ans = sc.next();
			} while (ans.equals("Yes") || ans.equals("y") || ans.equals("yes")||ans.equals("YES"));
			
		}else
		{
			System.out.println("Wrong username and password");
		}
			
		
		
		
		
		

	}

}
