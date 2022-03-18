import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusDAO {
	private Connection conexao;
	
	public OrderStatusDAO() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void insert (OrderStatus os) {
		String sql = "insert into orders_status (id, status_name) values (?,?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, os.getId());
			stmt.setString(2, os.getStatus_name());
			
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public void select() {
		String sql = "select * from orders_status";
		
		List<OrderStatus> lista = new ArrayList<OrderStatus>();
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String status_name = rs.getString("status_name");
				
				OrderStatus os = new OrderStatus();
				os.setId(id);
				os.setStatus_name(status_name);
				
				lista.add(os);
			}
			
			rs.close();
			stmt.close();
			
			//imprimir a lista
			for (OrderStatus status : lista) {
				System.out.println("Id: "+ status.getId()+ " - Desc: "+ status.getStatus_name());
			}
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
