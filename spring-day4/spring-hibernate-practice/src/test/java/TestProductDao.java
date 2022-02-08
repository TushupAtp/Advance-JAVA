import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.dao.ProductDao;
import com.cdac.entity.Product;

public class TestProductDao {

	@Test
	public void add() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ProductDao dao = (ProductDao) ctx.getBean("productDao");
		
		Product p = new Product();
		p.setName("iPhone X");
		p.setPrice(30000);
		p.setQuantity(99);
		dao.add(p);
	}
}
