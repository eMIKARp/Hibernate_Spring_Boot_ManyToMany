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
		Order order = new Order("Z dostawą do domu");
	    Product prod1 = new Product("Lg 42", 4800.00, "Dolby surround");
		Product prod2 = new Product("Sony 50", 5200.00, "4K");
		order.getProducts().add(prod1);
		order.getProducts().add(prod2);
		client.addOrder(order);
		
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);
		
		Client getClient = clientDao.get(client.getId());
		System.out.println("\n" + getClient);
		
		clientDao.removeAllOrders(client);		
		
		ctx.close();
	}
}
