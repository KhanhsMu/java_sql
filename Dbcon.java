import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbcon {
	 public static Connection getConnection() throws SQLException {
	        try {
	            String url = "jdbc:sqlserver://localhost:1433;databaseName=B3_404;user=sa;password=10062004";
	            Connection con = DriverManager.getConnection(url);
	            return con;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;    
	    }
	    
	    public static void main(String[] args) {
	        try {
	            Connection conn = Dbcon.getConnection();
	            if (conn != null) {                
	                System.out.println("Connected!");
	            } else {
	                System.out.println("Fail!");
	            }
	        } catch (Exception e) {
	        }
	    }
}


