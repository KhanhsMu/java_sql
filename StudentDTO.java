
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDTO {

		
	//thu tuc lay dssv tu csdl
	public List<Student> getAllStudent(){
		List<Student> listStudent = new ArrayList<Student>();
		
		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;
		try {
			conn = Dbcon.getConnection();
			if(conn !=null) {
				String sql ="Select * from Student";
				stm = conn.createStatement();
				result = stm.executeQuery(sql);
				
				while(result.next()) {
					int id = result.getInt(1);
					String fullName = result.getString(2);
					double gpa = result.getDouble(3);
					Student sv = new Student(id,fullName,gpa);
					listStudent.add(sv);
				}
				return listStudent;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean addStudent(Student st) {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = Dbcon.getConnection();
			if(conn != null) {
				String sql = "INSERT INTO Student(id, fullname , gpa) VALUES(?,?,?)";
				stm = conn.prepareStatement(sql);
				stm.setInt(1,st.getId());
				stm.setString(2, st.getfullName());
				stm.setDouble(3, st.getGpa());
				int result = stm.executeUpdate();
				if(result > 0 ) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return false;
}
	public boolean editStudent(Student st) {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = Dbcon.getConnection();
			if(conn != null) {
				String sql = "UPDATE Student SET fullname=? , gpa=?  WHERE id=?";
				stm = conn.prepareStatement(sql);
				stm.setString(1, st.getfullName());
				stm.setDouble(2, st.getGpa());
				stm.setInt(3,st.getId());
				
				int result = stm.executeUpdate();
				if(result > 0 ) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return false;
	}
	
	public boolean deleteStudent(int id) {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = Dbcon.getConnection();
			if(conn != null) {
				String sql = "DELETE FROM Student WHERE id=?";
				stm = conn.prepareStatement(sql);
				stm.setInt(1,id);
				int result = stm.executeUpdate();
				if(result > 0 ) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return false;
	}
	public List<Student> getStudentByname(String name ){
		List<Student> listStudent = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet result = null;
		try {
			conn = Dbcon.getConnection();
			if(conn !=null) {
				String sql ="Select * from Student WHERE fullname LIKE ?";
				stm = conn.prepareStatement(sql);
				stm.setString(1,"%" + name + "%");
				result = stm.executeQuery();
				
				while(result.next()) {
					int id = result.getInt(1);
					String fullName = result.getString(2);
					double gpa = result.getDouble(3);
					Student sv = new Student(id,fullName,gpa);
					listStudent.add(sv);
				}
				return listStudent;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
