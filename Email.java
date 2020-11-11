package emailapp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String department;
	private int mailboxCap = 500; // default mail capacity
	private String altEmail;
	private String company = "company.com";
	private int defaultPassLength = 10;

	// Constructor for first name and last name
	public Email(String fname, String lname) {
		this.firstname = fname;
		this.lastname = lname;
		
		// Call method asking and returning user's department
		this.department = setDepartment();
		
		// Call method returning random password
		this.password = randPass(defaultPassLength);
		System.out.println("Password: " + this.password);
	
		// Create email syntax
		email = fname.toLowerCase() + "." + lname.toLowerCase() + "@" + department + "." + company;
	
	}
	
	// Inquiry user department
	private String setDepartment() {
		System.out.println("DEPARTMENT CODES");
		System.out.println("0 - None");
		System.out.println("1 - Sales");
		System.out.println("2 - Development");
		System.out.println("3 - Accounting");
		System.out.print("Enter the department: ");
		
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		
		if(deptChoice == 1) {
			return "sales";
		} 
		else if(deptChoice == 2) {
			return "development";
		}
		else if(deptChoice == 3) {
			return "accounting";
		}
		else {
			return "other";
		}
	}
	
	// Generate random password
	private String randPass(int len) {
		String passSetting = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char [] password = new char[len];
		for(int i = 0; i < len; i++) {
			int rand = (int)(Math.random() * passSetting.length());
			password[i] = passSetting.charAt(rand);
		}
		return new String(password);
	}
	
	// Set mailbox capacity
	public void setMailboxCap(int capacity) {
		this.mailboxCap = capacity;
	}
	
	// Get mailbox capacity
	public int getMailboxCapacity() {
		return mailboxCap;
	}
	
	// Alternate email
	public void setAltEmail(String alternateEmail) {
		this.altEmail = alternateEmail;
	}
	
	// Get alternate email
	public String getAltEmail() {
		return altEmail;
	}
	
	// Change password
	public void changePassword(String pass) {
		this.password = pass;
	}
	
	// Get changed password
	public String getChangedPass() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstname + " " + lastname + 
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCap + "mb";
	}
	
}
