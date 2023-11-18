import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main_Student {
	static List<Student> listStudents = new ArrayList<Student>();
	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("MENU");
			System.out.println("1.Hien thi tat ca SV");
			System.out.println("2.Them 1 sv");
			System.out.println("3.Sua sv");
			System.out.println("4.Xoa sv");
			System.out.println("5.Tim sv theo ten");
			System.out.println("0.Thoat");
			System.out.println("Chon 1 phuong thuc");
			 choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1:{
				showAll();
				break;
			}
			case 2:{
				insertNewStudent();
				break;
			}
			case 3:{
				updateStudent();
				break;
			}
			case 4:{
				deleteStudent();
				break;
			}
			case 5:{
				SearchStudentByName();
				break;
			}
			default:
				System.out.println("t ko biet");
				break;
					}
	}while(choice!=0);
}
	public static void showAll() {
		StudentDTO dto = new StudentDTO();
		listStudents = dto.getAllStudent();
		for(Student student : listStudents) {
			System.out.println(student.toString());
		}
	}
	public static void insertNewStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thong tin 1 sinh vien");
		System.out.println("Nhap id");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap ten");
		String fullName = sc.nextLine();
		System.out.println("Nhap gpa");
		double gpa = Double.parseDouble(sc.nextLine());
		StudentDTO dto = new StudentDTO();
		Student st = new Student(id,fullName,gpa);
		if(dto.addStudent(st)) {
			System.out.println("Them sinh vien thanh cong");
		}
		else {
			System.out.println("Them sinh vien that bai");
		}
		
	}
	public static void updateStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thong tin 1 sinh vien");
		System.out.println("Nhap id");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap ten");
		String fullName = sc.nextLine();
		System.out.println("Nhap gpa");
		double gpa = Double.parseDouble(sc.nextLine());
		StudentDTO dto = new StudentDTO();
		Student st = new Student(id,fullName,gpa);
		if(dto.editStudent(st)) {
			System.out.println("Sua sinh vien thanh cong");
		}
		else {
			System.out.println("Sua sinh vien that bai");
		}
	}
	
	public static void deleteStudent() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Nhap id");
		int id = Integer.parseInt(sc.nextLine());
		
		StudentDTO dto = new StudentDTO();
		
		if(dto.deleteStudent(id)) {
			System.out.println("Xoa sinh vien thanh cong");
		}
		else {
			System.out.println("Xoa sinh vien that bai");
		}
	}
	
	public static void SearchStudentByName() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Nhap ten can tim");
		String name = sc.nextLine();
		
		StudentDTO dto = new StudentDTO();
		listStudents = dto.getStudentByname(name);
		for (Student student : listStudents) {
			System.out.println(student.toString());
		}
	}
}
