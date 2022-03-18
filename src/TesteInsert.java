
public class TesteInsert {

	public static void main(String[] args) {
		OrderStatus os = new OrderStatus();
		OrderStatusDAO dao = new OrderStatusDAO();
		
		os.setId(11);
		os.setStatus_name("Processing");
		
		dao.insert(os);
	}

}