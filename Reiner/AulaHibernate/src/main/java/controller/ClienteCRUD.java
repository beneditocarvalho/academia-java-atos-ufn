package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Cliente;

public class ClienteCRUD {
	protected SessionFactory sessionFactory;

	public void setup() {
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		// .configure() // configures settings from hibernate.cfg.xml
		// .build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			// sessionFactory = configuration.buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);

		}
	}

	public void exit() {
		// code to close Hibernate Session factory
	}

	public void create(Cliente cliente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(cliente);

		session.getTransaction().commit();
		session.close();
	}

	public Cliente read(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Cliente cliente = session.get(Cliente.class, id);

		session.close();
		return cliente;
	}

	public void update(Cliente cliente) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(cliente);

		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(cliente);

		session.getTransaction().commit();
		session.close();
	}

	public List<Cliente> listAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// leitura via Hibernate Query Language (HQL).
		List<Cliente> clientes = session.createQuery("from Cliente", Cliente.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return clientes;
	}

	public Object queryWhere(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Object object = session.createQuery("from Cliente where id=" + id, Cliente.class).getSingleResult();

		session.close();
		return object;
	}

	/*
	 * public Pessoa queryWhere(int id) { Session session =
	 * sessionFactory.openSession(); session.beginTransaction();
	 * 
	 * Pessoa pessoa = session.createQuery("from Pessoa where id="+id,
	 * Pessoa.class).getSingleResult();
	 * 
	 * session.close(); return pessoa; }
	 */

}