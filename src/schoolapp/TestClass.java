package schoolapp;

import java.util.Scanner;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Collections;

enum LOAD_TYPE {
	HARDCODED, KEYBOARD,FILE
}

enum DISPLAY_TYPE{
	CONSOLE, FILE, GUI
}
public class TestClass {	
	public static void main(String[] args) {
 	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Username:");
		var username = sc.next();
		System.out.println("Password:");
		var password = sc.next();
		
		try {
			Application.getInstance().login(new User(username,password));
			System.out.println(Application.getInstance().currentUser);
			System.out.println(Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
