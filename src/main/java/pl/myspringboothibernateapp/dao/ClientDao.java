package pl.myspringboothibernateapp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.myspringboothibernateapp.model.Client;
import pl.myspringboothibernateapp.model.Order;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {
	
	public void removeAllOrders(Client client) {
		   Client managedClient = get(client.getId());
		    for(Order order: managedClient.getOrders())
		        order.setClient(null);
		    managedClient.getOrders().clear();
	}
}
