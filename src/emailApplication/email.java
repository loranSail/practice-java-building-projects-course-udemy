package emailApplication;

import java.util.Scanner;

public class email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int defaultPasswordLenght = 8;
	private int mailBoxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";
	
	public email (String firstName, String lastName, int passwordLenght, String companySuffix) {
		this.firstName = firstName;
		this.lastName = lastName;
		/*System.out.println("Email created: " + this.firstName + " " + this.lastName);*/
		
		this.department = setDepartment();
		/*System.out.println("Selected department: " + this.department);*/
		
		this.defaultPasswordLenght = passwordLenght;
	
		this.password = randomPassword(this.defaultPasswordLenght);
		System.out.println("Your password is: " + this.password);
		
		this.companySuffix = companySuffix;
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + this.companySuffix;
		System.out.println("Your e-mail was created: " + this.email);
	}
	
	
	private String setDepartment() {
		System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 none\nEnter the department code:");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) { return "sales";}
		else if (depChoice == 2 ) {return "dev";}
		else if (depChoice == 3 ) {return "acct";}
		else {return "";}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKMLNOPQRSTUVXZ0123456789!@#$";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
	public void setMailBoxCapacity(int capacity) {this.mailBoxCapacity = capacity;}
	
	public void setAlternateEmail(String altEmail) {this.alternateEmail = altEmail;}
	
	public void setNewEmail(String newEmail) {this.email = newEmail;}
	
	public void changePassword(String passwrd) {this.password = passwrd;}
	
	
	public int getMailBoxCapacity() { return mailBoxCapacity;}
	public String getAlternateEmail() { return alternateEmail;}
	public String getPassword() { return password;}
	
	
	public String showInfo() {
	return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
			"COMPANY E-MAIL: " + email + "\n"+
			"MAILBOX CAPACITY: " + mailBoxCapacity + "mb";
	
	}
}
