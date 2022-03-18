import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaConnectionFactory {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Ok");
		
		String sql = "insert into orders_status (id, status_name) values (?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, 10);
		stmt.setString(2, "Cancelled");
		
		stmt.execute();
		
		
		
		con.close();
	}

}


