
import java.math.BigDecimal;

import com.project.jdbc.ServiceDaoJdbc;
import com.project.model.Service;

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServiceDaoJdbc dao = new ServiceDaoJdbc();
//		Service service = new Service(0,"General Test",new BigDecimal(150),null,null,"Admin","Admin");
//
//		
//		
//		System.out.println(dao.addService(service)+" row/s affected");
		
//		Service s = dao.getService("General Test");
//
//		System.out.println(s);
//		
//		
//		
//		System.out.println();
//
//		
//		Service service = new Service(0,"General Test",new BigDecimal(250),null,null,"Admin","Admin");
//		
//		System.out.println(dao.updateService(service)+" row/s updated");
		
		
		
		System.out.println(dao.deleteService("General Test")+" row/s deleted");
		
	}

}
