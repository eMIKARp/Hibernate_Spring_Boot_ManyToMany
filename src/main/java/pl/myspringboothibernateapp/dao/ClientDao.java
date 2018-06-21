package pl.myspringboothibernateapp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.myspringboothibernateapp.model.Client;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {

	public Client get(Long key) {
		Client client = super.get(key);
        client.getOrders().size();
        return client;
	}
}
