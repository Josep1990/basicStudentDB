package database;

import java.util.Random;

import java.util.Scanner;

//Create a Student Database with the following attributes:




// Methods: enroll(), pay(), checkBalance(), toString(), showCourses()
// Use encapsulation to set variables (phone, city, state)

public class StudentArchieve {

	public static void main(String[] args) {
		
		Student student1 = new Student("Pablo Scobar", "5684648");		
		student1.studentRegister("Leinster", "Dublin", "+353 088 888 1515");
		student1.showCourse();
		System.out.println("\n" + student1.toString());

		Student student2 = new Student("Julio Ferraz", "5654455");
		Student student3 = new Student("Maevis", "4875365");
		
//			System.out.println(student1.getSSN());
	}
}

class Student {
	
	private static int id = 9;
	private final double fee = 4500.00;
	private String studentID;
	private String name;
	private String SSN;
	private String email;
	private String phone;
	private String city;
	private String state;
	private double balance = 0.0;
	private String choosenCourse;
	Scanner scanner = new Scanner(System.in);
	//constructors ===========================================*
	
	public Student(String name ,String SSN) {
		this.name = name;
		this.SSN  = SSN; 
		id++;

	}
	
	
	//class methods ==========================================*
	//toString()
	public void studentRegister(String state, String city, String phone) {
		this.state = state;
		this.city  = city;
		this.phone = phone;		
	}
	
	public void showCourse() {
		String[] courses = {"Computer Science", "Web Design", "Software Development", "Computer security", "Marketing"};
		double deposit;
		try {
			System.out.println("Please choose one of the following options: (Please chose by the number e.g. 1, 2, or 3)");
			
			for(int i = 0; i < courses.length; i++) {
				System.out.println( (i+1) +" - Full time: " + courses[i] + " - Fees: R$" + fee);
			};
			
			String input = scanner.next().toString();

		switch(input) {
			case "1":
				choosenCourse = courses[0];
				break;
			case "2":
				choosenCourse = courses[1];
				break;
			case "3":
				choosenCourse = courses[2];
				break;
			case "4":
				choosenCourse = courses[3];
				break;
			case "5":
				choosenCourse = courses[4];
				break;
			default:
				System.out.println("Unfortunately this option it isnot availiable");				
		};
		
		System.out.println("Please, make your deposit");
		do {			
			deposit = scanner.nextDouble();
			payment(deposit);
			
		}while(deposit < fee);
		
		}catch(Exception e) {
			System.out.println("Please choose a valid option");
		}
		
	}
	private void payment(double deposit) {			
		
		balance += deposit;
		
		if(balance >= fee) {
			System.out.println("Congratulations, "+ name+ ", you are now enrolled in the course: " + choosenCourse );
			enroll(name, SSN);
		}else {
			System.out.println("We are sorry, the total fee for this course is: R$" + fee);
			checkBalance();
			System.out.println("Please, deposit the amount of R$" + (fee - balance) + " to procedure to the enrollement.");
			
		}
		
	}
	private void enroll(String name, String SSN ) {		
		setEmail();
		setID();
	}
	private void checkBalance() {
		System.out.println("Your currently Balance is: R$" + balance);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\n" + "State: " + state + ", " + city + "." 
	           + "\n"  + "Phone Number: " + phone + "\n"+"Student ID: " 
			   + studentID +"\n"+ "Email: " + email + "\n" + "Course: " + choosenCourse;
	}

	//getter and sellers =====================================*
	
	private void setEmail() {
		String newName = " ";
		if(name.length() > 10) {
			newName = name.substring(0, 12);
		}else {
			newName = name;
		}		
		email = newName.replaceAll("\\s+","-").toLowerCase() +"."+ id + "@supercollege.com";
		
		System.out.println("Student email address: " + email);
	}
	
	private void setID() {
		int min = 1000;
		int max = 9000;
//		int randNum = (int)(Math.random() * (max - min));
//		randNum += min; calculating a range between 1000 and 9000
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;	    
		String ssnID = SSN.substring((SSN.length()-4), SSN.length());
		
	    studentID = id +""+ randomNum + ssnID;
		System.out.println("Studend ID: "+studentID);
		
	}
	public String getName() {
		return name;
	}
	public String getSSN() {
		return SSN;
	}
	
}
