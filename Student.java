

public class Student {
	private int id;
	private String fullname;
	private double gpa;
	public Student() {}
	public Student(int id, String fullname, double gpa) {
		this.id = id;
		this.fullname = fullname;
		this.gpa = gpa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfullName() {
		return fullname;
	}
	public void setfullName(String fullname) {
		this.fullname = fullname;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fullname=" + fullname + ", gpa=" + gpa + "]";
	}
	
	
}

