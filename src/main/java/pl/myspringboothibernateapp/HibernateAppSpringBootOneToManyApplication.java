package pl.myspringboothibernateapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.myspringboothibernateapp.dao.ClientDao;
import pl.myspringboothibernateapp.dao.GenericDao;
import pl.myspringboothibernateapp.dao.OrderDao;
import pl.myspringboothibernateapp.model.Client;
import pl.myspringboothibernateapp.model.Order;

@SpringBootApplication
public class HibernateAppSpringBootOneToManyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(HibernateAppSpringBootOneToManyApplication.class, args);
		Client client = new Client("emil","karpowicz", "suwałki");
		ClientDao clientDao = ctx.getBean(ClientDao.class);
		clientDao.save(client);
		System.out.println(client);
		Order order = new Order("1","2");
		order.setClient(client);
		OrderDao orderDao = ctx.getBean(OrderDao.class);
		orderDao.save(order);
		System.out.println(order);
		
		Order getOrder = orderDao.get(1L);
		System.out.println(getOrder);

		Client getClient = clientDao.get(1L);
		System.out.println(getClient);
		ctx.close();
	}
}
