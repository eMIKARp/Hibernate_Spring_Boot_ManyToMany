package pl.myspringboothibernateapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.myspringboothibernateapp.dao.ClientDao;
import pl.myspringboothibernateapp.dao.GenericDao;
import pl.myspringboothibernateapp.dao.OrderDao;
import pl.myspringboothibernateapp.dao.ProductDao;
import pl.myspringboothibernateapp.model.Client;
import pl.myspringboothibernateapp.model.Order;
import pl.myspringboothibernateapp.model.Product;

@SpringBootApplication
public class HibernateAppSpringBootOneToManyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(HibernateAppSpringBootOneToManyApplication.class, args);
		Client client = new Client("emil","karpowicz", "suwałki");
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);

		Order order = new Order("Z dostawą do domu");
		order.setClient(client);
		OrderDao orderDao = ctx.getBean(OrderDao.class);
		orderDao.save(order);

		Product prod1 = new Product("Lg 42", 4800.00, "Dolby surround");
		Product prod2 = new Product("Sony 50", 5200.00, "4K");
		ProductDao productDao = ctx.getBean(ProductDao.class);
		productDao.save(prod1);
		productDao.save(prod2);
		
		orderDao.addProductsToOrder(order.getId(), prod1, prod2);
		
		ctx.close();
	}
}
