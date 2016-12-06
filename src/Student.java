
public class Student {
	private String ID;
	private String name;
	private String email;
	private double gpa;
	
	public Student(String iD, String name, String email, double gpa) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
		this.gpa = gpa;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public double getGpa() {
		return gpa;
	}
	
	
	
	
}
